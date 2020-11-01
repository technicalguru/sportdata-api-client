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
import com.sportdataapi.data.Bookmaker;

/**
 * Test the {@link BookmakersClient}.
 * @author ralph
 *
 */
public class BookmakersClientTest {

	/**
	 * Tests the list() method.
	 */
	@Test
	public void testList() {
		BookmakersClient client = ClientProvider.getClient().soccer().bookmakers();
		List<Bookmaker> bookmakers = client.list();
		assertFalse("Bookmaker list is empty", bookmakers.size() == 0);
		assertTrue("Too few bookmakers", bookmakers.size() > 20);
		boolean found = false;
		for (Bookmaker c : bookmakers) {
			if (c.getId() == 2) {
				// Test bet365
				found = true;
				assertEquals("Invalid name for bet365", "bet365", c.getName());
				assertEquals("Invalid image for bet365", "https://cdn.sportdataapi.com/images/soccer/bookmakers/2.png", c.getImage());
			}
		}
		assertTrue("bet365 not in list of markets", found);
	}

	/**
	 * Tests the get() method.
	 */
	@Test
	public void testGet() {
		BookmakersClient client = ClientProvider.getClient().soccer().bookmakers();
		Bookmaker c = client.get(2);
		assertNotNull("Bookmaker not found", c);
		// Test bet365
		assertEquals("Invalid name for bet365", "bet365", c.getName());
		assertEquals("Invalid image for bet365", "https://cdn.sportdataapi.com/images/soccer/bookmakers/2.png", c.getImage());
	}	
}
