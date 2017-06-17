package de.tub.as.smm.models;

import java.util.Date;

public class Reading {
	
	Long id;
	private SmartMeter geraet;
	private User benutzer;
	private Date zp;
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
