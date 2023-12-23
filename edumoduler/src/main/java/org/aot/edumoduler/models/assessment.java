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
public class assessment {

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private String assid;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int marks;
	
	@Column(nullable = false)
	private String type;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAssid() {
		return assid;
	}

	public void setAssid(String assid) {
		this.assid = assid;
	}
	
	// toString() method for representation
    @Override
    public String toString() {
        return "Assessment{" +
                "id=" + assid +
                ", type='" + type + '\'' +
                ", marks=" + marks +
                ", name='" + name + '\'' +
                '}';
    }
	
}
