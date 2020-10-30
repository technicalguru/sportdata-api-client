/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.Odds;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The odds client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#odds()} instead.</p>
 * @author ralph
 *
 */
public class OddsClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public OddsClient(WebTarget target) {
		super(target.path("odds"));
		throw new RuntimeException("This API endpoint is not yet implemented.");
	}

	/**
	 * Request and return the list of odds.
	 * @return list of odds
	 */
	public List<Odds> list() {
		Response<List<Odds>> response = getRequest().get(new GenericType<Response<List<Odds>>>() {});
		return response.getData();
	}
}
