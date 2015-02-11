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
<script type="text/javascript">
btnEnviar.addEventListener(MouseEvent.CLICK,camposLlenos);
function carga() //Lleva el cursor al primer campo de texto.
{
	document.getElementById("precioBase").focus();
	document.getElementById("btn2").focus();
	}
function formLavarropa()
{
	document.getElementById("resolucion").style.visibility="hidden";
	document.getElementById("sintonizador").style.visibility="hidden";	
	document.getElementById("lblResolucion").style.visibility="hidden";	
	document.getElementById("lblSintonizador").style.visibility="hidden";	
	document.getElementById("carga").style.visibility="visible";	
	document.getElementById("lblCarga").style.visibility="visible";
	}
function formTelevision()
{
	document.getElementById("carga").style.visibility="hidden";	
	document.getElementById("lblCarga").style.visibility="hidden";
	document.getElementById("resolucion").style.visibility="visible";
	document.getElementById("sintonizador").style.visibility="visible";	
	document.getElementById("lblResolucion").style.visibility="visible";	
	document.getElementById("lblSintonizador").style.visibility="visible";	
	}
function camposLlenos()
{
	var valido =true;
	var mensaje="Los siguientes campos están vacios:\n";
	
	if(document.getElementById('precioBase').value == "")
		{
		valido = false;
		mensaje +="* precio base\n";
		}

	if(document.getElementById('peso').value == "")
		{
		valido = false;
		mensaje +="* peso\n";
		}

	if(document.getElementById('resolucion').value == "")
		{
		valido = false;
		mensaje +="* resolución\n";
		}

	/*
	if(document.getElementById('carga').value == "")
		{
		valido = false;
		mensaje +="* carga\n";
		}
	*/
	
	if(!valido)
		alert(mensaje);
	else
		{
		document.getElementById('precioBase').value ="";
		document.getElementById('peso').value ="";
		document.getElementById('resolucion').value ="";
		document.getElementById('carga').value ="";
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
<title>FormAlta</title>
</head>
<body onload="carga()">
<div id="general">
<h1 style=color:white>Alta Electrodomestico</h1>
<div id="cuerpo">
<div id="controles">
<a href="#" onclick="formLavarropa()"><div id="btn1"><img src="Imagenes/lavarropa.png" alt="lavarropa" id="lavarropa"/></div></a>
<a href="#" onclick="formTelevision()"><div id="btn2"><img src="Imagenes/televisor.png" alt="televisor" id="televisor" /></div></a>
	<form method="post" action="Guardar" name="formAlta" id="formulario" >
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
	<input type="checkbox" name="sintonizador" id="sintonizador"><label id="lblSintonizador">Sintonizador</label><br>
	<label id="lblCarga" style="visibility:hidden">Carga:<input type="text" name="carga" id="carga" onkeypress="return soloNumeros(event)" style="visibility:hidden"/></label><br/>
	<br />
	<input id="btnEnviar" type="submit" name="submit" value="Guardar" onclick="camposLlenos()"/>
	<br />
	<br /> 
	</form>
<p id="link"><a href="Principal.html">Menú principal</a></p>
</div>
</div>

</div>
</body>
</html>