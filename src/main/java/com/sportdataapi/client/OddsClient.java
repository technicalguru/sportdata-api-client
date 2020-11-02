/**
 * 
 */
package com.sportdataapi.client;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.Odds;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

/**
 * The odds client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#odds()} instead.</p>
 * @author ralph
 *
 */
public class OddsClient extends AbstractClient {

	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public OddsClient(WebTarget target) {
		super(target.path("odds"));
	}

	/**
	 * Request and return the prematch odds for a match.
	 * @param matchId - ID of match
	 * @return list of prematch odds
	 */
	public Odds getPrematch(int matchId) {
		Response<Odds> response = getTarget().path(""+matchId).queryParam("type", "prematch").request().get(new GenericType<Response<Odds>>() {});
		try {
			return response.getData();
		} catch (NotFoundException e) {
			return null;
		}
	}

	/**
	 * Request and return the inplay odds for a match.
	 * @param matchId - ID of match
	 * @return list of inplay odds
	 */
	public Odds getInplay(int matchId) {
		try {
			Response<Odds> response = getTarget().path(""+matchId).queryParam("type", "inplay").request().get(new GenericType<Response<Odds>>() {});
			return response.getData();
		} catch (NotFoundException e) {
			return null;
		}
	}
}
