<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="model.entity.*" %>
<% Client mio = (Client)request.getAttribute("ClientObj"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aplication</title>
<link href="../estilos72.css" rel="stylesheet" type="text/css" />
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
<li><a href="/client/delete?Id=<%= mio.getId() %>">Borrar</a></li>
<li><a href="/client/view?Id=<%= mio.getId() %>"> Volver al modo vista</a></li>

</ul>
<% String fec = mio.getFecha();String ruci = mio.getRuc();String  nam = mio.getName(); String add =mio.getAddress(); String em = mio.getEmail();  String id= mio.getDocIde(); String  ce = mio.getCelular();%>
<section>
<div class='define'>
<div class="users index large-9 medium-8 columns content">
<form action="/client/update" method="get"   class="sign-up">
    <h1>Cliente</h1>
    <h5>(modo edicion)</h5>
    
    <label>Codigo <input class="sign-up-input" type="text" name ="lok" value="<%= mio.getId() %>" readonly="readonly" ></label><br>
    <label>Ultima Fecha de modificacion <input class="sign-up-input" type="text" name ="aasdd" value="<%= fec %>" readonly="readonly" ></label><br>
    <label>Nombre <input class="sign-up-input" type="text"  name="name" value ="<%=nam%>"  pattern="[a-zA-Z]{1,40}" title="ingrese mas de una letra y menos de 40" required></label><br>
    <label>Direccion <input  class="sign-up-input" type="text"  name="address" value="<%=add%>" required></label><br>
    <label>Email <input class="sign-up-input"  class="sign-up-input"type="email"  name="email"  value="<%=em%>" required ></label>
    
    <label>DNI <input class="sign-up-input" type="text"  name="ide"  value="<%=id%>" pattern="[0-9]{8}" title="ingrese 8 numeros" required></label><br>
    
     <label>RUC<input  class="sign-up-input" type="text"  name="ru"  value="<%=ruci%>"  value="<%=id%>"  pattern="(10|20|17|15|16)[0-9]{9}" title="ruc valido >:v " required></label>
     <label>Celular</label> <input class="sign-up-input" type="text"  name="celular"  value="<%=ce%>" pattern="[0-9]{5,15}" title="ingrese mas de 5 numeros" required></label>
    <label>Estatus</label><br>
	<select name ="statu">
  <option value="true">Activo</option>
  <option value="false">Inactivo</option>
	</select>
     <br>
    <input type="submit" value="Modificar Datos"   class="sign-up-button" ><br/>
    
    
    
  </form>
  </div>

</div>
</section>
  
</body>
</html>