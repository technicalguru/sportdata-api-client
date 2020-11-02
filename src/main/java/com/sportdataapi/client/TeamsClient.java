/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

import javax.ws.rs.NotFoundException;
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
	}

	/**
	 * Request and return the list of teams for a country.
	 * @param countryId - the ID of the country to query
	 * @return list of teams for the country
	 */
	public List<Team> list(int countryId) {
		if (countryId <= 0) throw new RuntimeException("countryId must be a positive number");
		Response<List<Team>> response = getTarget().queryParam("country_id", ""+countryId).request().get(new GenericType<Response<List<Team>>>() {});
		return response.getData();
	}
	
	/**
	 * Request and returns a specific team.
	 * @param id - id of team
	 * @return the team requested or {@code null}
	 */
	public Team get(int id) {
		try {
			Response<Team> response = getTarget().path(""+id).request().get(new GenericType<Response<Team>>() {});
			return response.getData();
		} catch (NotFoundException e) {
			return null;
		}
	}

}
