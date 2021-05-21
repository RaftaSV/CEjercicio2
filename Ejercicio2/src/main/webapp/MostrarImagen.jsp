<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
	$(document).ready(function () {

		$.post('ControllerMostrarArchivos', {
			//Enviar informacion

		}, function (response) {
			//Recibir informacion

			let datos = response;
			//console.log(datos);
			var imagen = document.getElementById('imagen');
			console.log(datos);
			for (let item of datos) {
			imagen.src="Files/"+item;
			}

		});
	});

	</script>
	<img id="imagen" alt="" src="">
</body>
</html>