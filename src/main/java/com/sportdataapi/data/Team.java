package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Team object for Sportdataapi.com.
 * @author ralph
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {

	private int id;
	private String name;
	private String shortCode;
	private String logo;
	private Country country;
	
	/**
	 * Constructor.
	 */
	public Team() {
	}

	/**
	 * Returns the id.
	 * @return the id
	 */
	@JsonProperty("team_id")
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id the id to set
	 */
	@JsonProperty("team_id")
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
	 * Returns the shortCode.
	 * @return the shortCode
	 */
	@JsonProperty("short_code")
	public String getShortCode() {
		return shortCode;
	}

	/**
	 * Sets the shortCode.
	 * @param shortCode the shortCode to set
	 */
	@JsonProperty("short_code")
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	/**
	 * Returns the logo.
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * Sets the logo.
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
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
		return "Team [id=" + id + ", name=" + name + ", shortCode=" + shortCode + ", logo=" + logo + ", country="+ country + "]";
	}
	
	
}
