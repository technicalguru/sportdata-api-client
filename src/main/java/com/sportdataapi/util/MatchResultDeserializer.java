package com.sportdataapi.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.sportdataapi.data.MatchResult;

/**
 * Helps Jackson to deserialize a match status.
 * @author ralph
 *
 */
public class MatchResultDeserializer extends JsonDeserializer<MatchResult> {

	/**
	 * Constructor.
	 */
	public MatchResultDeserializer() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MatchResult deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node    = p.readValueAsTree();
		if (!node.isNull()) {
			String s = node.asText();
			String results[];
			if (s.indexOf(':') > 0) {
				results = s.split(":", 2);
			} else {
				results = s.split("-", 2);
			}
			if (results.length == 2) {
				if ((results[0].length() > 0) && (results[1].length() > 0)) {
					return new MatchResult(Integer.valueOf(results[0]), Integer.valueOf(results[1]));
				}
				return null;
			}
			throw new RuntimeException("Cannot parse result: "+node.asText());
		}
		return null;
	}

	
}
