package ejb;

import java.util.List;

import javax.ejb.Remote;

import data.Car;
import data.Player;
import data.User;

@Remote
public interface GeralEJBRemote {
	public boolean login(String emailUser, String password);
	public boolean addAccount(String username, String password, String email);
}