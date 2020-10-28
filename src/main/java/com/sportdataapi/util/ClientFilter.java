/**
 * 
 */
package com.sportdataapi.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.NewCookie;

import org.ehcache.Cache;
import org.ehcache.PersistentCacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;


/**
 * Takes care of cookie handling and API requests.
 * @author ralph
 *
 */
public class ClientFilter implements ClientRequestFilter, ClientResponseFilter {

	private String apiKey;
	private Cache<String, NewCookie> cache;
	private PersistentCacheManager cacheManager;
	
	/**
	 * Constructor.
	 * @param apiKey - the API key.
	 */
	public ClientFilter(String apiKey) {
		this.apiKey = apiKey;

		cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
			    .with(CacheManagerBuilder.persistence(new File(".", "cookies.ehcache"))) 
			    .withCache("cookies",
			        CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, NewCookie.class,
			            ResourcePoolsBuilder.newResourcePoolsBuilder()
			                .heap(10, EntryUnit.ENTRIES) 
			                .disk(20, MemoryUnit.MB, true) 
			            )
			        .withValueSerializer(new NewCookieSerializer())
			    ).build(true);
		
		/*
		CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().withCache("cookies",
				CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, NewCookie.class, ResourcePoolsBuilder.heap(10)))
				//.withLoaderWriter(new NewCookieSerializer())
				.build(true); 
		*/
		cache = cacheManager.getCache("cookies", String.class, NewCookie.class);
		// TODO read cookies from a persistent cache
	}

	/**
	 * filter the reponse and evaluate the cookies to be set.
	 */
	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		for (Map.Entry<String, NewCookie> cookie : responseContext.getCookies().entrySet()) {
			String n = cookie.getKey();
			NewCookie c = cookie.getValue(); //.toCookie();
			cache.put(n, c);
		}
	}

	/**
	 * Set the API key and cookies if required.
	 */
	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		requestContext.getHeaders().add("apiKey", apiKey);
		Date now = new Date();
		for (Map.Entry<String, NewCookie> cookie : cache.getAll(new HashSet<String>()).entrySet()) {
			if (cookie.getValue().getExpiry().before(now)) {
				cache.remove(cookie.getKey());
			} else {
				requestContext.getCookies().put(cookie.getKey(), cookie.getValue().toCookie());
			}
		}
	}

	/**
	 * Closes the filter and, hence, the persistent cache.
	 */
	public void close() {
		cacheManager.close();
	}
}
