package de.tub.as.smm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.tub.as.smm.models.Reading;

/**
 * Session Bean implementation class ReadingDao
 */
@Stateless
public class ReadingDao {

	// Injected database connection:
	@PersistenceContext(name="primary")
	private EntityManager em;

	
	/**
	 * Stores a new reading
	 * @param read
	 */
	public void persist(Reading read) {
		em.persist(read);
	}
	
	
	/**
	 * Removes a reading with the matching id
	 * @param id
	 */
	public void removeReading(Long id) {
		
		em.createQuery("DELETE r FROM Reading r WHERE r.id = ?0")
		.setParameter(0, id)
		.executeUpdate();

	}
	

	/** 
	 * Retrieves a reading with the matching id
	 * 
	 * @param id
	 * @return Reading that matches the id
	 */
	public Reading getReadingById(Long id) {

		Reading query = em.createQuery("SELECT u FROM Reading u WHERE u.id = ?0 ", Reading.class)
						.setParameter(0, id)
						.getSingleResult();

		return query;

	}
	

	/**
	 * @return All readings in the Database
 	 */
	public List<Reading> getAllReadings() {
		
		TypedQuery<Reading> query = em.createQuery("SELECT u FROM Reading u ORDER BY u.id", Reading.class);
		return query.getResultList();
		
	}
		
}
