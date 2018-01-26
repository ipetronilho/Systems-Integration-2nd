package ejb;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dataCRUD.UserCRUDEJBRemote;

import java.util.logging.Logger;

/**
 * Session Bean implementation class PlayersEJB
 */
@Stateless
public class GeralEJB implements GeralEJBRemote {
	
	private static final Logger LOGGER = Logger.getLogger(GeralEJB.class.getName());
	
	@Inject
	UserCRUDEJBRemote userCRUDejb;
	
    /**
     * Default constructor.
     */
    public GeralEJB() {
       
    }
    
    // checks if login is valid
    public boolean login(String emailUser, String password) {
    	if (userCRUDejb.checkLogin(emailUser, password)) {
    		LOGGER.info("Success. User "+emailUser+" logged in!");
        	return true;
    	}
    	return false;
    }
    
    public boolean addAccount(String username, String password, String email) {
    	LOGGER.info("Creating new User "+email+"...");
    	userCRUDejb.createUser(username, password, email);
    	return true;
    }

    
}