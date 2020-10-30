/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.Round;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The rounds client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#rounds()} instead.</p>
 * @author ralph
 *
 */
public class RoundsClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public RoundsClient(WebTarget target) {
		super(target.path("rounds"));
		throw new RuntimeException("This API endpoint is not yet implemented.");
	}

	/**
	 * Request and return the list of rounds.
	 * @return list of rounds
	 */
	public List<Round> list() {
		Response<List<Round>> response = getRequest().get(new GenericType<Response<List<Round>>>() {});
		return response.getData();
	}
}
