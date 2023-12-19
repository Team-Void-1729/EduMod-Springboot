package org.aot.edumoduler.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class educator {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private String eduid;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String college;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private int mobile;
	
	@Column(nullable = false)
	private String about;
	
	@Column(columnDefinition = "boolean default false")
    private boolean verified;

//	@OneToMany(mappedBy = "edu", fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = course.class)
//	private List<course> courses;
	
	@Column(nullable = true)
	@Enumerated(value = EnumType.STRING)
	private EducatorRole roles;
	
	public educator() {}
	public enum EducatorRole {
	    ADMIN,
	    USER
	}
	
	
	public String getEduid() {
		return eduid;
	}
	public void setEduid(String eduid) {
		this.eduid = eduid;
	}

//	public List<course> getCourses() {
//		return courses;
//	}
//	public void setCourses(List<course> courses) {
//		this.courses = courses;
//	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
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

	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	public boolean getVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	
	public EducatorRole getRoles() {
		return roles;
	}
	public void setRoles(EducatorRole roles) {
		this.roles = roles;
	}


	
}
