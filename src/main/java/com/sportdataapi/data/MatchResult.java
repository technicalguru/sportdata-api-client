/**
 * 
 */
package com.sportdataapi.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sportdataapi.util.MatchResultDeserializer;

/**
 * Match results in a match.
 * @author ralph
 *
 */
@JsonDeserialize(using=MatchResultDeserializer.class)
public class MatchResult {

	private int homeScore;
	private int guestScore;
	
	/**
	 * Constructor.
	 */
	public MatchResult() {
		this(-1, -1);
	}

	/**
	 * Constructor.
	 * @param homeScore   - score of home team
	 * @param guestScore  - score of guest team
	 */
	public MatchResult(int homeScore, int guestScore) {
		setHomeScore(homeScore);
		setGuestScore(guestScore);
	}

	/**
	 * Returns the homeScore.
	 * @return the homeScore
	 */
	public int getHomeScore() {
		return homeScore;
	}

	/**
	 * Sets the homeScore.
	 * @param homeScore the homeScore to set
	 */
	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	/**
	 * Returns the guestScore.
	 * @return the guestScore
	 */
	public int getGuestScore() {
		return guestScore;
	}

	/**
	 * Sets the guestScore.
	 * @param guestScore the guestScore to set
	 */
	public void setGuestScore(int guestScore) {
		this.guestScore = guestScore;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "MatchResult [homeScore=" + homeScore + ", guestScore=" + guestScore + "]";
	}

	
}
