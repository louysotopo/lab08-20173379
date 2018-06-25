<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="model.entity.*" %>
<% Client mio = (Client)request.getAttribute("ClientObj"); %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aplicacion</title>
<link href="../estilos72.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <h1 class="name">Cliente</h1>
  
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
<li><a href="/client/delete?Id=<%= mio.getId() %>">Borrar</a></li>
<li><a href="/client/update?lok=<%= mio.getId() %>">Modificar</a></li>

</ul>
<% String fec = mio.getFecha();String ruci = mio.getRuc(); boolean sta = mio.getStatus(); String nam = mio.getName(); String add =mio.getAddress(); String em = mio.getEmail();  String id= mio.getDocIde(); String  ce = mio.getCelular();%>

<section>      
<div class='define'>
<div class="users index large-9 medium-8 columns content">
<form action=" " method="get"   class="sign-up">
    <h1>Cliente</h1>
    <h5>(modo vista )</h5>
    
    <label>Codigo <input class="sign-up-input" type="text" name ="lok" value="<%= mio.getId() %>" readonly="readonly" ></label><br>
    <label>Ultima Fecha de modificacion <input class="sign-up-input" type="text" name ="aasdd" value="<%= fec %>" readonly="readonly" ></label><br>
    <label>Nombre <input class="sign-up-input" type="text"  name="name" value ="<%=nam%>"  pattern="[a-zA-Z]{1,40}" title="ingrese mas de una letra y menos de 40" readonly="readonly" ></label><br>
    <label>Direccion <input  class="sign-up-input" type="text"  name="address" value="<%=add%>"  readonly="readonly" ></label><br>
    <label>Email <input class="sign-up-input"  class="sign-up-input"type="email"  name="email"  value="<%=em%>" readonly="readonly" ></label><br>
    <label>RUC<input  class="sign-up-input" type="text"  name="ru"  value="<%=ruci%>"  value="<%=id%>"  pattern="(10|20|17|15|16)[0-9]{9}" title="ruc valido >:v "   readonly="readonly"></label><br>
    <label>DNI <input class="sign-up-input" type="text"  name="ide"  value="<%=id%>" pattern="[0-9]{8}" title="ingrese 8 numeros"  readonly="readonly"></label><br>
    <label>Celular</label> <input class="sign-up-input" type="text"  name="celular"  value="<%=ce%>" pattern="[0-9]{5,15}" title="ingrese mas de 5 numeros"  readonly="readonly" ></label><br>
    <label>Estado</label><br>
    <h5> <% if(sta){ %><%="Activo" %><%} else{ %><%="Inactivo" %><%} %></h1><br>

     <br>
    
    
    
    
  </form>

</div>

</div>
</section>
  
  
</body>
</html>