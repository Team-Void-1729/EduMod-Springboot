package org.aot.edumoduler.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class educator {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private String eduid;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String designation;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private int mobile;
	
	@Column(nullable = false)
	private String[] domain;
	
	@Column(nullable = false)
	private int yearOfExpertise;
	
	@Column(nullable = true)
	@Enumerated(value = EnumType.STRING)
	private EducatorRole roles;
	
	public enum EducatorRole {
	    EDUCATOR,
	    DEVELOPER,
	    ADMINISTRATOR
	}
	
	
	public educator() {}
	
	
	public String getEduid() {
		return eduid;
	}
	public void setEduid(String eduid) {
		this.eduid = eduid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String[] getDomain() {
		return domain;
	}
	public void setDomain(String[] domain) {
		this.domain = domain;
	}
	public int getYearOfExpertise() {
		return yearOfExpertise;
	}
	public void setYearOfExpertise(int yearOfExpertise) {
		this.yearOfExpertise = yearOfExpertise;
	}
	public EducatorRole getRoles() {
		return roles;
	}
	public void setRoles(EducatorRole roles) {
		this.roles = roles;
	}
}
