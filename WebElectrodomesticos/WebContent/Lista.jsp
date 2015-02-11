<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.sql.Connection"
	import="java.sql.DriverManager"
	import="java.sql.ResultSet"
	import="java.sql.Statement"
	import="java.sql.SQLException"
	import="java.sql.PreparedStatement"
	import="entidades.*"
    %>
<%@ include file="Conexion.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estiloOpciones.css" />
<title>FormListado</title>
<script> 
function cambiarDiv() 
{ 
    document.getElementById("cargando").style.display = "none"; // Oculto el div de cargando 
    document.getElementById("global").style.display = "block"; // Muestro el otro div 
} 

window.onload = cambiarDiv; // Asigno la función al evento onload de la página 
</script> 
</head>
<body>
<div id="general">
<h1 style=color:white>Listado Electrodomestico</h1>
<div id="cuerpo">

<div id="cargando">Cargando datos...</div> 
<div id="global" style="display:none"> 
DATOS DE LA BASE DE DATOS EN TABLA
<form method="post" action="Mostrar" name="Listado" id="Listado" >
<input id="btnEnviar" type="submit" name="submit" value="Mostrar"/>
</form>

</div>
</div>
</div>
</body>
</html>