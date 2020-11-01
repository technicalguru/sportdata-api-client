/**
 * 
 */
package com.sportdataapi.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Odds for a market.
 * @author ralph
 *
 */
public class MarketOdds {

	private List<BookmakerOdds> bookmakerOdds;
	
	/**
	 * Constructor.
	 */
	public MarketOdds() {
	}

	/**
	 * Returns the bookmakerOdds.
	 * @return the bookmakerOdds
	 */
	@JsonProperty("bookmakers")
	public List<BookmakerOdds> getBookmakerOdds() {
		return bookmakerOdds;
	}

	/**
	 * Sets the bookmakerOdds.
	 * @param bookmakerOdds the bookmakerOdds to set
	 */
	@JsonProperty("bookmakers")
	public void setBookmakerOdds(List<BookmakerOdds> bookmakerOdds) {
		this.bookmakerOdds = bookmakerOdds;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "MarketOdds [bookmakerOdds=" + bookmakerOdds + "]";
	}

	
}
