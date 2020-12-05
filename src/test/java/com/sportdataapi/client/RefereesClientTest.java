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
import com.sportdataapi.data.Referee;

/**
 * Test the {@link RefereesClient}.
 * @author ralph
 *
 */
public class RefereesClientTest {

	/**
	 * Tests the list() method (for a country).
	 */
	@Test
	public void testList() {
		RefereesClient client = ClientProvider.getClient().soccer().referees();
		List<Referee> referees = client.list(48);
		assertFalse("Referee list is empty", referees.size() == 0);
		assertTrue("Too few referees", referees.size() > 5);
		boolean found = false;
		for (Referee c : referees) {
			if (c.getId() == 24) {
				// Test Tom Bauer
				found = true;
				assertEquals("Invalid name for referee", "Tom Bauer", c.getName());
				assertEquals("Invalid common name for referee", "Bauer, Tom", c.getCommonName());
				assertEquals("Invalid first name for referee", "Tom", c.getFirstName());
				assertEquals("Invalid last name for referee", "Bauer", c.getLastName());
				assertEquals("Invalid country for referee", 48, c.getCountry().getId());
			}
		}
		assertTrue("Tom Bauer (24) not is list of referees", found);
	}

	/**
	 * Tests the get() method.
	 */
	@Test
	public void testGet() {
		RefereesClient client = ClientProvider.getClient().soccer().referees();
		Referee c = client.get(24);
		assertNotNull("Referee not found", c);
		// Test Tom Bauer
		assertEquals("Invalid name for referee", "Tom Bauer", c.getName());
		assertEquals("Invalid common name for referee", "Bauer, Tom", c.getCommonName());
		assertEquals("Invalid first name for referee", "Tom", c.getFirstName());
		assertEquals("Invalid last name for referee", "Bauer", c.getLastName());
		assertEquals("Invalid country for referee", 48, c.getCountry().getId());
	}	
}
