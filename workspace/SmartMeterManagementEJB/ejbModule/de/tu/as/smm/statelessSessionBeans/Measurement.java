package de.tu.as.smm.statelessSessionBeans;

import javax.ejb.Stateless;

import de.tub.as.smm.models.SmartMeter;

/**
 * Session Bean implementation class UserDaoEJB
 */
@Stateless
public class Measurement {
	
	public double measureVolt(){
		//TODO
		return Math.random()*6 + 1;
	}
	
	public double measureCurr(){
		//TODO
		return Math.random()*6 +1;
	}

	public boolean isOverMax(SmartMeter that, Double current){
		
		if(that.getMaxBelastung() < current){
			return true;
		}
		else{
			return false;
		}
	}
	
}
