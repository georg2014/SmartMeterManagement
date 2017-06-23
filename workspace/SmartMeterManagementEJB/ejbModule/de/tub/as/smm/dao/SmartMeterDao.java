package de.tub.as.smm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.tub.as.smm.models.Reading;
import de.tub.as.smm.models.SmartMeter;
import de.tub.as.smm.models.User;

/**
 * Session Bean implementation class UserDaoEJB
 */
@Stateless
public class SmartMeterDao {

	// Injected database connection:
	@PersistenceContext(name = "primary")
	private EntityManager em;

	// Stores a new SmartMeter:
	public void persist(SmartMeter smeter) {
		em.persist(smeter);
	}
	
	
	/**
	 * Deletes the SM that matches the given Gk
	 * @param m Gerätekennung
	 */
	public void removeMeters(String m) {

		SmartMeter del = getMeterByGk(m);

		em.createQuery("DELETE sm FROM SmartMeter sm WHERE sm.id = ?0.id")
		.setParameter(0, del)
		.executeUpdate();

	}
	
	
	/**
	 * 
	 * Updates the Gerätekennung and the Max strain of a specific Smart Meter
	 * 
	 * @param gk Gerätekennung of the SM that is to be updated
	 * @param newgk New Gerätekennung
	 * @param max new max strain value
	 */
	public void updateMeters(String gk, String newgk, Double max) {

		if (newgk != null) {
			em.createQuery("UPDATE SmartMeter m SET m.geraeteKennung = ?0 WHERE m.id = ?1.id ")
			.setParameter(1, getMeterByGk(gk))
			.setParameter(0, newgk)
			.executeUpdate();
			
		}
		if (max != null) {
			em.createQuery("UPDATE SmartMeter m SET m.maxBelastung = ?0 WHERE m.id = ?1.id ")
			.setParameter(1, getMeterByGk(gk))
			.setParameter(0, max)
			.executeUpdate();
		}
	}
	
	/**
	 * 
	 * Returns the SmartMeter that matches with the given Grätekennung
	 * 
	 * @param gk Gerätekennung
	 * @return
	 */
	public SmartMeter getMeterByGk(String gk) {
		SmartMeter query = em.createQuery("SELECT s FROM SmartMeter s WHERE s.geraeteKennung = ?0", SmartMeter.class)
				.setParameter(0, gk)
				.getSingleResult();
		return query;

	}

	/**
	 * @return All SmartMeters in the Database
	 */
	public List<SmartMeter> getAllMeters() {
		TypedQuery<SmartMeter> query = em.createQuery("SELECT u FROM SmartMeter u ORDER BY u.id", SmartMeter.class);
		return query.getResultList();
	}
	
	/**
	 * Returns all the SmartMeters that belong to the logged in user and the clicked on Smart Meter
	 * 
	 * @param sm SmartMeter the reading was taken from
	 * @param u User that created the reading
	 * @return Readings that were created by this user on this SmartMeter
	 */
	public List<Reading> getSpecificReadings(SmartMeter sm, User u) {
		List<Reading> query = em.createQuery("SELECT r FROM Reading r WHERE r.geraet.id = ?0 AND r.benutzer.id = ?1",Reading.class)
				.setParameter(0, sm.getId())
				.setParameter(1, u.getId())
				.getResultList();
		return query;
	}

}