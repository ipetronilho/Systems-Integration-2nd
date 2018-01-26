package dataCRUD;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import data.Car;
import data.User;

@Stateless
public class CarCRUDEJB implements CarCRUDRemote {
	@PersistenceContext(name="Cars")
	EntityManager em;
	
	private static final Logger LOGGER = Logger.getLogger(CarCRUDEJB.class.getName());
	
    public boolean createCar(String brand, String model, String price, String kilometers, String date, User user, ArrayList<User> followers) {
    	// fetches user
    	float priceFloat = Float.parseFloat(price);
    	float kilometersFloat = Float.parseFloat(kilometers);
    	Date d = getDateString(date);
    	
    	LOGGER.info("Creating car with info "+brand+", "+model+", "+price+", "+kilometers+", "+date+", from the user"+user.getEmail());
    	
    	Car car = new Car(brand, model, priceFloat, kilometersFloat, d, user, new ArrayList <User>());
       
        em.persist(car);
       
        LOGGER.info("Car created added to "+user.getUsername());
        
        return true;
    }
    
    public boolean updateCar(String paramType, String newParam, String idSt) {
    	int id = Integer.parseInt(idSt);
        Query q = em.createQuery(
        		"FROM Car c WHERE c.id = :i");
        q.setParameter("i", id);
        
        LOGGER.info("Updating car "+id+" with info "+paramType+", "+newParam);
    	
        @SuppressWarnings("unchecked")
        List<Car> result = q.getResultList();
        if (result.size()!=0) {
        	Car car = result.get(0);
        	
        	if (paramType.compareTo("brand")==0) {
        		car.setBrand(newParam);
        	}
        	
        	else if (paramType.compareToIgnoreCase("model")==0) {
        		car.setModel(newParam);
        	}
        	else if (paramType.compareToIgnoreCase("price")==0) {
        		car.setPrice(Float.parseFloat(newParam));
        	}
        	else if (paramType.compareToIgnoreCase("kilometers")==0) {
        		car.setKilometers(Float.parseFloat(newParam));
        	}
        	else if (paramType.compareToIgnoreCase("registeredDate")==0) {
        		car.setRegisteredDate(getDateString(newParam));
        	}
        	LOGGER.info("Car updated successfully.");
        	return true;
        }       
        // TODO
        // em.persist(car); ??
        LOGGER.info("Can't find car...");
        return false;
    }
    
    public Car getCar(int id) {
    	LOGGER.info("Reading car "+id);
    	
    	Car car = null;
    	Query q = em.createQuery(
        		"FROM Car c WHERE c.id = :i");
        q.setParameter("i", id);
        
        @SuppressWarnings("unchecked")
        List<Car> result = q.getResultList();
        if (result.size()!=0) {
        	car = result.get(0);
        }       
    	return car;
    }
    
    public boolean deleteCar(String idSt) {
    	
    	Car carDelete = getCar(Integer.parseInt(idSt));
    	em.remove(carDelete);
    	
    	return false;
    }
    
    public ArrayList <String> searchCars(String arg1, String arg2, String searchMode, String order) {
    	LOGGER.info("My arg1 is "+arg1+", my arg2 is "+arg2+" and my searchMode is "+searchMode);
    	Query q = null;
    	String qSt = "from Car c";
    	
    	// search all cars
    	if (searchMode.compareToIgnoreCase("ALL")==0)
    		q = em.createQuery(qSt);
    	
    	// search brand + model
    	else if (searchMode.compareToIgnoreCase("BRAND")==0) {
    		if (arg1 != null && arg2 != null) {
    			q = em.createQuery("from Car c where c.brand like :b  and model like :m");
        		q.setParameter("m", arg2);
        	}
        	
        	// search by brand only
        	else if (arg1 != null && arg2 == null) {
        		q = em.createQuery("from Car c where c.brand like :b");
        	}
            q.setParameter("b", arg1);
    	}
    	
    	/*else if (searchMode.compareToIgnoreCase("USER")==0) {
    		q = em.createQuery("from Car c where c.owner_id = ");
    	}*/
    	
    	else if (searchMode.compareToIgnoreCase("DATE")==0) {
    		q = em.createQuery("from Car c where c.registeredDate >= :d");
    		q.setParameter("d", getDateString(arg1));
    	}
    	
    	
    	else {
        	// search price
        	if (searchMode.compareToIgnoreCase("PRICE")==0 )
        		q = em.createQuery("from Car c where c.price between :i and :f");
        	
        	// search kilometers
        	else if (searchMode.compareToIgnoreCase("KILOMETERS")==0 )
        		q = em.createQuery("from Car c where c.kilometers between :i and :f");
        	
            q.setParameter("i", Float.parseFloat(arg1));
            q.setParameter("f", Float.parseFloat(arg2));
    	}

    	@SuppressWarnings("unchecked")
        List<Car> result = q.getResultList();
    	ArrayList <String> resultStList = carsToStringList(result);
        String resultSt = carsToString(result);
        
        for (int i=0;i<resultStList.size();i++) {
        	LOGGER.info("Sending "+resultStList.get(i));
        }
        
        return resultStList;
    }
    
    
    // auxiliary functions
    public ArrayList<String> carsToStringList(List<Car> result) {
    	ArrayList <String> stList = new ArrayList <String>();
    	String st="";
    	if (!result.isEmpty()) {
	        for (int i=0;i<result.size();i++) {
	        	st = st+"Brand: "+result.get(i).getBrand()+"<br>";
	        	st = st+"[Id: "+result.get(i).getId()+"] <br>";
	        	st = st+"Model: "+result.get(i).getModel()+"<br>";
	        	st = st+"Price: "+result.get(i).getPrice()+"<br>";
	        	st = st+"Kilometers: "+result.get(i).getKilometers()+"<br>";
	        	st = st+"<br>";
	        }
	        stList.add(st);
        }
    	return stList;
    }
    
    public String carsToString(List<Car> result) {
    	String st="";
    	if (!result.isEmpty()) {
	        for (int i=0;i<result.size();i++) {
	        	st = st+"Brand: "+result.get(i).getBrand()+"<br>";
	        	st = st+"Model: "+result.get(i).getModel()+"<br>";
	        	st = st+"Price: "+result.get(i).getPrice()+"<br>";
	        	st = st+"Kilometers: "+result.get(i).getKilometers()+"<br>";
	        	st = st+"<br>";
	        }
        }
    	return st;
    }
    
    public static Date getDateString(String st) {
    	int day, month, year;
    	
		String[] parts = st.split("-");

		String yearSt=parts[0];
		String monthSt=parts[1];
		String daySt=parts[2];
		day = Integer.parseInt(daySt);
		month = Integer.parseInt(monthSt);
		year = Integer.parseInt(yearSt);
		
		return(getDate(day, month, year));
        
    }
    
    public static Date getDate(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);

        Date d = cal.getTime();
        return d;
    }
    
}