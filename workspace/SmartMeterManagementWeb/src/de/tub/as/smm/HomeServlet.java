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
		
		//resets the gerätekennung that was used for a previous detailed view of the smart meter matching the gk
		session.setAttribute("deviceNumber", null);
		
		//sets the logged in user attribute for the jsp
		request.setAttribute("loggedInUser", session.getAttribute("sessionUser"));
		
		//gets all smart meters and makes them available for the home jsp
		request.setAttribute("meterList", meterDao.getAllMeters());
		
		//send home.jsp
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Gets the gk for the new smartmeter and the max strain
		String gk = request.getParameter("gk");
		String max = request.getParameter("max");
		
		//check if gk begins with two big letters and 8 numbers
		if (gk.matches("[A-Z]{2}[0-9]{8}")) {
			
			
			//checks if max strain matches a double number
			if (max.matches("[0-9]{1,13}(\\.[0-9]*)?")) {
				
				Double dmax = Double.parseDouble(max);
				
				if(dmax>=50 && dmax<=100){
				
				//resets alert attribute when input was correct
				request.getSession().setAttribute("isNoValidSM", "0");
				
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
					meterDao.persist(new SmartMeter(gk, dmax));
				}
				
				}
				
				else{
					//sets alert attribute for home jsp when max input isnt within 50 - 100
					request.getSession().setAttribute("isNoValidSM", "1");
				}
				
			}else{
				//sets alert attribute for home jsp when max input isnt in double format
				request.getSession().setAttribute("isNoValidSM", "1");
			}
			
		}else{
			//sets alert attribute when gk has not the right format
			request.getSession().setAttribute("isNoValidSM", "2");//alter wrong input
		}
		doGet(request, response);

	}
}