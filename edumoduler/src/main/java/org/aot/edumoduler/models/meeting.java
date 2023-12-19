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
public class meeting {

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private String meetingid;
	private String name;
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