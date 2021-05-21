/**
 * 
 */
package com.sportdataapi.client;

import java.net.URI;

/**
 * Listens to requests that are registered so they can be debugged later.
 * @author ralph
 *
 */
public interface RequestListener {

	/**
	 * Registers a URI.
	 * @param uri - the URI to be registered.
	 */
	public void registerRequest(URI uri);
	
}
