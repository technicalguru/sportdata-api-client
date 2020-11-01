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
import com.sportdataapi.data.Market;

/**
 * Test the {@link MarketsClient}.
 * @author ralph
 *
 */
public class MarketsClientTest {

	/**
	 * Tests the list() method.
	 */
	@Test
	public void testList() {
		MarketsClient client = ClientProvider.getClient().soccer().markets();
		List<Market> markets = client.list();
		assertFalse("Market list is empty", markets.size() == 0);
		assertTrue("Too few countries", markets.size() > 5);
		boolean found = false;
		for (Market c : markets) {
			if (c.getId() == 1) {
				// Test 1X2, Full Time Result
				found = true;
				assertEquals("Invalid name for market", "1X2, Full Time Result", c.getName());
			}
		}
		assertTrue("1X2, Full Time Result not in list of markets", found);
	}

	/**
	 * Tests the get() method.
	 */
	@Test
	public void testGet() {
		MarketsClient client = ClientProvider.getClient().soccer().markets();
		Market c = client.get(1);
		assertNotNull("Market not found", c);
		// Test 1X2, Full Time Result
		assertEquals("Invalid name for market", "1X2, Full Time Result", c.getName());
	}	
}
