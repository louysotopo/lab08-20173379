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


<form action="/client/add" method="get"  class="sign-up">
	<h1 class="name">Nuevo Cliente</h1>    
    <input class="sign-up-input" type="text"  name="name"   placeholder="Nombres" pattern="[a-zA-Z]{1,40}" title="ingrese mas de una letra y menos de 40" required><br>
    <input  class="sign-up-input" type="text"  name="address"   placeholder="Direccion" required><br>
    <input  class="sign-up-input" type="email"  name="email"    placeholder="Correo@Electronico.etc"  required ><h5 style="color:red"> <br>
    
    <input  class="sign-up-input" type="text"  name="ide"    placeholder="DNI" pattern="[0-9]{8}" title="ingrese 8 numeros" required><br>
    
    <input  class="sign-up-input" type="text"  name="celu"    placeholder="Celular" pattern="[0-9]{5,15}" title="ingrese mas de 5 numeros" required><br>

    <input  class="sign-up-input" type="text"  name="ru"    placeholder="RUC" pattern="(10|20|17|15|16)[0-9]{9}" title="ingrese 11 digitos " ><br>
    <label>Estado</label><br>
    <select name ="statu">
  <option value="true">Activo</option>
  <option value="false">Inactivo</option>
	</select>
    
    <input type="submit" value="Crear" class="sign-up-button" >
   
  </form>
</body>
</html>