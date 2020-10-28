/**
 * 
 */
package com.sportdataapi;

import javax.ws.rs.client.WebTarget;

import com.sportdataapi.data.Status;

/**
 * The Status getter.
 * @author ralph
 *
 */
public class StatusClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	protected StatusClient(WebTarget target) {
		super(target.path("status"));
	}

	/**
	 * Request and returns the API status info.
	 * @return status info
	 */
	public Status get() {
		return getRequest().get(Status.class);
	}
}
