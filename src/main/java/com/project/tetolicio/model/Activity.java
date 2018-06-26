package com.project.tetolicio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Activity")
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ActivitySpecificationId", referencedColumnName = "Id")
	private ActivitySpecification spec;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BabyId", referencedColumnName = "Id")
	private Baby baby;
	
	@Temporal(TemporalType.TIME)
	@Column(name="activityDate", unique = false, nullable = false)
	private Date activityDate;

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	@Column(name="activityStart", precision=10, scale=2)
	private Double activityStart;
	
	@Column(name="activityEnd", precision=10, scale=2)
	private Double activityEnd;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ActivitySpecification getSpec() {
		return spec;
	}

	public void setSpec(ActivitySpecification spec) {
		this.spec = spec;
	}

	public Baby getBaby() {
		return baby;
	}

	public void setBaby(Baby baby) {
		this.baby = baby;
	}

	public Double getActivityStart() {
		return activityStart;
	}

	public void setActivityStart(Double activityStart) {
		this.activityStart = activityStart;
	}

	public Double getActivityEnd() {
		return activityEnd;
	}

	public void setActivityEnd(Double activityEnd) {
		this.activityEnd = activityEnd;
	}
}
