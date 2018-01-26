package ejb;

import java.util.List;

import javax.ejb.Remote;

import data.Car;
import data.Player;
import data.User;

@Remote
public interface AccountEJBRemote {
	public boolean editProfile(String email, String username, String password);
	public boolean deleteAccount(String email);
	public boolean followCar(String email, int car_id);
}