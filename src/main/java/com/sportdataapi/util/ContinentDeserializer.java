package com.sportdataapi.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.sportdataapi.data.Continent;

/**
 * Helps Jackson to deserialize a continent.
 * @author ralph
 *
 */
public class ContinentDeserializer extends JsonDeserializer<Continent> {

	/**
	 * Constructor.
	 */
	public ContinentDeserializer() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Continent deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node     = p.readValueAsTree();
		String name       = node.asText();
		for (Continent c : Continent.values()) {
			if (c.getApiName().equals(name)) return c;
		}
		return null;
	}

	
}
