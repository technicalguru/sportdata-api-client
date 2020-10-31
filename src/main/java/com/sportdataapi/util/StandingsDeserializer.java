package com.sportdataapi.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sportdataapi.data.TeamStandings;

/**
 * Helps Jackson to deserialize a match status.
 * @author ralph
 *
 */
public class StandingsDeserializer extends JsonDeserializer<Object> {

	/**
	 * Constructor.
	 */
	public StandingsDeserializer() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		switch (p.currentTokenId()) {
		case JsonTokenId.ID_START_ARRAY:
			return p.readValueAs(new TypeReference<List<TeamStandings>>() { });
		case JsonTokenId.ID_START_OBJECT:
			return p.readValueAs(new TypeReference<Map<String,List<TeamStandings>>>() { });
		}
		return null;
	}

	
}
