package sessionmanagement.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;



@WebServlet("/Home")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		String age=request.getParameter("age");
		PrintWriter printWriter=response.getWriter();
		
		
		if(password.equals("root")&&uname.equals("root")) {
			
			//Cookie stored
			Cookie cookie=new Cookie("username", uname);
			response.addCookie(cookie);
			request.getRequestDispatcher("display").include(request, response);
						
		}
		else {
			printWriter.print("Please Enter correct username or password");
			request.getRequestDispatcher("login.html").forward(request, response);
			
		}
		
		
		
		
	}

}
