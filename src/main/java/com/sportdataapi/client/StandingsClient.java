/**
 * 
 */
package com.sportdataapi.client;

import javax.ws.rs.NotFoundException;
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
	 * @param target the target to request
	 */
	public StandingsClient(WebTarget target) {
		super(target.path("standings"));
	}

	/**
	 * Request and return the list of standings.
	 * @param seasonId ID of season to return standings for 
	 * @return list of standings
	 */
	public LeagueStandings get(int seasonId) {
		try {
			Response<LeagueStandings> response = registerRequest(getTarget().queryParam("season_id", seasonId)).request().get(new GenericType<Response<LeagueStandings>>() {});
			return response.getData();
		} catch (NotFoundException e) {
			return null;
		}
	}
}
