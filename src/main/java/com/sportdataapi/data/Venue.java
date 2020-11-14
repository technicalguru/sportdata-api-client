package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Venue object for Sportdataapi.com.
 * @author ralph
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Venue {

	private int id;
	private String name;
	private int capacity;
	private String city;
	private int countryId;
	private Country country;
	
	/**
	 * Constructor.
	 */
	public Venue() {
	}

	/**
	 * Returns the id.
	 * @return the id
	 */
	@JsonProperty("venue_id")
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id the id to set
	 */
	@JsonProperty("venue_id")
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
	 * Sets the name.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the capacity.
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Sets the capacity.
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Returns the city.
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Returns the country.
	 * @return the country
	 */
	@JsonProperty("country_id")
	public int getCountryId() {
		return countryId;
	}

	/**
	 * Sets the country.
	 * @param countryId the country to set
	 */
	@JsonProperty("country_id")
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	/**
	 * Sets the country.
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
		if (country != null) setCountryId(country.getId());
	}

	/**
	 * Returns the country.
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Venue [id=" + id + ", name=" + name + ", capacity=" + capacity + ", city=" + city + ", countryId=" + countryId + "]";
	}

	
}
