/**
 * 
 */
package com.sportdataapi;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

/**
 * Base class for all client instances.
 * @author ralph
 *
 */
public abstract class AbstractClient {

	private WebTarget target;
	
	/**
	 * Constructor.
	 * @param target - the target to request.
	 * @param apiKey . the API key
	 */
	protected AbstractClient(WebTarget target) {
		this.target   = target;
	}

	/**
	 * Returns a request builder.
	 * @param path the path for the request.
	 * @return the builder
	 */
	public Builder getRequest() {
		Builder rc = target.request();
		return rc;
	}

	/**
	 * Returns the target.
	 * @return the target
	 */
	protected WebTarget getTarget() {
		return target;
	}
}
