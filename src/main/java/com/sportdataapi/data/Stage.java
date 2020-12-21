package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Stage object (inside a match) for Sportdataapi.com.
 * @author ralph
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stage {

	private int id;
	private String name;
	
	/**
	 * Constructor.
	 */
	public Stage() {
	}

	/**
	 * Returns the ID.
	 * @return the id
	 */
	@JsonProperty("stage_id")
	public int getId() {
		return id;
	}

	/**
	 * Sets the ID.
	 * @param id the id to set
	 */
	@JsonProperty("stage_id")
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the name.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


}
