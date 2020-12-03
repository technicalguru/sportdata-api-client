/**
 * 
 */
package com.sportdataapi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Bookmaker object for Sportdataapi.com.
 * @author ralph
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bookmaker {

	private int id;
	private String name;
	private String image;
	
	/**
	 * Constructor.
	 */
	public Bookmaker() {
	}

	/**
	 * Returns the id.
	 * @return the id
	 */
	@JsonProperty("bookmaker_id")
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id the id to set
	 */
	@JsonProperty("bookmaker_id")
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

	/**
	 * Returns the image.
	 * @return the image
	 */
	@JsonProperty("img")
	public String getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 * @param image the image to set
	 */
	@JsonProperty("img")
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Bookmaker [id=" + id + ", name=" + name + ", image=" + image + "]";
	}

	
}
