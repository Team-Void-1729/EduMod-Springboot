package org.aot.edumoduler.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class curriculum {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private String curid;
	
	@Column(nullable = false)
	private String branch;
	
	@Column(nullable = false)
	private String sem;
	
	@Column(nullable = false)
	private String status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "edu_id", referencedColumnName = "eduid")
	private educator edu;	
	
	public curriculum() {}
	
	
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

	public String getSem() {
		return sem;
	}

	public void setSemester(String sem) {
		this.sem = sem;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public educator getEdu() {
		return edu;
	}

	public void setEducator(educator edu) {
		this.edu = edu;
	}
}
