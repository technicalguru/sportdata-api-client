package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * League object for Sportdataapi.com.
 * @author ralph
 *
 */
public class League {

	private int id;
	private int country;
	private String name;
	
	/**
	 * Constructor.
	 */
	public League() {
	}

	/**
	 * Returns the id.
	 * @return the id
	 */
	@JsonProperty("league_id")
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id - the id to set
	 */
	@JsonProperty("league_id")
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the country.
	 * @return the country
	 */
	@JsonProperty("country_id")
	public int getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 * @param country - the country to set
	 */
	@JsonProperty("country_id")
	public void setCountry(int country) {
		this.country = country;
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

	
}
