package com.example.FSJDSwiggy.Model;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@DynamicUpdate
public class Restaurant {
/* In this class. We have created the required attributes for the swiggy management and make that as private 
 * attributes. To access the data and replace the data, we have used the getters and setters.
 * 
 * Annotations:
 * @Id is used to indicate the primary key
 * @Generated value is used to indicate the type of primary key whether auto, identity.....
 * @column(name=..) is used if u need to give the new name other than the attribute name.
 * @Entity is used to display the data as a table in database.
 * @Dynamic Update is used to update only the data which you want to update. 
 * 
 * Constructors:
 * Parameterized constructor is used to set the value for the attributes.
 * 
 * 
 */

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int resId;
	
	@Column(name="restaurantName",nullable=false)
	private String resName;
	private String ownerName;
	private String foodType;
	private float rating;
	private String location;
	
	public Restaurant() {
		
	}
	
	public String getResName() {
		return resName;
	}
	public void setResName(String restaurantName) {
		this.resName = restaurantName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getResId() {
		return resId;
	}
	
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public  String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public Restaurant(int resId, String resName, String ownerName, String foodType, float rating,
			String location) {
		this.resId = resId;
		this.resName = resName;
		this.ownerName = ownerName;
		this.foodType = foodType;
		this.rating = rating;
		this.location = location;
	}
}

	


