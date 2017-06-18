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
@Table(name = "READING")
public class Reading implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7484804196838031411L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "R_ID")
	Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SMART_ID")
	private SmartMeter geraet;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private User benutzer;

	@Column(name = "TIME")
	private Date zp;

	@Column(name = "VALUE")
	private Double kwh;

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
