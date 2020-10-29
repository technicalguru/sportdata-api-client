package com.sportdataapi.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Helps Jackson to deserialize the query attribute in a response.
 * @author ralph
 *
 */
public class ResponseQueryDeserializer extends JsonDeserializer<ResponseQuery> {

	/**
	 * Constructor.
	 */
	public ResponseQueryDeserializer() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseQuery deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ResponseQuery rc = new ResponseQuery();
		JsonNode node     = p.readValueAsTree();
		if (!node.isArray()) {
			rc = p.readValueAs(ResponseQuery.class);
		}
		return rc;
	}

	
}
