/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.League;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The leagues client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#leagues()} instead.</p>
 * @author ralph
 *
 */
public class LeaguesClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public LeaguesClient(WebTarget target) {
		super(target.path("leagues"));
		throw new RuntimeException("This API endpoint is not yet implemented.");
	}

	/**
	 * Request and return the list of leagues.
	 * @return list of leagues
	 */
	public List<League> list() {
		Response<List<League>> response = getRequest().get(new GenericType<Response<List<League>>>() {});
		return response.getData();
	}
}
