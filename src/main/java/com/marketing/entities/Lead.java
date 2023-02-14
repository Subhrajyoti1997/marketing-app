package com.marketing.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leads")


//if we want to different name of table then use @Table 
//if not use it automatically take class name as database name


public class Lead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	//we can make id as wrapper type or datatype 
	
	@Column(name="first_name",nullable =false, length=45)
	private String firstName;//in java camelcase but we use snakecase (db_hh) in db
	@Column(name="last_name",nullable =false, length=45)
	private String lastName;
	@Column(name="email",nullable =false, length=128,unique=true)
	private String email;
	private long mobile;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

}
