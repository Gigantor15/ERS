package com.ers.middle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Lookup and cache services. Reduces performance overhead of looking up
 * services.
 * 
 * @author Gigantor15
 *
 */
public class ServiceLocator {

	private static DataSource ers;
	private static Properties env; // environment props

	static { // used to initialize static variables.
				// executed when class is loaded into JVM
		// load properties from jndi.properties in classpath
		InputStream stream = ServiceLocator.class.getClassLoader().getResourceAsStream("jndi.properties");
		env = new Properties();
		try {
			env.load(stream);
		} catch (IOException e) {
		}
	}

	public synchronized static DataSource getERSDatabase() {
		if (ers == null)
			ers = lookupERS();
		return ers;
	}

	private static DataSource lookupERS() {
		try {
			Context ctxt = new InitialContext(env);
			DataSource ds = (DataSource) ctxt.lookup(env.getProperty("ers"));
			return ds;
		} catch (NamingException e) {
			e.printStackTrace();
			return null; // datasource could not be found
		}

	}
}
