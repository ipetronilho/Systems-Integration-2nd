package dataCRUD;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import data.Car;
import data.User;

@Stateless
public class UserCRUDEJB implements UserCRUDEJBRemote  {
	
    @PersistenceContext(name="Cars")
    EntityManager em;

    private static final Logger LOGGER = Logger.getLogger(UserCRUDEJB.class.getName());
    /**
     * Default constructor.
     */
    public UserCRUDEJB() {
        
    }
    
    public void createUser(String username, String password, String email) {
    	LOGGER.info("Creating user"+email);
    	User user = new User(username, md5hashing(password), email);
    	em.persist(user);
    }
    
    
    public boolean deleteUser(String email) {
    	LOGGER.info("Deleting user"+email);
        Query q = em.createQuery(
        		"FROM User us WHERE us.email like :e");
        q.setParameter("e", email);
        
        @SuppressWarnings("unchecked")
        List<User> result = q.getResultList();
        if (result.size()!=0) {
        	User user = result.get(0);
        	em.remove(user);
        	return true;
        }       
        return false;
    }

    public User readUser(String username) {
    	LOGGER.info("Reading user"+username);
    	
    	Query q = em.createQuery("from User us where us.name = :n");
        q.setParameter("n", username);
        if (!q.getResultList().isEmpty()) {
        	User user = (User) q.getResultList().get(0);
        	return user;
        }
        
    	return null;
    }
    
    public User getUser(String email) {
    	LOGGER.info("Getting user"+email);
    	
    	Query q = em.createQuery("from User us where us.email = :n");
        q.setParameter("n", email);
        if (!q.getResultList().isEmpty()) {
        	User user = (User) q.getResultList().get(0);
        	return user;
        }
        
    	return null;
    }
    
    public boolean updateUser(String email, String username, String password) {
    	LOGGER.info("Updating user"+email);
    	
        Query q = em.createQuery(
        		"FROM User us WHERE us.email LIKE :e");
        q.setParameter("e", email);
        
        @SuppressWarnings("unchecked")
        List<User> result = q.getResultList();
        if (result.size()!=0) {
        	User user = result.get(0);
        	user.setEmail(email);
        	user.setName(username);
        	user.setPassword(password);
        	return true;
        }       
        return false;
    }

    public boolean checkLogin(String userEmail, String password) {
    	LOGGER.info("Verifying user "+userEmail+ " with password "+password+"...");
    	Query q = em.createQuery(
    			"SELECT email FROM User us WHERE us.email LIKE :u and us.password LIKE :p");
        q.setParameter("u", userEmail);
        q.setParameter("p", md5hashing(password));

		if (!q.getResultList().isEmpty()) {
			return true;
		}
		
    	return false;
    }
    

	// encripts password with MD5 algorithm 
	private String md5hashing(String plaintext) {
		MessageDigest m;
		String hashtext = "";
		try {
			m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(plaintext.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			hashtext = bigInt.toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hashtext;
	}
    
}