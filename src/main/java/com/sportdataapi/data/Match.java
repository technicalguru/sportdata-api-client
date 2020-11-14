package com.sportdataapi.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sportdataapi.util.RsDateDeserializer;

import rs.baselib.util.RsDate;

/**
 * Match object for Sportdataapi.com.
 * @author ralph
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Match {

	private int id;
	private MatchStatus status;
	private String statusText;
	private RsDate start;
	private Integer minute;
	private int leagueId;
	private int seasonId;
	private int roundId;
	private Round round;
	private MatchResults results;
	private Team homeTeam;
	private Team guestTeam;
	private int refereeId;
	private List<MatchEvent> events;
	private TeamStats homeTeamStats;
	private TeamStats guestTeamStats;
	private TeamLineup homeTeamLineup;
	private TeamLineup guestTeamLineup;
	private Venue venue;
	
	/**
	 * Constructor.
	 */
	public Match() {
	}

	/**
	 * Returns the id.
	 * @return the id
	 */
	@JsonProperty("match_id")
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id the id to set
	 */
	@JsonProperty("match_id")
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the status.
	 * @return the status
	 */
	@JsonProperty("status_code")
	public MatchStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 * @param status the status to set
	 */
	@JsonProperty("status_code")
	public void setStatus(MatchStatus status) {
		this.status = status;
	}

	/**
	 * Returns the statusText.
	 * @return the statusText
	 */
	@JsonProperty("status")
	public String getStatusText() {
		return statusText;
	}

	/**
	 * Sets the statusText.
	 * @param statusText the statusText to set
	 */
	@JsonProperty("status")
	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	/**
	 * Returns the start.
	 * @return the start
	 */
	@JsonProperty("match_start")
	@JsonDeserialize(using=RsDateDeserializer.class)
	public RsDate getStart() {
		return start;
	}

	/**
	 * Sets the start.
	 * @param start the start to set
	 */
	@JsonProperty("match_start")
	@JsonDeserialize(using=RsDateDeserializer.class)
	public void setStart(RsDate start) {
		this.start = start;
	}

	/**
	 * Returns the minute.
	 * @return the minute
	 */
	public Integer getMinute() {
		return minute;
	}

	/**
	 * Sets the minute.
	 * @param minute the minute to set
	 */
	public void setMinute(Integer minute) {
		this.minute = minute;
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
	 * Returns the roundId.
	 * @return the roundId
	 */
	@JsonProperty("round_id")
	public int getRoundId() {
		return roundId;
	}

	/**
	 * Sets the roundId.
	 * @param roundId the roundId to set
	 */
	@JsonProperty("round_id")
	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}

	/**
	 * Returns the round.
	 * @return the round
	 */
	public Round getRound() {
		return round;
	}

	/**
	 * Sets the round.
	 * @param round the round to set
	 */
	public void setRound(Round round) {
		this.round = round;
		if (round != null) setRoundId(round.getId());
	}

	/**
	 * Returns the results.
	 * @return the results
	 */
	@JsonProperty("stats")
	public MatchResults getResults() {
		return results;
	}

	/**
	 * Sets the results.
	 * @param results the results to set
	 */
	@JsonProperty("stats")
	public void setResults(MatchResults results) {
		this.results = results;
	}

	/**
	 * Returns the homeTeam.
	 * @return the homeTeam
	 */
	@JsonProperty("home_team")
	public Team getHomeTeam() {
		return homeTeam;
	}

	/**
	 * Sets the homeTeam.
	 * @param homeTeam the homeTeam to set
	 */
	@JsonProperty("home_team")
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	/**
	 * Returns the guestTeam.
	 * @return the guestTeam
	 */
	@JsonProperty("away_team")
	public Team getGuestTeam() {
		return guestTeam;
	}

	/**
	 * Sets the guestTeam.
	 * @param guestTeam the guestTeam to set
	 */
	@JsonProperty("away_team")
	public void setGuestTeam(Team guestTeam) {
		this.guestTeam = guestTeam;
	}

	/**
	 * Returns the Referee ID.
	 * @return the refereeId
	 */
	@JsonProperty("referee_id")
	public int getRefereeId() {
		return refereeId;
	}

	/**
	 * Sets the Referee ID.
	 * @param refereeId the refereeId to set
	 */
	@JsonProperty("referee_id")
	public void setRefereeId(int refereeId) {
		this.refereeId = refereeId;
	}

	/**
	 * Returns the events.
	 * @return the events
	 */
	@JsonProperty("match_events")
	public List<MatchEvent> getEvents() {
		return events;
	}

	/**
	 * Sets the events.
	 * @param events the events to set
	 */
	@JsonProperty("match_events")
	public void setEvents(List<MatchEvent> events) {
		this.events = events;
	}

	/**
	 * Sets the matchStatistics.
	 * @param stats - the match statistics to set
	 */
	@JsonProperty("match_statistics")
	public void setMatchStatistics(TeamStats stats[]) {
		if (stats != null) {
			for (TeamStats stat : stats) {
				if ((homeTeam  != null) && (homeTeam.getId()  == stat.getTeamId())) homeTeamStats  = stat;
				if ((guestTeam != null) && (guestTeam.getId() == stat.getTeamId())) guestTeamStats = stat;
			}
		}
	}
	
	/**
	 * Returns the homeTeamStats.
	 * @return the homeTeamStats
	 */
	public TeamStats getHomeTeamStats() {
		return homeTeamStats;
	}

	/**
	 * Returns the guestTeamStats.
	 * @return the guestTeamStats
	 */
	public TeamStats getGuestTeamStats() {
		return guestTeamStats;
	}

	/**
	 * Sets the lineups.
	 * @param lineups the lineups to set
	 */
	public void setLineups(TeamLineup lineups[]) {
		if (lineups != null) {
			for (TeamLineup lineup : lineups) {
				if ((homeTeam  != null) && (homeTeam.getId()  == lineup.getTeamId())) homeTeamLineup  = lineup;
				if ((guestTeam != null) && (guestTeam.getId() == lineup.getTeamId())) guestTeamLineup = lineup;
			}
		}
	}

	/**
	 * Returns the homeTeamLineup.
	 * @return the homeTeamLineup
	 */
	public TeamLineup getHomeTeamLineup() {
		return homeTeamLineup;
	}

	/**
	 * Returns the guestTeamLineup.
	 * @return the guestTeamLineup
	 */
	public TeamLineup getGuestTeamLineup() {
		return guestTeamLineup;
	}

	/**
	 * Returns the venue.
	 * @return the venue
	 */
	public Venue getVenue() {
		return venue;
	}

	/**
	 * Sets the venue.
	 * @param venue the venue to set
	 */
	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Match [id=" + id + ", status=" + status + ", statusText=" + statusText + ", start=" + start
				+ ", minute=" + minute + ", leagueId=" + leagueId + ", seasonId=" + seasonId + ", roundId=" + roundId + ", results="
				+ results + ", homeTeam=" + homeTeam + ", guestTeam=" + guestTeam + ", events=" + events
				+ ", homeTeamStats=" + homeTeamStats + ", guestTeamStats=" + guestTeamStats + ", homeTeamLineup="
				+ homeTeamLineup + ", guestTeamLineup=" + guestTeamLineup + ", venue=" + venue + "]";
	}

}
