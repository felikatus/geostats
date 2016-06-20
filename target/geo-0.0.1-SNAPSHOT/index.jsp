<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <spring:url value="/resources/js/jquery-3.0.0.js" var="jqueryJs" />
    <spring:url value="/resources/js/map.js" var="mapJs" />
    <spring:url value="/resources/main.css" var="mainCSS" />
     
    <script src="${jqueryJs}"></script>
    <script src="${mapJs}"></script>
    <link href="${mainCSS}" rel="stylesheet" />
    
<title>GEO</title>
</head>
<body>
<h1>Send your query</h1>
<a href=/geo/heat>Heat map</a>

<div id="msg"></div>
<div id="map"></div>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD2iNxTB_yhdK6DmBRid3bj4QtCmfxRHS8&callback=initMap"
        async defer></script>
</body>
</html>




