/**
 * 
 */
package com.sportdataapi;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sportdataapi.data.Status;

/**
 * Test the {@link StatusClient}.
 * @author ralph
 *
 */
public class StatusClientTest {

	@Test
	public void testGet() {
		StatusClient client = ClientProvider.getClient().status();
		Status status = client.get();
		assertTrue("No requests left", status.getRemainingRequests() > 0);
	}

}
