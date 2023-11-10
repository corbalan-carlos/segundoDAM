package instituto;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Database {
	public String dbName;
	protected Connection conn;
	public DatabaseMetaData dbProperties;
	private Map<String,Table> tables;
	private Map<String,TableToQuery> ttq;
	Database(String dbName,String dbURL,String user, String passwd) throws SQLException {
		conn=DriverManager.getConnection(dbURL, user, passwd);
		this.dbName=dbName;
	}
	Database(String dbName,String dbURL) throws SQLException {
		conn=DriverManager.getConnection(dbURL);
		this.dbName=dbName;
		this.dbProperties=conn.getMetaData();
	}
	void addTables() throws SQLException, NoResultSetException {
		tables=new HashMap<String,Table>();
		Statement showTables= conn.createStatement();
		if (!showTables.execute("show tables;")) {
			throw new NoResultSetException("show tables no ha devuelto ningun resultado\nS");
		}
		ResultSet showResult=showTables.getResultSet();
		while (showResult.next()) {
			String tableName=showResult.getString(1);
			Statement select=conn.createStatement();
			if (!select.execute("select * from "+tableName+" limit 1;")) {
				throw new NoResultSetException("select a la tabla "+tableName+" no ha devuelto resultado");
			}
			ResultSet selectResult=select.getResultSet();
			int n=selectResult.getMetaData().getColumnCount();
			int[] typeArr=new int[n];
			String[] nameArr=new String[n];
			for (int i=1;i<n;i++) {
				typeArr[i-1]=selectResult.getMetaData().getColumnType(i);
				nameArr[i-1]=selectResult.getMetaData().getColumnName(i);
			}
			tables.put(tableName, new Table(tableName,typeArr,n,nameArr));
		}
	}
	public Table getTables(String name) {
		return tables.get(name);
	}
	public TableToQuery getTtq(String name) {
		if (ttq.get(name)==null) {
			
		}
	}
	
}
