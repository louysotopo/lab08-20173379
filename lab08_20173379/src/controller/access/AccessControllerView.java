package controller.access;

import java.io.IOException;


import javax.servlet.http.*;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.jdo.PersistenceManager;
import model.entity.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


import controller.*;

@SuppressWarnings("serial")
public class AccessControllerView extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
	
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Access/view.jsp");
	
	Key k = KeyFactory.createKey(Access.class.getSimpleName(), new Long(request.getParameter("Id")).longValue()); //aqui
	Access  a = pm.getObjectById(Access.class, k);
	
	request.setAttribute("AccessObj", a);
	rd.forward(request, response);
	
	
	
	}
}
