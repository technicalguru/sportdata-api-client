/**
 * 
 */
package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Team statistics object for sportdatapi.com.
 * @author ralph
 *
 */
public class TeamStats {

	private int teamId;
	private String teamName;
	private int fouls;
	private int injuries;
	private int corners;
	private int offsides;
	private int shotsTotal;
	private int shotsOnTarget;
	private int shotsOffTarget;
	private int shotsBlocked;
	private int possessionTime;
	private int possessionPercent;
	private int yellowCards;
	private int yellowRedCards;
	private int redCards;
	private int substitutions;
	private int goalKicks;
	private int goalAttempts;
	private int freeKicks;
	private int throwIns;
	private int ballSafes;
	private int goals;
	private int penalties;
	private int attacks;
	private int dangerousAttacks;
	
	/**
	 * Constructor.
	 */
	public TeamStats() {
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
	 * Returns the teamName.
	 * @return the teamName
	 */
	@JsonProperty("team_name")
	public String getTeamName() {
		return teamName;
	}

	/**
	 * Sets the teamName.
	 * @param teamName the teamName to set
	 */
	@JsonProperty("team_name")
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * Returns the fouls.
	 * @return the fouls
	 */
	public int getFouls() {
		return fouls;
	}

	/**
	 * Sets the fouls.
	 * @param fouls the fouls to set
	 */
	public void setFouls(int fouls) {
		this.fouls = fouls;
	}

	/**
	 * Returns the injuries.
	 * @return the injuries
	 */
	public int getInjuries() {
		return injuries;
	}

	/**
	 * Sets the injuries.
	 * @param injuries the injuries to set
	 */
	public void setInjuries(int injuries) {
		this.injuries = injuries;
	}

	/**
	 * Returns the corners.
	 * @return the corners
	 */
	public int getCorners() {
		return corners;
	}

	/**
	 * Sets the corners.
	 * @param corners the corners to set
	 */
	public void setCorners(int corners) {
		this.corners = corners;
	}

	/**
	 * Returns the offsides.
	 * @return the offsides
	 */
	public int getOffsides() {
		return offsides;
	}

	/**
	 * Sets the offsides.
	 * @param offsides the offsides to set
	 */
	public void setOffsides(int offsides) {
		this.offsides = offsides;
	}

	/**
	 * Returns the shotsTotal.
	 * @return the shotsTotal
	 */
	@JsonProperty("shots_total")
	public int getShotsTotal() {
		return shotsTotal;
	}

	/**
	 * Sets the shotsTotal.
	 * @param shotsTotal the shotsTotal to set
	 */
	@JsonProperty("shots_total")
	public void setShotsTotal(int shotsTotal) {
		this.shotsTotal = shotsTotal;
	}

	/**
	 * Returns the shotsOnTarget.
	 * @return the shotsOnTarget
	 */
	@JsonProperty("shots_on_target")
	public int getShotsOnTarget() {
		return shotsOnTarget;
	}

	/**
	 * Sets the shotsOnTarget.
	 * @param shotsOnTarget the shotsOnTarget to set
	 */
	@JsonProperty("shots_on_target")
	public void setShotsOnTarget(int shotsOnTarget) {
		this.shotsOnTarget = shotsOnTarget;
	}

	/**
	 * Returns the shotsOffTarget.
	 * @return the shotsOffTarget
	 */
	@JsonProperty("shots_off_target")
	public int getShotsOffTarget() {
		return shotsOffTarget;
	}

	/**
	 * Sets the shotsOffTarget.
	 * @param shotsOffTarget the shotsOffTarget to set
	 */
	@JsonProperty("shots_off_target")
	public void setShotsOffTarget(int shotsOffTarget) {
		this.shotsOffTarget = shotsOffTarget;
	}

	/**
	 * Returns the shotsBlocked.
	 * @return the shotsBlocked
	 */
	@JsonProperty("shots_blocked")
	public int getShotsBlocked() {
		return shotsBlocked;
	}

	/**
	 * Sets the shotsBlocked.
	 * @param shotsBlocked the shotsBlocked to set
	 */
	@JsonProperty("shots_blocked")
	public void setShotsBlocked(int shotsBlocked) {
		this.shotsBlocked = shotsBlocked;
	}

	/**
	 * Returns the possessionTime.
	 * @return the possessionTime
	 */
	@JsonProperty("possessiontime")
	public int getPossessionTime() {
		return possessionTime;
	}

	/**
	 * Sets the possessionTime.
	 * @param possessionTime the possessionTime to set
	 */
	@JsonProperty("possessiontime")
	public void setPossessionTime(int possessionTime) {
		this.possessionTime = possessionTime;
	}

	/**
	 * Returns the possessionPercent.
	 * @return the possessionPercent
	 */
	@JsonProperty("possessionpercent")
	public int getPossessionPercent() {
		return possessionPercent;
	}

	/**
	 * Sets the possessionPercent.
	 * @param possessionPercent the possessionPercent to set
	 */
	@JsonProperty("possessionpercent")
	public void setPossessionPercent(int possessionPercent) {
		this.possessionPercent = possessionPercent;
	}

	/**
	 * Returns the yellowCards.
	 * @return the yellowCards
	 */
	@JsonProperty("yellowcards")
	public int getYellowCards() {
		return yellowCards;
	}

	/**
	 * Sets the yellowCards.
	 * @param yellowCards the yellowCards to set
	 */
	@JsonProperty("yellowcards")
	public void setYellowCards(int yellowCards) {
		this.yellowCards = yellowCards;
	}

	/**
	 * Returns the yellowRedCards.
	 * @return the yellowRedCards
	 */
	@JsonProperty("yellowredcards")
	public int getYellowRedCards() {
		return yellowRedCards;
	}

	/**
	 * Sets the yellowRedCards.
	 * @param yellowRedCards the yellowRedCards to set
	 */
	@JsonProperty("yellowredcards")
	public void setYellowRedCards(int yellowRedCards) {
		this.yellowRedCards = yellowRedCards;
	}

	/**
	 * Returns the redCards.
	 * @return the redCards
	 */
	@JsonProperty("redcards")
	public int getRedCards() {
		return redCards;
	}

	/**
	 * Sets the redCards.
	 * @param redCards the redCards to set
	 */
	@JsonProperty("redcards")
	public void setRedCards(int redCards) {
		this.redCards = redCards;
	}

	/**
	 * Returns the substitutions.
	 * @return the substitutions
	 */
	public int getSubstitutions() {
		return substitutions;
	}

	/**
	 * Sets the substitutions.
	 * @param substitutions the substitutions to set
	 */
	public void setSubstitutions(int substitutions) {
		this.substitutions = substitutions;
	}

	/**
	 * Returns the goalKicks.
	 * @return the goalKicks
	 */
	@JsonProperty("goal_kick")
	public int getGoalKicks() {
		return goalKicks;
	}

	/**
	 * Sets the goalKicks.
	 * @param goalKicks the goalKicks to set
	 */
	@JsonProperty("goal_kick")
	public void setGoalKicks(int goalKicks) {
		this.goalKicks = goalKicks;
	}

	/**
	 * Returns the goalAttempts.
	 * @return the goalAttempts
	 */
	@JsonProperty("goal_attempts")
	public int getGoalAttempts() {
		return goalAttempts;
	}

	/**
	 * Sets the goalAttempts.
	 * @param goalAttempts the goalAttempts to set
	 */
	@JsonProperty("goal_attempts")
	public void setGoalAttempts(int goalAttempts) {
		this.goalAttempts = goalAttempts;
	}

	/**
	 * Returns the freeKicks.
	 * @return the freeKicks
	 */
	@JsonProperty("free_kick")
	public int getFreeKicks() {
		return freeKicks;
	}

	/**
	 * Sets the freeKicks.
	 * @param freeKicks the freeKicks to set
	 */
	@JsonProperty("free_kick")
	public void setFreeKicks(int freeKicks) {
		this.freeKicks = freeKicks;
	}

	/**
	 * Returns the throwIns.
	 * @return the throwIns
	 */
	@JsonProperty("throw_in")
	public int getThrowIns() {
		return throwIns;
	}

	/**
	 * Sets the throwIns.
	 * @param throwIns the throwIns to set
	 */
	@JsonProperty("throw_in")
	public void setThrowIns(int throwIns) {
		this.throwIns = throwIns;
	}

	/**
	 * Returns the ballSafes.
	 * @return the ballSafes
	 */
	@JsonProperty("ball_safe")
	public int getBallSafes() {
		return ballSafes;
	}

	/**
	 * Sets the ballSafes.
	 * @param ballSafes the ballSafes to set
	 */
	@JsonProperty("ball_safe")
	public void setBallSafes(int ballSafes) {
		this.ballSafes = ballSafes;
	}

	/**
	 * Returns the goals.
	 * @return the goals
	 */
	public int getGoals() {
		return goals;
	}

	/**
	 * Sets the goals.
	 * @param goals the goals to set
	 */
	public void setGoals(int goals) {
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
	 * Returns the attacks.
	 * @return the attacks
	 */
	public int getAttacks() {
		return attacks;
	}

	/**
	 * Sets the attacks.
	 * @param attacks the attacks to set
	 */
	public void setAttacks(int attacks) {
		this.attacks = attacks;
	}

	/**
	 * Returns the dangerousAttacks.
	 * @return the dangerousAttacks
	 */
	@JsonProperty("dangerous_attacks")
	public int getDangerousAttacks() {
		return dangerousAttacks;
	}

	/**
	 * Sets the dangerousAttacks.
	 * @param dangerousAttacks the dangerousAttacks to set
	 */
	@JsonProperty("dangerous_attacks")
	public void setDangerousAttacks(int dangerousAttacks) {
		this.dangerousAttacks = dangerousAttacks;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "TeamStats [teamId=" + teamId + ", teamName=" + teamName + ", fouls=" + fouls + ", injuries=" + injuries
				+ ", corners=" + corners + ", offsides=" + offsides + ", shotsOnTarget=" + shotsOnTarget
				+ ", shotsOffTarget=" + shotsOffTarget + ", shotsBlocked=" + shotsBlocked + ", possessionTime="
				+ possessionTime + ", possessionPercent=" + possessionPercent + ", yellowCards=" + yellowCards
				+ ", yellowRedCards=" + yellowRedCards + ", redCards=" + redCards + ", substitutions=" + substitutions
				+ ", goalKicks=" + goalKicks + ", goalAttempts=" + goalAttempts + ", freeKicks=" + freeKicks
				+ ", throwIns=" + throwIns + ", ballSafes=" + ballSafes + ", goals=" + goals + ", penalties="
				+ penalties + ", attacks=" + attacks + ", dangerousAttacks=" + dangerousAttacks + "]";
	}

	
}
