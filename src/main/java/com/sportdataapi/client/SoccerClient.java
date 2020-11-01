/**
 * 
 */
package com.sportdataapi.client;

import javax.ws.rs.client.WebTarget;

import com.sportdataapi.SportDataClient;
import com.sportdataapi.util.AbstractClient;

/**
 * The main client for soccer events.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SportDataClient#soccer()} instead.</p>
 * @author ralph
 *
 */
public class SoccerClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public SoccerClient(WebTarget target) {
		super(target.path("soccer"));
	}

	/**
	 * Returns the access client for bookmakers.
	 * @return the client to request bookmaker information
	 */
	public BookmakersClient bookmakers() {
		return get(BookmakersClient.class);
	}
	
	/**
	 * Returns the access client for countries.
	 * @return the client to request country information
	 */
	public CountriesClient countries() {
		return get(CountriesClient.class);
	}
	
	/**
	 * Returns the access client for leagues.
	 * @return the client to request league information
	 */
	public LeaguesClient leagues() {
		return get(LeaguesClient.class);
	}
	
	/**
	 * Returns the access client for markets.
	 * @return the client to request market information
	 */
	public MarketsClient markets() {
		return get(MarketsClient.class);
	}
	
	/**
	 * Returns the access client for matches.
	 * @return the client to request match information
	 */
	public MatchesClient matches() {
		return get(MatchesClient.class);
	}
	
	/**
	 * Returns the access client for odds.
	 * @return the client to request odds information
	 */
	public OddsClient odds() {
		return get(OddsClient.class);
	}
	
	/**
	 * Returns the access client for players.
	 * @return the client to request player information
	 */
	public PlayersClient players() {
		return get(PlayersClient.class);
	}
	
	/**
	 * Returns the access client for rounds.
	 * @return the client to request round information
	 */
	public RoundsClient rounds() {
		return get(RoundsClient.class);
	}
	
	/**
	 * Returns the access client for seasons.
	 * @return the client to request season information
	 */
	public SeasonsClient seasons() {
		return get(SeasonsClient.class);
	}
	
	/**
	 * Returns the access client for standings.
	 * @return the client to request standings information
	 */
	public StandingsClient standings() {
		return get(StandingsClient.class);
	}
	
	/**
	 * Returns the access client for teams.
	 * @return the client to request teams information
	 */
	public TeamsClient teams() {
		return get(TeamsClient.class);
	}
	
	/**
	 * Returns the access client for top scorers.
	 * @return the client to request top scorer information
	 */
	public TopScorersClient topScorers() {
		return get(TopScorersClient.class);
	}
	
	/**
	 * Returns the access client for venues.
	 * @return the client to request venue information
	 */
	public VenuesClient venues() {
		return get(VenuesClient.class);
	}
	

}
