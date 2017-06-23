package de.tub.as.smm;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.tub.as.smm.dao.ReadingDao;
import de.tub.as.smm.dao.SmartMeterDao;
import de.tub.as.smm.models.Reading;
import de.tub.as.smm.models.SmartMeter;
import de.tub.as.smm.models.User;
import de.tub.as.smm.statelessSessionBeans.Measurement;

/**
 * Servlet implementation class DetailsServlet
 */
@WebServlet("/details")
public class DetailsServlet extends HttpServlet {

	// Injected EJB:
	@EJB
	Measurement mea;
	@EJB
	SmartMeterDao smartMeterDao;
	@EJB
	ReadingDao rDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// Handle the Details view
		// get the device id
		if (session.getAttribute("deviceNumber") == null) {
			session.setAttribute("deviceNumber", smartMeterDao.getMeterByGk(request.getParameter("thisGK")));
		}

		SmartMeter currentSM = (SmartMeter) session.getAttribute("deviceNumber");

		User currentU = (User) session.getAttribute("sessionUser");

		System.out.println(currentSM);
		System.out.println(currentU);

		// setter
		request.setAttribute("volt", mea.measureVolt());
		request.setAttribute("curr", mea.measureCurr(currentSM));
		request.setAttribute("max", currentSM.getMaxBelastung());

		if (!(currentU == null)) {
			request.setAttribute("readingList", smartMeterDao.getSpecificReadings(currentSM, currentU));
		}

		// send details.jsp
		request.getRequestDispatcher("/details.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//make a new session
		HttpSession session = request.getSession();
		//get smart meter from session and user
		SmartMeter currentSM = (SmartMeter) session.getAttribute("deviceNumber");
		User currentU = (User) session.getAttribute("sessionUser");
		
		//debug print outs
		System.out.println(currentSM);
		System.out.println(currentU);

		// Handle new Reading
		if (!(currentU == null)) {
			//check for valid inputs
			if (request.getParameter("value").matches("[0-9]{1,13}(\\.[0-9]*)?")) {
				session.setAttribute("isWrongValue", "0");//no alter
				Double stand = Double.parseDouble(request.getParameter("value"));
				//add reading to the reading database
				rDao.persist(new Reading(currentSM, currentU, stand));
			}else{
				session.setAttribute("isWrongValue", "1");//alter wrong input
			}
		}else{
			session.setAttribute("isWrongValue", "1");//alter wrong input
		}
		
		//Handle To High Voltage Error
		if(mea.isOverMax(currentSM, currentSM.getMaxBelastung())){
			session.setAttribute("isToHigh", "1");
		}else{
			session.setAttribute("isToHigh", "0");
		}

		doGet(request, response);
	}

}