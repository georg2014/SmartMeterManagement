package de.tub.as.smm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.tub.as.smm.models.SmartMeter;

/**
 * Session Bean implementation class UserDaoEJB
 */
@Stateless
public class SmartMeterDao{

	// Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new SmartMeter:
    public void persist(SmartMeter smeter) {
        em.persist(smeter);
    }
 
    // Retrieves all the SmartMeters:
    public List<SmartMeter> getAllMeters() {
        TypedQuery<SmartMeter> query = em.createQuery("SELECT u FROM SmartMeter u ORDER BY u.id", SmartMeter.class);
        return query.getResultList();
    }

}