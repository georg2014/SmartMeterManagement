package de.tub.as.smm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.tub.as.smm.models.Reading;

@Stateless
public class ReadingDao {

	// Injected database connection:
	@PersistenceContext(name="primary")
	private EntityManager em;

	// Stores a new Reading:
	public void persist(Reading read) {
		em.persist(read);
	}

	public void removeReading(Long id) {
		
		em.createQuery("DELETE r FROM Reading r WHERE r.id = id").executeUpdate();

	}

	public void updateMeters() {

	}
	
	// Retrieves a reading with the matching id
	public Reading getReadingById(Long id) {

		Reading query = em.createQuery("SELECT u FROM Reading u WHERE u.id = id ", Reading.class)
						  .getSingleResult();

		return query;

	}

	// Retrieves all the Readings:
	public List<Reading> getAllReadings() {
		
		TypedQuery<Reading> query = em.createQuery("SELECT u FROM Reading u ORDER BY u.id", Reading.class);
		return query.getResultList();
		
	}
		
}
