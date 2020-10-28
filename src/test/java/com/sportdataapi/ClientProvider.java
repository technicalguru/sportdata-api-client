package com.sportdataapi;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

import rs.baselib.io.FileFinder;

/**
 * ClientProvider.
 */
public class ClientProvider extends RunListener {

	private static SportDataClient client;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void testRunStarted(Description description) throws Exception {
		super.testRunStarted(description);
		String apiKey = null;
		// Load from file
		try {
			apiKey = FileFinder.load(ClientProvider.class, "my-apikey.txt").trim();
		} catch (NullPointerException e) {
			// Ignore
		}
		// Load from environment
		if (apiKey == null) {
			apiKey = System.getenv("SPA_API_TOKEN");
		}
		if (apiKey != null) {
			client = SportDataClientFactory.newClient(apiKey, true);
		} else {
			throw new Exception("No API key available. Use file \"my-apikey.txt\" or environment var \"SPA_API_TOKEN\"");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void testRunFinished(Result result) throws Exception {
		if (client != null) {
			client.close();
		}
		super.testRunFinished(result);
	}

	/**
	 * Returns the client.
	 * @return the client
	 */
	public static SportDataClient getClient() {
		return client;
	}

}
