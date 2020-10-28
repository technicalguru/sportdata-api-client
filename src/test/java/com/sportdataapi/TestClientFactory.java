/**
 * 
 */
package com.sportdataapi;

import rs.baselib.io.FileFinder;

/**
 * Creates a singleton for testing
 * @author ralph
 *
 */
public class TestClientFactory {

	private static SportDataClient client;

	/**
	 * Provides the singleton.
	 * @return the client singleton.
	 * @throws Exception when a problem occurs
	 */
	public static SportDataClient getClient() throws Exception {
		if (client == null) {
			synchronized (TestClientFactory.class) {
				if (client == null) {
					String apiKey = FileFinder.load(StatusClientTest.class, "my-apikey.txt").trim();
					client = SportDataClientFactory.newClient(apiKey, true);
				}
			}
		}
		return client;
	}

	/**
	 * Closes the test client.
	 */
	public static void close() {
		if (client != null) {
			synchronized (TestClientFactory.class) {
				if (client != null) {
					client.close();
					client = null;
				}
			}
		}
	}
}
