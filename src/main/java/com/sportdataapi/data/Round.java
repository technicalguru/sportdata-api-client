package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Round object for Sportdataapi.com.
 * @author ralph
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Round {

	private int id;
	private int leagueId;
	private int seasonId;
	private String name;
	private boolean current;
	private String leagueName;
	
	/**
	 * Constructor.
	 */
	public Round() {
	}

	/**
	 * Returns the id.
	 * @return the id
	 */
	@JsonProperty("round_id")
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id the id to set
	 */
	@JsonProperty("round_id")
	public void setId(int id) {
		this.id = id;
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
	 * @param leagueId the leagueId to set
	 */
	@JsonProperty("league_id")
	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	/**
	 * Returns the seasonId.
	 * @return the seasonId
	 */
	@JsonProperty("season_id")
	public int getSeasonId() {
		return seasonId;
	}

	/**
	 * Sets the seasonId.
	 * @param seasonId the seasonId to set
	 */
	@JsonProperty("season_id")
	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
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
	 * Returns the current.
	 * @return the current
	 */
	@JsonProperty("is_current")
	public boolean isCurrent() {
		return current;
	}

	/**
	 * Sets the current.
	 * @param current the current to set
	 */
	@JsonProperty("is_current")
	public void setCurrent(boolean current) {
		this.current = current;
	}

	/**
	 * Returns the leagueName.
	 * @return the leagueName
	 */
	@JsonProperty("league_name")
	public String getLeagueName() {
		return leagueName;
	}

	/**
	 * Sets the leagueName.
	 * @param leagueName the leagueName to set
	 */
	@JsonProperty("league_name")
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Round [id=" + id + ", leagueId=" + leagueId + ", seasonId=" + seasonId + ", name=" + name + ", current=" + current + ", leagueName=" + leagueName + "]";
	}

	
}
