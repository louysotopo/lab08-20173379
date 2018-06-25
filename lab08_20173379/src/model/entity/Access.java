package model.entity;
import javax.jdo.annotations.IdentityType;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF;


@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Access {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private Long idRule;
	
	@Persistent
	private Long idURL;
	
	@Persistent
	private boolean status;
		
	
	@Persistent
	private Date fecha;
 
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public Access(Long idR,Long idU,boolean stat){
		this.idRule = idU;
		this.idURL= idR;
		this.status = stat;
		this.fecha = new Date();
	}
	
	public String getId() {
		return Long.toString(id);
	}
	public String  getIdRule(){
		return Long.toString(this.idRule);
	}
	public String getIdUrl(){
		return Long.toString(this.idURL);
	}

	public boolean getStatus(){
		return this.status;
	}
	public void insertStatus( boolean aux){
		this.status = aux;
	}
	public String getFecha(){
		if(this.fecha == null){
			return "null";
		}else{
		return formatter.format(fecha);
		}
	}
	public String getNameRole(){
		final  PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Role.class.getSimpleName(), this.idRule); //aqui
		try{
		Role  a = pm.getObjectById(Role.class, k);
		if(a ==null){
			return "desconocido ";
		}
		return a.getName();
		}catch(Exception e){
			return "desconocido";
		}
	}
	public String getNameURL(){
		final  PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Resource.class.getSimpleName(), this.idURL); //aqui
		try{
		Resource  e = pm.getObjectById(Resource.class, k);
		if(e ==null){
			return "desconocido ";
		}
		return e.getName();
		}catch(Exception e){
			return "desconocido";
		}
	}
}
