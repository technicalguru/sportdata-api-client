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
		throw new RuntimeException("This API endpoint is not yet implemented.");
	}

	/**
	 * Request and return the list of seasons.
	 * @return list of seasons
	 */
	public List<Season> list() {
		Response<List<Season>> response = getRequest().get(new GenericType<Response<List<Season>>>() {});
		return response.getData();
	}
}
