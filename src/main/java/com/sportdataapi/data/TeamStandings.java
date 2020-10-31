/**
 * 
 */
package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TeamStandings object for Sportdataapi.com.
 * @author ralph
 *
 */
public class TeamStandings {

	private int teamId;
	private int points;
	private String status;
	private String result;
	private StandingsStats overallStats;
	private StandingsStats homeStats;
	private StandingsStats awayStats;
	
	/**
	 * Constructor.
	 */
	public TeamStandings() {
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
	 * Returns the points.
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Sets the points.
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Returns the status.
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Returns the result.
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Sets the result.
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * Returns the overallStats.
	 * @return the overallStats
	 */
	@JsonProperty("overall")
	public StandingsStats getOverallStats() {
		return overallStats;
	}

	/**
	 * Sets the overallStats.
	 * @param overallStats the overallStats to set
	 */
	@JsonProperty("overall")
	public void setOverallStats(StandingsStats overallStats) {
		this.overallStats = overallStats;
	}

	/**
	 * Returns the homeStats.
	 * @return the homeStats
	 */
	@JsonProperty("home")
	public StandingsStats getHomeStats() {
		return homeStats;
	}

	/**
	 * Sets the homeStats.
	 * @param homeStats the homeStats to set
	 */
	@JsonProperty("home")
	public void setHomeStats(StandingsStats homeStats) {
		this.homeStats = homeStats;
	}

	/**
	 * Returns the awayStats.
	 * @return the awayStats
	 */
	@JsonProperty("away")
	public StandingsStats getAwayStats() {
		return awayStats;
	}

	/**
	 * Sets the awayStats.
	 * @param awayStats the awayStats to set
	 */
	@JsonProperty("away")
	public void setAwayStats(StandingsStats awayStats) {
		this.awayStats = awayStats;
	}

	/**
	 * Statistics about the goals and wins.
	 * @author ralph
	 *
	 */
	public static class StandingsStats {
		
		private int gamesPlayed;
		private int won;
		private int draw;
		private int lost;
		private int goalsDiff;
		private int goalsScored;
		private int goalsAgainst;
		
		/**
		 * Constructor.
		 */
		public StandingsStats() {
		}

		/**
		 * Returns the gamesPlayed.
		 * @return the gamesPlayed
		 */
		@JsonProperty("games_played")
		public int getGamesPlayed() {
			return gamesPlayed;
		}

		/**
		 * Sets the gamesPlayed.
		 * @param gamesPlayed the gamesPlayed to set
		 */
		@JsonProperty("games_played")
		public void setGamesPlayed(int gamesPlayed) {
			this.gamesPlayed = gamesPlayed;
		}

		/**
		 * Returns the won.
		 * @return the won
		 */
		public int getWon() {
			return won;
		}

		/**
		 * Sets the won.
		 * @param won the won to set
		 */
		public void setWon(int won) {
			this.won = won;
		}

		/**
		 * Returns the draw.
		 * @return the draw
		 */
		public int getDraw() {
			return draw;
		}

		/**
		 * Sets the draw.
		 * @param draw the draw to set
		 */
		public void setDraw(int draw) {
			this.draw = draw;
		}

		/**
		 * Returns the lost.
		 * @return the lost
		 */
		public int getLost() {
			return lost;
		}

		/**
		 * Sets the lost.
		 * @param lost the lost to set
		 */
		public void setLost(int lost) {
			this.lost = lost;
		}

		/**
		 * Returns the goalsDiff.
		 * @return the goalsDiff
		 */
		@JsonProperty("goals_diff")
		public int getGoalsDiff() {
			return goalsDiff;
		}

		/**
		 * Sets the goalsDiff.
		 * @param goalsDiff the goalsDiff to set
		 */
		@JsonProperty("goals_diff")
		public void setGoalsDiff(int goalsDiff) {
			this.goalsDiff = goalsDiff;
		}

		/**
		 * Returns the goalsScored.
		 * @return the goalsScored
		 */
		@JsonProperty("goals_scored")
		public int getGoalsScored() {
			return goalsScored;
		}

		/**
		 * Sets the goalsScored.
		 * @param goalsScored the goalsScored to set
		 */
		@JsonProperty("goals_scored")
		public void setGoalsScored(int goalsScored) {
			this.goalsScored = goalsScored;
		}

		/**
		 * Returns the goalsAgainst.
		 * @return the goalsAgainst
		 */
		@JsonProperty("goals_against")
		public int getGoalsAgainst() {
			return goalsAgainst;
		}

		/**
		 * Sets the goalsAgainst.
		 * @param goalsAgainst the goalsAgainst to set
		 */
		@JsonProperty("goals_against")
		public void setGoalsAgainst(int goalsAgainst) {
			this.goalsAgainst = goalsAgainst;
		}
		
		
	}
}
