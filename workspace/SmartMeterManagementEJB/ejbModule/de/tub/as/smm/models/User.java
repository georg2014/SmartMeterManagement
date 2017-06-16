package de.tub.as.smm.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User implements Serializable {
 
    // Persistent Fields:
    Long id;
    private String name;
    private Date signingDate;
    private List<Reading> readings;
    
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="USER_ID")
    public Long getId() {
		return id;
	}
    
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="SINGING_DATE")
	public Date getSigningDate() {
		return signingDate;
	}

	// Constructors:
    public User() {
    }
 
    public User(String name) {
        this.name = name;
        this.signingDate = new Date(System.currentTimeMillis());
    }
 
    // String Representation:
    @Override
    public String toString() {
        return name + " (signed on " + signingDate + ")";
    }
}