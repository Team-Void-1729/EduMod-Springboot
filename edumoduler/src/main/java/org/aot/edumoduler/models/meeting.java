package org.aot.edumoduler.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class meeting {

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private String meetingid;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String timestamp;
	
	public String getMeetingid() {
		return meetingid;
	}
	public void setMeetingid(String meetingid) {
		this.meetingid = meetingid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}