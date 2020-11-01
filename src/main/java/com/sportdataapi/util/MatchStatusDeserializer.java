package com.sportdataapi.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.sportdataapi.data.MatchStatus;

/**
 * Helps Jackson to deserialize a match status.
 * @author ralph
 *
 */
public class MatchStatusDeserializer extends JsonDeserializer<MatchStatus> {

	/**
	 * Constructor.
	 */
	public MatchStatusDeserializer() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MatchStatus deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = p.readValueAsTree();
		int id        = node.asInt();
		return MatchStatus.withId(id);
	}

	
}
