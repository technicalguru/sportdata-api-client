/**
 * 
 */
package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Top scorer object for Sportdataapi.com.
 * @author ralph
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopScorer {

	private int position;
	private Player player;
	private Team team;
	private int leagueId;
	private int seasonId;
	private int matchesPlayed;
	private int minutesPlayed;
	private int substitutedIn;
	private ScoredGoals goals;
	private int penalties;
	
	/**
	 * Constructor.
	 */
	public TopScorer() {
	}
	
	/**
	 * Returns the position.
	 * @return the position
	 */
	@JsonProperty("pos")
	public int getPosition() {
		return position;
	}
	
	/**
	 * Sets the position.
	 * @param position the position to set
	 */
	@JsonProperty("pos")
	public void setPosition(int position) {
		this.position = position;
	}
	
	/**
	 * Returns the player.
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Sets the player.
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/**
	 * Returns the team.
	 * @return the team
	 */
	public Team getTeam() {
		return team;
	}
	
	/**
	 * Sets the team.
	 * @param team the team to set
	 */
	public void setTeam(Team team) {
		this.team = team;
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
	 * Returns the matchesPlayed.
	 * @return the matchesPlayed
	 */
	@JsonProperty("matches_played")
	public int getMatchesPlayed() {
		return matchesPlayed;
	}
	
	/**
	 * Sets the matchesPlayed.
	 * @param matchesPlayed the matchesPlayed to set
	 */
	@JsonProperty("matches_played")
	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}
	
	/**
	 * Returns the minutesPlayed.
	 * @return the minutesPlayed
	 */
	@JsonProperty("minutes_played")
	public int getMinutesPlayed() {
		return minutesPlayed;
	}
	
	/**
	 * Sets the minutesPlayed.
	 * @param minutesPlayed the minutesPlayed to set
	 */
	@JsonProperty("minutes_played")
	public void setMinutesPlayed(int minutesPlayed) {
		this.minutesPlayed = minutesPlayed;
	}
	
	/**
	 * Returns the substitutedIn.
	 * @return the substitutedIn
	 */
	@JsonProperty("substituted_in")
	public int getSubstitutedIn() {
		return substitutedIn;
	}
	
	/**
	 * Sets the substitutedIn.
	 * @param substitutedIn the substitutedIn to set
	 */
	@JsonProperty("substituted_in")
	public void setSubstitutedIn(int substitutedIn) {
		this.substitutedIn = substitutedIn;
	}
	
	/**
	 * Returns the goals.
	 * @return the goals
	 */
	public ScoredGoals getGoals() {
		return goals;
	}
	
	/**
	 * Sets the goals.
	 * @param goals the goals to set
	 */
	public void setGoals(ScoredGoals goals) {
		this.goals = goals;
	}
	
	/**
	 * Returns the penalties.
	 * @return the penalties
	 */
	public int getPenalties() {
		return penalties;
	}
	
	/**
	 * Sets the penalties.
	 * @param penalties the penalties to set
	 */
	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "TopScorer [position=" + position + ", player=" + player + ", team=" + team + ", leagueId=" + leagueId
				+ ", seasonId=" + seasonId + ", matchesPlayed=" + matchesPlayed + ", minutesPlayed=" + minutesPlayed
				+ ", substitutedIn=" + substitutedIn + ", goals=" + goals + ", penalties=" + penalties + "]";
	}

	/**
	 * Scored goals for top scorers object in sportdataapi.com.
	 * @author ralph
	 *
	 */
	public static class ScoredGoals {

		private int overall;
		private int home;
		private int away;
		
		/**
		 * Constructor.
		 */
		public ScoredGoals() {
		}

		/**
		 * Returns the overall.
		 * @return the overall
		 */
		public int getOverall() {
			return overall;
		}

		/**
		 * Sets the overall.
		 * @param overall the overall to set
		 */
		public void setOverall(int overall) {
			this.overall = overall;
		}

		/**
		 * Returns the home.
		 * @return the home
		 */
		public int getHome() {
			return home;
		}

		/**
		 * Sets the home.
		 * @param home the home to set
		 */
		public void setHome(int home) {
			this.home = home;
		}

		/**
		 * Returns the away.
		 * @return the away
		 */
		public int getAway() {
			return away;
		}

		/**
		 * Sets the away.
		 * @param away the away to set
		 */
		public void setAway(int away) {
			this.away = away;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String toString() {
			return "ScoredGoals [overall=" + overall + ", home=" + home + ", away=" + away + "]";
		}

		
	}

	/**
	 * Player object for scorers in Sportdataapi.com.
	 * @author ralph
	 *
	 */
	public class Player {

		private int id;
		private String name;

		/**
		 * Constructor.
		 */
		public Player() {
		}

		/**
		 * Returns the id.
		 * @return the id
		 */
		@JsonProperty("player_id")
		public int getId() {
			return id;
		}

		/**
		 * Sets the id.
		 * @param id the id to set
		 */
		@JsonProperty("player_id")
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * Returns the name.
		 * @return the name
		 */
		@JsonProperty("player_name")
		public String getName() {
			return name;
		}

		/**
		 * Sets the name.
		 * @param name the name to set
		 */
		@JsonProperty("player_name")
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String toString() {
			return "Player [id=" + id + ", name=" + name + "]";
		}
		
	}
	
	/**
	 * Team object for scorers in Sportdataapi.com.
	 * @author ralph
	 *
	 */
	public class Team {

		private int id;
		private String name;

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
		@JsonProperty("team_name")
		public String getName() {
			return name;
		}

		/**
		 * Sets the name.
		 * @param name the name to set
		 */
		@JsonProperty("team_name")
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String toString() {
			return "Team [id=" + id + ", name=" + name + "]";
		}
		
	}
}
