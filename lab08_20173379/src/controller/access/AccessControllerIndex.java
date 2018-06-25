package controller.access;

import java.io.IOException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;

import java.util.List;

import javax.servlet.*;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import model.entity.*;

@SuppressWarnings("serial")
public class AccessControllerIndex extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		
		
		
		
		
        final Query query = pm.newQuery(Access.class);
	    query.setOrdering("fecha DESC");
		
	    
	    @SuppressWarnings("unchecked")
		List<Access> accounts = (List<Access>) query.execute();
        req.setAttribute("accounts", accounts);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/Views/Access/index.jsp");
		rd.forward(req, resp);		
	}
				
}
