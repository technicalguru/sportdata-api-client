/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.Team;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The teams client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#teams()} instead.</p>
 * @author ralph
 *
 */
public class TeamsClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public TeamsClient(WebTarget target) {
		super(target.path("teams"));
		throw new RuntimeException("This API endpoint is not yet implemented.");
	}

	/**
	 * Request and return the list of teams.
	 * @return list of teams
	 */
	public List<Team> list() {
		Response<List<Team>> response = getRequest().get(new GenericType<Response<List<Team>>>() {});
		return response.getData();
	}
}
