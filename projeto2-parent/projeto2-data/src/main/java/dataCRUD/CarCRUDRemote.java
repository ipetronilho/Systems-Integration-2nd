package dataCRUD;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Remote;

import data.Car;
import data.User;

//@Remote
@Local
public interface CarCRUDRemote {
	public boolean createCar(String brand, String model, String price, String kilometers, String date, User user, ArrayList<User> followers);
	public boolean updateCar(String paramType, String newParam, String id);
	public Car getCar(int id);
	public boolean deleteCar(String car_id);
	
	public ArrayList <String> searchCars(String arg1, String arg2, String searchMode, String order);
}