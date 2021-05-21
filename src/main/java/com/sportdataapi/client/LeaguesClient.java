/**
 * 
 */
package com.sportdataapi.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.League;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The leagues client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#leagues()} instead.</p>
 * @author ralph
 *
 */
public class LeaguesClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public LeaguesClient(WebTarget target) {
		super(target.path("leagues"));
	}

	/**
	 * Request and return the list of all leagues.
	 * <p>Same as {@code list(false);}</p>
	 * @return list of leagues
	 */
	public List<League> list() {
		return list(false);
	}

	/**
	 * Request and return the list of all leagues.
	 * @param subscribedOnly - limit result to subscribed leagues only
	 * @return list of leagues
	 */
	public List<League> list(boolean subscribedOnly) {
		WebTarget target = getTarget();
		if (subscribedOnly)  target = target.queryParam("subscribed", subscribedOnly);
		Response<List<League>> response = registerRequest(target).request().get(new GenericType<Response<List<League>>>() {});
		return response.getData();
	}

	/**
	 * Request and return the list of leagues in a country.
	 * @param countryId - list leagues of this country only
	 * @return list of leagues
	 */
	public List<League> list(int countryId) {
		if (countryId <= 0) throw new RuntimeException("countryId must be a positive number");
		WebTarget target = getTarget().queryParam("country_id", countryId);
		Response<Map<String,League>> response = registerRequest(target).request().get(new GenericType<Response<Map<String,League>>>() {});
		return new ArrayList<>(response.getData().values());
	}
	
	/**
	 * Request and returns a specific league.
	 * @param id - id of league
	 * @return the league requested or {@code null}
	 */
	public League get(int id) {
		try {
			Response<League> response = registerRequest(getTarget().path(""+id)).request().get(new GenericType<Response<League>>() {});
			return response.getData();
		} catch (NotFoundException e) {
			return null;
		}
	}

}
