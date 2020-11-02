/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.Player;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The players client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#players()} instead.</p>
 * @author ralph
 *
 */
public class PlayersClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public PlayersClient(WebTarget target) {
		super(target.path("players"));
	}

	/**
	 * Request and return the list of players.
	 * @param countryId - ID of country of players
	 * @return list of players
	 */
	public List<Player> list(int countryId) {
		return list(countryId, 0, 0);
	}

	/**
	 * Request and return the list of players.
	 * @param countryId - ID of country of players
	 * @param minAge    - minimum age of players
	 * @return list of players
	 */
	public List<Player> listMinAge(int countryId, int minAge) {
		return list(countryId, minAge, 0);
	}
	
	/**
	 * Request and return the list of players.
	 * @param countryId - ID of country of players
	 * @param maxAge    - maximum age of players
	 * @return list of players
	 */
	public List<Player> listMaxAge(int countryId, int maxAge) {
		return list(countryId, 0, maxAge);
	}
	
	/**
	 * Request and return the list of players.
	 * @param countryId - ID of country of players
	 * @param minAge    - minimum age of players
	 * @param maxAge    - maximum age of players
	 * @return list of players
	 */
	public List<Player> list(int countryId, int minAge, int maxAge) {
		WebTarget target = getTarget().queryParam("country_id", ""+countryId);
		if (minAge > 0) target = target.queryParam("min_age", ""+minAge);
		if (maxAge > 0) target = target.queryParam("max_age", ""+maxAge);
		Response<List<Player>> response = target.request().get(new GenericType<Response<List<Player>>>() {});
		return response.getData();
	}
	
	/**
	 * Returns the player with given id.
	 * @param id - ID of player
	 * @return the player or {@code null}
	 */
	public Player get(int id) {
		try {
			Response<Player> response = getTarget().path(""+id).request().get(new GenericType<Response<Player>>() {});
			return response.getData();
		} catch (NotFoundException e) {
			return null;
		}
	}

}
