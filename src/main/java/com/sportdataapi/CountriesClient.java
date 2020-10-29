/**
 * 
 */
package com.sportdataapi;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.Country;
import com.sportdataapi.util.Response;

/**
 * The countries getter.
 * @author ralph
 *
 */
public class CountriesClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	protected CountriesClient(WebTarget target) {
		super(target.path("countries"));
	}

	/**
	 * Request and return the list of countries.
	 * @return list of countries
	 */
	public List<Country> list() {
		Response<List<Country>> response = getRequest().get(new GenericType<Response<List<Country>>>() {});
		return response.getData();
	}
}
