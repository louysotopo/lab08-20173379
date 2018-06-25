package controller.roles;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.jdo.PersistenceManager;
import model.entity.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.UserServiceFactory;

import controller.*;

@SuppressWarnings("serial")
public class RolesControllerView  extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {


			final  PersistenceManager pm = PMF.get().getPersistenceManager();
			
	
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Roles/view.jsp");
	
	Key k = KeyFactory.createKey(Role.class.getSimpleName(), new Long(request.getParameter("Id")).longValue()); //aqui
	Role  a = pm.getObjectById(Role.class, k);
	
	request.setAttribute("RolesObj", a);
	rd.forward(request, response);
	
	
	
	}
				
}
