package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Stage object (inside a match) for Sportdataapi.com.
 * @author ralph
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Group {

	private int id;
	private String name;

	/**
	 * Constructor.
	 */
	public Group() {
	}

	/**
	 * Returns the ID.
	 * @return the id
	 */
	@JsonProperty("group_id")
	public int getId() {
		return id;
	}

	/**
	 * Sets the ID.
	 * @param id the id to set
	 */
	@JsonProperty("group_id")
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the name.
	 * @return the name
	 */
	@JsonProperty("group_name")
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * @param name the name to set
	 */
	@JsonProperty("group_name")
	public void setName(String name) {
		this.name = name;
	}

	
}
