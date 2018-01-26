package ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import data.Car;
import data.Player;
import data.User;

@Remote
public interface CarsEJBRemote {
    //public void populate();
    public ArrayList <String> listCars(String arg1, String arg2, String searchMode, String order);
    public boolean addCar(String brand, String model, String price, String kilometers, String registeredDate, String email);
    public boolean editCar(String paramType, String newParam, String id);
    public boolean deleteCar(String car_id);
    public boolean addFollower(String email, int car_id);
}