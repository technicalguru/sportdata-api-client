/**
 * 
 */
package com.sportdataapi.client;

import java.util.List;

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
		throw new RuntimeException("This API endpoint is not yet implemented.");
	}

	/**
	 * Request and return the list of players.
	 * @return list of players
	 */
	public List<Player> list() {
		Response<List<Player>> response = getRequest().get(new GenericType<Response<List<Player>>>() {});
		return response.getData();
	}
}
