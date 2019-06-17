<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>JSTL JSP page</title>
	</head>

	<body>
		<h3>Wywolanie c:out dla $Sesja1 z serwletu</h3>
		<c:out value = "${Sesja1}"></c:out><br>
		<h3>Wywolanie c:out dla $Sesja2 z serwletu</h3>
		<c:out value = "${Sesja2}"></c:out><br>
		<h3>Wywolanie c:out dla $Atrybut1 z serwletu</h3>
		<c:out value = "${Atrybut1}"></c:out><br>
		<h3>Wywolanie c:out dla $Atrybut2 z serwletu</h3>
	 	<c:out value = "${Atrybut2}"></c:out><br><br>
	 	
	 	<h3> Przyklady 10 roznych znacznikow JSTL</h3><br>
	 	
	 	<c:set var = "test" value = "${'1 i 2. c:set oraz c:out --- Przyklad uzycia < to cale zdanie jest zapisane przez c:set, wyswietlane przez c:out'}"/>
	 	<c:out value = "${test}"/><br><br><br>
	 	<c:catch var ="Exception">
	 	
	 	3 i 4. c:catch oraz c:if --- Proba wykonania int x = 5/0; w kodzie jsp<br>
         <% int x = 5/0;%>
      	</c:catch>
      	<c:if test = "${Exception != null}">
         <p>Wyjatek : ${Exception}<br>
         Zaistnial wyjatek: ${Exception.message}</p><br><br>
      	</c:if>
      	
      	5, 6 i 7. c:choose c:when i c:otherwise<br>
      	<c:set var = "liczba" scope = "session" value = "${1000*counter}"/>
      	<% out.println("Atrybut sesji counter: " + session.getAttribute("counter") + "<br>"); %>
      	<c:choose>
      	<c:when test = "${liczba <= 1000}">
      	Opcja pierwsza dla c:choose, c:when, gdy 1000*counter (ilosc odswiezen strony) wynosi mniej lub rowno 1000<br>
      	</c:when>
      	<c:when test = "${liczba > 1000 && liczba <= 2000}">
      	Opcja druga dla c:choose, c:when, gdy 1000*counter (ilosc odswiezen strony) wynosi miedzy 1001-2000<br>
      	</c:when>
      	<c:otherwise>
      	Opcja trzecia dla c:choose, c:otherwise - gdy 1000*counter (ilosc odswiezen strony) wyniesie ponad 2000<br>
      	</c:otherwise>
      	</c:choose><br>
      	
      	8. c:forEach <br>
      	<c:forEach var = "i" begin = "1" end = "5">
         poz <c:out value = "${i}"/><br>
       	</c:forEach><br>
       	
       	9. c:url<br>
       	<a href = "<c:url value = "http://www.google.pl"/>">google</a><br><br>
       	
       	10. fmt:formatDate<br>
       	<p>Data i czas: <fmt:formatDate type = "both" dateStyle = "long" timeStyle = "long" value = "${now}" /></p>
      	
	</body>
</html>