package de.tub.as.smm;

import java.util.List;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tub.as.smm.dao.UserDao;
import de.tub.as.smm.models.User;

/**
 * Servlet implementation class UserServlet
 */

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Injected DAO EJB:
    @EJB
    UserDao userDao;
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	// Display the list of guests:
        request.setAttribute("user", userDao.getAllUsers());
<<<<<<< HEAD
        
        for(User u : userDao.getAllUsers()){
        	System.out.println(u);
        }
        
=======
>>>>>>> refs/remotes/origin/GeorgsZweigAufgabe2
        request.getRequestDispatcher("/user.jsp").forward(request, response);
 		
    }
 
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Handle a new guest:
        String name = request.getParameter("name");
        if (name != null && name.chars().allMatch(Character::isLetter)){
        	//src=https://stackoverflow.com/questions/5238491/check-if-string-contains-only-letters
        	
        	//no doubles
        	boolean userIsNew = true;
        	List<User> users = userDao.getAllUsers();
        	for (User user : users) {
        		if(name == user.getName()){
        			userIsNew = false;
        			//log in as old user
        			//loggedInUser = userDao.getUserByName(name);
        			//tell that see user.jsp line 69
        		}
        	}
        	if(userIsNew){
        		userDao.persist(new User(name));
//    			loggedInUser = user.getUserByName(name);
        	}
        }
        
        //add user cookie to know which user is logged in
        Cookie [] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
			     if ("loggedInUser".equals(cookie.getName())) {
			    	 cookie.setValue(name);
			     }
			}
		}else{
	        Cookie loggedInUser = new Cookie("loggedInUser", name);
	        response.addCookie(loggedInUser);
		}
        // Display the list of guests:
        doGet(request, response);
    }
}

