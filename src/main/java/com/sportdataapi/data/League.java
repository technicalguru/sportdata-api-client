package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * League object for Sportdataapi.com.
 * @author ralph
 *
 */
public class League {

	private int id;
	private int countryId;
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
	 * Returns the countryId.
	 * @return the countryId
	 */
	@JsonProperty("country_id")
	public int getCountryId() {
		return countryId;
	}

	/**
	 * Sets the countryId.
	 * @param countryId - the countryId to set
	 */
	@JsonProperty("country_id")
	public void setCountryId(int countryId) {
		this.countryId = countryId;
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
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "League [id=" + id + ", countryId=" + countryId + ", name=" + name + "]";
	}
}
