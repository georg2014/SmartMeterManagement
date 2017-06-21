package de.tub.as.smm;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tu.as.smm.statelessSessionBeans.Measurement;
import de.tub.as.smm.models.SmartMeter;

import de.tub.as.smm.models.User;

/**
 * May be better to filter user cookie and smart meter cookie ....
 */


/**
 * Servlet implementation class DetailsServlet
 */
@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	// Injected EJB:
    @EJB
    Measurement mea;

	
	//Logged in User
	User loggedInUser;
	//The Current that can be measured is relative to the max curr of the smart meter, so this is necessary
	SmartMeter currentSM;


		
		  
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/details.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO details.jsp line 79 ff
		request.setAttribute("volt", mea.measureVolt());
		request.setAttribute("curr", mea.measureCurr(currentSM));
		
//		/**
//		 * Copy Pasta from userServlet ...
//		 */
//		//look which sm is to show
//        Cookie [] cookies = request.getCookies();
//		if(cookies != null){
//			for (Cookie cookieSM : cookies) {
//			     if ("thisSM".equals(cookieSM.getName())) {
//			    	 String thisGK = cookieSM.getValue();
//			    	 
//			    	 
//			    	 /**
//			    	  * Copy Pasta from addSmServlet ...
//			    	  */
//			    	 //look if a user is logged in
//		    	 	 for (Cookie cookieU : cookies) {
//		    			 if ("loggedInUser".equals(cookieU.getName())) {
//		    				 // Handle a new SM:
//		    				 String smartmeterGK = request.getParameter("smartmeterGK");
//		    				 String smartmeterMB = request.getParameter("smartmeterMB");
//		    				 if (smartmeterGK != null && smartmeterGK != "" && smartmeterGK.substring(0, 1).chars().allMatch(Character::isLetter)
//		    						 &&	 smartmeterMB != null && smartmeterMB != ""){//TODO check if int + String to double
//		    					 //src=https://stackoverflow.com/questions/5238491/check-if-string-contains-only-letters
//		    					 
//		    					 //no doubles
//		    					 boolean smIsNew = true;
//		    					 List<SmartMeter> sms = smartMeterDao.getAllMeters();
//		    					 for (SmartMeter sm : sms) {
//		    						 if(smartmeterGK == sm.getGeraeteKennung()){
//		    							 smIsNew = false;
//		    							 //log in as old user
//		    							 //tell that see user.jsp line 69
//		    						 }
//		    					 }
//		    					 if(smIsNew){
//		    						 smartMeterDao.persist(new SmartMeter(smartmeterGK, smartmeterMB));
//		    					 }
//		    				 }
//		    			 }
//			    	 }
			    	 doGet(request, response);
//			     }
//			    	 
//			     }
//			}
		}
		

}