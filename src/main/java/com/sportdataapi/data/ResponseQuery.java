package com.sportdataapi.data;

import java.util.List;
import java.util.Map;

/**
 * Query Response information.
 * @author ralph
 *
 */
public class ResponseQuery {

	private Map<String,Object> queryValues;
	private List<Map<String,String>> errors;
	
	/**
	 * Constructor.
	 */
	public ResponseQuery() {
	}

	/**
	 * Returns the values used for the query (parameters)
	 * @return the queryValues
	 */
	public Map<String, Object> getQueryValues() {
		return queryValues;
	}

	/**
	 * ets the query parameters.
	 * @param queryValues the queryValues to set
	 */
	public void setQueryValues(Map<String, Object> queryValues) {
		this.queryValues = queryValues;
	}

	/**
	 * Returns the errors.
	 * @return the errors
	 */
	public List<Map<String,String>> getErrors() {
		return errors;
	}

	/**
	 * Sets the errors.
	 * @param errors the errors to set
	 */
	public void setErrors(List<Map<String,String>> errors) {
		this.errors = errors;
	}

	
}
