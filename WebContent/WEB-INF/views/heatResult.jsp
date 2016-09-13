<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Heat map results</title>

	
    <script>
		  myModel=[];
		  myModel.lat='${lat}';
		  myModel.lon='${lon}';
		  myModel.radius='${radius}';
	</script>
	<spring:url value="/resources/css/results.css" var="resultsCSS" />
	<link href="${resultsCSS}" rel="stylesheet" />
	
    <spring:url value="/resources/js/jquery-3.0.0.js" var="jqueryJs" />
    <spring:url value="/resources/js/map.js" var="mapJs" />
    <spring:url value="https://maps.googleapis.com/maps/api/js?key=AIzaSyD2iNxTB_yhdK6DmBRid3bj4QtCmfxRHS8&signed_in=true&libraries=visualization&callback=initMap" var="gmapi" />

    <script src="${jqueryJs}"></script>
    <script src="${mapJs}"></script>

    
</head>
<body>
<h2>${msg}</h2>
<div id="msg"></div>
<div id="map"></div>
<script src="${gmapi}" async defer></script>
</body>
</html>