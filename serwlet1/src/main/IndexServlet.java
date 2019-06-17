package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	///// UTWORZENIE ARRAYLIST I TESTOWY U¯YTKOWNIK
	ArrayList<User> Users = new ArrayList<>();
	boolean isTaken = false;
	String Ulist = "";
	String lista = "";
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		
		///// PRZYPISANIE DANYCH U¯YTKOWNIKA POBRANYCH Z INDEX.HTML
		int age = Integer.parseInt(request.getParameter("age"));
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String[] y = request.getParameterValues("interests[]");
		
		
		///// ODNOŒNIK NA STRONÊ G£ÓWN¥
		out.println("<A HREF=\"http://localhost:8080/serwlet1/index.html\">Strona glowna</A><br>");
		out.println("<A HREF=\"http://localhost:8080/serwlet1/UserServlet\">Lista uzytkownikow</A><br>");
		
		
		///// WYPISANIE DANYCH U¯YTKOWNIKA ZE ZMIENNYCH ZAPISANYCH W SERWLECIE
		out.println("Metoda Get" + "<br>" + "Login: " + login + "<br>" + "Haslo: " + pass + "<br>" + "Wiek: " + age + "<br>" + "Imie: " + name + "<br>" + "Nazwisko: " + surname + "<br>");
		out.println("Zainteresowania: <br>");
		for(int i=0; i<y.length;i++) {
			out.println(i+1 + ": "+ y[i] + "<br>");
		} out.println("<br>");
		
		///// INFORMACJA O DODANIU U¯YTKOWNIKA O KONKRETNYM LOGINIE ORAZ DODANIE GO DO ARRAYLIST
		out.println("Uzytkownik " + login + " dodany. <br><br>");
		User usernew = new User(login, pass, name, surname, age);
		
		///// SPRAWDZENIE CZY U¯YTKOWNIK SIÊ NIE POWTARZA W ARRAYLIST
		for(int i=0; i<Users.size();i++) {
			if(Users.get(i).login.equals(usernew.login)) isTaken = true;
			else isTaken = false;
			out.println("Proba " + i + " : " + isTaken + " / " + Users.get(i).login + " / " + usernew.login + "<br>");
		}
		if(!isTaken) {Users.add(usernew); Ulist += "[" + usernew.getUserData() + "]<br>";}
		
		///// WYPISANIE WSZYSTKICH U¯YTKOWNIKÓW ZAPISANYCH W ARRAYLIST
		out.println("Uzytkownicy:<br>");
		for(int i=0; i<Users.size();i++) {
			out.println("- " + Users.get(i).getUserData() + "<br>");
		}
		out.println("<br><br>" + Ulist + "<br><br>");
		
		///// WYS£ANIE DO DRUGIEGO SERWLETA
		request.setAttribute("UsersList",Ulist);
		RequestDispatcher rd = request.getRequestDispatcher("/UserServlet");
		rd.forward(request, response); // ZAKOMENTOWAÆ BY ZOBACZYÆ EFEKT W PIERWSZYM SERWLECIE.
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		
		out.print("Metoda Post" + "<br>");
		out.print("Login: " + request.getParameter("login") + "<br>");
		out.print("Haslo: " + request.getParameter("pass") + "<br>");
		out.print("Wiek: " + request.getParameter("age") + "<br>");
		out.print("Imie: " + request.getParameter("name") + "<br>");
		out.print("Nazwisko: " + request.getParameter("surname") + "<br>");
		out.print("Zainteresowania: <br>");
		String[] y = request.getParameterValues("interests[]");
		for(int i=0; i<y.length;i++) {
			out.print(i+1 + ": "+ y[i] + "<br>");
		}
		///// ODNOŒNIK NA STRONÊ G£ÓWN¥
		out.println("<A HREF=\"http://localhost:8080/serwlet1/index.html\">Strona glowna</A><br>");
	}

}
