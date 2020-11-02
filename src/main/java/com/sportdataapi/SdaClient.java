/**
 * 
 */
package com.sportdataapi;

import javax.ws.rs.client.Client;

import com.sportdataapi.client.SoccerClient;
import com.sportdataapi.client.StatusClient;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.ClientFilter;

/**
 * The main client to be used.
 * @author ralph
 *
 */
public class SdaClient extends AbstractClient {

	public static String NAME    = "sportdata-api-client";
	public static String VERSION = "0.2";
	public static String URL     = "https://github.com/technicalguru/sportdata-api-client";
	
			
	private Client          client;
	private ClientFilter    filter;
	
	/**
	 * Constructor.
	 * @param restClient - The Jersey HTTP client to be used
	 * @param apiKey     - The sportdataapi.com API key
	 */
	protected SdaClient(Client restClient, String apiKey) {
		super(restClient.target("https://app.sportdataapi.com/api/v1"));
		client      = restClient;
		filter      = new ClientFilter(apiKey);
		getTarget().register(filter);
	}

	/**
	 * Returns the soccer client.
	 * @return the soccer client.
	 */
	public SoccerClient soccer() {
		return get(SoccerClient.class);
	}

	/**
	 * Returns the status client.
	 * @return the status client
	 */
	public StatusClient status() {
		return get(StatusClient.class);
	}
	
	/**
	 * Close the client.
	 */
	public void close() {
		client.close();
	}
}
