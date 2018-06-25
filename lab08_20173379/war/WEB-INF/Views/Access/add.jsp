<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.List"%>
 <%@ page import ="model.entity.*" %>
  <% List<Resource> resources = (List<Resource>)request.getAttribute("resources"); %>
 <% List<Role> roles = (List<Role>)request.getAttribute("roles"); %>
    
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


<form action="/access/add" method="get"  class="sign-up">
	<h1 class="name">Nuevo Acceso</h1>    
    
     <h3>RECURSO</h3>
      <select name ="url">
     <% for (int i = 0;i<resources.size();i++) { %>
   <% Resource a = (Resource)resources.get(i); %>
  <option value="<%= a.getId() %>"><%= a.getName() %></option>
  <%} %>
  </select>
  <h3>Rol</h3>
      <select name ="rule">
     <% for (int i = 0;i<roles.size();i++) { %>
   <% Role a = (Role)roles.get(i); %>
  <option value="<%= a.getId() %>"><%= a.getName() %></option>
  <%} %>
  <label>Estado</label><br>
  </select>
    <select name ="statu">
  <option value="true">Activo</option>
  <option value="false">Inactivo</option>
	</select>
    
    <input type="submit" value="Crear Acceso" class="sign-up-button" >
   
  </form>
</body>
</html>