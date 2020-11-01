/**
 * 
 */
package com.sportdataapi.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Provides the lineup for a team.
 * @author ralph
 *
 */
public class TeamLineup {

	private int teamId;
	private String formation;
	private boolean formationConfirmed;
	private List<Player> players;
	
	/**
	 * Constructor.
	 */
	public TeamLineup() {
	}

	/**
	 * Returns the teamId.
	 * @return the teamId
	 */
	@JsonProperty("team_id")
	public int getTeamId() {
		return teamId;
	}

	/**
	 * Sets the teamId.
	 * @param teamId the teamId to set
	 */
	@JsonProperty("team_id")
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	/**
	 * Returns the formation.
	 * @return the formation
	 */
	public String getFormation() {
		return formation;
	}

	/**
	 * Sets the formation.
	 * @param formation the formation to set
	 */
	public void setFormation(String formation) {
		this.formation = formation;
	}

	/**
	 * Returns the formationConfirmed.
	 * @return the formationConfirmed
	 */
	@JsonProperty("formation_confirmed")
	public boolean isFormationConfirmed() {
		return formationConfirmed;
	}

	/**
	 * Sets the formationConfirmed.
	 * @param formationConfirmed the formationConfirmed to set
	 */
	@JsonProperty("formation_confirmed")
	public void setFormationConfirmed(boolean formationConfirmed) {
		this.formationConfirmed = formationConfirmed;
	}

	/**
	 * Returns the players.
	 * @return the players
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * Sets the players.
	 * @param players the players to set
	 */
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "TeamLineup [teamId=" + teamId + ", formation=" + formation + ", formationConfirmed="
				+ formationConfirmed + ", players=" + players + "]";
	}

	
}
