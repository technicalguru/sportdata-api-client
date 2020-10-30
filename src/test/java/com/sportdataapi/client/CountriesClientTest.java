/**
 * 
 */
package com.sportdataapi.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.sportdataapi.ClientProvider;
import com.sportdataapi.data.Continent;
import com.sportdataapi.data.Country;

/**
 * Test the {@link CountriesClient}.
 * @author ralph
 *
 */
public class CountriesClientTest {

	/**
	 * Tests the list() method.
	 */
	@Test
	public void testList() {
		CountriesClient client = ClientProvider.getClient().soccer().countries();
		List<Country> countries = client.list();
		assertFalse("Country list is empty", countries.size() == 0);
		assertTrue("Too few countries", countries.size() > 100);
		for (Country c : countries) {
			if (c.getId() == 48) {
				// Test Germany
				assertEquals("Invalid name for GERMANY", "Germany", c.getName());
				assertEquals("Invalid countryCode for GERMANY", "de", c.getCountryCode());
				assertEquals("Invalid continent for GERMANY", Continent.EUROPE, c.getContinent());				
			}
		}
	}

}
