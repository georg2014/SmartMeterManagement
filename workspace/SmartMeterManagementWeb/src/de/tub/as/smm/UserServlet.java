package de.tub.as.smm;

import java.util.List;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.tub.as.smm.dao.UserDao;
import de.tub.as.smm.models.User;

/**
 * Servlet implementation class UserServlet
 */

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	
	// Injected DAO EJB:
	@EJB
	UserDao userDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("sessionUser") != null){
			request.setAttribute("loggedInUser", session.getAttribute("sessionUser"));
		}
		
		// Display the list of guests:
		List<User> userList = userDao.getAllUsers();
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/user.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// Handle a new guest:
		String name = request.getParameter("name");
		if (!name.equals(null) && !name.isEmpty() && name.chars().allMatch(c -> Character.isLetter(c))) {

			boolean userIsNew = true;

			for (User user : userDao.getAllUsers()) {
				if (name.equals(user.getName())) {
					userIsNew = false;
					session.setAttribute("sessionUser", userDao.getUserByName(name));
				}
			}
			if (userIsNew) {
				userDao.persist(new User(name));
				session.setAttribute("sessionUser", userDao.getUserByName(name));
			}
		}
		doGet(request, response);
	}
}