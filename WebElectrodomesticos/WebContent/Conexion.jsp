<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="java.sql.Connection"
	import="java.sql.DriverManager"
	import="java.sql.ResultSet"
	import="java.sql.Statement"
	import="java.sql.SQLException"
%>

<%
Connection conex =null;
Statement sql = null;
try{
	Class.forName("com.mysql.jdbc.Driver");
	conex = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos");
	sql = conex.createStatement();
}catch(Exception e){

}
%>
