package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            out.println("<h3>Login Test: </h3>");
            out.println("<div>");
            
            if (username != null && password != null) {
	            if (username.equals("admin") && password.equals("password123")) {
	            	out.print("<p>Welcome: ");
	            	out.println("<p>" + username + "</p>");
	            } else {
	            	out.print("Invalid Login please try again <a href=\"/Simple_Web_App\">here</a></p>");
	            }
		    } else {
		    	out.print("<p>Invalid Login please try again <a href=\"http://localhost:8080/Simple_Web_App\">here</a></p>");
		    }    
            
            out.println("</div>");
            
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
