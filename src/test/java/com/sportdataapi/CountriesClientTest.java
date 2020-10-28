/**
 * 
 */
package com.sportdataapi;

import org.junit.Test;

/**
 * Test the {@link CountriesClient}.
 * @author ralph
 *
 */
public class CountriesClientTest {

	@Test
	public void testList() {
		CountriesClient client = ClientProvider.getClient().soccer().countries();
		client.list();
	}

}
