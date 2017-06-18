package de.tub.as.smm.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.tub.as.smm.models.User;

/**
 * Session Bean implementation class UserDaoEJB
 */
@Stateless
public class UserDao {

	// Injected database connection:
	@PersistenceContext(name="primary")
	private EntityManager em;

	// Stores a new user:
	public void persist(User user) {
		em.persist(user);
	}

	public void removeUser(String u) {
		User del = getUserByName(u);

		em.createQuery("DELETE u FROM User u WHERE u.getId = del.id").executeUpdate();
	}

	public void updateUser() {

	}

	public User getUserByName(String name) {

		User query = em.createQuery("SELECT u FROM User u WHERE u.getName() = name", User.class)
					   .getSingleResult();
		return query;

	}

	// Retrieves all the users:
	public List<User> getAllUsers() {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u ORDER BY u.id", User.class);
		return query.getResultList();
	}

}
