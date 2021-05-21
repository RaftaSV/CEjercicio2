<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String Id = request.getParameter("Id");
String Usuario = request.getParameter("Usu");
String Password = request.getParameter("Pass");

if(Id==null||Id==""){
	
	Id="";
	Usuario="";
	Password="";
	
}
%>
<form action="ControllerMostrarInformacion" method = "get">
<input type="hidden" value= <%= Id %>  name="IdUsuario">
<label> Usuario </label>
<Input type="text" value = "<%=Usuario %>" name ="Usuario">
<label> Password </label>
<Input type="text" value = "<%=Password %>" name ="Pass">
<button name="Guardar" value="btna">Guardar</button>
</form>
</body>
</html>