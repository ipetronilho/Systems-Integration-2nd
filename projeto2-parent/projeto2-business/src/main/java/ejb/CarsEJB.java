package ejb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import data.Car;
import data.User;
import dataCRUD.CarCRUDRemote;
import dataCRUD.UserCRUDEJBRemote;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * Session Bean implementation class PlayersEJB
 */
@Stateless
public class CarsEJB implements CarsEJBRemote {
	
	private static final Logger LOGGER = Logger.getLogger(CarsEJB.class.getName());

	@Inject
	CarCRUDRemote carCRUDejb;

	@Inject
	UserCRUDEJBRemote userCRUDejb;

	/**
	 * Default constructor.
	 */
	public CarsEJB() {
		
	}

	public boolean addCar(String brand, String model, String price, String kilometers, String registeredDate, String email) {
		LOGGER.info("Adding car "+brand+"...");
		boolean result;
		User owner = userCRUDejb.getUser(email);
		result = carCRUDejb.createCar(brand, model, price, kilometers, registeredDate, owner, new ArrayList <User>());
		return result;
	}

	public ArrayList <String> listCars(String arg1, String arg2, String searchMode, String order) {
		LOGGER.info("Listing cars... ");
		return carCRUDejb.searchCars(arg1, arg2, searchMode, order);
	}

	public boolean editCar(String paramType, String newParam, String id) {
		LOGGER.info("Editing car "+id);
		if (paramType.compareToIgnoreCase("PRICE")==0) {
			alertFollowers(newParam, id);
		}
		return carCRUDejb.updateCar(paramType, newParam, id);
	}
	
	public void alertFollowers(String newPrice, String id) {
		LOGGER.info("Alerting followers "+id);
		Car c = carCRUDejb.getCar(Integer.parseInt(id));
		for (int i=0;i<c.getFollowers().size();i++) {
			sendEmail(c.getFollowers().get(i).getEmail(), "Price of Car "+c.getBrand()+" [ID: "+c.getId()+"] has changed to"+newPrice);
		}
	}
	
	public void sendEmail(String to, String msgEmail) {
		// File Name SendEmail.java
		// Recipient's email ID needs to be mentioned.

		// Sender's email ID needs to be mentioned
		String from = "ilp@dei.uc.pt";

		// Assuming you are sending email from localhost
		String host = "localhost";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("PROJETO-IS");

			// Now set the actual message
			message.setText(msgEmail);

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	public boolean deleteCar(String car_id) {
		LOGGER.info("Deleting car "+car_id);
		return carCRUDejb.deleteCar(car_id);
	}
	
	public boolean addFollower(String email, int car_id) {
		LOGGER.info("Adding follower "+email+" to car "+car_id);
		User follower = userCRUDejb.getUser(email);
		Car car = carCRUDejb.getCar(car_id);
		car.getFollowers().add(follower);
		return true;
	}

	public static Date getDate(int day, int month, int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, day);

		Date d = cal.getTime();
		return d;
	}

	// In case we need to populate this... 
	/*public void populate() {
		User [] users = { new User("joao", "123", "joaoc@gmail.com"), new User("Ana Dias", "234", "anad@hotmail.com"), new User("Afonso Costa", "345", "afonsoc@yahoo.pt"), new User("Alice Vieira", "456", "alice@gmail.com") };
		
		ArrayList <User> followersCar0 = new ArrayList<User>();
		ArrayList <User> followersCar1 = new ArrayList<User>();
		ArrayList <User> followersCar2 = new ArrayList<User>();
		followersCar1.add(users[0]);
		followersCar2.add(users[1]);

		Car [] cars = {
				new Car("BMW", "CE", 50000, 123, getDate(11,4,1987), users[0], followersCar0),
				new Car("Mercedes", "XLE", 100000, 1234, getDate(11,4,2000), users[0], followersCar1),
				new Car("Audi", "LE", 900000, 12345, getDate(11,4,2001), users[1], followersCar0),
				new Car("Ferrari", "CE", 1000, 123456, getDate(11,4,2002), users[1], followersCar0),
				new Car("Lamborghini", "XLE", 100000, 1234567, getDate(11,4,2006), users[2], followersCar0),
				new Car("Peugeot", "CE", 50000, 123, getDate(11,4,2017), users[2], followersCar0),
				new Car("Citroën", "XLE", 700000, 1234, getDate(11,4,1900), users[3], followersCar0),
				new Car("Toyota", "LE", 20000, 12345, getDate(11,4,1800), users[3], followersCar2)
		};

		for (User u : users)
			em.persist(u);

		for (Car c : cars)
			em.persist(c);
	}
*/
}