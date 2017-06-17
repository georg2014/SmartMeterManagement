package de.tub.as.smm.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SMART_METERS")
public class SmartMeter implements Serializable {

	// Persistent Fields:
	Long id;
	private String geraeteKennung;
	private Double maxBelastung;
	private List<Reading> ablesungen;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	public Long getId() {
		return id;
	}

	@OneToMany
	@JoinColumn(name = "READINGS")
	public List<Reading> getAblesung() {
		return ablesungen;
	}

	public void setAblesung(List<Reading> ablesung) {
		this.ablesungen = ablesung;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGeraeteKennung() {
		return geraeteKennung;
	}

	public void setGeraeteKennung(String geraeteKennung) {
		this.geraeteKennung = geraeteKennung;
	}

	public Double getMaxBelastung() {
		return maxBelastung;
	}

	public void setMaxBelastung(Double maxBelastung) {
		this.maxBelastung = maxBelastung;
	}

	// Constructors:
	public SmartMeter() {
	}

	public SmartMeter(String gk, Double maxBel) {
		this.geraeteKennung = gk;
		this.maxBelastung = maxBel;
	}

	// String Representation:
	@Override
	public String toString() {
		return geraeteKennung + " (Max Belastung in Ampere " + maxBelastung + ")";

	}
}
