/**
 * 
 */
package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Provides various match results for a match.
 * @author ralph
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchResults {

	private MatchResult scores;
	private MatchResult halfTime;
	private MatchResult endTime;
	private MatchResult extraTime;
	private MatchResult penalties;
	
	/**
	 * Constructor.
	 */
	public MatchResults() {
	}

	/**
	 * Sets the home score.
	 * @param homeScore the homeScore to set
	 */
	@JsonProperty("home_score")
	public void setHomeScore(int homeScore) {
		if (scores == null) scores = new MatchResult();
		scores.setHomeScore(homeScore);
	}

	/**
	 * Sets the guest score.
	 * @param guestScore the guestScore to set
	 */
	@JsonProperty("away_score")
	public void setGuestScore(int guestScore) {
		if (scores == null) scores = new MatchResult();
		scores.setGuestScore(guestScore);
	}

	/**
	 * Returns the scores.
	 * @return the scores
	 */
	@JsonIgnore
	public MatchResult getScores() {
		return scores;
	}

	/**
	 * Sets the scores.
	 * @param scores the scores to set
	 */
	@JsonIgnore
	public void setScores(MatchResult scores) {
		this.scores = scores;
	}

	/**
	 * Returns the halfTime.
	 * @return the halfTime
	 */
	@JsonProperty("ht_score")
	public MatchResult getHalfTime() {
		return halfTime;
	}

	/**
	 * Sets the halfTime.
	 * @param halfTime the halfTime to set
	 */
	@JsonProperty("ht_score")
	public void setHalfTime(MatchResult halfTime) {
		this.halfTime = halfTime;
	}

	/**
	 * Returns the endTime.
	 * @return the endTime
	 */
	@JsonProperty("ft_score")
	public MatchResult getEndTime() {
		return endTime;
	}

	/**
	 * Sets the endTime.
	 * @param endTime the endTime to set
	 */
	@JsonProperty("ft_score")
	public void setEndTime(MatchResult endTime) {
		this.endTime = endTime;
	}

	/**
	 * Returns the extraTime.
	 * @return the extraTime
	 */
	@JsonProperty("et_score")
	public MatchResult getExtraTime() {
		return extraTime;
	}

	/**
	 * Sets the extraTime.
	 * @param extraTime the extraTime to set
	 */
	@JsonProperty("et_score")
	public void setExtraTime(MatchResult extraTime) {
		this.extraTime = extraTime;
	}

	/**
	 * Returns the penalties.
	 * @return the penalties
	 */
	@JsonProperty("ps_score")
	public MatchResult getPenalties() {
		return penalties;
	}

	/**
	 * Sets the penalties.
	 * @param penalties the penalties to set
	 */
	@JsonProperty("ps_score")
	public void setPenalties(MatchResult penalties) {
		this.penalties = penalties;
	}

	/**
	 * Returns the latest result (penalties before extra time before end time before half time).
	 * @return best result
	 */
	@JsonIgnore
	public MatchResult getLast() {
		if (getPenalties() != null) return getPenalties();
		if (getExtraTime() != null) return getExtraTime();
		if (getEndTime() != null)   return getEndTime();
		return getHalfTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "MatchResults [scores=" + scores + ", halfTime=" + halfTime + ", endTime=" + endTime + ", extraTime="
				+ extraTime + ", penalties=" + penalties + "]";
	}
	
	
}
