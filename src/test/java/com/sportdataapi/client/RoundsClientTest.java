/**
 * 
 */
package com.sportdataapi.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.sportdataapi.ClientProvider;
import com.sportdataapi.data.Round;

/**
 * Test the {@link RoundsClient}.
 * @author ralph
 *
 */
public class RoundsClientTest {

	/**
	 * Tests the list() method.
	 */
	@Test
	public void testList() {
		RoundsClient client = ClientProvider.getClient().soccer().rounds();
		List<Round> rounds = client.list(503);
		assertTrue("Invalid number of rounds", rounds.size() == 34);
		boolean found = false;
		for (Round c : rounds) {
			if (c.getId() == 6211) {
				// Test Round 2
				found = true;
				assertEquals("Invalid name German Bundesliga 19/20 Round 2", "2", c.getName());
				assertEquals("Invalid seasonId German Bundesliga 19/20 Round 2", 503, c.getSeason());
				assertEquals("Invalid leagueId German Bundesliga 19/20 Round 2", 314, c.getLeague());
				assertEquals("Invalid leagueName German Bundesliga 19/20 Round 2", "Bundesliga", c.getLeagueName());
			}
		}
		assertTrue("German Bundesliga 19/20 Round 2 not in list of rounds", found);
	}

	/**
	 * Tests the get() method.
	 */
	@Test
	public void testGet() {
		RoundsClient client = ClientProvider.getClient().soccer().rounds();
		Round c = client.get(6211);
		assertNotNull("Round not found", c);
		// Test Round 2
		assertEquals("Invalid name German Bundesliga 19/20 Round 2", "2", c.getName());
		assertEquals("Invalid seasonId German Bundesliga 19/20 Round 2", 503, c.getSeason());
		assertEquals("Invalid leagueId German Bundesliga 19/20 Round 2", 314, c.getLeague());
		assertEquals("Invalid leagueName German Bundesliga 19/20 Round 2", "Bundesliga", c.getLeagueName());
	}	
}
