/**
 * 
 */
package com.lst.dbc;

import java.sql.Connection;

/**
 * @author lst
 *
 */
public interface DatabaseConnection {
	
	public void close();
	
	public Connection getConnection();

}
