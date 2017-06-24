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
		
		/**Handle a new guest:**/
		//get the input from the user.jsp
		String name = request.getParameter("name");
		
		//check input: name is not null and not empty and matches characters(all inputs are letters)
		if (!name.equals(null) && !name.isEmpty() && name.chars().allMatch(c -> Character.isLetter(c))) {
			
			//if name is not null and not empty and matches characters(all inputs are letters)
			session.setAttribute("isWrongName", "0");//no alter
			boolean userIsNew = true;
			
			//go through all users that exists in the database
			for (User user : userDao.getAllUsers()) {
				
				//check if the input is a name that already exists in the database
				if (name.equals(user.getName())){
					
					//if the name already exists the user is not new
					userIsNew = false;
					
					//log in the user as the existing user via session
					session.setAttribute("sessionUser", userDao.getUserByName(name));
				}
			}
			
			//check if user is new
			if (userIsNew) {
				
				//if user is new add a new user with the given name into the database and the session
				userDao.persist(new User(name));
				session.setAttribute("sessionUser", userDao.getUserByName(name));
			}
		}else{
			session.setAttribute("isWrongName", "1");//alter wrong input
		}
		doGet(request, response);
	}
}