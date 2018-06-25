package controller.users;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;

import controller.PMF;

import javax.servlet.*;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import model.entity.*;

@SuppressWarnings("serial")
public class UsersControllerStart extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query query = pm.newQuery(User.class);
	  	    
	    @SuppressWarnings("unchecked")
		List<User> accounts = (List<User>) query.execute();
	    
	    if(accounts.isEmpty()){
		
		
		Role a = new Role("admin", true);
		try{
			pm.makePersistent(a);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			pm.close();
			
		}
		
		String query2 =  "select from " + Role.class.getName()+
				" where name=='admin'" +
				" && status==true";
		PersistenceManager pm1 = PMF.get().getPersistenceManager();
		@SuppressWarnings("unchecked")
		List<Role> rSearch = (List<Role>) pm1.newQuery(query2).execute();
		
		
		User x = new User("llorenzo@unsa.edu.pe",Long.parseLong(rSearch.get(0).getId()),true );
		try{
			pm1.makePersistent(x);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			pm1.close();
			
		}
		
		String [] cadenas = {"/access/delete","/access/add",
							"/resources/delete","/resources/add",
							"/roles/delete","/roles/add",
							"/users/delete","/users/add",
							"/client/delete","/client/add"
							};
		Resource [] reso  = new Resource[10];
		
		PersistenceManager pm2 = PMF.get().getPersistenceManager();
		for(int i=0; i<reso.length;i++){
			reso[i] = new Resource(cadenas[i], true );
		}
		try{
			for(int i=0; i<reso.length;i++){
				pm2.makePersistent(reso[i]);
			}
						
		}catch(Exception e){
			System.out.println(e);
		}finally{
			pm2.close();
			
		}
		
		Access[] ac = new Access[10];
		String query21 ="";
	
		PersistenceManager pm3 = PMF.get().getPersistenceManager();
		for(int i=0; i<ac.length;i++){
				query21 =  "select from " + Resource.class.getName()+
				" where name=='" + cadenas[i] + "'" +
				" && status==true";
				@SuppressWarnings("unchecked")
				List<Resource> gg1 = (List<Resource>) pm3.newQuery(query21).execute();
				ac[i] = new Access(Long.parseLong(gg1.get(0).getId()) ,Long.parseLong(rSearch.get(0).getId()),true);
		}
		
		try{
			for(int i=0; i<ac.length;i++){
				pm3.makePersistent(ac[i]);
			}
		}catch(Exception e){
			System.out.println(e);
		}finally{
			pm3.close();
			response.sendRedirect("/users");
		}
		
	    }
	    else{
	    	response.sendRedirect("/users");
	    }
		
		
	}

}
