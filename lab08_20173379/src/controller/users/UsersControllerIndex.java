package controller.users;


import java.io.IOException;
import javax.servlet.http.*;

import controller.PMF;

import java.util.List;

import javax.servlet.*;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import model.entity.*;

@SuppressWarnings("serial")
public class UsersControllerIndex extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		
		
        final Query query = pm.newQuery(User.class);
	    query.setOrdering("fecha DESC");
		
	    
	    @SuppressWarnings("unchecked")
		List<User> accounts = (List<User>) query.execute();
        req.setAttribute("accounts", accounts);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/Views/Users/index.jsp");
		rd.forward(req, resp);		
	}

}
