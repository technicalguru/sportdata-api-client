/**
 * 
 */
package com.sportdataapi.util;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

/**
 * Base class for all client instances.
 * @author ralph
 *
 */
public abstract class AbstractClient {

	private SubClientHolder subclients;
	
	/**
	 * Constructor.
	 * @param target - the target to request.
	 */
	protected AbstractClient(WebTarget target) {
		subclients = new SubClientHolder(target);
	}

	/**
	 * Returns a request builder.
	 * @return the builder
	 */
	public Builder getRequest() {
		Builder rc = getTarget().request();
		return rc;
	}

	/**
	 * Returns the target.
	 * @return the target
	 */
	protected WebTarget getTarget() {
		return subclients.getTarget();
	}
	
	/**
	 * Returns the subclient of the given type.
	 * <p>Be aware that subclient use relative REST API paths.</p>
	 * @param <T>   - Class of subclient
	 * @param clazz - class of subclient
	 * @return new or existing instance of subclient
	 */
	public <T extends AbstractClient> T get(Class<T> clazz) {
		return subclients.get(clazz);
	}
	
}
