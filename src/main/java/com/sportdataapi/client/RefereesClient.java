/**
 * 
 */
package com.sportdataapi.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.Referee;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The referees client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#referees()} instead.</p>
 * @author ralph
 *
 */
public class RefereesClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public RefereesClient(WebTarget target) {
		super(target.path("referees"));
	}

	/**
	 * Request and return the list of referees in a country.
	 * @param countryId - list referees of this country only
	 * @return list of referees
	 */
	public List<Referee> list(int countryId) {
		if (countryId <= 0) throw new RuntimeException("countryId must be a positive number");
		WebTarget target = getTarget().queryParam("country_id", countryId);
		Response<List<Referee>> response = target.request().get(new GenericType<Response<List<Referee>>>() {});
		return new ArrayList<>(response.getData());
	}
	
	/**
	 * Request and returns a specific referee.
	 * @param id - id of referee
	 * @return the referee requested or {@code null}
	 */
	public Referee get(int id) {
		try {
			Response<Referee> response = getTarget().path(""+id).request().get(new GenericType<Response<Referee>>() {});
			return response.getData();
		} catch (NotFoundException e) {
			return null;
		}
	}

}
