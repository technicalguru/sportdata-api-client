package com.sportdataapi.data;

/**
 * A continent.
 * @author ralph
 *
 */
public enum Continent {

	AFRICA("Africa"),
	ASIA("Asia"),
	OCEANIA("Oceania"),
	EUROPE("Europe"),
	NORTH_AMERICA("North America"),
	SOUTH_AMERICA("South America"),
	WORLD("World");

	private String apiName;
	
	private Continent(String apiName) {
		this.apiName = apiName;
	}
	
	public String getApiName() {
		return apiName;
	}
}
