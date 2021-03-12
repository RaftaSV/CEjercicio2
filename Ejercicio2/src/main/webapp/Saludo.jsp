<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

</head>
<body>
	<h1>WELLCOME</h1>
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
					<td> <button type="button" class="btn btn-warning">Editar</button> 
					<a href="ControllerMostrarInformacion?usu=${item.idUsuario}" class="btn btn-danger"> Eliminar </a> </td>

				</tr>
				`
				
				console.log(item.Pass);
			}
			
			
		});
	});
	
	</script>
	<table class="table table-dark" id="tablaDatos">
		<thead>
			<th>ID</th>
			<th>Usuario</th>
			<th>Pass</th>
			<th>Acciones</th>
		</thead>
	</table>


</body>
</html>