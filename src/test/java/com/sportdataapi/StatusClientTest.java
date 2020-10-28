/**
 * 
 */
package com.sportdataapi;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sportdataapi.data.Status;

/**
 * Test the {@link StatusClient}.
 * @author ralph
 *
 */
public class StatusClientTest {

	private static StatusClient client;
	
	/**
	 * Sets up the client
	 * @throws Exception - when setup fails
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		client = TestClientFactory.getClient().status();
	}

	@Test
	public void testGet() {
		Status status = client.get();
		assertTrue("No requests left", status.getRemainingRequests() > 0);
	}

	@AfterClass
	public static void shutdownAfterClass() throws Exception {
		TestClientFactory.close();
	}
}
