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
import com.sportdataapi.data.Venue;

/**
 * Test the {@link VenuesClient}.
 * @author ralph
 *
 */
public class VenuesClientTest {

	/**
	 * Tests the list() method.
	 */
	@Test
	public void testList() {
		VenuesClient client = ClientProvider.getClient().soccer().venues();
		List<Venue> venues = client.list(48);
		assertFalse("Venues list is empty", venues.size() == 0);
		assertTrue("Too few venues", venues.size() >= 50);
		boolean found = false;
		for (Venue c : venues) {
			if (c.getId() == 1504) {
				// Test Volksparkstadium Hamburg, Germany
				found = true;
				assertEquals("Invalid city for Volksparkstadium", "Hamburg", c.getCity());
				assertEquals("Invalid country for Volksparkstadium", 48, c.getCountryId());
			}
		}
		assertTrue("Volksparkstadium not in list of venues", found);
	}

	/**
	 * Tests the get() method.
	 */
	@Test
	public void testGet() {
		VenuesClient client = ClientProvider.getClient().soccer().venues();
		Venue c = client.get(1504);
		assertNotNull("Venue not found", c);
		// Test Volksparkstadium Hamburg, Germany
		assertEquals("Invalid city for Volksparkstadium", "Hamburg", c.getCity());
		assertEquals("Invalid country for Volksparkstadium", 48, c.getCountryId());
	}	
}
