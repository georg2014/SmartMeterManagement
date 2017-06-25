package de.tub.as.smm.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Reading implements Serializable {
	
	// Persistent Fields:
	//Persistent auto generatet Id attribute
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "R_ID")
	Long id;

	//many to one relation with smartmeter
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private SmartMeter geraet;

	//many to one relation with user
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private User benutzer;

	@Column(name = "TIME")
	private Date zp;

	@Column(name = "VALUE")
	private Double kwh;

	//Getters n setters
	public SmartMeter getGeraet() {
		return geraet;
	}

	public void setGeraet(SmartMeter geraet) {
		this.geraet = geraet;
	}

	public User getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(User benutzer) {
		this.benutzer = benutzer;
	}

	public Date getZp() {
		return zp;
	}

	public void setZp(Date zp) {
		this.zp = zp;
	}

	public Double getKwh() {
		return kwh;
	}

	public void setKwh(Double kwh) {
		this.kwh = kwh;
	}

	// Constructors:
	public Reading() {
	}

	public Reading(SmartMeter gk, User u, Double stand) {
		this.geraet = gk;
		this.benutzer = u;
		this.zp = new Date(System.currentTimeMillis());
		this.kwh = stand;
	}

	// String Representation:
	@Override
	public String toString() {
		return null;

	}

}
