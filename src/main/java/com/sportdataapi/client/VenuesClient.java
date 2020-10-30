/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

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
		throw new RuntimeException("This API endpoint is not yet implemented.");
	}

	/**
	 * Request and return the list of venues.
	 * @return list of venues
	 */
	public List<Venue> list() {
		Response<List<Venue>> response = getRequest().get(new GenericType<Response<List<Venue>>>() {});
		return response.getData();
	}
}
