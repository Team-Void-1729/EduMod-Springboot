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
	private int time;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "edu_id", referencedColumnName = "eduid")
	private educator edu;	

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
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
		
	public educator getEdu() {
		return edu;
	}
	public void setEdu(educator edu) {
		this.edu = edu;
	}
	
	@Override
    public String toString() {
        return "Course{" +
                "id=" + courseid +
                ", type='" + type + '\'' +
                ", title=" + title +
                ", code='" + code + '\'' +
                ", credits='" + credits + '\'' +
                ", stream='" + stream + '\'' +
                ", sem='" + sem + '\'' +
                ", time='" + time + '\'' +
                ", educator='" + edu + '\'' +
                '}';
    }
}
