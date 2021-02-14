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
import com.sportdataapi.data.Stage;

/**
 * Test the {@link StagesClient}.
 * @author ralph
 *
 */
public class StagesClientTest {

	/**
	 * Tests the list() method.
	 */
	@Test
	public void testList() {
		StagesClient client = ClientProvider.getClient().soccer().stages();
		List<Stage> stages = client.list(496);
		assertEquals("Invalid number of stages", 1, stages.size());
		boolean found = false;
		for (Stage c : stages) {
			if (c.getId() == 1) {
				// Test Stage 1
				found = true;
				assertEquals("Invalid name German Bundesliga 20/21 Stage 1", "Regular Season", c.getName());
			}
		}
		assertTrue("German Bundesliga 20/21 Stage 1 not in list of stages", found);
	}

	/**
	 * Tests the get() method.
	 */
	@Test
	public void testGet() {
		StagesClient client = ClientProvider.getClient().soccer().stages();
		Stage c = client.get(1);
		assertNotNull("Stage not found", c);
		// Test Stage 1
		assertEquals("Invalid name German Bundesliga 20/21 Stage 1", "Regular Season", c.getName());
	}	
}
