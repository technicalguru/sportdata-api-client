/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.TopScorer;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The top scorers client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#topScorers()} instead.</p>
 * @author ralph
 *
 */
public class TopScorersClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public TopScorersClient(WebTarget target) {
		super(target.path("topscorers"));
	}

	/**
	 * Request and return the list of top scorers for a season.
	 * @param seasonId - the ID of the season
	 * @return list of top scorers
	 */
	public List<TopScorer> get(int seasonId) {
		Response<List<TopScorer>> response = getTarget().queryParam("season_id", seasonId).request().get(new GenericType<Response<List<TopScorer>>>() {});
		return response.getData();
	}
}
