package de.tu.as.smm.statelessSessionBeans;

import javax.ejb.Stateless;

import de.tub.as.smm.models.SmartMeter;

/**
 * Session Bean implementation class UserDaoEJB
 */
@Stateless
public class Measurement {
	
<<<<<<< HEAD
	/**
<<<<<<< HEAD
	 *Die Spannung(Genauigkeit: 0.1 Volt)
	 *soll zwischen 220 und 240 Volt liegen
	 * @return
	 */
	public double measureVolt(){
		
		
		double volt = Math.random()*20+220;
		volt = Math.round(volt);
=======
		Die Spannung(Genauigkeit: 0.1 Volt)
		soll zwischen 220 und 240 Volt liegen*/
	public double measureVolt(){
		
		double volt = Math.random()*20;
		volt = (volt+220)*10;
		Math.round(volt);
>>>>>>> origin/GeorgsZweigAufgabe2
=======
	public double measureVolt(){
		
		/**
		Die Spannung(Genauigkeit: 0.1 Volt)
		soll zwischen 220 und 240 Volt liegen*/
		double volt = Math.random()*20;
		volt = (volt+220)*10;
		Math.round(volt);
>>>>>>> parent of 3791c3a... Es ist vollbracht :D
		volt = volt/10;
		return volt;
		
	}
	
<<<<<<< HEAD
	/**
<<<<<<< HEAD
	 *Die Stromstärke (Genauigkeit: 0.1 Ampere) liegt
	 *zwischen 0 und (der jeweiligen maximalen Belastung +5 Ampere)
	 * @param smart
	 * @return
	 */
	public double measureCurr(SmartMeter smart){
		
=======
		die Stromstärke (Genauigkeit: 0.1 Ampere) 
		zwischen 0 und (der jeweiligen maximalen Belastung 
		+5 Ampere) */
	public double measureCurr(SmartMeter smart){
>>>>>>> origin/GeorgsZweigAufgabe2
=======
	public double measureCurr(SmartMeter smart){
		/**
		die Stromstärke (Genauigkeit: 0.1 Ampere) 
		zwischen 0 und (der jeweiligen maximalen Belastung 
		+5 Ampere) */
>>>>>>> parent of 3791c3a... Es ist vollbracht :D
		double curr = Math.random()*smart.getMaxBelastung();
		curr = curr*10;
		Math.round(curr);
		curr = curr/10;
		return curr;
	}

	public boolean isOverMax(SmartMeter smart, Double current){
		
		if(smart.getMaxBelastung() < current){
			return true;
		}
		else{
			return false;
		}
	}
	
}
