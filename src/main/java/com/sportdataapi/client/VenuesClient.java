/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.Venue;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The venues client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#venues()} instead.</p>
 * @author ralph
 *
 */
public class VenuesClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public VenuesClient(WebTarget target) {
		super(target.path("venues"));
	}

	/**
	 * Request and return the list of venues for a country.
	 * @param countryId - the ID of the country to query
	 * @return list of venues for the country
	 */
	public List<Venue> list(int countryId) {
		if (countryId <= 0) throw new RuntimeException("countryId must be a positive number");
		Response<List<Venue>> response = getTarget().queryParam("country_id", ""+countryId).request().get(new GenericType<Response<List<Venue>>>() {});
		return response.getData();
	}
	
	/**
	 * Request and returns a specific venue.
	 * @param id - id of venue
	 * @return the venue requested or {@code null}
	 */
	public Venue get(int id) {
		try {
			Response<Venue> response = getTarget().path(""+id).request().get(new GenericType<Response<Venue>>() {});
			return response.getData();
		} catch (NotFoundException e) {
			return null;
		}
	}

}
