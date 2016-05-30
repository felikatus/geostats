<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Chose your heat map query</h1>



<form:form action="newHeatQuery" method="post">
	<label>Origin latitude: <form:input type="text" name="lat" path="lat" /></label>
	<label>Origin longitude: <form:input type="text" name="lon" path="lon" /></label>
	<label>Radius: <form:input type="text" name="radius" path="radius" /></label>
	<label>Date range from: <form:input type="text" name ="dateFrom" path="dateFrom" /></label>
	<label>Date range to: <form:input type="text" name="dateTo" path="dateTo" /></label>
	<input type="submit" value="Submit" />
</form:form>
  
 



</body>
</html>