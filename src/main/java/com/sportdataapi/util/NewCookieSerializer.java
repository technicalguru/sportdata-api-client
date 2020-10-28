/**
 * 
 */
package com.sportdataapi.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.Date;

import javax.ws.rs.core.NewCookie;

import org.ehcache.shadow.org.terracotta.offheapstore.util.ByteBufferInputStream;
import org.ehcache.spi.serialization.Serializer;
import org.ehcache.spi.serialization.SerializerException;

/**
 * Provide Serialization for cookies.
 * @author ralph
 *
 */
public class NewCookieSerializer implements Serializer<NewCookie> {

	/**
	 * Constructor.
	 */
	public NewCookieSerializer() {
	}

	/**
	 * Is the cookie equals to the one in the buffer?
	 * @param cookie
	 * @param buf
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SerializerException
	 */
	@Override
	public boolean equals(NewCookie cookie, ByteBuffer buf) throws ClassNotFoundException, SerializerException {
		return false;
	}

	/**
	 * Reads a cookie from the buffer.
	 * @param buf
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SerializerException
	 */
	@Override
	public NewCookie read(ByteBuffer buf) throws ClassNotFoundException, SerializerException {
		try {
			ObjectInputStream in = new ObjectInputStream(new ByteBufferInputStream(buf));
			String name      = in.readUTF();
			String value     = in.readUTF();
			String path      = in.readUTF();
			String domain    = in.readUTF();
			int version      = in.readInt();
			String comment   = in.readUTF();
			int maxAge       = in.readInt();
			long expiryTime  = in.readLong();
			Date expiry      = expiryTime > 0 ? new Date(expiryTime) : null;
			boolean secure   = in.readBoolean();
			boolean httpOnly = in.readBoolean();
			in.close();
			return new NewCookie(name, value, path, domain, version, comment, maxAge, expiry, secure, httpOnly);
		} catch (IOException e) {
			throw new SerializerException("Cannot deserialize cookie", e);
		}
		
	}

	/**
	 * Writes the cookie into the buffer.
	 * @param cookie
	 * @return
	 * @throws SerializerException
	 */
	@Override
	public ByteBuffer serialize(NewCookie cookie) throws SerializerException {
		try {
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			ObjectOutputStream    out  = new ObjectOutputStream(bout);
			
			out.writeUTF(cookie.getName());
			out.writeUTF(cookie.getValue());
			out.writeUTF(cookie.getPath());
			out.writeUTF(cookie.getDomain());
			out.writeInt(cookie.getVersion());
			out.writeUTF(cookie.getComment());
			out.writeInt(cookie.getMaxAge());
			out.writeLong(cookie.getExpiry() != null ? cookie.getExpiry().getTime() : 0);
			out.writeBoolean(cookie.isSecure());
			out.writeBoolean(cookie.isHttpOnly());
			
			out.flush();
			return ByteBuffer.wrap(bout.toByteArray());
		} catch (IOException e) {
			throw new SerializerException("Cannot serialize cookie", e);
		}
	}

	
}
