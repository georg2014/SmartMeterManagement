package de.tub.as.smm;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tu.as.smm.statelessSessionBeans.Measurement;
import de.tub.as.smm.dao.SmartMeterDao;
import de.tub.as.smm.dao.UserDao;
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
    UserDao userDao;
    @EJB
    SmartMeterDao smartMeterDao;
    
		  
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get data from session
		
		
		//setter
			//doesnt work because it is refering to the home.jsp not the details jsp i guess
//		System.err.println(request.getParameter("thisGK"));
//		request.setAttribute("deviceNumber", request.getParameter("thisGK"));
//		System.err.println(mea.measureVolt());
//		request.setAttribute("volt", mea.measureVolt());
//		System.err.println(mea.measureCurr(smartMeterDao.getMeterByGk(request.getParameter("thisGK"))));
//		request.setAttribute("curr", mea.measureCurr(smartMeterDao.getMeterByGk(request.getParameter("thisGK"))));
//		System.err.println(smartMeterDao.getMeterByGk(request.getParameter("thisGK")).getMaxBelastung());
//		request.setAttribute("max", smartMeterDao.getMeterByGk(request.getParameter("thisGK")).getMaxBelastung());
		//send details.jsp
		request.getRequestDispatcher("/details.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Handle the Details view
		//get the device id
		String thisGK = request.getParameter("thisGK");
		System.err.println(thisGK);
		
		//save the device id as session for the smart meter
		request.getSession().setAttribute("sessionSM", smartMeterDao.getMeterByGk(thisGK));
		
		doGet(request, response);
	}

}