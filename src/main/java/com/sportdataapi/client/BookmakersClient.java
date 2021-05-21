/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.Bookmaker;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The bookmakers client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#bookmakers()} instead.</p>
 * @author ralph
 *
 */
public class BookmakersClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public BookmakersClient(WebTarget target) {
		super(target.path("bookmakers"));
	}

	/**
	 * Request and return the list of bookmakers.
	 * @return list of bookmakers
	 */
	public List<Bookmaker> list() {
		Response<List<Bookmaker>> response = getRequest().get(new GenericType<Response<List<Bookmaker>>>() {});
		return response.getData();
	}
	
	/**
	 * Request and returns a specific bookmaker.
	 * @param id - id of bookmaker
	 * @return the bookmaker requested or {@code null}
	 */
	public Bookmaker get(int id) {
		try {
			Response<Bookmaker> response = registerRequest(getTarget().path(""+id)).request().get(new GenericType<Response<Bookmaker>>() {});
			return response.getData();
		} catch (NotFoundException e) {
			return null;
		}
	}

}
