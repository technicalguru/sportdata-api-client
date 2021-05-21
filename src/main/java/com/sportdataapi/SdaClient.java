/**
 * 
 */
package com.sportdataapi;

import java.net.URI;

import javax.ws.rs.client.Client;

import com.sportdataapi.client.RequestListener;
import com.sportdataapi.client.SoccerClient;
import com.sportdataapi.client.StatusClient;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.ClientFilter;

/**
 * The main client to be used.
 * @author ralph
 *
 */
public class SdaClient extends AbstractClient implements RequestListener {

	public static String NAME    = "sportdata-api-client";
	public static String VERSION = "0.9.6";
	public static String URL     = "https://github.com/technicalguru/sportdata-api-client";
	
			
	private Client          client;
	private ClientFilter    filter;
	private URI             lastGlobalUri;
	
	/**
	 * Constructor.
	 * @param restClient - The Jersey HTTP client to be used
	 * @param apiKey     - The sportdataapi.com API key
	 */
	protected SdaClient(Client restClient, String apiKey) {
		super(restClient.target("https://app.sportdataapi.com/api/v1"));
		client        = restClient;
		filter        = new ClientFilter(apiKey);
		lastGlobalUri = null;
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

	/**
	 * {@inheritDoc} 
	 */
	@Override
	public void registerRequest(URI uri) {
		lastGlobalUri = uri;
	}

	/**
	 * Returns the last URI that was requested globally.
	 * @return the URI requested last
	 */
	public URI getLastGlobalUri() {
		return lastGlobalUri;
	}
}
