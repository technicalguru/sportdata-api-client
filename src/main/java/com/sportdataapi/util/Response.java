package com.sportdataapi.util;

/**
 * API Response Object
 * @author ralph
 *
 */
public class Response<T> {

	private ResponseQuery query;
	private T data;
	
	/**
	 * Constructor.
	 */
	public Response() {
	}

	/**
	 * Constructor.
	 */
	public Response(ResponseQuery query, T data) {
		setQuery(query);
		setData(data);
	}

	/**
	 * Returns the query.
	 * @return the query
	 */
	public ResponseQuery getQuery() {
		return query;
	}

	/**
	 * Sets the query.
	 * @param query - the query to set
	 */
	public void setQuery(ResponseQuery query) {
		this.query = query;
	}

	/**
	 * Returns whether the response has errors.
	 */
	public boolean hasErrors() {
		if (query == null) return true;
		if (query.getErrors() == null) return false;
		if (!query.getErrors().isEmpty()) return true;
		return false;
	}
	
	/**
	 * Returns the data.
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Sets the data.
	 * @param data - the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

}
