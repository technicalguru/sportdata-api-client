package com.sportdataapi.util;

import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.TimeZone;

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
		if (value.length() == 19) {
			RsDay day     = RsDay.getDay(value.substring(0, 4)+value.substring(5, 7)+value.substring(8, 10));
			RsDate rc     = day.getBegin();
			rc.setTimeZone(TimeZone.getTimeZone("UTC"));
			rc.add(Calendar.HOUR_OF_DAY, Integer.valueOf(value.substring(11,13)));
			rc.add(Calendar.MINUTE,      Integer.valueOf(value.substring(14,16)));
			return rc;
		} else {
			// 2020-09-23T23:11:10.000000Z
			TemporalAccessor ta = DateTimeFormatter.ISO_INSTANT.parse(value);
			return new RsDate(Instant.from(ta).getLong(ChronoField.INSTANT_SECONDS));
		}
	}

	
}
