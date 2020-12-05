package com.sportdataapi.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import rs.baselib.util.RsDay;

/**
 * Helps Jackson to deserialize a day.
 * @author ralph
 *
 */
public class RsDayDeserializer extends JsonDeserializer<RsDay> {

	/**
	 * Constructor.
	 */
	public RsDayDeserializer() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RsDay deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node     = p.readValueAsTree();
		if (!node.isNull()) {
			String value      = node.asText();
			if (value.length() >= 10) {
				return RsDay.getDay(value.substring(0, 4)+value.substring(5, 7)+value.substring(8, 10));
			}
		}
		return null;
	}


}
