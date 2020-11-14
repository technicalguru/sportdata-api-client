package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sportdataapi.util.RsDayDeserializer;

import rs.baselib.util.RsDay;

/**
 * Season object for Sportdataapi.com.
 * @author ralph
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Season {

    private int id;
    private String name;
    private boolean current;
    private int countryId;
    private int leagueId;
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
	 * Returns the leagueId.
	 * @return the leagueId
	 */
	@JsonProperty("league_id")
	public int getLeagueId() {
		return leagueId;
	}

	/**
	 * Sets the leagueId.
	 * @param leagueId - the leagueId to set
	 */
	@JsonProperty("league_id")
	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	/**
	 * Returns the start.
	 * @return the start
	 */
	@JsonProperty("start_date")
	@JsonDeserialize(using=RsDayDeserializer.class)
	public RsDay getStart() {
		return start;
	}

	/**
	 * Sets the start.
	 * @param start - the start to set
	 */
	@JsonProperty("start_date")
	@JsonDeserialize(using=RsDayDeserializer.class)
	public void setStart(RsDay start) {
		this.start = start;
	}

	/**
	 * Returns the end.
	 * @return the end
	 */
	@JsonProperty("end_date")
	@JsonDeserialize(using=RsDayDeserializer.class)
	public RsDay getEnd() {
		return end;
	}

	/**
	 * Sets the end.
	 * @param end - the end to set
	 */
	@JsonProperty("end_date")
	@JsonDeserialize(using=RsDayDeserializer.class)
	public void setEnd(RsDay end) {
		this.end = end;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Season [id=" + id + ", name=" + name + ", current=" + current + ", countryId=" + countryId + ", leagueId=" + leagueId + ", start=" + start + ", end=" + end + "]";
	}

	
}
