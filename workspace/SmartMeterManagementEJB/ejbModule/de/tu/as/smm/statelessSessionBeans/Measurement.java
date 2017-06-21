package de.tu.as.smm.statelessSessionBeans;

import javax.ejb.Stateless;

import de.tub.as.smm.models.SmartMeter;

/**
 * Session Bean implementation class UserDaoEJB
 */
@Stateless
public class Measurement {
	
	public double measureVolt(){
		
		double volt = Math.random()*240;
		volt = volt*10;
		Math.round(volt);
		volt = volt/10;
		return volt;
		
	}
	
	public double measureCurr(SmartMeter smart){
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
