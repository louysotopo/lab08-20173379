<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import ="model.entity.*" %>
 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aplicacion</title>
<link href="../estilos72.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1 class="name"><a href="../">Aplicacion</a></h1>
<ul  class="horizontal">
    <li><a href="/client"> Clientes </a></li>
    <li><a href="/users">Usuarios </a></li>
    <li><a href="/roles">Roles </a></li>
    <li><a href="/resources"> Recursos</a></li>
    <li><a href="/access">Accesos </a></li>
    <li><a href="/users/logout">Log Out </a></li>
    <li><a href="/users/login">Login</a></li>
    
    
    
</ul>


<form action="/resources/add" method="get"  class="sign-up">
	<h1 class="name">Nuevo RECURSO</h1>    
    <input class="sign-up-input" type="text"  name="url"   placeholder="Nombres"  required><br>
    <label>Estado</label><br>
    <select name ="statu">
  <option value="true">Activo</option>
  <option value="false">Inactivo</option>
	</select>
    
    <input type="submit" value="Crear Recurso" class="sign-up-button" >
   
  </form>
</body>
</html>