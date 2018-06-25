package model.entity;
import javax.jdo.annotations.IdentityType;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Role {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private String name;
	
	@Persistent
	private Date fecha;
 
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	@Persistent
	private boolean status;
	
	public Role(String name,boolean stat){
		this.name = name;
		this.status = stat;
		fecha = new Date();
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
	
	public String getFecha(){
		return formatter.format(fecha);
	}
	
	public boolean getStatus(){
		return this.status;
	}
	public void insertStatus( boolean aux){
		this.status = aux;
	}
	
	
}
