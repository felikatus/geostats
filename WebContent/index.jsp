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
	<a class="disabled" href=>Puntos de detención</a>
	<a class="disabled" href=>Días de permanencia</a>
	<a class="disabled" href=>Mapa de rutas</a>
</div>

</body>
</html>




