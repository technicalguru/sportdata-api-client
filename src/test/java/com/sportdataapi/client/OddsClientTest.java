/**
 * 
 */
package com.sportdataapi.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sportdataapi.ClientProvider;
import com.sportdataapi.data.BookmakerOdds;
import com.sportdataapi.data.Odds;

/**
 * Test the {@link OddsClient}.
 * @author ralph
 *
 */
public class OddsClientTest {

	/**
	 * Tests the getPrematch() method.
	 */
	@Test
	public void testPrematch() {
		OddsClient client = ClientProvider.getClient().soccer().odds();
		Odds c = client.getPrematch(120423);
		assertNotNull("Odds not found", c);
		// Test odds
		assertEquals("Invalid number of markets", 3, c.getMarkets().size());
		assertEquals("Invalid number of Asian Handicap odds for match", 8, c.getMarket("Asian Handicap").getBookmakerOdds().size());
		boolean found = false;
		for (BookmakerOdds odds : c.getMarket("Asian Handicap").getBookmakerOdds()) {
			if (odds.getBookmakerId() == 23) {
				found = true;
				assertEquals("Invalid bookmakerName for SBOBET in Asian Handicap market", "SBOBET", odds.getBookmakerName());
				assertEquals("Invalid home odds for SBOBET in Asian Handicap market", "1.82", odds.getOdds().getHome());
				assertEquals("Invalid away odds for SBOBET in Asian Handicap market", "1.98", odds.getOdds().getAway());
			}
		}
		assertTrue("Cannot find SBOBET in Asian Handicap market", found);
	}	
	
	/**
	 * Tests the getInplay() method.
	 */
	@Test
	public void testInplay() {
		OddsClient client = ClientProvider.getClient().soccer().odds();
		Odds c = client.getInplay(120423);
		assertNotNull("Odds not found", c);
		// Test odds
		assertEquals("Invalid number of markets", 3, c.getMarkets().size());
		assertEquals("Invalid number of Asian Handicap odds for match", 8, c.getMarket("Asian Handicap").getBookmakerOdds().size());
		boolean found = false;
		for (BookmakerOdds odds : c.getMarket("Asian Handicap").getBookmakerOdds()) {
			if (odds.getBookmakerId() == 23) {
				found = true;
				assertEquals("Invalid bookmakerName for SBOBET in Asian Handicap market", "SBOBET", odds.getBookmakerName());
				assertEquals("Invalid home odds for SBOBET in Asian Handicap market", "1.58", odds.getOdds().getHome());
				assertEquals("Invalid away odds for SBOBET in Asian Handicap market", "2.28", odds.getOdds().getAway());
			}
		}
		assertTrue("Cannot find SBOBET in Asian Handicap market", found);
	}	
}
