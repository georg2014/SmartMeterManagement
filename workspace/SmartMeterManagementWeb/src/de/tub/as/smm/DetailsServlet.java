package de.tub.as.smm;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	private static final long serialVersionUID = 1L;
	 
	// Injected EJB:
    @EJB
    Measurement mea;
    @EJB
    SmartMeterDao smartMeterDao;
    @EJB
    ReadingDao readingDao;
		  
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Handle the Details view
		//get the device id
		String thisGK = request.getParameter("thisGK");
		
		//TODO in use?
		//save the device id as session for the smart meter
		request.getSession().setAttribute("sessionSM", smartMeterDao.getMeterByGk(thisGK));
		
		//setter
		request.setAttribute("deviceNumber", request.getParameter("thisGK"));
		request.setAttribute("volt", mea.measureVolt());
<<<<<<< HEAD
<<<<<<< HEAD
		request.setAttribute("curr", mea.measureCurr(currentSM));
		request.setAttribute("max", currentSM.getMaxBelastung());

		if (!(currentU == null)) {
			request.setAttribute("readingList", smartMeterDao.getSpecificReadings(currentSM, currentU));
		}

		// send details.jsp
=======
		request.setAttribute("curr", mea.measureCurr(smartMeterDao.getMeterByGk(request.getParameter("thisGK"))));
		request.setAttribute("max", smartMeterDao.getMeterByGk(request.getParameter("thisGK")).getMaxBelastung());
		
//		SmartMeter sm = (SmartMeter)request.getSession().getAttribute("sessionSM");
//		User u = (User)request.getSession().getAttribute("sessionUser");
//		request.setAttribute("readings", smartMeterDao.getSpecificReadings(sm, u));
		//send details.jsp
>>>>>>> origin/GeorgsZweigAufgabe2
=======
		request.setAttribute("curr", mea.measureCurr(smartMeterDao.getMeterByGk(request.getParameter("thisGK"))));
		request.setAttribute("max", smartMeterDao.getMeterByGk(request.getParameter("thisGK")).getMaxBelastung());
		
		SmartMeter sm = (SmartMeter)request.getSession().getAttribute("sessionSM");
		User u = (User)request.getSession().getAttribute("sessionUser");
		request.setAttribute("readings", smartMeterDao.getSpecificReadings(sm, u));
		//send details.jsp
>>>>>>> parent of 3791c3a... Es ist vollbracht :D
		request.getRequestDispatcher("/details.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Handle new Reading
<<<<<<< HEAD
<<<<<<< HEAD
		if (!(currentU == null)) {
			if (request.getParameter("value").matches("[0-9]{1,13}(\\.[0-9]*)?")) {
=======
		if(request.getSession().getAttribute("sessionUser") != null){
			//user is logged in
			String value = request.getParameter("value");
			if(!value.equals(null) && !value.isEmpty() && value.matches("[0-9]{1,3}")){
				User user = (User)request.getSession().getAttribute("sessionUser");
>>>>>>> parent of 3791c3a... Es ist vollbracht :D
				Double stand = Double.parseDouble(request.getParameter("value"));
				readingDao.persist(new Reading((SmartMeter)request.getAttribute("deviceNumber"),user,stand));
			}
		}
<<<<<<< HEAD

=======
//		if(request.getSession().getAttribute("sessionUser") != null){
//			//user is logged in
//			String value = request.getParameter("value");
//			if(!value.equals(null) && !value.isEmpty() && value.matches("[0-9]{1,3}")){
//				User user = (User)request.getSession().getAttribute("sessionUser");
//				Double stand = Double.parseDouble(request.getParameter("value"));
//				readingDao.persist(new Reading((SmartMeter)request.getAttribute("deviceNumber"),user,stand));
//			}
//		}
		
>>>>>>> origin/GeorgsZweigAufgabe2
=======
		
>>>>>>> parent of 3791c3a... Es ist vollbracht :D
		doGet(request, response);
	}

}