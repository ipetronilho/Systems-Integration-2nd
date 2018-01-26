package data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity implementation class for Entity: Player
 *
 */
@Entity
public class Car implements Serializable {


	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private float price;
    private float kilometers;
    private String photoFile;
    @Temporal(TemporalType.DATE)
    private Date registeredDate;
    @ManyToOne
    private User owner;
    // TODO - acrescentar depois: private User followers;
    @ManyToMany
    private List<User> followers;
    
    public Car() {
        super();
    }

    public Car(String brand, String model, float price, float kilometers, Date registeredDate, User owner, ArrayList <User> followers) {
        super();
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.kilometers=kilometers;
        this.registeredDate = registeredDate;
        this.owner = owner;
        this.followers = followers;
    }
    
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getKilometers() {
		return kilometers;
	}

	public void setKilometers(float kilometers) {
		this.kilometers = kilometers;
	}

	public String getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(String photoFile) {
		this.photoFile = photoFile;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public static long getSerialversionuid() {
        return serialVersionUID;
    }
	
    public List<User> getFollowers() {
		return followers;
	}

	public void setFollowedUsers(List<User> followedUsers) {
		this.followers = followers;
	}

    @Override
    public String toString() {
    	return "Brand: "+this.brand+", model: "+this.model+", price: "+this.price+", kilometers: "+this.kilometers+", registered in Date "+this.registeredDate;
        }

}