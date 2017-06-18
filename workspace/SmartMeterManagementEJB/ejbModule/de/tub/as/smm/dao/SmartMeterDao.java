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
	@PersistenceContext(name="primary")
	private EntityManager em;

	// Stores a new SmartMeter:
	public void persist(SmartMeter smeter) {
		em.persist(smeter);
	}

	public void removeMeters(String m) {

		SmartMeter del = getMeterByGk(m);

		em.createQuery("DELETE sm FROM SmartMeter sm WHERE sm.id = del.id").executeUpdate();

	}

	public void updateMeters() {

	}

	public SmartMeter getMeterByGk(String gk) {
		SmartMeter query = em.createQuery("SELECT u FROM SmartMeter u WHERE u.name = gk", SmartMeter.class)
				.getSingleResult();
		return query;

	}

	// Retrieves all the SmartMeters:
	public List<SmartMeter> getAllMeters() {
		TypedQuery<SmartMeter> query = em.createQuery("SELECT u FROM SmartMeter u ORDER BY u.id", SmartMeter.class);
		return query.getResultList();
	}

	public List<Reading> getSpecificReadings(SmartMeter sm, User u) {
		List<Reading> query = em
				.createQuery("SELECT r FROM Reading r WHERE r.gereat.id = sm.id AND WHERE r.benutzer.id = u.id",Reading.class)
				.getResultList();
		return query;
	}

}