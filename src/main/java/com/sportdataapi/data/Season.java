package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import rs.baselib.util.RsDate;
import rs.baselib.util.RsDay;

/**
 * Season object for Sportdataapi.com.
 * @author ralph
 *
 */
public class Season {

    private int id;
    private String name;
    private boolean current;
    private int country;
    private int league;
    private RsDay start;
    private RsDay end;
    
	/**
	 * Constructor.
	 */
	public Season() {
	}

	/**
	 * Returns the id.
	 * @return the id
	 */
	@JsonProperty("season_id")
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id - the id to set
	 */
	@JsonProperty("season_id")
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
	 * Returns the current.
	 * @return the current
	 */
	@JsonProperty("is_current")
	public boolean isCurrent() {
		return current;
	}

	/**
	 * Sets the current.
	 * @param current - the current to set
	 */
	@JsonProperty("is_current")
	public void setCurrent(boolean current) {
		this.current = current;
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
	 * Returns the league.
	 * @return the league
	 */
	@JsonProperty("league_id")
	public int getLeague() {
		return league;
	}

	/**
	 * Sets the league.
	 * @param league - the league to set
	 */
	@JsonProperty("league_id")
	public void setLeague(int league) {
		this.league = league;
	}

	/**
	 * Returns the start.
	 * @return the start
	 */
	public RsDate getStart() {
		return start;
	}

	/**
	 * Sets the start.
	 * @param start - the start to set
	 */
	public void setStart(RsDay start) {
		this.start = start;
	}

	/**
	 * Returns the end.
	 * @return the end
	 */
	public RsDay getEnd() {
		return end;
	}

	/**
	 * Sets the end.
	 * @param end - the end to set
	 */
	public void setEnd(RsDay end) {
		this.end = end;
	}

	
}
