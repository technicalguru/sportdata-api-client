package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Round object for Sportdataapi.com.
 * @author ralph
 *
 */
public class Round {

	private int id;
	private int league;
	private int season;
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
	 * Returns the league.
	 * @return the league
	 */
	@JsonProperty("league_id")
	public int getLeague() {
		return league;
	}

	/**
	 * Sets the league.
	 * @param league the league to set
	 */
	@JsonProperty("league_id")
	public void setLeague(int league) {
		this.league = league;
	}

	/**
	 * Returns the season.
	 * @return the season
	 */
	@JsonProperty("season_id")
	public int getSeason() {
		return season;
	}

	/**
	 * Sets the season.
	 * @param season the season to set
	 */
	@JsonProperty("season_id")
	public void setSeason(int season) {
		this.season = season;
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
		return "Round [id=" + id + ", league=" + league + ", season=" + season + ", name=" + name + ", current=" + current + ", leagueName=" + leagueName + "]";
	}

	
}
