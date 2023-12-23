package org.aot.edumoduler.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class course {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private String courseid;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false, unique = true)
	private String title;
	
	@Column(nullable = false, unique = true)
	private String code;
	
	@Column(nullable = false)
	private int credits;
	
	@Column(nullable = false)
	private String stream;
	
	@Column(nullable = false)
	private String sem;
	
	@Column(nullable = false)
	private int L;
	
	@Column(nullable = false)
	private int T;
	
	@Column(nullable = false)
	private int P;

	public course() {}

	
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}

	public int getL() {
		return L;
	}
	public void setL(int l) {
		L = l;
	}

	public int getT() {
		return T;
	}
	public void setT(int t) {
		T = t;
	}
	
	public int getP() {
		return P;
	}
	public void setP(int p) {
		P = p;
	}
}
