<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <spring:url value="/resources/css/query.css" var="queryCSS" />
 <link href="${queryCSS}" rel="stylesheet" />
</head>
<body>
<h1>Chose your heat map query</h1>



<form action="/geo/submitHeatForm" method="post">
	<label>Origin latitude: <input type="text" name="lat" value="39.4720026" /></label>
	<label>Origin longitude: <input type="text" name="lon" value="-6.3901787" /></label>
	<label>Radius: <input type="text" name="radius" value="10" /></label>
	<label>Date range from: <input type="text" name ="dateFrom" value="2016-04-12T09:00+0000"/></label>
	<label>Date range to: <input type="text" name="dateTo" value="2016-06-15T12:30+0000" /></label>
	<input type="submit" value="Submit" />
</form>
  

</body>
</html>