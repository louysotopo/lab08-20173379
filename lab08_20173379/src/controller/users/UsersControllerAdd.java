package controller.users;

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
public class UsersControllerAdd extends HttpServlet{

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	//comprobacion
		com.google.appengine.api.users.User uGoogle = UserServiceFactory.getUserService().getCurrentUser();
		
		if(uGoogle==null){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/err1.jsp");
			rd.forward(req, resp);
		}
		else{
			final PersistenceManager pm = PMF.get().getPersistenceManager();
			
			String query1 =  "select from "+User.class.getName()+
					" where email=='" + uGoogle.getEmail() + "'" +
					" && status==true";
			@SuppressWarnings("unchecked")
			List<model.entity.User> uSearch = (List<model.entity.User>) pm.newQuery(query1).execute();
			if(uSearch.isEmpty()){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/err2.jsp");
				rd.forward(req, resp);
			}
			else{
				String query2 =  "select from " + Resource.class.getName()+
						" where name=='" + req.getServletPath() + "'" +
						" && status==true";
				
				@SuppressWarnings("unchecked")
				List<Resource> rSearch = (List<Resource>) pm.newQuery(query2).execute();
				if(rSearch.isEmpty()){
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/err3.jsp");
					rd.forward(req, resp);
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
						rd.forward(req, resp);
					}
					else{
						//aqui termina comprobacion
	
	
	
	
	
	
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/Views/Users/add.jsp");
		
		if(req.getParameter("mail")== null){
			final Query query = pm.newQuery(Role.class);
		    query.setOrdering("fecha DESC");
		    @SuppressWarnings("unchecked")
			List<Role> roles = (List<Role>) query.execute();
	        req.setAttribute("roles", roles);
			rd.forward(req, resp);
					
		}
		else{
			//---------
			String query4 =  "select from "+User.class.getName()+
					" where email=='" + req.getParameter("mail") + "'" +
					"";
			@SuppressWarnings("unchecked")
			List<model.entity.User> fSearch = (List<model.entity.User>) pm.newQuery(query4).execute();
			if(fSearch.isEmpty()){

				boolean status1= false;
				String aux = "true";
				if(aux.equalsIgnoreCase(((String)req.getParameter("statu")))){
					status1 = true;
				}
				User a = new User(req.getParameter("mail"),Long.parseLong(req.getParameter("role")), status1 );
			try{
				pm.makePersistent(a);
			}catch(Exception e){
				System.out.println(e);
			}finally{
				pm.close();
				resp.sendRedirect("/users");
			}
			}else{
				resp.sendRedirect("/users");
			}
			
			//---------
			
			
			
			
		}}}}}
}}
		

