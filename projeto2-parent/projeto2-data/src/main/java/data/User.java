package data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;


	private String name;
    private String address;
    private String email;
    private int phoneNumber;
    private String username;
    private String password;
    @OneToMany(mappedBy="owner")
    private List<Car> cars;
    @ManyToMany(mappedBy="follower")
    private List<Car> followedCars;
    

    public User() {
        super();
    }

    public User(String name, String password, String email) {
        super();
        this.name = name;
        this.password = password;
        this.email= email;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    public List<Car> getFollowedCars() {
		return followedCars;
	}

	public void setFollowedCars(List<Car> followedCars) {
		this.followedCars = followedCars;
	}

}