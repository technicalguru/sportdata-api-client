/**
 * 
 */
package com.sportdataapi.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.sportdataapi.ClientProvider;
import com.sportdataapi.data.Team;

/**
 * Test the {@link TeamsClient}.
 * @author ralph
 *
 */
public class TeamsClientTest {

	/**
	 * Tests the list() method.
	 */
	@Test
	public void testList() {
		TeamsClient client = ClientProvider.getClient().soccer().teams();
		List<Team> teams = client.list(48);
		assertFalse("Teams list is empty", teams.size() == 0);
		assertTrue("Too few teams", teams.size() >= 50);
		boolean found = false;
		for (Team c : teams) {
			if (c.getId() == 4066) {
				// Test Bayern Munich
				found = true;
				assertEquals("Invalid name for Bayern Munich", "FC Bayern Munich", c.getName());
				assertEquals("Invalid shortCode for Bayern Munich", "FCB", c.getShortCode());
				assertEquals("Invalid country for Bayern Munich", 48, c.getCountry().getId());
			}
		}
		assertTrue("Bayern Munich not in list of teams", found);
	}

	/**
	 * Tests the get() method.
	 */
	@Test
	public void testGet() {
		TeamsClient client = ClientProvider.getClient().soccer().teams();
		Team c = client.get(4066);
		assertNotNull("Team not found", c);
		// Test Bayern Munich
		assertEquals("Invalid name for Bayern Munich", "FC Bayern Munich", c.getName());
		assertEquals("Invalid shortCode for Bayern Munich", "FCB", c.getShortCode());
		assertEquals("Invalid country for Bayern Munich", 48, c.getCountry().getId());
	}	
	
	/**
	 * Tests the get() method.
	 */
	@Test
	public void testGetNotFound() {
		TeamsClient client = ClientProvider.getClient().soccer().teams();
		Team c = client.get(0);
		assertNull("No team expected", c);
	}
	
	/**
	 * Tests the list() method.
	 */
	@Test
	public void testListNotFound() {
		TeamsClient client = ClientProvider.getClient().soccer().teams();
		List<Team> teams = client.list(3000);
		assertEquals("List shall be empty", 0, teams.size());
	}
}
