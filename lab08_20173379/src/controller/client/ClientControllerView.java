package controller.client;

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
public class ClientControllerView  extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		

		final  PersistenceManager pm = PMF.get().getPersistenceManager();
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Client/view.jsp");
		
		Key k = KeyFactory.createKey(Client.class.getSimpleName(), new Long(request.getParameter("Id")).longValue()); 
		Client  a = pm.getObjectById(Client.class, k);
		
		
		request.setAttribute("ClientObj", a);
		rd.forward(request, response);
		
	   
		 
			
	}
			

}