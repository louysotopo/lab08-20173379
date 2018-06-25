package controller.client;

import controller.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;

import javax.servlet.*;
import javax.jdo.PersistenceManager;
import model.entity.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class ClientControllerUpdate  extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		
	// comprobacion		
	com.google.appengine.api.users.User uGoogle = UserServiceFactory.getUserService().getCurrentUser();
			
			if(uGoogle==null){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/err1.jsp");
				rd.forward(request, response);
			}
			else{
				final  PersistenceManager pm = PMF.get().getPersistenceManager();
				
				String query1 =  "select from "+User.class.getName()+
						" where email=='" + uGoogle.getEmail() + "'" +
						" && status==true";
				@SuppressWarnings("unchecked")
				List<model.entity.User> uSearch = (List<model.entity.User>) pm.newQuery(query1).execute();
				if(uSearch.isEmpty()){
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/err2.jsp");
					rd.forward(request, response);
				}
				else{
					String query2 =  "select from " + Resource.class.getName()+
							" where name=='" + request.getServletPath() + "'" +
							" && status==true";
					
					@SuppressWarnings("unchecked")
					List<Resource> rSearch = (List<Resource>) pm.newQuery(query2).execute();
					if(rSearch.isEmpty()){
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/err3.jsp");
						rd.forward(request, response);
					}
					else{
						
						String query3 =  "select from " + Access.class.getName()+
								" where idRule== " + uSearch.get(0).getRole()  +
								" && idURL== " + rSearch.get(0).getId()  +
								" && status==true";
						@SuppressWarnings("unchecked")
						List<Access> aSearch = (List<Access>) pm.newQuery(query3).execute();
						
						if(aSearch.isEmpty()){
							RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/err4.jsp");
							rd.forward(request, response);
						}
						else{
							// aqui termina conprobacion
	
	
	
		
		 
		 Key k = KeyFactory.createKey(Client.class.getSimpleName(), new Long(request.getParameter("lok")).longValue());
			Client  a = pm.getObjectById(Client.class, k);
		 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Client/update.jsp");
		 if(request.getParameter("name")== null){
			  request.setAttribute("ClientObj", a);
				rd.forward(request, response);
						
			}
		 else{
			 
			String address1=(String)request.getParameter("address");
			String name1 =(String)request.getParameter("name");
			String celu1 = (String)request.getParameter("celular");
			String docIde = (String)request.getParameter("ide");
			String email1 = (String)request.getParameter("email");
			String ruc1 = (String)request.getParameter("ru");
			boolean status1= false;
			
			if(((String)request.getParameter("statu")).equals("true")){
				status1 = true;
			}
			
			a.setAddress(address1);
			a.setName(name1);
			a.setCelular(celu1);
			a.setDocIde(docIde);
			a.setEmail(email1);
			a.setRuc(ruc1);
			a.insertStatus(status1);
			a.UpDateFecha();
		
			pm.close();
		  response.sendRedirect("/client");
		 
			
	}
}
}}}}}