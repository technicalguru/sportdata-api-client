/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.Season;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The seasons client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#seasons()} instead.</p>
 * @author ralph
 *
 */
public class SeasonsClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public SeasonsClient(WebTarget target) {
		super(target.path("seasons"));
	}

	/**
	 * Request and return the list of seasons for a specific league.
	 * @param leagueId - the ID of the league to query
	 * @return list of seasons for the league
	 */
	public List<Season> list(int leagueId) {
		if (leagueId <= 0) throw new RuntimeException("leagueId must be a positive number");
		Response<List<Season>> response = getTarget().queryParam("league_id", ""+leagueId).request().get(new GenericType<Response<List<Season>>>() {});
		return response.getData();
	}
	
	/**
	 * Request and returns a specific season.
	 * @param id - id of season
	 * @return the season requested or {@code null}
	 */
	public Season get(int id) {
		Response<Season> response = getTarget().path(""+id).request().get(new GenericType<Response<Season>>() {});
		return response.getData();
	}


}
