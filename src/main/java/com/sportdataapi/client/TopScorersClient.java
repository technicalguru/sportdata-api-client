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
		throw new RuntimeException("This API endpoint is not yet implemented.");
	}

	/**
	 * Request and return the list of top scorers.
	 * @return list of top scorers
	 */
	public List<TopScorer> list() {
		Response<List<TopScorer>> response = getRequest().get(new GenericType<Response<List<TopScorer>>>() {});
		return response.getData();
	}
}
