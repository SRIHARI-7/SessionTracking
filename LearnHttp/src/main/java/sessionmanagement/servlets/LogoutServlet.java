package sessionmanagement.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteCookies")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String uname=request.getParameter("uname");
		PrintWriter printWriter=response.getWriter();
		if(uname.equals("root")) {
			Cookie []cookies=request.getCookies();
			for(int i=0;i<cookies.length;i++) {
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
			
			printWriter.println("<h5>"+uname+"&nbspLogged out successfully</h5>");
			request.getRequestDispatcher("login.html");
		}
	}

}
