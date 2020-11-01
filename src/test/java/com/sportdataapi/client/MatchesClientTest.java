/**
 * 
 */
package com.sportdataapi.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.sportdataapi.ClientProvider;
import com.sportdataapi.data.Match;
import com.sportdataapi.data.MatchStatus;

/**
 * Test the {@link MatchsClient}.
 * @author ralph
 *
 */
public class MatchesClientTest {

	/**
	 * Tests the list() method for season only.
	 */
	@Test
	public void testList() {
		MatchesClient client = ClientProvider.getClient().soccer().matches();
		List<Match> matches = client.list(503);
		assertEquals("Matches list is incorrect", 391, matches.size());
		boolean found = false;
		for (Match c : matches) {
			if (c.getId() == 178014) {
				// Test match
				found = true;
				assertEquals("Invalid league for match", 314, c.getLeagueId());
				assertEquals("Invalid season for match", 503, c.getSeasonId());
				assertEquals("Invalid status for match", MatchStatus.ENDED, c.getStatus());
				assertEquals("Invalid statusText for match", "finished", c.getStatusText());
				assertTrue("Invalid start for match: "+c.getStart().toString(), c.getStart().toString().indexOf("2020-01-25T17:30:00") > 0);
				assertNull("Invalid minute for match", c.getMinute());
				assertEquals("Invalid result for match", "MatchResult [homeScore=5, guestScore=0]", c.getResults().getLast().toString());
				assertEquals("Invalid homeTeam for match", 4066, c.getHomeTeam().getId());
				assertEquals("Invalid league for match", 4077, c.getGuestTeam().getId());
				assertEquals("Invalid venue for match", 1927, c.getVenue().getId());
			}
		}
		assertTrue("Match 178014 not in list of matches", found);
		// Test 4 others
		matches = client.list(1245);
		assertEquals("Matches list for UEFA CL 19/20 is incorrect", 214, matches.size());
		matches = client.list(1243); System.out.println("Current size for season 1243 => "+matches.size());
//		assertEquals("Matches list for UEFA CL 20/21 is incorrect", 149, teams.size());
		matches = client.list(435);
		assertEquals("Matches list for UEFA EL 19/20 is incorrect", 523, matches.size());
		matches = client.list(434); System.out.println("Current size for season 434 => "+matches.size());
//		assertEquals("Matches list for UEFA EL 20/21 is incorrect", 306, teams.size());

	}

	/**
	 * Tests the listLive() method.
	 */
	@Test
	public void testListLive() {
		MatchesClient client = ClientProvider.getClient().soccer().matches();
		List<Match> matches = client.listLive();
		// No assumptions can be made
		assertNotNull("Live matches request failed", matches);
	}
	
	/**
	 * Tests the get() method.
	 */
	@Test
	public void testGet() {
		MatchesClient client = ClientProvider.getClient().soccer().matches();
		Match c = client.get(178014);
		assertNotNull("Match not found", c);
		// Test match
		assertEquals("Invalid league for match", 314, c.getLeagueId());
		assertEquals("Invalid season for match", 503, c.getSeasonId());
		assertEquals("Invalid status for match", MatchStatus.ENDED, c.getStatus());
		assertEquals("Invalid statusText for match", "finished", c.getStatusText());
		assertTrue("Invalid start for match: "+c.getStart().toString(), c.getStart().toString().indexOf("2020-01-25T17:30:00") > 0);
		assertNull("Invalid minute for match", c.getMinute());
		assertEquals("Invalid result for match", "MatchResult [homeScore=5, guestScore=0]", c.getResults().getLast().toString());
		assertEquals("Invalid homeTeam for match", 4066, c.getHomeTeam().getId());
		assertEquals("Invalid league for match", 4077, c.getGuestTeam().getId());
		assertEquals("Invalid number of events", 11, c.getEvents().size());
		assertNotNull("No homeTeamLineup for match", c.getHomeTeamLineup());
		assertEquals("Invalid number of players in homeTeamLineup for match", 11, c.getHomeTeamLineup().getPlayers().size());
		assertNotNull("No guestTeamLineup for match", c.getGuestTeamLineup());
		assertEquals("Invalid number of players in guestTeamLineup for match", 11, c.getGuestTeamLineup().getPlayers().size());
		assertEquals("Invalid venue for match", 1927, c.getVenue().getId());
	}	
}
