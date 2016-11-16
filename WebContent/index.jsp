<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <spring:url value="/resources/css/main.css" var="mainCSS" />
 <link href="${mainCSS}" rel="stylesheet" />

    
<title>GEO</title>
</head>
<body>
<h1>Elige una consulta</h1>
<div class="queries">
	<a href=heat>Mapa de calor</a>
	<a href=distance>Distancia recorrida</a>
	<a href=stops>Puntos de detención</a>
<!-- 	<a class="disabled" href=>Días de permanencia</a> -->
	<a href="routes">Mapa de rutas</a>
</div>
<div class="help">
	<h2>Ayuda</h2>
	<p>Haciendo click sobre uno de los botones se realiza la consulta correspondiente. Las posibles consultas son:
	<ul>
	<li><strong>Mapa de calor</strong>: Se obtiene como resultado un mapa con los puntos calientes de la zona consultada. Estos puntos representan las zonas por las que han pasado más usuarios en el rango de tiempo introducido. </li>
	<li><strong>Distancia recorrida</strong>: Se obtiene como resultado una tabla con la distancia recorrida en metros por cada usuario en la zona y rango temporal seleccionados.</li>
	<li><strong>Puntos de detención</strong>: Se obtiene un mapa similar al mapa de calor pero los puntos representan las zonas donde los usuarios han estado detenidos más tiempo.</li>
	<li><strong>Mapa de rutas</strong>: Se obtiene un mapa con las rutas seguidas por cada usuario representadas en diferentes colores.</li>
	</ul>
	<p>Una vez seleccionada una consulta se solicitará una serie de datos como punto de origen y radio para el área de la consulta y una fecha inicial y final.</p>
</div>
</body>
</html>




