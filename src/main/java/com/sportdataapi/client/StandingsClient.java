/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.Standings;
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
		throw new RuntimeException("This API endpoint is not yet implemented.");
	}

	/**
	 * Request and return the list of standings.
	 * @return list of standings
	 */
	public List<Standings> list() {
		Response<List<Standings>> response = getRequest().get(new GenericType<Response<List<Standings>>>() {});
		return response.getData();
	}
}
