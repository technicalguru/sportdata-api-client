/**
 * 
 */
package com.sportdataapi.data;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sportdataapi.util.StandingsDeserializer;

/**
 * Information about the teamStandings in a league.
 * @author ralph
 *
 */
public class LeagueStandings {

	private int leagueId;
	private int seasonId;
	private boolean hasGroups;
	private List<TeamStandings> teamStandings;
	private Map<String,List<TeamStandings>> groupStandings;
	
	/**
	 * Constructor.
	 */
	public LeagueStandings() {
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
	 * Returns the hasGroups.
	 * @return the hasGroups
	 */
	@JsonProperty("has_groups")
	public boolean isHasGroups() {
		return hasGroups;
	}

	/**
	 * Sets the hasGroups.
	 * @param hasGroups the hasGroups to set
	 */
	@JsonProperty("has_groups")
	public void setHasGroups(boolean hasGroups) {
		this.hasGroups = hasGroups;
	}

	/**
	 * Returns the teamStandings.
	 * @return the teamStandings
	 */
	public List<TeamStandings> getTeamStandings() {
		return teamStandings;
	}

	/**
	 * Returns the groupStandings.
	 * @return the groupStandings
	 */
	public Map<String, List<TeamStandings>> getGroupStandings() {
		return groupStandings;
	}

	/**
	 * Sets the teamStandings.
	 * @param teamStandings the teamStandings to set
	 */
	@SuppressWarnings("unchecked")
	@JsonProperty("standings")
	@JsonDeserialize(using=StandingsDeserializer.class)
	public void setStandings(Object standings) {
		if (standings instanceof List) {
			teamStandings = (List<TeamStandings>) standings;
		} else if (standings instanceof Map) {
			groupStandings = (Map<String,List<TeamStandings>>) standings;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "LeagueStandings [leagueId=" + leagueId + ", seasonId=" + seasonId + ", hasGroups=" + hasGroups
				+ ", teamStandings=" + teamStandings + ", groupStandings=" + groupStandings + "]";
	}

	
}
