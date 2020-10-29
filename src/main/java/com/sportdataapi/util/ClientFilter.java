/**
 * 
 */
package com.sportdataapi.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.NewCookie;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


/**
 * Takes care of cookie handling and API requests.
 * @author ralph
 *
 */
public class ClientFilter implements ClientRequestFilter, ClientResponseFilter {

	private static Logger log = LoggerFactory.getLogger(ClientFilter.class);
	
	private String apiKey;
	private Map<String, NewCookie> cookies;
	
	/**
	 * Constructor.
	 * @param apiKey - the API key.
	 */
	public ClientFilter(String apiKey) {
		this.apiKey = apiKey;
		cookies = readCookies();
	}

	/**
	 * filter the reponse and evaluate the cookies to be set.
	 */
	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		for (Map.Entry<String, NewCookie> cookie : responseContext.getCookies().entrySet()) {
			String n = cookie.getKey();
			NewCookie c = cookie.getValue();
			cookies.put(n, c);
		}
		saveCookies();
	}

	/**
	 * Set the API key and cookies if required.
	 */
	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		requestContext.getHeaders().add("apiKey", apiKey);
		Date now = new Date();
		for (Map.Entry<String, NewCookie> entry : cookies.entrySet()) {
			String name = entry.getKey();
			NewCookie cookie = entry.getValue();
			if (cookie.getExpiry().before(now)) {
				cookies.remove(name);
			} else {
				requestContext.getHeaders().add("Cookie", cookie.getName()+'='+cookie.getValue());
			}
		}
	}

	/**
	 * Load the cookies from local disk cache.
	 * @return the cached cookies from disk
	 */
	protected Map<String,NewCookie> readCookies() {
		Map<String,NewCookie> rc = new HashMap<String, NewCookie>();
		ObjectMapper mapper = new ObjectMapper();
		File dbFile = new File(".", "cookies.db");
		if (dbFile.exists() && dbFile.canRead()) {
			try {
				JsonNode arrayNode = mapper.readTree(dbFile);
				if (arrayNode.isArray()) {
					Iterator<JsonNode> i = arrayNode.elements();
					while (i.hasNext()) {
						JsonNode node = i.next();
						if (node.isObject()) {
							String  name     = null;
							String  value    = null;
							String  path     = null;
							String  domain   = null;
							int     version  = 1;
							String  comment  = null;
							int     maxAge   = 0;
							Date    expiry   = null;
							boolean secure   = false;
							boolean httpOnly = false;
									
							JsonNode field = node.findValue("name");
							if (field != null) name = field.asText();
							field = node.findValue("value");
							if (field != null) value = field.asText();
							field = node.findValue("path");
							if (field != null) path = field.asText();
							field = node.findValue("domain");
							if (field != null) domain = field.asText();
							field = node.findValue("version");
							if (field != null) version = field.asInt();
							field = node.findValue("comment");
							if (field != null) comment = field.asText();
							field = node.findValue("maxAge");
							if (field != null) maxAge = field.asInt();
							field = node.findValue("expiry");
							if (field != null) expiry = new Date(field.asLong());
							field = node.findValue("secure");
							if (field != null) secure = field.asBoolean();
							field = node.findValue("httpOnly");
							if (field != null) httpOnly = field.asBoolean();
							NewCookie cookie = new NewCookie(name, value, path, domain, version, comment, maxAge, expiry, secure, httpOnly);
							rc.put(name, cookie);
						} else {
							throw new IOException("Invalid objects in array");
						}
					}
				} else {
					throw new IOException("cookies DB has no array of cookies");
				}
			} catch (IOException e) {
				log.warn("Cannot read cookies from disk", e);
			}
		}
		return rc;
	}
	
	/**
	 * Saves the cookies to local disk cache.
	 */
	protected void saveCookies() {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrNode = mapper.createArrayNode();
		for (Map.Entry<String, NewCookie> entry : cookies.entrySet()) {
			NewCookie cookie = entry.getValue();
			ObjectNode node = arrNode.addObject();
			node.put("name", cookie.getName());
			node.put("value", cookie.getValue());
			if (cookie.getPath() != null) {
				node.put("path", cookie.getPath());
			} else {
				node.putNull("path");
			}
			if (cookie.getDomain() != null) {
				node.put("domain", cookie.getDomain());
			} else {
				node.putNull("domain");
			}
			node.put("version", cookie.getVersion());
			if (cookie.getComment() != null) {
				node.put("comment", cookie.getComment());
			} else {
				node.putNull("comment");
			}
			node.put("maxAge", cookie.getMaxAge());
			if (cookie.getExpiry() != null) {
				node.put("expiry", cookie.getExpiry().getTime());
			} else {
				node.putNull("expiry");
			}
			node.put("secure", cookie.isSecure());
			node.put("httpOnly", cookie.isHttpOnly());
		}
		try {
			FileUtils.writeStringToFile(new File(".", "cookies.db"), arrNode.toString(), StandardCharsets.UTF_8, false);
		} catch (IOException e) {
			log.warn("Cannot write cookies to disk", e);
		}
		
	}
}
