/**
 * 
 */
package com.sportdataapi.client;

import javax.ws.rs.client.WebTarget;

import com.sportdataapi.SdaClient;
import com.sportdataapi.data.Status;
import com.sportdataapi.util.AbstractClient;

/**
 * The Status client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SdaClient#status()} instead.</p>
 * @author ralph
 *
 */
public class StatusClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public StatusClient(WebTarget target) {
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
