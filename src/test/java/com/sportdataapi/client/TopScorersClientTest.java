/**
 * 
 */
package com.sportdataapi.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.sportdataapi.ClientProvider;
import com.sportdataapi.data.TopScorer;

/**
 * Test the {@link TopScorersClient}.
 * @author ralph
 *
 */
public class TopScorersClientTest {

	/**
	 * Tests the get() method.
	 */
	@Test
	public void testGet() {
		TopScorersClient client = ClientProvider.getClient().soccer().topScorers();
		List<TopScorer> scorers = client.get(496);
		assertTrue("Invalid number of topscorers", scorers.size() > 50);
		boolean found = false;
		for (TopScorer c : scorers) {
			if (c.getPlayer().getId() == 4934) {
				// Test TopScorer 2
				found = true;
				assertEquals("Invalid name for Rober Lewandowski", "Robert Lewandowski", c.getPlayer().getName());
				assertEquals("Invalid teamId for Rober Lewandowski", 4066, c.getTeam().getId());
				assertEquals("Invalid teamName for Rober Lewandowski", "FC Bayern Munich", c.getTeam().getName());
				assertEquals("Invalid leagueId", 314, c.getLeagueId());
				assertEquals("Invalid seasonId", 496, c.getSeasonId());
			}
		}
		assertTrue("Robert Lewandowski not in list of top scorers", found);
	}

}
