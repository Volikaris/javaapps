<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Podstrona 1</title>
</head>
<body>
	<%!
		String title = "<a href=\"podstrona3.jsp\">Podstrona trzecia</a>";
	%>
	<%
		session = request.getSession();
		synchronized(session){
			int counter = (int)session.getAttribute("Counter");
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
			
			for(int i = 1 ; i <= counter; i++){
				out.println(i + " : " + session.getAttribute("Page"+i) + "<br>");
			}
			if(counter < 3) counter++;
			else counter = 3;
			session.setAttribute("Counter", counter);
			Cookie[] cks = request.getCookies();
			if (cks != null) {
				for (int i = 0; i < cks.length; i++) {
					if (i == (cks.length - 1))
					{
						response.sendRedirect("index.html");
						return;
					}
					i++;
				}
			} else {
				response.sendRedirect("index.html");
				return;
			}
		}
 	%>
 	<br><br>
	Linki do podstron:<br>
	<a href="home.jsp">Strona glowna</a><br>
	<a href="podstrona.jsp">Podstrona</a><br>
	<a href="podstrona2.jsp">Podstrona2</a><br>
	<a href="podstrona4.jsp">Podstrona4</a><br>
</body>
</html>