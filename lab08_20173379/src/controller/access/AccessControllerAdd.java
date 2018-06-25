package controller.access;

import model.entity.*;
import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import javax.servlet.*;

@SuppressWarnings("serial")
public class AccessControllerAdd extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
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
	
	
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Access/add.jsp");
		
		if(request.getParameter("url")== null){
			final Query query12 = pm.newQuery(Role.class);
		    query12.setOrdering("fecha DESC");
		    
		    final Query query22 = pm.newQuery(Resource.class);
		    query22.setOrdering("fecha DESC");			
		    
		    @SuppressWarnings("unchecked")
			List<Role> roles = (List<Role>) query12.execute();
	        request.setAttribute("roles", roles);
	        

		    @SuppressWarnings("unchecked")
			List<Client> resources = (List<Client>) query22.execute();
	        request.setAttribute("resources", resources);
			
			rd.forward(request, response);
					
		}
		else{
			
//------------
			String query4 =  "select from " + Access.class.getName()+
					" where idRule== " + request.getParameter("rule") +
					" && idURL== " + request.getParameter("url")  +
					"";
			@SuppressWarnings("unchecked")
			List<Access> fSearch = (List<Access>) pm.newQuery(query4).execute();
			
			if(fSearch.isEmpty()){
				boolean status1= false;
				String aux = "true";
				if(aux.equalsIgnoreCase(((String)request.getParameter("statu")))){
					status1 = true;
				}
				
				Access a = new Access( Long.parseLong(request.getParameter("url")),Long.parseLong(request.getParameter("rule")), status1 );
			try{
				pm.makePersistent(a);
			}catch(Exception e){
				System.out.println(e);
			}finally{
				pm.close();
				response.sendRedirect("/access");
			}
			
			
				
			}else{
				response.sendRedirect("/access");
			}
//-----------------------			
			
				
			
		}

		
				}}}}
			
	}
	

}
