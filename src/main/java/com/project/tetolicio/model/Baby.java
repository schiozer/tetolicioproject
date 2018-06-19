package com.project.tetolicio.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Baby {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private Date bith;
	
	
	public Date getBith() {
		return bith;
	}
	public void setAge(Date bith) {
		this.bith = bith;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
