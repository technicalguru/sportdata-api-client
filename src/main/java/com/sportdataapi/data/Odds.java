/**
 * 
 */
package com.sportdataapi.data;

import java.util.Collection;
import java.util.HashMap;

/**
 * Odds object for Sportdataapi.com.
 * @author ralph
 *
 */
public class Odds extends HashMap<String,MarketOdds>{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor.
	 */
	public Odds() {
	}

	/**
	 * Returns the markets.
	 * @return the markets
	 */
	public Collection<String> getMarkets() {
		return keySet();
	}

	/**
	 * Returns a single market odds info
	 * @param market the market name
	 * @return the odds for this market
	 */
	public MarketOdds getMarket(String market) {
		return get(market);
	}

}
