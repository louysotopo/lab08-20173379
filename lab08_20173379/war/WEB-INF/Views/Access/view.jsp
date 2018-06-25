<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="model.entity.*" %>
<% Access mio = (Access)request.getAttribute("AccessObj"); %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aplicacion</title>
<link href="../estilos72.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <h1 class="name">Acceso</h1>
  
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
<li><a href="/access/delete?Id=<%= mio.getId() %>">Borrar</a></li>


</ul>
<% String fec = mio.getFecha(); boolean sta = mio.getStatus(); String namRol = mio.getNameRole(); String namRule = mio.getNameURL();  %>

<section>      
<div class='define'>
<div class="users index large-9 medium-8 columns content">
<form action=" " method="get"   class="sign-up">
    <h1>Cliente</h1>
    <h5>(modo vista )</h5>
    
    <label>Codigo <input class="sign-up-input" type="text" name ="lok" value="<%= mio.getId() %>" readonly="readonly" ></label><br>
    <label>Ultima Fecha de modificacion <input class="sign-up-input" type="text" name ="aasdd" value="<%= fec %>" readonly="readonly" ></label><br>
    <label>Rol<input class="sign-up-input" type="text"  name="name" value ="<%=namRol%>"   readonly="readonly" ></label><br>
    <label>Recurso<input class="sign-up-input" type="text"  name="name" value ="<%=namRule%>"  readonly="readonly" ></label><br>
    <label>Estado</label><br>
    <h5> <% if(sta){ %><%="Activo" %><%} else{ %><%="Inactivo" %><%} %></h1><br>

     <br>
    
    
    
    
  </form>

</div>

</div>
</section>
  
  
</body>
</html>