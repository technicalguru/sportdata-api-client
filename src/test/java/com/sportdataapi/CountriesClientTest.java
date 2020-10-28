/**
 * 
 */
package com.sportdataapi;

import org.junit.BeforeClass;
import org.junit.Test;

import rs.baselib.io.FileFinder;

/**
 * Test the {@link CountriesClient}.
 * @author ralph
 *
 */
public class CountriesClientTest {

	private static CountriesClient client;
	
	/**
	 * Sets up the client.
	 * @throws Exception - when setup fails
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String apiKey = FileFinder.load(CountriesClientTest.class, "my-apikey.txt").trim();
		client = SportDataClientFactory.newClient(apiKey, true).soccer().countries();
	}

	@Test
	public void testList() {
		client.list();
	}

}
