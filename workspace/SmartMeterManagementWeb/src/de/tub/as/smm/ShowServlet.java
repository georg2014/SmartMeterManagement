package de.tub.as.smm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowServlet
 */
//connect jsp and servlet via action and the name between "/ and "
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	// manage requests and response
    	// came here from doPost
    	// here all is working faster normaly
    	request.getRequestDispatcher("/user.jsp").forward(request, response);
 			//going to the user.jsp in loading it in the browser
    	// here another way to print something in the webpage
    	response.getWriter().println("<p>this is a paragraph</p>");
 		request.setAttribute("this", "THIS");//should change the this above ti THIS
 		//somehow load this again
    }
 
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // manage requests and response
    	
    	//in line 12 in jsp we said we are connected to this servlet
    		//POST means we first go in this methode and the given paramter are not shown on the url
    	//in line 14 in jsp a submit button is pressed
    	doGet(request,response);
        
    }

}
