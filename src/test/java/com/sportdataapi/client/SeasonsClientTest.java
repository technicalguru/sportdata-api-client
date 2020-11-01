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
import com.sportdataapi.data.Season;

/**
 * Test the {@link SeasonsClient}.
 * @author ralph
 *
 */
public class SeasonsClientTest {

	/**
	 * Tests the list() method.
	 */
	@Test
	public void testList() {
		SeasonsClient client = ClientProvider.getClient().soccer().seasons();
		List<Season> seasons = client.list(314);
		assertFalse("Season list is empty", seasons.size() == 0);
		assertTrue("Too few seasons", seasons.size() >= 3);
		boolean found = false;
		for (Season c : seasons) {
			if (c.getId() == 496) {
				// Test German Bundesliga season 20/21
				found = true;
				assertEquals("Invalid name for Bundesliga Season 20/21",      "20/21", c.getName());
				assertEquals("Invalid countryId for Bundesliga Season 20/21", 48, c.getCountry());
				assertEquals("Invalid leagueId for Bundesliga Season 20/21",  314, c.getLeague());
				assertEquals("Invalid startDate for Bundesliga Season 20/21", "20200918", c.getStart().getKey());
				assertEquals("Invalid endDate for Bundesliga Season 20/21",   "20210529", c.getEnd().getKey());
			}
		}
		assertTrue("Bundesliga 1 season 20/21 not in list of seasons", found);
	}

	/**
	 * Tests the get() method.
	 */
	@Test
	public void testGet() {
		SeasonsClient client = ClientProvider.getClient().soccer().seasons();
		Season c = client.get(496);
		assertNotNull("Season not found", c);
		// Test German Bundesliga season 20/21
		assertEquals("Invalid name for Bundesliga Season 20/21",      "20/21", c.getName());
		assertEquals("Invalid countryId for Bundesliga Season 20/21", 48, c.getCountry());
		assertEquals("Invalid leagueId for Bundesliga Season 20/21",  314, c.getLeague());
		assertEquals("Invalid startDate for Bundesliga Season 20/21", "20200918", c.getStart().getKey());
		assertEquals("Invalid endDate for Bundesliga Season 20/21",   "20210529", c.getEnd().getKey());
	}	
}
