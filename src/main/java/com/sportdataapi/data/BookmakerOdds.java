/**
 * 
 */
package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sportdataapi.util.RsDateDeserializer;

import rs.baselib.util.RsDate;

/**
 * Odds for a specific bookmaker.
 * @author ralph
 *
 */
public class BookmakerOdds {

	private int bookmakerId;
	private String bookmakerName;
	private OddsData odds;
	private RsDate lastUpdated;
	
	/**
	 * Constructor.
	 */
	public BookmakerOdds() {
	}

	/**
	 * Returns the bookmakerId.
	 * @return the bookmakerId
	 */
	@JsonProperty("bookmaker_id")
	public int getBookmakerId() {
		return bookmakerId;
	}
	
	/**
	 * Sets the bookmakerId.
	 * @param bookmakerId the bookmakerId to set
	 */
	@JsonProperty("bookmaker_id")
	public void setBookmakerId(int bookmakerId) {
		this.bookmakerId = bookmakerId;
	}

	/**
	 * Returns the bookmakerName.
	 * @return the bookmakerName
	 */
	@JsonProperty("bookmaker_name")
	public String getBookmakerName() {
		return bookmakerName;
	}

	/**
	 * Sets the bookmakerName.
	 * @param bookmakerName the bookmakerName to set
	 */
	@JsonProperty("bookmaker_name")
	public void setBookmakerName(String bookmakerName) {
		this.bookmakerName = bookmakerName;
	}

	/**
	 * Returns the odds.
	 * @return the odds
	 */
	@JsonProperty("odds_data")
	public OddsData getOdds() {
		return odds;
	}

	/**
	 * Sets the odds.
	 * @param odds the odds to set
	 */
	@JsonProperty("odds_data")
	public void setOdds(OddsData odds) {
		this.odds = odds;
	}

	/**
	 * Returns the lastUpdated.
	 * @return the lastUpdated
	 */
	@JsonProperty("last_updated")
	@JsonDeserialize(using=RsDateDeserializer.class)
	public RsDate getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * Sets the lastUpdated.
	 * @param lastUpdated the lastUpdated to set
	 */
	@JsonProperty("last_updated")
	@JsonDeserialize(using=RsDateDeserializer.class)
	public void setLastUpdated(RsDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "BookmakerOdds [bookmakerId=" + bookmakerId + ", bookmakerName=" + bookmakerName + ", odds="
				+ odds + "]";
	}

	
}
