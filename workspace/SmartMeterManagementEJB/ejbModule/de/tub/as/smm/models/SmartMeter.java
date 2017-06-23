package de.tub.as.smm.models;

import java.io.Serializable;
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
@Table
public class SmartMeter implements Serializable {

	// Persistent Fields:
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "METER_ID")
	Long id;

	@Column(name = "GK")
	private String geraeteKennung;

	@Column(name = "MAX")
	private Double maxBelastung;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "geraet")
	private List<Reading> ablesungen;

	public Long getId() {
		return id;
	}

	public List<Reading> getAblesung() {
		return ablesungen;
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
