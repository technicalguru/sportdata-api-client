/**
 * 
 */
package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sportdataapi.util.RsDayDeserializer;

import rs.baselib.util.RsDay;

/**
 * Player object for Sportdataapi.com.
 * @author ralph
 *
 */
public class Player {

	private int id;
	private String firstName;
	private String lastName;
	private RsDay birthday;
	private int age;
	private int weight;
	private int height;
	private String image;
	private Country country;
	
	/**
	 * Constructor.
	 */
	public Player() {
	}

	/**
	 * Returns the id.
	 * @return the id
	 */
	@JsonProperty("player_id")
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id the id to set
	 */
	@JsonProperty("player_id")
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the firstName.
	 * @return the firstName
	 */
	@JsonProperty("firstname")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the firstName.
	 * @param firstName the firstName to set
	 */
	@JsonProperty("firstname")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns the lastName.
	 * @return the lastName
	 */
	@JsonProperty("lastname")
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the lastName.
	 * @param lastName the lastName to set
	 */
	@JsonProperty("lastname")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the birthday.
	 * @return the birthday
	 */
	@JsonDeserialize(using=RsDayDeserializer.class)
	public RsDay getBirthday() {
		return birthday;
	}

	/**
	 * Sets the birthday.
	 * @param birthday the birthday to set
	 */
	@JsonDeserialize(using=RsDayDeserializer.class)
	public void setBirthday(RsDay birthday) {
		this.birthday = birthday;
	}

	/**
	 * Returns the age.
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Returns the weight.
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Sets the weight.
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * Returns the height.
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Returns the image.
	 * @return the image
	 */
	@JsonProperty("img")
	public String getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 * @param image the image to set
	 */
	@JsonProperty("img")
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * Returns the country.
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday
				+ ", age=" + age + ", weight=" + weight + ", height=" + height + ", image=" + image + ", country="
				+ country + "]";
	}

	
}
