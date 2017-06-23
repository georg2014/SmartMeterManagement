package de.tub.as.smm;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.tu.as.smm.statelessSessionBeans.Measurement;
import de.tub.as.smm.dao.ReadingDao;
import de.tub.as.smm.dao.SmartMeterDao;
import de.tub.as.smm.models.Reading;
import de.tub.as.smm.models.SmartMeter;
import de.tub.as.smm.models.User;

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
		
		HttpSession session = request.getSession();

		SmartMeter currentSM = (SmartMeter) session.getAttribute("deviceNumber");
		User currentU = (User) session.getAttribute("sessionUser");

		System.out.println(currentSM);
		System.out.println(currentU);

		// Handle new Reading
		if (!(currentU == null)) {
			if (request.getParameter("value").matches("[0-9]{1,13}(\\.[0-9]*)?")) {
				Double stand = Double.parseDouble(request.getParameter("value"));
				rDao.persist(new Reading(currentSM, currentU, stand));
			}
		}

		doGet(request, response);
	}

}