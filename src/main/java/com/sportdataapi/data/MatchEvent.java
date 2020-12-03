/**
 * 
 */
package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Provides data about an event in the match.
 * @author ralph
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchEvent {

	private int teamId;
	private String eventType;
	private int playerId;
	private String playerName;
	private int relatedPlayerId;
	private String relatedPlayerName;
	private int minute;
	private Integer extraMinute;
	private String reason;
	private String injured;
	private boolean ownGoal;
	private boolean penalty;
	private MatchResult result;
	
	/**
	 * Constructor.
	 */
	public MatchEvent() {
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
	 * Returns the eventType.
	 * @return the eventType
	 */
	@JsonProperty("type")
	public String getEventType() {
		return eventType;
	}

	/**
	 * Sets the eventType.
	 * @param eventType the eventType to set
	 */
	@JsonProperty("type")
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * Returns the playerId.
	 * @return the playerId
	 */
	@JsonProperty("player_id")
	public int getPlayerId() {
		return playerId;
	}

	/**
	 * Sets the playerId.
	 * @param playerId the playerId to set
	 */
	@JsonProperty("player_id")
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	/**
	 * Returns the playerName.
	 * @return the playerName
	 */
	@JsonProperty("player_name")
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Sets the playerName.
	 * @param playerName the playerName to set
	 */
	@JsonProperty("player_name")
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * Returns the relatedPlayerId.
	 * @return the relatedPlayerId
	 */
	@JsonProperty("related_player_id")
	public int getRelatedPlayerId() {
		return relatedPlayerId;
	}

	/**
	 * Sets the relatedPlayerId.
	 * @param relatedPlayerId the relatedPlayerId to set
	 */
	@JsonProperty("related_player_id")
	public void setRelatedPlayerId(int relatedPlayerId) {
		this.relatedPlayerId = relatedPlayerId;
	}

	/**
	 * Returns the relatedPlayerName.
	 * @return the relatedPlayerName
	 */
	@JsonProperty("related_player_name")
	public String getRelatedPlayerName() {
		return relatedPlayerName;
	}

	/**
	 * Sets the relatedPlayerName.
	 * @param relatedPlayerName the relatedPlayerName to set
	 */
	@JsonProperty("related_player_name")
	public void setRelatedPlayerName(String relatedPlayerName) {
		this.relatedPlayerName = relatedPlayerName;
	}

	/**
	 * Returns the minute.
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * Sets the minute.
	 * @param minute the minute to set
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}

	/**
	 * Returns the extraMinute.
	 * @return the extraMinute
	 */
	@JsonProperty("extra_minute")
	public Integer getExtraMinute() {
		return extraMinute;
	}

	/**
	 * Sets the extraMinute.
	 * @param extraMinute the extraMinute to set
	 */
	@JsonProperty("extra_minute")
	public void setExtraMinute(Integer extraMinute) {
		this.extraMinute = extraMinute;
	}

	/**
	 * Returns the reason.
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * Sets the reason.
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * Returns the injured.
	 * @return the injured
	 */
	public String getInjured() {
		return injured;
	}

	/**
	 * Sets the injured.
	 * @param injured the injured to set
	 */
	public void setInjured(String injured) {
		this.injured = injured;
	}

	/**
	 * Returns the ownGoal.
	 * @return the ownGoal
	 */
	@JsonProperty("own_goal")
	public boolean isOwnGoal() {
		return ownGoal;
	}

	/**
	 * Sets the ownGoal.
	 * @param ownGoal the ownGoal to set
	 */
	@JsonProperty("own_goal")
	public void setOwnGoal(boolean ownGoal) {
		this.ownGoal = ownGoal;
	}

	/**
	 * Returns the penalty.
	 * @return the penalty
	 */
	public boolean isPenalty() {
		return penalty;
	}

	/**
	 * Sets the penalty.
	 * @param penalty the penalty to set
	 */
	public void setPenalty(boolean penalty) {
		this.penalty = penalty;
	}

	/**
	 * Returns the result.
	 * @return the result
	 */
	public MatchResult getResult() {
		return result;
	}

	/**
	 * Sets the result.
	 * @param result the result to set
	 */
	public void setResult(MatchResult result) {
		this.result = result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "MatchEvent [teamId=" + teamId + ", eventType=" + eventType + ", playerId=" + playerId + ", playerName="
				+ playerName + ", relatedPlayerId=" + relatedPlayerId + ", relatedPlayerName=" + relatedPlayerName
				+ ", minute=" + minute + ", extraMinute=" + extraMinute + ", reason=" + reason + ", injured=" + injured
				+ ", ownGoal=" + ownGoal + ", penalty=" + penalty + ", result=" + result + "]";
	}

	
}
