/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.Stage;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The stages client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#stages()} instead.</p>
 * @author ralph
 *
 */
public class StagesClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public StagesClient(WebTarget target) {
		super(target.path("stages"));
	}

	/**
	 * Request and return the list of teams for a country.
	 * @param seasonId - the ID of the season (of a league) to query
	 * @return list of seasons for the country
	 */
	public List<Stage> list(int seasonId) {
		if (seasonId <= 0) throw new RuntimeException("seasonId must be a positive number");
		Response<List<Stage>> response = getTarget().queryParam("season_id", ""+seasonId).request().get(new GenericType<Response<List<Stage>>>() {});
		return response.getData();
	}
	
	/**
	 * Request and returns a specific stage.
	 * @param id - id of stage
	 * @return the stage requested or {@code null}
	 */
	public Stage get(int id) {
		try {
			Response<Stage> response = getTarget().path(""+id).request().get(new GenericType<Response<Stage>>() {});
			return response.getData();
		} catch (NotFoundException e) {
			return null;
		}
	}

}
