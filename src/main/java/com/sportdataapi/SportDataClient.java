/**
 * 
 */
package com.sportdataapi;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import com.sportdataapi.util.ClientFilter;

/**
 * The main client to be used.
 * @author ralph
 *
 */
public class SportDataClient {

	private Client       client;
	private ClientFilter filter;
	private WebTarget    rootTarget;
	
	/**
	 * Constructor.
	 * @param restClient - The Jersey client to be used
	 * @param apiKey     - The sportdataapi.com API key
	 */
	protected SportDataClient(Client restClient, String apiKey) {
		client      = restClient;
		filter      = new ClientFilter(apiKey);
		client.register(filter);
		rootTarget  = client.target("https://app.sportdataapi.com/api/v1");
	}

	/**
	 * Returns the soccer client.
	 * @return the soccer client.
	 */
	public SoccerClient soccer() {
		return new SoccerClient(rootTarget);
	}

	/**
	 * Returns the status client.
	 * @return the status client
	 */
	public StatusClient status() {
		return new StatusClient(rootTarget);
	}
	
	/**
	 * Close the client.
	 */
	public void close() {
		client.close();
	}
}
