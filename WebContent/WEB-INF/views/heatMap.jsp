<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Heat map results</title>
	
	    
    <script>
	  myModel=[];
	  myModel.lat='${lat}';
	  myModel.lon='${lon}';
	  myModel.locations = '${locations}';
	</script>
	
    <spring:url value="/resources/js/jquery-3.0.0.js" var="jqueryJs" />
    <spring:url value="/resources/js/map.js" var="mapJs" />
    <spring:url value="https://maps.googleapis.com/maps/api/js?key=AIzaSyD2iNxTB_yhdK6DmBRid3bj4QtCmfxRHS8&signed_in=true&libraries=visualization&callback=initMap" var="gmapi" />
    <spring:url value="/resources/css/results.css" var="resultsCSS" />

    <script src="${jqueryJs}"></script>
    <script src="${mapJs}"></script>
    <link href="${resultsCSS}" rel="stylesheet" />
    

</head>
<body>
<h1>Resultados del mapa de calor</h1>
<%-- <h2>${lat}</h2> --%>
<!-- 		<ul> -->
<%-- 			<c:forEach var="location" items="${locations}"> --%>
<%-- 				<li>${location}</li> --%>
<%-- 			</c:forEach> --%>
<!-- 		</ul> -->
<!-- <div id="msg"></div> -->
<div id="map"></div>
<script src="${gmapi}" async defer></script>
</body>
</html>