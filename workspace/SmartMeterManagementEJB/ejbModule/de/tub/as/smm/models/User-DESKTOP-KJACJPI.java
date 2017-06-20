
package de.tub.as.smm.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class User implements Serializable {

	// Persistent Fields:

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SINGING_DATE")
	private Date signingDate;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "benutzer")
	private List<Reading> readings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getSigningDate() {
		return signingDate;
	}

	public List<Reading> getReadings() {
		return readings;
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