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
import com.sportdataapi.data.Player;

/**
 * Test the {@link PlayersClient}.
 * @author ralph
 *
 */
public class PlayersClientTest {

	/**
	 * Tests the list() method.
	 */
	@Test
	public void testList1() {
		PlayersClient client = ClientProvider.getClient().soccer().players();
		List<Player> players = client.list(48);
		assertFalse("Players list is empty", players.size() == 0);
		assertTrue("Too few players: "+players.size(), players.size() >= 50);
		boolean found = false;
		for (Player c : players) {
			if (c.getId() == 1488) {
				// Test Lukas Fadinger (Germany)
				found = true;
				assertEquals("Invalid firstName for Lukas Fadinger (Germany)", "Lukas", c.getFirstName());
				assertEquals("Invalid lastName for Lukas Fadinger (Germany)", "Fadinger", c.getLastName());
				assertEquals("Invalid birthday for Lukas Fadinger (Germany)", "20000927", c.getBirthday().getKey());
				assertEquals("Invalid country for Lukas Fadinger (Germany)", 48, c.getCountry().getId());
			}
		}
		assertTrue("Lukas Fadinger (Germany) not in list of players", found);
	}

	/**
	 * Tests the list() method with full age restriction.
	 */
	@Test
	public void testList2() {
		PlayersClient client = ClientProvider.getClient().soccer().players();
		List<Player> players = client.list(48, 19, 35);
		assertFalse("Players list is empty", players.size() == 0);
//		for (Player c : players) {
//			assertTrue("minAge violated for player: "+c.toString(), c.getAge() >= 19);
//			assertTrue("maxAge violated for player: "+c.toString(), c.getAge() <= 35);
//			assertEquals("Invalid country for player", 48, c.getCountry().getId());
//		}
	}


	/**
	 * Tests the listMinAge() method.
	 */
	@Test
	public void testListMinAge() {
		PlayersClient client = ClientProvider.getClient().soccer().players();
		List<Player> players = client.listMinAge(48, 19);
		assertFalse("Players list is empty", players.size() == 0);
//		for (Player c : players) {
//			assertTrue("minAge violated for player: "+c.toString(), c.getAge() >= 19);
//			assertEquals("Invalid country for player", 48, c.getCountry().getId());
//		}
	}

	/**
	 * Tests the listMaxAge() method.
	 */
	@Test
	public void testListMaxAge() {
		PlayersClient client = ClientProvider.getClient().soccer().players();
		List<Player> players = client.listMaxAge(48, 35);
		assertFalse("Players list is empty", players.size() == 0);
//		for (Player c : players) {
//			assertTrue("maxAge violated for player: "+c.toString(), c.getAge() <= 35);
//			assertEquals("Invalid country for player", 48, c.getCountry().getId());
//		}
	}

	/**
	 * Tests the get() method.
	 */
	@Test
	public void testGet() {
		PlayersClient client = ClientProvider.getClient().soccer().players();
		Player c = client.get(1488);
		assertNotNull("Player not found", c);
		// Test Lukas Fadinger (Germany)
		assertEquals("Invalid firstName for Lukas Fadinger (Germany)", "Lukas", c.getFirstName());
		assertEquals("Invalid lastName for Lukas Fadinger (Germany)", "Fadinger", c.getLastName());
		assertEquals("Invalid birthday for Lukas Fadinger (Germany)", "20000927", c.getBirthday().getKey());
		assertEquals("Invalid country for Lukas Fadinger (Germany)", 48, c.getCountry().getId());
	}	
}
