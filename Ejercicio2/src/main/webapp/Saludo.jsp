<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<head>
<meta charset="utf-8">
<title>Insert title here</title>
<!-- Required meta tags -->

<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

</head>
<body>
	<h1>USUARIOS</h1>
	<br>
	<a href="add.jsp"  class="btn btn-primary"> Agregar </a>
	
	<script type="text/javascript">
	
	$(document).ready(function(){
		
		$.post('ControllerMostrarInformacion',{
			//Enviar informacion
			
		}, function(response){
			//Recibir informacion
			
			let datos = JSON.parse(response);
			console.log(datos);
			
			var tabla = document.getElementById('tablaDatos');
			for(let item of datos){
				
				tabla.innerHTML += `
				 <tr>
					<td> ${item.idUsuario} </td>
				    <td> ${item.Usuario} </td>
					<td> ${item.PassWord} </td>
					<td> ${item.TipoUsuario}</td>
					<td>
					<a href="ControllerMostrarInformacion?usu=${item.idUsuario}&Eliminar=btne" class="btn btn-danger"> Eliminar </a> 
					<a href="add.jsp?Id=${item.idUsuario}&Usu=${item.Usuario}&Pass=${item.PassWord}" class="btn btn-warning"> Actualizar </a> 
					</td>

				</tr>
				`
				
				console.log(item.Pass);
			}
			
			
		});
	});
	
	</script>
	<%
	HttpSession sesion = (HttpSession) request.getSession();
	String usuSession = String.valueOf(sesion.getAttribute("usuario"));
	System.out.print(usuSession + " Nombre usuario");
	
	if(usuSession.equals(null) || usuSession.equals("null") ){
		
		response.sendRedirect("Index.jsp");
		
	}
	
	%>
	
	<form action="ControllerLogin" method="post">
	
	<input type="submit" name="btncerrar" value="cerrar">
	
	</form>
	<table class="table table-dark" id="tablaDatos">
		<thead>
			<th>ID</th>
			<th>Usuario</th>
			<th>Pass</th>
			<th> Tipo</th>
			<th>Acciones</th>
		</thead>
	</table>


</body>
</html>