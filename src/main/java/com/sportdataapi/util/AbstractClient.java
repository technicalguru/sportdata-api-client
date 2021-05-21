/**
 * 
 */
package com.sportdataapi.util;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import com.sportdataapi.client.RequestListener;

/**
 * Base class for all client instances.
 * @author ralph
 *
 */
public abstract class AbstractClient {

	private SubClientHolder subclients;
	private URI lastURI;
	private Set<RequestListener> requestListeners;
	
	/**
	 * Constructor.
	 * @param target - the target to request.
	 */
	protected AbstractClient(WebTarget target) {
		subclients = new SubClientHolder(target);
		lastURI    = null;
		requestListeners = new HashSet<RequestListener>();
	}

	/**
	 * Register the target that it is requested now.
	 * <p>Descendants shall call this method in order to allow debug of URIs requested.</p>
	 * @param target - the target to register
	 * @return the target again (for method chaining)
	 */
	protected WebTarget registerRequest(WebTarget target) {
		if (target != null) lastURI = target.getUri();
		fireRequestRegistered(lastURI);
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
	 * Adds a request listener.
	 * @param listener - listener to add
	 */
	public void addRequestListener(RequestListener listener) {
		requestListeners.add(listener);
	}
	
	/**
	 * Informs all listeners about the last URI.
	 * @param uri - the URI to be fired
	 */
	protected void fireRequestRegistered(URI uri) {
		for (RequestListener r : requestListeners) {
			r.registerRequest(uri);
		}
	}
	/**
	 * Returns the subclient of the given type.
	 * <p>Be aware that subclient use relative REST API paths.</p>
	 * @param <T>   - Class of subclient
	 * @param clazz - class of subclient
	 * @return new or existing instance of subclient
	 */
	public <T extends AbstractClient> T get(Class<T> clazz) {
		T rc = subclients.get(clazz);
		// Register this object if required
		if (this instanceof RequestListener) {
			rc.addRequestListener((RequestListener)this);
		}
		// Register all listeners that this object knows
		for (RequestListener r : requestListeners) {
			rc.addRequestListener(r);
		}
		return rc;
	}
	
}
