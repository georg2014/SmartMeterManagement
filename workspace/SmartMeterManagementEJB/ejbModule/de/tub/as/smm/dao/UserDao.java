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

	/**
	 * Stores a new User
	 * @param user
	 */
	public void persist(User user) {
		em.persist(user);
		
	}
	
	/**
	 * Removes the user that matches the name
	 * @param u Name
	 */
	public void removeUser(String u) {
		em.createQuery("DELETE u FROM User u WHERE u.id = ?0.id")
		.setParameter(0, getUserByName(u))
		.executeUpdate();
	}
	
	/**
	 * Updates a users name
	 * @param name Old name
	 * @param newname
	 */
	public void updateUser(String name ,String newname) {
		
		if (newname != null) {
			em.createQuery("UPDATE User us SET us.name = ?0 WHERE ?1.id = us.id ")
			.setParameter(0, newname)
			.setParameter(1, getUserByName(newname))
			.executeUpdate();
		}
		
	}
	
	/**
	 * @param name
	 * @return The user that goes with the given name
	 */
	public User getUserByName(String name) {
		
		try{
		User query = em.createQuery("SELECT u FROM User u WHERE u.name = ?0", User.class)
						.setParameter(0, name)
					   .getSingleResult();
			return query;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		

	}
	
	/**
	 * @return All users in this Database
	 */
	public List<User> getAllUsers() {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u ORDER BY u.id", User.class);
		return query.getResultList();
	}

}
