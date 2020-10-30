/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.Match;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The matches client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#matches()} instead.</p>
 * @author ralph
 *
 */
public class MatchesClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public MatchesClient(WebTarget target) {
		super(target.path("matches"));
		throw new RuntimeException("This API endpoint is not yet implemented.");
	}

	/**
	 * Request and return the list of matches.
	 * @return list of matches
	 */
	public List<Match> list() {
		Response<List<Match>> response = getRequest().get(new GenericType<Response<List<Match>>>() {});
		return response.getData();
	}
}
