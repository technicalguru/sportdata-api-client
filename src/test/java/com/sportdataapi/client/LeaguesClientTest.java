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
import com.sportdataapi.data.League;

/**
 * Test the {@link LeaguesClient}.
 * @author ralph
 *
 */
public class LeaguesClientTest {

	/**
	 * Tests the list() method.
	 */
	@Test
	public void testList1() {
		LeaguesClient client = ClientProvider.getClient().soccer().leagues();
		List<League> leagues = client.list();
		assertTrue("League list is empty", leagues.size() > 0);
		assertTrue("Too few leagues", leagues.size() > 100);
		boolean found = false;
		for (League c : leagues) {
			if (c.getId() == 314) {
				// Test German Bundesliga
				found = true;
				assertEquals("Invalid name for Bundesliga", "Bundesliga", c.getName());
				assertEquals("Invalid country for Bundesliga", 48, c.getCountry());
			}
		}
		assertTrue("Bundesliga 1 not in list of leagues", found);
	}

	/**
	 * Tests the list() method (for a country).
	 */
	@Test
	public void testList2() {
		LeaguesClient client = ClientProvider.getClient().soccer().leagues();
		List<League> leagues = client.list(48);
		assertFalse("League list is empty", leagues.size() == 0);
		assertTrue("Too few leagues", leagues.size() > 5);
		boolean found = false;
		for (League c : leagues) {
			if (c.getId() == 314) {
				// Test German Bundesliga
				found = true;
				assertEquals("Invalid name for Bundesliga", "Bundesliga", c.getName());
				assertEquals("Invalid country for Bundesliga", 48, c.getCountry());
			}
		}
		assertTrue("Bundesliga 1 not is list of leagues", found);
	}

	/**
	 * Tests the list() method (subscribed only).
	 */
	@Test
	public void testList3() {
		LeaguesClient client = ClientProvider.getClient().soccer().leagues();
		List<League> leagues = client.list(true);
		assertTrue("Subscribed league list is empty", leagues.size() > 0);
	}

	/**
	 * Tests the get() method.
	 */
	@Test
	public void testGet() {
		LeaguesClient client = ClientProvider.getClient().soccer().leagues();
		League c = client.get(314);
		assertNotNull("League not found", c);
		// Test German Bundesliga
		assertEquals("Invalid name for Bundesliga", "Bundesliga", c.getName());
		assertEquals("Invalid country for Bundesliga", 48, c.getCountry());
	}	
}
