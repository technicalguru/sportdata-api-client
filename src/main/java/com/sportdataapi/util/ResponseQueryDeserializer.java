package com.sportdataapi.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
		Map<String,Object> values = new HashMap<>();
		ResponseQuery rc  = new ResponseQuery();
		JsonNode node     = p.readValueAsTree();
		if (!node.isArray()) {
			Iterator<Map.Entry<String,JsonNode>> i =  node.fields();
			while (i.hasNext()) {
				Map.Entry<String,JsonNode> entry = i.next();
				String   name  = entry.getKey();
				String   value = entry.getValue().asText();
				values.put(name, value);
			}
		}
		rc.setQueryValues(values);
		return rc;
	}
}
