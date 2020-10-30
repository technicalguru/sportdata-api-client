/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.Market;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The markets client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#markets()} instead.</p>
 * @author ralph
 *
 */
public class MarketsClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public MarketsClient(WebTarget target) {
		super(target.path("markets"));
		throw new RuntimeException("This API endpoint is not yet implemented.");
	}

	/**
	 * Request and return the list of markets.
	 * @return list of markets
	 */
	public List<Market> list() {
		Response<List<Market>> response = getRequest().get(new GenericType<Response<List<Market>>>() {});
		return response.getData();
	}
}
