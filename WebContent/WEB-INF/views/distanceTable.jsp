<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Tabla de distancias</title>
	
	    
	
    <spring:url value="/resources/js/jquery-3.0.0.js" var="jqueryJs" />
    <spring:url value="/resources/css/results.css" var="resultsCSS" />

    <script src="${jqueryJs}"></script>
    <link href="${resultsCSS}" rel="stylesheet" />
    

</head>
<body>
<h1>Tabla de distancias</h1>

<%--  		<ul>
			<c:forEach var="distance" items="${distances}">
			
				<td>${distance.distance}</td>
			</c:forEach>
		</ul> --%>
<table class="distances">
	<tr>
		<th>Número</th>
		<th>Distancia</th>
	</tr>

	<c:forEach begin="0" end="${fn:length(distances) - 1}" var="index">
   		<tr>
	      <td><c:out value="${index}"/></td>
	      <td><c:out value="${distances[index].distance}"/>m</td>
	   </tr>
	</c:forEach>
	<tr>
		<td class="strong">TOTAL</td>
		<td><c:out value="${total}"/>m</td>
	</tr>
</table>
<!-- <div id="msg"></div> -->
</body>
</html>