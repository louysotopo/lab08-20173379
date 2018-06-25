package controller.users;

import java.io.IOException;


import javax.servlet.http.*;


import javax.servlet.*;
import javax.jdo.PersistenceManager;
import model.entity.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


import controller.*;

@SuppressWarnings("serial")
public class UsersControllerView extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

		// comprobacion		

			final  PersistenceManager pm = PMF.get().getPersistenceManager();
			
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Users/view.jsp");
	
	Key k = KeyFactory.createKey(User.class.getSimpleName(), new Long(request.getParameter("Id")).longValue()); 
	User  a = pm.getObjectById(User.class, k);
	
	request.setAttribute("AccessObj", a);
	rd.forward(request, response);
	
	
					
	}
}
