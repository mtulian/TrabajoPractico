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
	import="java.util.ArrayList"
    %>
<%@ include file="Conexion.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="EstiloBaja.css" />

<script type="text/javascript">
function Confirmacion()
{
	  var rc = confirm("¿Seguro que desea Eliminar?");
      return rc;	
}
function camposLlenos()
{
	var valido =true;
	var mensaje="Ingrese un Id";
		
	if(document.getElementById('id').value == "")
		valido = false;

	if(!valido)
		{
			alert(mensaje);
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

<title>FormBaja</title>
</head>
<body>
<div id="general">
<h1 style=color:white>Baja Electrodomestico</h1>

<div id="cuerpo">
	<form method="post" action="Baja" name="formBaja" id="formBaja">
	<label>ID:<input type="text" name="id" id="id" onkeypress="return soloNumeros(event)"/></label>
	<input id="btnBorrar" type="submit" name="submit" value="Borrar" onclick="return camposLlenos();return Confirmacion()" />
	<br/>
	<br/>
	</form>
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
<td><strong>Borrar</strong></td> 
</tr>

<%
		Statement st;
		try {
	        //response.setContentType("text/html");
	        
			st = (Statement) Conexion.GetConnection().createStatement();
			ResultSet rs = (ResultSet) st.executeQuery("SELECT * FROM electrodomestico");
			
			ArrayList<Electrodomestico> lista = new ArrayList<Electrodomestico>();
			int i=0;
			while(rs.next()) {
				
				if(rs.getString("carga") ==null)
				{
					Television elec = new Television();
					elec.setResolucion(rs.getFloat("resolucion"));
					elec.setSintonizadorTDT(rs.getBoolean("sintonizador"));
					
					//CÓDIGO REPETIDO, CORREGIR.
					elec.setId(rs.getInt("id"));
					elec.setColor(rs.getString("color"));
					elec.setPeso(rs.getFloat("peso"));
					elec.setConsumoEnergetico( rs.getString("consumoEnergetico"));
					elec.setPrecioBase(rs.getFloat("precioBase"));	
					
					lista.add(elec);
					
				}
				else
				{
					Lavarropas elec = new Lavarropas();		
					elec.setCarga(rs.getFloat("carga"));

					//CÓDIGO REPETIDO, CORREGIR.
					elec.setId(rs.getInt("id"));
					elec.setColor(rs.getString("color"));
					elec.setPeso(rs.getFloat("peso"));
					elec.setConsumoEnergetico( rs.getString("consumoEnergetico"));
					elec.setPrecioBase(rs.getFloat("precioBase"));	
					
					lista.add(elec);
				}				

				out.println("<tr>");
				out.println("<td>" + rs.getInt("id") + "</td>");
				out.println("<td>" + rs.getFloat("precioBase") + "</td>");
				out.println("<td>" + rs.getString("color") + "</td>");
				out.println("<td>" + rs.getString("consumoEnergetico") + "</td>");
				out.println("<td>" + rs.getFloat("peso") + "</td>");
				out.println("<td>" + rs.getFloat("resolucion") + "</td>");
				out.println("<td>" + rs.getBoolean("sintonizador") + "</td>");
				out.println("<td>" + rs.getFloat("carga") + "</td>");
				out.println("<td>" + "<input type=\"image\" src=\"Imagenes/deleteRow.png\"  name=\"borrar\" value=\"Borrar\" onclick=\"return confirm('¿Seguro que desea Eliminar?');\" />" + "</td>");
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