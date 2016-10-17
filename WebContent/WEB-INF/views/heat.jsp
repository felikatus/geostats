<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<spring:url value="/resources/css/query.css" var="queryCSS" />
	<spring:url value="/resources/css/flatpickr.min.css" var="flatpickrCSS" />
	<link href="${queryCSS}" rel="stylesheet" />
	<link href="${flatpickrCSS}" rel="stylesheet" />
 
	<spring:url value="/resources/js/jquery-3.0.0.js" var="jqueryJs" />
	<spring:url value="https://maps.googleapis.com/maps/api/js?key=AIzaSyD2iNxTB_yhdK6DmBRid3bj4QtCmfxRHS8&signed_in=true&libraries=visualization&callback=initMap" var="gmapi" />
	<spring:url value="/resources/js/locationpicker.jquery.js" var="locationPickerJs" />
	<spring:url value="/resources/js/flatpickr.js" var="flatpickrJs" />
	
	<script src="${jqueryJs}"></script>
	<script src="${gmapi}"></script>
	<script src="${locationPickerJs}"></script>
	<script src="${flatpickrJs}"></script>
</head>
<body>
<h1>Elige los parámetros de tu consulta</h1>



<form action="submitHeatForm" method="post">
	<label>Latitud origen: <input id="originLatitude" type="text" name="lat" value="39.4720026" /></label>
	<label>Longitud origen: <input id="originLongitude" type="text" name="lon" value="-6.3901787" /></label>
	<label>Radio: <input id="radius" type="text" name="radius" value="10" /></label>
	<label>Desde: <input name = "dateFrom" class="flatpickr" id="dateFrom" data-enable-time=true data-time_24hr=true></label>
	<label>Hasta: <input name = "dateTo" class="flatpickr" id="dateTo" data-enable-time=true data-time_24hr=true></label>
<!-- 	<label>Date range from: <input type="text" name ="dateFrom" value="2016-04-12T09:00+0000"/></label> -->
<!-- 	<label>Date range to: <input type="text" name="dateTo" value="2016-06-15T12:30+0000" /></label> -->
	<p>La consulta tardará unos segundos en recibir los datos</p>
	<input id="submit" type="submit" value="Enviar" />
</form>
<div id="locationpicker" style="width: 500px; height: 400px;"></div>
  
<script>
$('#dateFrom').flatpickr();
$('#dateTo').flatpickr();
$('#locationpicker').locationpicker({
	location: {latitude: 39.4720026, longitude: -6.3901787},
	radius: 300,
	inputBinding: 	{radiusInput: $('#radius'),
					latitudeInput: $('#originLatitude'),
					longitudeInput: $('#originLongitude')
					}
});


</script>

</body>
</html>