/**
 * 
 */
package com.sportdataapi.util;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.WebTarget;

/**
 * A helper class to maintain subclients in a client.
 * @author ralph
 *
 */
public class SubClientHolder {

	private Map<Class<?>, Object> subclients;
	private WebTarget             target;
	
	/**
	 * Constructor.
	 */
	public SubClientHolder(WebTarget target) {
		this.target = target;
		subclients  = new HashMap<>();
	}

	/**
	 * Returns the subclient of the given type.
	 * <p>Be aware that subclient use relative REST API paths.</p>
	 * @param <T>   - Class of subclient
	 * @param clazz - class of subclient
	 * @return new or existing instance of subclient
	 */
	@SuppressWarnings("unchecked")
	public <T extends AbstractClient> T get(Class<T> clazz) {
		T rc = (T)subclients.get(clazz);
		if (rc == null) {
			try {
				Constructor<T> c = clazz.getConstructor(WebTarget.class);
				rc = c.newInstance(target);
				subclients.put(clazz, rc);
			} catch (Exception e) {
				throw new RuntimeException("Cannot create subclient", e);
			}
		}
		return rc;
	}

	/**
	 * Returns the target.
	 * @return the target
	 */
	public WebTarget getTarget() {
		return target;
	}
	
}
