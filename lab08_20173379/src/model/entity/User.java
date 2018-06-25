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
public class User {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private Long idRole;
	
	
	@Persistent
	private String email;
	
	@Persistent
	private String docIde; //*doc de identidad DNI / RUC
	 
	@Persistent
	private Date fecha;
 
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	@Persistent
	private boolean status;
	
	
	@Persistent
	private String ruc; 
	
	public User(String email,Long rol,boolean sta) {
		super();
	
		this.email = email;
		this.fecha = new Date();
		this.status = sta;
		this.idRole = rol;
	}
	
	public String getId() {
		return Long.toString(id);
	}

	public void setId(String idPersona) {
		Long clave =Long.parseLong(idPersona);
		this.id = clave;
	}

	public String getRole(){
		return Long.toString(idRole);
	}
	public String getNameRole(){
		final  PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Role.class.getSimpleName(), this.idRole); //aqui
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
		
	public void insertStatus( boolean aux){
		this.status = aux;
	}
	public String getFecha(){
		return formatter.format(fecha);
	}
	
	public boolean getStatus(){
		return this.status;
	}
	public String getEmail(){
		return this.email;
	}
	
	
	
	

}
