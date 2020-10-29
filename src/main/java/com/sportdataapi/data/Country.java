package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sportdataapi.util.ContinentDeserializer;

/**
 * Country object for Sportdataapi.com.
 * @author ralph
 *
 */
public class Country {

	private int id;
	private String name;
	private String countryCode;
	private Continent continent;
	
	/**
	 * Constructor.
	 */
	public Country() {
	}

	/**
	 * Returns the id.
	 * @return the id
	 */
	@JsonProperty("country_id")
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id - the id to set
	 */
	@JsonProperty("country_id")
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
	 * @param name - the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the countryCode.
	 * @return the countryCode
	 */
	@JsonProperty("country_code")
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Sets the countryCode.
	 * @param countryCode - the countryCode to set
	 */
	@JsonProperty("country_code")
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Returns the continent.
	 * @return the continent
	 */
	public Continent getContinent() {
		return continent;
	}

	/**
	 * Sets the continent.
	 * @param continent - the continent to set
	 */
	@JsonDeserialize(using=ContinentDeserializer.class)
	public void setContinent(Continent continent) {
		this.continent = continent;
	}
}
