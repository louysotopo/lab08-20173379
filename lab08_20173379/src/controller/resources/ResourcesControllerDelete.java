package controller.resources;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;


import javax.servlet.*;
import javax.jdo.PersistenceManager;
import model.entity.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.UserServiceFactory;

import controller.*;

@SuppressWarnings("serial")
public class ResourcesControllerDelete extends HttpServlet{

@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

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
	
	
	
		
	
	// comprobacion

		
		
		Key k = KeyFactory.createKey(Resource.class.getSimpleName(), new Long(request.getParameter("Id")).longValue()); //aqui
		Resource  a = pm.getObjectById(Resource.class, k);
		pm.deletePersistent (a);
		
	   response.sendRedirect("/resources");
}}}}}
}
