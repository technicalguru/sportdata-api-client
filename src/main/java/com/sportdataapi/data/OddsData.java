/**
 * 
 */
package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Odds data information.
 * @author ralph
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OddsData {

	private String home;
	private String draw;
	private String away;
	private String handicap;
	private MatchResult score;
	private String minute;
	private String over;
	private String under;
	
	/**
	 * Constructor.
	 */
	public OddsData() {
	}

	/**
	 * Returns the home.
	 * @return the home
	 */
	public String getHome() {
		return home;
	}

	/**
	 * Sets the home.
	 * @param home the home to set
	 */
	public void setHome(String home) {
		this.home = home;
	}

	/**
	 * Returns the draw.
	 * @return the draw
	 */
	public String getDraw() {
		return draw;
	}

	/**
	 * Sets the draw.
	 * @param draw the draw to set
	 */
	public void setDraw(String draw) {
		this.draw = draw;
	}

	/**
	 * Returns the away.
	 * @return the away
	 */
	public String getAway() {
		return away;
	}

	/**
	 * Sets the away.
	 * @param away the away to set
	 */
	public void setAway(String away) {
		this.away = away;
	}

	/**
	 * Returns the handicap.
	 * @return the handicap
	 */
	public String getHandicap() {
		return handicap;
	}

	/**
	 * Sets the handicap.
	 * @param handicap the handicap to set
	 */
	public void setHandicap(String handicap) {
		this.handicap = handicap;
	}

	/**
	 * Returns the score.
	 * @return the score
	 */
	public MatchResult getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 * @param score the score to set
	 */
	public void setScore(MatchResult score) {
		this.score = score;
	}

	/**
	 * Returns the minute.
	 * @return the minute
	 */
	public String getMinute() {
		return minute;
	}

	/**
	 * Sets the minute.
	 * @param minute the minute to set
	 */
	public void setMinute(String minute) {
		this.minute = minute;
	}

	/**
	 * Returns the over.
	 * @return the over
	 */
	public String getOver() {
		return over;
	}

	/**
	 * Sets the over.
	 * @param over the over to set
	 */
	public void setOver(String over) {
		this.over = over;
	}

	/**
	 * Returns the under.
	 * @return the under
	 */
	public String getUnder() {
		return under;
	}

	/**
	 * Sets the under.
	 * @param under the under to set
	 */
	public void setUnder(String under) {
		this.under = under;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "OddsData [home=" + home + ", draw=" + draw + ", away=" + away + ", handicap=" + handicap + ", score="
				+ score + ", minute=" + minute + ", over=" + over + ", under=" + under + "]";
	}

	
}
