package de.tub.as.smm.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SmartMeter implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String geraeteKennung;
    private Double maxBelastung;
    
 
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
