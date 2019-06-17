package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.Parameters;


public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	int counter = 0;
	HttpSession session;
	String[] values = {"","",""};
	
	private String getValues() {
		String allValues = "";
		for(int i = 0; i < values.length; i++) {
			allValues += values[i] + ", ";
		}
		return allValues;
	}
	
	public class Book{
		String title, author, genre;
		public Book(String title, String author, String genre) {
			this.title = title;
			this.author = author;
			this.genre = genre;
		}
		private String getBook() {
			return title + ", " + author + ", " + genre;
		}
	}
	

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	response.setContentType("text/html");
	response.setCharacterEncoding("UTF-8");
	
	Book book1 = new Book("Wiedzmin", "Sapkowski", "Fantasy");
	for(int i = 0; i < values.length; i++) {
		values[i] = "Wartosc " + i;
	}
	counter++;
	Date date = new Date();
	
	//Sesja przyk³ad
	session = request.getSession(true);
	session.setAttribute("Sesja1", getValues());
	session.setAttribute("Sesja2", book1.getBook());
	session.setAttribute("counter", counter);
	
	//Atrybuty przyk³ad
	request.setAttribute("Atrybut1", getValues());
	request.setAttribute("Atrybut2", book1.getBook());
	request.setAttribute("now", date);
	
	out.println("To jest serwlet");
	
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
}

}
