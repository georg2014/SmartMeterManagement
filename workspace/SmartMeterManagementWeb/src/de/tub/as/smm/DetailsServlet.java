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

	// Injected EJBs:
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
		
		//get the device that was selected on smart meter overview
		SmartMeter currentSM = (SmartMeter) session.getAttribute("deviceNumber");
		
		//get the logged in user
		User currentU = (User) session.getAttribute("sessionUser");
		
		//takes measurements with the injected Measurement session bean
		Double mCurr = mea.measureCurr(currentSM);
		Double mVolt = mea.measureVolt();
		
		//set attributes for details jsp
		request.setAttribute("volt", mVolt);
		request.setAttribute("curr", mCurr);
		request.setAttribute("max", currentSM.getMaxBelastung());

		// Handle To High Voltage Error
		if (mea.isOverMax(currentSM, mCurr)) {
			//set alert 
			session.setAttribute("isToHigh", "1");
		} else {
			//reset alert
			session.setAttribute("isToHigh", "0");
		}
		
		//only get all readings for this user and smartmeter if a user is logged in
		if (!(currentU == null)) {
			//gets reading based on the current smart meter and user
			request.setAttribute("readingList", smartMeterDao.getSpecificReadings(currentSM, currentU));
		}

		//send details.jsp
		request.getRequestDispatcher("/details.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// get smart meter from session and user
		SmartMeter currentSM = (SmartMeter) session.getAttribute("deviceNumber");
		User currentU = (User) session.getAttribute("sessionUser");

		// Handle new Reading
		//a user must be logged in to create readings
		if (!(currentU == null)) {
			
			// check if the input value is in double format
			if (request.getParameter("value").matches("[0-9]{1,13}(\\.[0-9]*)?")) {
				
				//resets alert attribute
				session.setAttribute("isWrongValue", "0");
				Double stand = Double.parseDouble(request.getParameter("value"));
				
				// add reading to the reading database
				rDao.persist(new Reading(currentSM, currentU, stand));
			
			} else {
				//sets alert attribute
				session.setAttribute("isWrongValue", "1");
			}
			
		} else {
			//set different alert
			session.setAttribute("isWrongValue", "2");
		}

		doGet(request, response);
	}

}