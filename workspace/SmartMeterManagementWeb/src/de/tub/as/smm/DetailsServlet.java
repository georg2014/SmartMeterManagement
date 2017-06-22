package de.tub.as.smm;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tu.as.smm.statelessSessionBeans.Measurement;
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
	
	//attributes
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
		
		doGet(request, response);
	}

}