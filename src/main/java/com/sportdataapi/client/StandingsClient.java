/**
 * 
 */
package com.sportdataapi.client;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.LeagueStandings;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The standings client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#standings()} instead.</p>
 * @author ralph
 *
 */
public class StandingsClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public StandingsClient(WebTarget target) {
		super(target.path("standings"));
	}

	/**
	 * Request and return the list of standings.
	 * @return list of standings
	 */
	public LeagueStandings get(int seasonId) {
		Response<LeagueStandings> response = getTarget().queryParam("season_id", seasonId).request().get(new GenericType<Response<LeagueStandings>>() {});
		return response.getData();
	}
}
