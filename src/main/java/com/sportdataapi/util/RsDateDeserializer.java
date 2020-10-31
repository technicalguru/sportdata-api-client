package com.sportdataapi.util;

import java.io.IOException;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import rs.baselib.util.RsDate;
import rs.baselib.util.RsDay;

/**
 * Helps Jackson to deserialize a date.
 * @author ralph
 *
 */
public class RsDateDeserializer extends JsonDeserializer<RsDate> {

	/**
	 * Constructor.
	 */
	public RsDateDeserializer() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RsDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node     = p.readValueAsTree();
		String value      = node.asText();
		RsDay day     = RsDay.getDay(value.substring(0, 4)+value.substring(5, 7)+value.substring(8, 10));
		RsDate rc     = day.getBegin();
		rc.add(Calendar.HOUR_OF_DAY, Integer.valueOf(value.substring(11,13)));
		rc.add(Calendar.MINUTE,      Integer.valueOf(value.substring(14,16)));
		return rc;
	}

	
}
