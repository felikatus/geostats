<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Chose your heat map query</h1>



<form action="/geo/submitHeatForm" method="post">
	<label>Origin latitude: <input type="text" name="lat" /></label>
	<label>Origin longitude: <input type="text" name="lon" /></label>
	<label>Radius: <input type="text" name="radius" /></label>
	<label>Date range from: <input type="text" name ="dateFrom" /></label>
	<label>Date range to: <input type="text" name="dateTo" /></label>
	<input type="submit" value="Submit" />
</form>
  


</body>
</html>