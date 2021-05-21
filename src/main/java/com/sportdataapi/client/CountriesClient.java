/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.Country;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The countries client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#countries()} instead.</p>
 * @author ralph
 *
 */
public class CountriesClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public CountriesClient(WebTarget target) {
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

	/**
	 * Request and returns a specific country.
	 * @param id - id of country
	 * @return the country requested or {@code null}
	 */
	public Country get(int id) {
		try {
			Response<Country> response = registerRequest(getTarget().path(""+id)).request().get(new GenericType<Response<Country>>() {});
			return response.getData();
		} catch (NotFoundException e) {
			return null;
		}
	}
}
