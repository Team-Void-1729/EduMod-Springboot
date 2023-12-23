package org.aot.edumoduler.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class curriculum {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private String curid;
	
	@Column(nullable = false)
	private String branch;
	
	@Column(nullable = false)
	private int sem;

	@Column(nullable = false)
	private String status;
	
	private String[] overview;
	
	private String[] reference;
	
	private String[] outcomes;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<course> courses = new ArrayList<course>();
	
	
	public curriculum() {}
	
	
	public List<course> getCourses() {
		return courses;
	}
	public void setCourses(List<course> courses) {
		this.courses = courses;
	}


	public String[] getOverview() {
		return overview;
	}


	public void setOverview(String[] overview) {
		this.overview = overview;
	}


	public String[] getReference() {
		return reference;
	}


	public void setReference(String[] reference) {
		this.reference = reference;
	}

	public String[] getOutcomes() {
		return outcomes;
	}


	public void setOutcomes(String[] outcomes) {
		this.outcomes = outcomes;
	}
	
	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}	
	
	public String getCurid() {
		return curid;
	}

	public void setCurid(String curid) {
		this.curid = curid;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
