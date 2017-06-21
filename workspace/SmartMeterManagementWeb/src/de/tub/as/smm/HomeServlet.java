package de.tub.as.smm;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tub.as.smm.dao.SmartMeterDao;
import de.tub.as.smm.dao.UserDao;
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

		try {
			User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");
			request.setAttribute("loggedInUsr", loggedInUser.getName());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("meterList", meterDao.getAllMeters());

		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// Handle a new Smart Meter:
			System.out.println(request.getParameter("gk"));
			System.out.println(request.getParameter("max"));
			String gk = request.getParameter("gk");
			Double max = Double.parseDouble(request.getParameter("max"));

			if (gk.matches("[A-Z]{2}[0-9]{8}") && max >= 50 && max <= 100) {

				List<SmartMeter> meterList = meterDao.getAllMeters();

				boolean meterIsNew = true;

				for (SmartMeter m : meterList) {
					if (gk.equals(m.getGeraeteKennung())) {
						meterIsNew = false;
					}
				}
				if (meterIsNew) {

					meterDao.persist(new SmartMeter(gk, max));
				}

				doGet(request, response);
			}
		} catch (NullPointerException e) {
			System.out.println("Form was empty");
			doGet(request, response);
		}
	}
}