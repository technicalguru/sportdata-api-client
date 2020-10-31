/**
 * 
 */
package com.sportdataapi.client;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import com.sportdataapi.data.Match;
import com.sportdataapi.data.MatchStatus;
import com.sportdataapi.util.AbstractClient;
import com.sportdataapi.util.Response;

import rs.baselib.util.RsDay;

/**
 * The matches client.
 * <p><b>Attention!</b> You shall never create this client directly but use {@link SoccerClient#matches()} instead.</p>
 * @author ralph
 *
 */
public class MatchesClient extends AbstractClient {

	private static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(""); 
	/**
	 * Constructor.
	 * @param target - the target to request
	 */
	public MatchesClient(WebTarget target) {
		super(target.path("matches"));
	}

	/**
	 * Request and return the list of matches in a season.
	 * @return list of matches
	 */
	public List<Match> list(int seasonId) {
		return list(seasonId, null, null, null);
	}
	
	/**
	 * Request and return the list of matches in a season.
	 * @return list of matches
	 */
	public List<Match> list(int seasonId, MatchStatus status) {
		return list(seasonId, status, null, null);
	}
	
	/**
	 * Request and return the list of matches in a season.
	 * @return list of matches
	 */
	public List<Match> list(int seasonId, RsDay from, RsDay to) {
		return list(seasonId, null, from, to);
	}
	
	/**
	 * Request and return the list of matches in a season.
	 * @return list of matches
	 */
	public List<Match> list(int seasonId, MatchStatus status, RsDay from, RsDay to) {
		WebTarget target = getTarget().queryParam("season_id", seasonId);
		if (status != null) target = target.queryParam("status_id", status.getId());
		if (from   != null) target = target.queryParam("date_from", DATE_FORMATTER.format(from.getTime()));
		if (to     != null) target = target.queryParam("date_to",   DATE_FORMATTER.format(from.getTime()));
		Response<List<Match>> response = target.request().get(new GenericType<Response<List<Match>>>() {});
		return response.getData();
	}
	
	/**
	 * Request and return the list of live matches.
	 * @return list of matches
	 */
	public List<Match> listLive() {
		return listLive(0, null);
	}
	
	/**
	 * Request and return the list of live matches .
	 * @return list of matches
	 */
	public List<Match> listLive(int seasonId) {
		return listLive(seasonId, null);
	}
	
	/**
	 * Request and return the list of live matches.
	 * @return list of matches
	 */
	public List<Match> listLive(int seasonId, MatchStatus status) {
		WebTarget target = getTarget().queryParam("live", "true");
		if (seasonId  > 0)    target = target.queryParam("season_id", seasonId);
		if (status   != null) target = target.queryParam("status_id", status.getId());
		Response<List<Match>> response = target.request().get(new GenericType<Response<List<Match>>>() {});
		return response.getData();
	}
	
	/**
	 * Returns the match with given id.
	 * @param id - ID of match
	 * @return the match or {@code null}
	 */
	public Match get(int id) {
		Response<Match> response = getTarget().path(""+id).request().get(new GenericType<Response<Match>>() {});
		return response.getData();
	}
}
