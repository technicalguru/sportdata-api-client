/**
 * 
 */
package com.sportdataapi.util;

import java.net.URI;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

/**
 * Base class for all client instances.
 * @author ralph
 *
 */
public abstract class AbstractClient {

	private SubClientHolder subclients;
	private URI lastURI;
	
	/**
	 * Constructor.
	 * @param target - the target to request.
	 */
	protected AbstractClient(WebTarget target) {
		subclients = new SubClientHolder(target);
		lastURI    = null;
	}

	/**
	 * Register the target that it is requested now.
	 * <p>Descendants shall call this method in order to allow debug of URIs requested.</p>
	 * @param target - the target to register
	 * @return the target again (for method chaining)
	 */
	protected WebTarget registerRequest(WebTarget target) {
		if (target != null) lastURI = target.getUri();
		return target;
	}
	
	/**
	 * Returns a request builder.
	 * @return the builder
	 */
	public Builder getRequest() {
		Builder rc = registerRequest(getTarget()).request();
		return rc;
	}

	/**
	 * Returns the last registered URI that was requested (can be null)
	 * @return the last URI that was requested
	 */
	public URI getLastUri() {
		return lastURI;
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
