/**
 * 
 */
package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sportdataapi.util.RsDayDeserializer;

import rs.baselib.util.RsDay;

/**
 * Referee object for Sportdataapi.com.
 * @author ralph
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Referee {

	private int id;
	private String name;
	private String commonName;
	private String firstName;
	private String lastName;
	private RsDay birthday;
	private String image;
	private Country country;
	
	/**
	 * Constructor.
	 */
	public Referee() {
	}

	/**
	 * Returns the id.
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the name.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the common name.
	 * @return the commonName
	 */
	@JsonProperty("common_name")
	public String getCommonName() {
		return commonName;
	}

	/**
	 * Sets the common name.
	 * @param commonName the commonName to set
	 */
	@JsonProperty("common_name")
	public void setCommonName(String commonName) {
		this.commonName = commonName;
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
	@JsonProperty("birthdate")
	public RsDay getBirthday() {
		return birthday;
	}

	/**
	 * Sets the birthday.
	 * @param birthday the birthday to set
	 */
	@JsonProperty("birthdate")
	@JsonDeserialize(using=RsDayDeserializer.class)
	public void setBirthday(RsDay birthday) {
		this.birthday = birthday;
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

}
