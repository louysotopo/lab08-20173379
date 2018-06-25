package model.entity;

import javax.jdo.annotations.IdentityType;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Resource {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private String name;
	
	@Persistent
	private boolean status;
	
	@Persistent
	private Date fecha;
 
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public Resource(String ur,boolean stat ){
		this.name = ur;
		this.status = stat;
		this.fecha = new Date();
	}
	
	public String getId() {
		return Long.toString(id);
	}

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public boolean getStatus(){
		return this.status;
	}
	public void insertStatus( boolean aux){
		this.status = aux;
	}
	public String getFecha(){
		if(this.fecha == null){
			return "gg";
		}else{
		return formatter.format(fecha);
		}
	}
	

}
