package com.project.tetolicio.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Version;


@Entity
@Table(name="Baby")
public class Baby {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Column(name="name", unique = true, nullable = false, length = 250)
	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name="birth", unique = false, nullable = false)
	private Date birth;
	
	@Version
	private int version;
	
	@OneToMany(mappedBy = "baby", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Activity> activities;
	
	public List<Activity> getActivities() {
		return activities;
	}
	
	/*Wat*/
	
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public Date getBirth() {
		return birth;
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
	
	public Integer getVersion() {
		return version;
	}
}
