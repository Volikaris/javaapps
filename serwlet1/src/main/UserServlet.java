package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int counter = 0;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		counter++;
		
		out.println("Liczba odwiedzin tego serwleta: " + counter + "<br>");
		
		out.println("<A HREF=\"http://localhost:8080/serwlet1/index.html\">Strona glowna</A><br><br>");
		
		out.println("Lista uzytkownikow: "+ "<br><br>");
		String uslist = (String)request.getAttribute("UsersList");
		out.println(uslist);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
