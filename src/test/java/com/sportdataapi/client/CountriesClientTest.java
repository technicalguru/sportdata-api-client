/**
 * 
 */
package com.sportdataapi.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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
		boolean found = false;
		for (Country c : countries) {
			if (c.getId() == 48) {
				// Test Germany
				found = true;
				assertEquals("Invalid name for GERMANY", "Germany", c.getName());
				assertEquals("Invalid countryCode for GERMANY", "de", c.getCountryCode());
				assertEquals("Invalid continent for GERMANY", Continent.EUROPE, c.getContinent());				
			}
		}
		assertTrue("Germany not in list of countries", found);
	}

	/**
	 * Tests the get() method.
	 */
	@Test
	public void testGet() {
		CountriesClient client = ClientProvider.getClient().soccer().countries();
		Country c = client.get(48);
		assertNotNull("Country not found", c);
		// Test Germany
		assertEquals("Invalid name for GERMANY", "Germany", c.getName());
		assertEquals("Invalid countryCode for GERMANY", "de", c.getCountryCode());
		assertEquals("Invalid continent for GERMANY", Continent.EUROPE, c.getContinent());				
	}	
}
