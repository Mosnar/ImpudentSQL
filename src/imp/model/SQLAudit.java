/**
 * 
 */
package imp.model;

import java.sql.DriverManager;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;

import imp.core.IPObject;
import imp.core.serverType;

/**
 * @author Ransom Roberson
 * @date 11.06.13
 */
public class SQLAudit {
	private IPObject target;
	private String JDBC_DRIVER;
	private String DB_URL;
	private java.sql.Connection  con = null;
	private String USER;
	private String PASS;
	private String PORT;

	/**
	 * This constructor will setup the sql scanning parameters
	 * 
	 * @param target
	 *            IPObject of target server
	 * @param type
	 *            serverType enum to declare what kind of scan we're performing
	 */
	public SQLAudit(IPObject target, serverType type) {
		Config cfg = new Config();
		this.target = target;
		if (type == imp.core.serverType.MYSQL) {
			USER = cfg.getProperty("mysql.user");
			PASS = cfg.getProperty("mysql.pass");
			PORT = cfg.getProperty("mysql.port");
			
			JDBC_DRIVER = "com.mysql.jdbc.Driver";
			DB_URL = "jdbc:mysql://" + target.toString() + ":" + PORT;
		} else if (type == imp.core.serverType.MSSQL) {
			USER = cfg.getProperty("mssql.user");
			PASS = cfg.getProperty("mssql.pass");
			PORT = cfg.getProperty("mssql.port");
			
			JDBC_DRIVER = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
			DB_URL = "jdbc:microsoft:sqlserver://" + target.toString() + ":" + PORT;
		} else {
			// Scan both
		}

	}

	private void run() {

		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		Driver d = (Driver)Class.forName(JDBC_DRIVER).newInstance();

		con = DriverManager.getConnection(DB_URL, USER, PASS);
		*/
	}

	public IPObject get() {
		return target;
	}

}
