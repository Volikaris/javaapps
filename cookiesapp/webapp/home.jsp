<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cookies zadania</title>
</head>
<body>
	<%!
		String title = "<a href=\"home.jsp\">Strona Glowna</a>";
		int counter = 0;
	%>
	<%
		session = request.getSession(true);
		synchronized(session){
			if(session.isNew())session.setAttribute("Counter", 1);
			if((int)session.getAttribute("Counter") == 0) counter = 1;
			switch(counter){
			case 3:
				session.setAttribute("Page"+3, session.getAttribute("Page"+2));
				session.setAttribute("Page"+2, session.getAttribute("Page"+1));
				session.setAttribute("Page"+1, title);
				break;
			case 2:
				session.setAttribute("Page"+2, session.getAttribute("Page"+1));
				session.setAttribute("Page"+1, title);
				break;
			case 1:
				session.setAttribute("Page"+1, title);
				break;
			}
			out.println("Ostatnio odwiedzone strony:<br>");
			for(int i = 1 ; i <= counter; i++){
				out.println(i + " : " + session.getAttribute("Page"+i) + "<br>");
			}
			if(counter < 3) counter++;
			else counter = 3;
			session.setAttribute("Counter", counter);
		}
		Cookie[] cks = request.getCookies();
		try{
			for(Cookie item: cks){
				if(item.getName().equals("ciastko")){
					out.println("<br>Witaj " + item.getValue() + "<br>");
				}
			}
		}catch(Exception ex){
			System.out.println("Cookie was null");
		}
		if (cks != null) {
			for (int i = 0; i < cks.length; i++) {
				String name = cks[i].getName();
				String value = cks[i].getValue();
				if (name == "ciastko") {
					break;
				}
				if (i == (cks.length - 1))
				{
					session.setAttribute("Counter", 0);
					response.sendRedirect("index.html");
					return;
				}
				i++;
			}
		} else {
			session.setAttribute("Counter", 0);
			response.sendRedirect("index.html");
			return;
		}
	%>
	<h3>Ciastko zostalo utworzone pozytywnie.</h3>
	<br> czas trwania ciastka ustawiony na 600 sekund
	<br> mozesz usunac ciastko ponizej lub czekac 600 sekund
	<br> sesja trwa do zamkniecia przegladarki.
	<br><br>
	<form action="logout1" method="post">
		<input type="submit" value="Usun ciastko">
	</form>
	Linki do podstron:<br>
	<a href="podstrona.jsp">Podstrona</a><br>
	<a href="podstrona2.jsp">Podstrona2</a><br>
	<a href="podstrona3.jsp">Podstrona3</a><br>
	<a href="podstrona4.jsp">Podstrona4</a><br>
</body>
</html>