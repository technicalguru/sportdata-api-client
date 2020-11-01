/**
 * 
 */
package com.sportdataapi.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.sportdataapi.ClientProvider;
import com.sportdataapi.data.LeagueStandings;
import com.sportdataapi.data.TeamStandings;

/**
 * Test the {@link StandingsClient}.
 * @author ralph
 *
 */
public class StandingsClientTest {

	/**
	 * Tests the get() method for non-groups.
	 */
	@Test
	public void testGet1() {
		StandingsClient client = ClientProvider.getClient().soccer().standings();
		LeagueStandings leagueStandings = client.get(496);
		assertEquals("Incorrect leagueId", 314, leagueStandings.getLeagueId());
		assertEquals("Incorrect seasonId", 496, leagueStandings.getSeasonId());
		assertFalse("Incorrect hasGroups value", leagueStandings.isHasGroups());
		List<TeamStandings> teamStandings = leagueStandings.getTeamStandings();
		assertEquals("TeamStandings list length is incorrect", 18, teamStandings.size());
		for (TeamStandings c : teamStandings) {
			// Test general standings characteristics
			assertTrue("Invalid value for teamId: "+c.getTeamId(), c.getTeamId() > 0);
			assertTrue("Invalid value for points: "+c.getPoints(), c.getPoints() >= 0);
			assertTrue("Invalid value for overallStats.gamesPlayed: "+c.getOverallStats().getGamesPlayed(), c.getOverallStats().getGamesPlayed() > 0);
			assertTrue("Invalid value for overallStats.won: "+c.getOverallStats().getWon(), c.getOverallStats().getWon() >= 0);
			assertTrue("Invalid value for overallStats.draw: "+c.getOverallStats().getDraw(), c.getOverallStats().getDraw() >= 0);
			assertTrue("Invalid value for overallStats.lost: "+c.getOverallStats().getLost(), c.getOverallStats().getLost() >= 0);
			assertTrue("Invalid value for overallStats.goalsScored: "+c.getOverallStats().getGoalsScored(), c.getOverallStats().getGoalsScored() >= 0);
			assertTrue("Invalid value for overallStats.goalsAgainst: "+c.getOverallStats().getGoalsAgainst(), c.getOverallStats().getGoalsAgainst() >= 0);
			assertTrue("Invalid value for homeStats.gamesPlayed: "+c.getHomeStats().getGamesPlayed(), c.getHomeStats().getGamesPlayed() > 0);
			assertTrue("Invalid value for homeStats.won: "+c.getHomeStats().getWon(), c.getHomeStats().getWon() >= 0);
			assertTrue("Invalid value for homeStats.draw: "+c.getHomeStats().getDraw(), c.getHomeStats().getDraw() >= 0);
			assertTrue("Invalid value for homeStats.lost: "+c.getHomeStats().getLost(), c.getHomeStats().getLost() >= 0);
			assertTrue("Invalid value for homeStats.goalsScored: "+c.getHomeStats().getGoalsScored(), c.getHomeStats().getGoalsScored() >= 0);
			assertTrue("Invalid value for homeStats.goalsAgainst: "+c.getHomeStats().getGoalsAgainst(), c.getHomeStats().getGoalsAgainst() >= 0);
			assertTrue("Invalid value for awayStats.gamesPlayed: "+c.getAwayStats().getGamesPlayed(), c.getAwayStats().getGamesPlayed() > 0);
			assertTrue("Invalid value for awayStats.won: "+c.getAwayStats().getWon(), c.getAwayStats().getWon() >= 0);
			assertTrue("Invalid value for awayStats.draw: "+c.getAwayStats().getDraw(), c.getAwayStats().getDraw() >= 0);
			assertTrue("Invalid value for awayStats.lost: "+c.getAwayStats().getLost(), c.getAwayStats().getLost() >= 0);
			assertTrue("Invalid value for awayStats.goalsScored: "+c.getAwayStats().getGoalsScored(), c.getAwayStats().getGoalsScored() >= 0);
			assertTrue("Invalid value for awayStats.goalsAgainst: "+c.getAwayStats().getGoalsAgainst(), c.getAwayStats().getGoalsAgainst() >= 0);
		}
	}

	/**
	 * Tests the get() method for groups.
	 */
	@Test
	public void testGet2() {
		StandingsClient client = ClientProvider.getClient().soccer().standings();
		LeagueStandings leagueStandings = client.get(1243);
		assertEquals("Incorrect leagueId", 281,  leagueStandings.getLeagueId());
		assertEquals("Incorrect seasonId", 1243, leagueStandings.getSeasonId());
		assertTrue("Incorrect hasGroups value", leagueStandings.isHasGroups());
		Map<String,List<TeamStandings>> groupStandings = leagueStandings.getGroupStandings();
		assertEquals("Incorrect number of groups", 8, groupStandings.size());
		for (Map.Entry<String, List<TeamStandings>> group : groupStandings.entrySet()) {
			List<TeamStandings> teamStandings = group.getValue();
			assertEquals("TeamStandings list length is incorrect", 4, teamStandings.size());
			for (TeamStandings c : teamStandings) {
				// Test general standings characteristics
				assertTrue("Invalid value for teamId: "+c.getTeamId(), c.getTeamId() > 0);
				assertTrue("Invalid value for points: "+c.getPoints(), c.getPoints() >= 0);
				assertTrue("Invalid value for overallStats.gamesPlayed: "+c.getOverallStats().getGamesPlayed(), c.getOverallStats().getGamesPlayed() > 0);
				assertTrue("Invalid value for overallStats.won: "+c.getOverallStats().getWon(), c.getOverallStats().getWon() >= 0);
				assertTrue("Invalid value for overallStats.draw: "+c.getOverallStats().getDraw(), c.getOverallStats().getDraw() >= 0);
				assertTrue("Invalid value for overallStats.lost: "+c.getOverallStats().getLost(), c.getOverallStats().getLost() >= 0);
				assertTrue("Invalid value for overallStats.goalsScored: "+c.getOverallStats().getGoalsScored(), c.getOverallStats().getGoalsScored() >= 0);
				assertTrue("Invalid value for overallStats.goalsAgainst: "+c.getOverallStats().getGoalsAgainst(), c.getOverallStats().getGoalsAgainst() >= 0);
				assertTrue("Invalid value for homeStats.gamesPlayed: "+c.getHomeStats().getGamesPlayed(), c.getHomeStats().getGamesPlayed() > 0);
				assertTrue("Invalid value for homeStats.won: "+c.getHomeStats().getWon(), c.getHomeStats().getWon() >= 0);
				assertTrue("Invalid value for homeStats.draw: "+c.getHomeStats().getDraw(), c.getHomeStats().getDraw() >= 0);
				assertTrue("Invalid value for homeStats.lost: "+c.getHomeStats().getLost(), c.getHomeStats().getLost() >= 0);
				assertTrue("Invalid value for homeStats.goalsScored: "+c.getHomeStats().getGoalsScored(), c.getHomeStats().getGoalsScored() >= 0);
				assertTrue("Invalid value for homeStats.goalsAgainst: "+c.getHomeStats().getGoalsAgainst(), c.getHomeStats().getGoalsAgainst() >= 0);
				assertTrue("Invalid value for awayStats.gamesPlayed: "+c.getAwayStats().getGamesPlayed(), c.getAwayStats().getGamesPlayed() > 0);
				assertTrue("Invalid value for awayStats.won: "+c.getAwayStats().getWon(), c.getAwayStats().getWon() >= 0);
				assertTrue("Invalid value for awayStats.draw: "+c.getAwayStats().getDraw(), c.getAwayStats().getDraw() >= 0);
				assertTrue("Invalid value for awayStats.lost: "+c.getAwayStats().getLost(), c.getAwayStats().getLost() >= 0);
				assertTrue("Invalid value for awayStats.goalsScored: "+c.getAwayStats().getGoalsScored(), c.getAwayStats().getGoalsScored() >= 0);
				assertTrue("Invalid value for awayStats.goalsAgainst: "+c.getAwayStats().getGoalsAgainst(), c.getAwayStats().getGoalsAgainst() >= 0);
			}
		}
	}
}
