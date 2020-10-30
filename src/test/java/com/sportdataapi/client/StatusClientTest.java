/**
 * 
 */
package com.sportdataapi.client;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sportdataapi.ClientProvider;
import com.sportdataapi.data.Status;

/**
 * Test the {@link StatusClient}.
 * @author ralph
 *
 */
public class StatusClientTest {

	/**
	 * Tests the get() method.
	 */
	@Test
	public void testGet() {
		StatusClient client = ClientProvider.getClient().status();
		Status status = client.get();
		assertTrue("No requests left", status.getRemainingRequests() > 0);
	}

}
