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

import de.tub.as.smm.dao.SmartMeterDao;
import de.tub.as.smm.models.SmartMeter;

/**
 * Servlet implementation class addSmServlet
 */
@WebServlet("/addSM")
public class addSmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	SmartMeterDao smartMeterDao;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie [] cookies = request.getCookies();//TODO req or res ?
		if(cookies != null){
			for (Cookie cookie : cookies) {
			     if ("loggedInUser".equals(cookie.getName())) {
			    	 //add sm
			    	// Handle a new SM:
			         String smartmeterGK = request.getParameter("smartmeterGK");
			         String smartmeterMB = request.getParameter("smartmeterMB");
			         if (smartmeterGK != null && smartmeterGK != "" && smartmeterGK.substring(0, 1).chars().allMatch(Character::isLetter)
			        	&&	 smartmeterMB != null && smartmeterMB != ""){//TODO check if int + String to double
			         	//src=https://stackoverflow.com/questions/5238491/check-if-string-contains-only-letters
			         	
			         	//no doubles
			         	boolean smIsNew = true;
			         	List<SmartMeter> sms = smartMeterDao.getAllMeters();
			         	for (SmartMeter sm : sms) {
			         		if(smartmeterGK == sm.getGeraeteKennung()){
			         			smIsNew = false;
			         		}
			         	}
			         	if(smIsNew){
//			         		smartMeterDao.persist(new SmartMeter(smartmeterGK, smartmeterMB));
			         	}
			         }
			     }
			}
		}
		doGet(request, response);
	}

}
