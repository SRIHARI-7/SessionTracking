package sessionmanagement.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		String age=request.getParameter("age");
		Cookie []cookies=request.getCookies();
		PrintWriter printWriter=response.getWriter();
		
		printWriter.print("<h1>Login SuccessFully...</h1><br><hr>");
		
		//Successfully Cookies used
		printWriter.println("<h4>Welcome&nbsp"+cookies[0].getValue()+"</h4>");
		
		//using hidden form field
		printWriter.println("<h4>Your Age is "+age+"</h4>");
		
		//url rewritting
		printWriter.println("<a href='deleteCookies?uname="+uname+"'>Logout</a>"); 
	}

}
