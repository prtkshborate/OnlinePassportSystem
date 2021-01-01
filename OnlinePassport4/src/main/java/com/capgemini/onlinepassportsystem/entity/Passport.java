package com.capgemini.onlinepassportsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "p")
public class Passport {

	private long id;
	private String p_type;
	
	
	public Passport()
	{
		
	}
	public Passport(long id,String p_type) {
		super();
		this.id = id;
		this.p_type = p_type;
	}
	public String getP_type() {
		return p_type;
	}
	public void setP_type(String p_type) {
		this.p_type = p_type;
	}
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return id + p_type ;
	}
	
}
