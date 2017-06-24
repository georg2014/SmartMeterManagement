package de.tub.as.smm.statelessSessionBeans;

import javax.ejb.Stateless;

import de.tub.as.smm.models.SmartMeter;

/**
 * Session Bean implementation class UserDaoEJB
 */
@Stateless
public class Measurement {
	
	/**
	 *Die Spannung(Genauigkeit: 0.1 Volt)
	 *soll zwischen 220 und 240 Volt liegen
	 * @return
	 */
	public double measureVolt(){
		
		
		double volt = Math.random()*20+220;
		volt = volt*10;
		volt = Math.round(volt);
		volt = volt/10;
		return volt;
		
	}
	
	/**
	 *Die Stromstärke (Genauigkeit: 0.1 Ampere) liegt
	 *zwischen 0 und (der jeweiligen maximalen Belastung +5 Ampere)
	 * @param smart
	 * @return
	 */
	public double measureCurr(SmartMeter smart){
		
<<<<<<< HEAD
		double curr = Math.random()*smart.getMaxBelastung();
=======
		double curr = Math.random()*smart.getMaxBelastung()+5;
>>>>>>> refs/heads/JakobsZweigAufgabe2
		curr = curr*10;
		curr = Math.round(curr);
		curr = curr/10;
		return curr;
	}
	
	/**
	 * checks if the current of the given smart meter is over max 
	 * @param smart Meter
	 * @param current
	 * @return boolean
	 */
	public boolean isOverMax(SmartMeter smart, Double current){
		
		if(smart.getMaxBelastung() < current){
			return true;
		}
		else{
			return false;
		}
	}
	
}
