package ejb;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import data.Car;
import data.User;
import dataCRUD.CarCRUDRemote;
import dataCRUD.UserCRUDEJBRemote;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 * Session Bean implementation class PlayersEJB
 */
@Stateless
public class AccountEJB implements AccountEJBRemote {
	
	private static final Logger LOGGER = Logger.getLogger(AccountEJB.class.getName());
	
	@Inject
	UserCRUDEJBRemote userCRUDejb;
	
	@Inject
	CarCRUDRemote carCRUDejb;
	
    /**
     * Default constructor.
     */
    public AccountEJB() {
       
    }
    
    public boolean followCar(String email, int car_id) {
    	LOGGER.info("Following car "+car_id+"...");
    	Car car = carCRUDejb.getCar(car_id);
    	User user = userCRUDejb.getUser(email);
    	user.getFollowedCars().add(car);
    	return true;
    }
    
    // checks if login is valid
    public boolean login(String emailUser, String password) throws NoSuchAlgorithmException {
    	
    	if (userCRUDejb.checkLogin(emailUser, password)) {
    		LOGGER.info("Success. User "+emailUser+" logged in!");
        	return true;
    	}
    	LOGGER.info("User or password are not correct.");
    	return false;
    }
    
    
    public boolean editProfile(String email, String username, String password) {
    	LOGGER.info("Updating User "+email+" info...");
    	userCRUDejb.updateUser(email, username, password);
    	return true;
    }
    
    public boolean deleteAccount(String email) {
    	LOGGER.info("Deleting User "+email+"...");
    	userCRUDejb.deleteUser(email);
    	return true;
    }

    
     
}