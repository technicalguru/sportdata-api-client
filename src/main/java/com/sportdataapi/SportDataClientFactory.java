/**
 * 
 */
package com.sportdataapi;

import java.util.logging.Level;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

/**
 * Entrypoint for usage. Factory to create clients.
 * @author ralph
 *
 */
public class SportDataClientFactory {


	/**
	 * Builds a new sportdataapi.com client (no debugging).
	 * @param apiKey  - the API key
	 * @return the client
	 */
	public static SportDataClient newClient(String apiKey) {
		return newClient(apiKey, false);
	}
	
	/**
	 * Builds a new sportdataapi.com client.
	 * @param apiKey  - the API key
	 * @param isDebug - whether the requests shall be debugged
	 * @return the client
	 */
	public static SportDataClient newClient(String apiKey, boolean isDebug) {
		ClientConfig config = new ClientConfig();
		if (isDebug) {
			config.property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_TEXT);
			config.property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_CLIENT, Level.INFO.getName());
		}
		return newClient(apiKey, config);
	}

	/**
	 * Builds a new sportdataapi.com client.
	 * @param apiKey  - the API key
	 * @param config  - Jersey client config
	 * @return the client
	 */
	public static SportDataClient newClient(String apiKey, ClientConfig config) {
		Client client = ClientBuilder.newClient(config);
		return new SportDataClient(client, apiKey);
	}

}
