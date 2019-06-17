package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String im = request.getParameter("imie");
		String cname = "ciastko";
		PrintWriter out = response.getWriter();
		Cookie ck = new Cookie(cname, im);
		ck.setMaxAge(600);
		ck.setHttpOnly(false);
		if (im != "") {
			response.addCookie(ck);
			response.sendRedirect("home.jsp");
			return;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			out.println("Nie wprowadzono imienia");
		}
	}

}