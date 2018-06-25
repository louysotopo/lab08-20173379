<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List"%>  
<%@ page import ="model.entity.*" %>  
 <% List<Access> accounts = (List<Access>)request.getAttribute("accounts"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aplicacion</title>
<link href="estilos72.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <h1 class="name"><a href="./">Aplicacion</a></h1>
 
<ul  class="horizontal">
     <li><a href="/client"> Clientes </a></li>
    <li><a href="/users">Usuarios </a></li>
    <li><a href="/roles">Roles </a></li>
    <li><a href="/resources"> Recursos</a></li>
    <li><a href="/access">Accesos </a></li>
    <li><a href="/users/logout">Log Out </a></li>
    <li><a href="/users/login">Login</a></li>
    
</ul>
<ul class= "navbar">

<li><h3>Acciones<h3></li>
<li><a href="/access/add">Nuevo acceso</a></li>

</ul>
<section>      
<div class='define'>
<div class="users index large-9 medium-8 columns content">
<h1>Accesos</h1>
<table>
	<thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">ID Rol</th>
                <th scope="col">ID Recurso</th>
                <th scope="col">Fecha</th>
                <th scope="col">Estado</th>
                
               
            </tr>
        </thead>
                <tbody>
         
 <% for (int i = 0;i<accounts.size();i++) { %>
   <% Access a = (Access)accounts.get(i); %>
   <tr>
   <td><a href="access/view?Id=<%= a.getId() %>"><%= a.getId() %></a></td>
    <td><%= a.getNameRole() %></td>
    <td><%= a.getNameURL() %></td>
    <td><%= a.getFecha() %></td>
    
    <td><%if(a.getStatus()){ %><%="activo"%><%} else{ %><%="inactivo" %><%} %></td>
   </tr>
  <% } %>
  
  </tbody>
  </table>
</div>

</div>
</section> 
</body>
</html>