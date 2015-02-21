<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.sql.Connection"
	import="java.sql.DriverManager"
	import="java.sql.ResultSet"
	import="java.sql.Statement"
	import="java.sql.SQLException"
	import="java.sql.PreparedStatement"
	import="entidades.*"
	import="controlador.*"
    %>
<%@ include file="Conexion.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="EstiloModi.css" />
<script>
function soloNumeros(e)
{
	key=e.KeyCode || e.which;
	teclado= String.fromCharCode(key);
	numero="0123456789.";
	especiales="8-37-38-46";
	teclado_especial = false;
	
	for(var i in especiales)
		{
			if(key==especiales[i]){
				teclado_especial = true;
			}
		}
	
	if(numero.indexOf(teclado)==-1 && !teclado_especial){
		return false;		
	}
}
function soloNumeros(e)
{
	key=e.KeyCode || e.which;
	teclado= String.fromCharCode(key);
	numero="0123456789";
	especiales="8-37-38-46";
	teclado_especial = false;
	
	for(var i in especiales)
		{
			if(key==especiales[i]){
				teclado_especial = true;
			}
		}
	
	if(numero.indexOf(teclado)==-1 && !teclado_especial){
		return false;		
	}
}
</script>
<title>FormModi</title>
</head>
<body>
<div id="general">
<h1 style=color:white>Modificación Electrodomestico</h1>
<div id="cuerpo">
<div id="buscador">
	<form method="post" action="Modificacion" name="formModi" id="formModi">
	<label>ID:<input type="text" name="id" id="id" onkeypress="return soloNumeros(event)"/></label>
	<input id="btnBuscar" type="submit" name="submit" value="Buscar" onclick="return camposLlenos()" />
	<br/>
	<br/>
	</form>
</div>
<% 
int id = (int)session.getAttribute("id");
float precioBase = (float)session.getAttribute("precioBase");
String color = (String)session.getAttribute("color");
String consumoEnergetico = (String)session.getAttribute("consumoEnergetico");
float peso = (float)session.getAttribute("peso");
float resolucion = (float)session.getAttribute("resolucion");
boolean sintonizador = (boolean)session.getAttribute("sintonizador");
float carga = (float)session.getAttribute("carga");
%> 
<div id="divForm">
	<br/>
	<form method="post" action="Guardar" name="forModi" id="forModi" >
	<label>Id:<input type="text" name="id" id="id" readonly></label><br/>
	<label>PrecioBase:<input type="text" name="precioBase" id="precioBase" onkeypress="return soloNumeros(event)"/></label><br/>
	<label>Color:
	<select id="color" name="color">
	<option value="blanco">Blanco</option>
	<option value="negro">Negro</option>
	<option value="rojo">Rojo</option>
	<option value="azul">Azul</option>
	<option value="gris">Gris</option>
	</select></label><br/>
	<label>Consumo energetico:
	<select id="consumoEnergetico" name="consumoEnergetico">
	<option value="A">A</option>
	<option value="B">B</option>
	<option value="C">C</option>
	<option value="D">D</option>
	<option value="E">E</option>
	<option value="F">F</option>
	</select></label><br/>
	<label>Peso:<input type="text" name="peso" id="peso" onkeypress="return soloNumeros(event)"/></label><br/>
	<label id="lblResolucion">Resolución:<input type="text" name="resolucion" id="resolucion" onkeypress="return soloNumeros(event)"/></label><br/>
	<input type="checkbox" name="sintonizador" id="sintonizador"><label id="lblSintonizador">Sintonizador</label><br/>
	<label id="lblCarga">Carga:<input type="text" name="carga" id="carga" onkeypress="return soloNumeros(event)"/></label><br/>
	<br />
	<input id="btnGuardar" type="submit" name="submit" value="Guardar" onclick="return camposLlenos()" />
	<br />
	<br /> 
	</form>
</div>
<br /> 
<table id="miTabla" border="1">
<tr>
<td><strong>ID</strong></td>
<td><strong>PrecioBase</strong></td> 
<td><strong>Color</strong></td> 
<td><strong>ConsumoEnergetico</strong></td> 
<td><strong>Peso</strong></td>  
<td><strong>Resolucion</strong></td> 
<td><strong>Sintonizador</strong></td> 
<td><strong>Carga</strong></td> 
</tr>

<%
		Statement st;
		try {
	        //response.setContentType("text/html");
	        
			st = (Statement) Conexion.GetConnection().createStatement();
			ResultSet rs = (ResultSet) st.executeQuery("SELECT * FROM electrodomestico");
			
			int i=0;
			while(rs.next()) {							

				out.println("<tr>");
				out.println("<td>" + rs.getInt("id") + "</td>");
				out.println("<td>" + rs.getFloat("precioBase") + "</td>");
				out.println("<td>" + rs.getString("color") + "</td>");
				out.println("<td>" + rs.getString("consumoEnergetico") + "</td>");
				out.println("<td>" + rs.getFloat("peso") + "</td>");
				out.println("<td>" + rs.getFloat("resolucion") + "</td>");
				out.println("<td>" + rs.getBoolean("sintonizador") + "</td>");
				out.println("<td>" + rs.getFloat("carga") + "</td>");
				out.println("</tr>");
				i++;
				
			} // end while
		
			rs.close();
			st.close();
			Conexion.CloseConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
%>
</table>
<p id="link">&nbsp;<a href="Principal.html">Menú principal</a></p>
</div>
</div>
</body>
</html>