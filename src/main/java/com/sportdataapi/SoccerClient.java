/**
 * 
 */
package com.sportdataapi;

import javax.ws.rs.client.WebTarget;

/**
 * The countries getter.
 * @author ralph
 *
 */
public class SoccerClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	protected SoccerClient(WebTarget target) {
		super(target.path("soccer"));
	}

	/**
	 * Returns the access client for countries.
	 * @return the client to request country information
	 */
	public CountriesClient countries() {
		return new CountriesClient(getTarget());
	}
	

}
