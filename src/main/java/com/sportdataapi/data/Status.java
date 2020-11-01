/**
 * 
 */
package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The status of the API.
 * @author ralph
 *
 */
public class Status {

	private int remainingRequests;
	
	/**
	 * Constructor.
	 */
	public Status() {
	}

	/**
	 * Returns the remaining requests info.
	 * @return the remainingRequests
	 */
	@JsonProperty("remaining_requests")
	public int getRemainingRequests() {
		return remainingRequests;
	}

	/**
	 * Sets the remaining requests info.
	 * @param remainingRequests - the remainingRequests to set
	 */
	@JsonProperty("remaining_requests")
	public void setRemainingRequests(int remainingRequests) {
		this.remainingRequests = remainingRequests;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Status [remainingRequests=" + remainingRequests + "]";
	}

	
}
