package dataCRUD;

import javax.ejb.Local;
import javax.ejb.Remote;

import data.Car;
import data.User;

// @Remote
@Local
public interface UserCRUDEJBRemote {
	public void createUser(String username, String password, String email);
	public User getUser(String email);
	public boolean updateUser(String email, String username, String password);
	public boolean deleteUser(String email);
	public boolean checkLogin(String userEmail, String password);
}