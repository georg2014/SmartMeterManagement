package de.tub.as.smm;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.tub.as.smm.dao.SmartMeterDao;
import de.tub.as.smm.models.SmartMeter;
import de.tub.as.smm.models.User;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	// Injected DAO EJB:
	@EJB
	SmartMeterDao meterDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		session.setAttribute("deviceNumber", null);
		
		//setter
		request.setAttribute("loggedInUser", session.getAttribute("sessionUser"));
		request.setAttribute("meterList", meterDao.getAllMeters());
		//send home.jsp
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Handle a new Smart Meter:
		String gk = request.getParameter("gk");
		
		//check that max is a number this commas my be
		if (request.getParameter("max").matches("[0-9]{1,13}(\\.[0-9]*)?")) {
			
			//if max only contains numbers
			//make to double
			Double max = Double.parseDouble(request.getParameter("max"));
			
			//check that gk begins with two big letters and 8 numbers and max is between 50 and 100
			if (gk.matches("[A-Z]{2}[0-9]{8}") && max >= 50 && max <= 100) {
				
				//if gk contains two big letters and 8 numbers and max is between 50 and 100
				request.getSession().setAttribute("isNoValidSM", "0");//no alert
				
				//get a list of all smart meters from the database
				List<SmartMeter> meterList = meterDao.getAllMeters();
				
				boolean meterIsNew = true;
				
				//check if in all smart meters is on with the same gk
				for (SmartMeter m : meterList) {
					if (gk.equals(m.getGeraeteKennung())) {
						
						//if it is so make meterIsNew to false because there exists yet a meter
						meterIsNew = false;
					}
				}
				if (meterIsNew) {
					//add new smart meter to the database
					meterDao.persist(new SmartMeter(gk, max));
				}
			}else{
				//gk contains not two big letters and 8 numbers and max is between 50 and 100
				request.getSession().setAttribute("isNoValidSM", "2");//alter wrong input
			}
		}else{
			//max not only contains numbers
			request.getSession().setAttribute("isNoValidSM", "1");//alter wrong input
		}
		doGet(request, response);

	}
}