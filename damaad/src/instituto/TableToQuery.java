package instituto;

import java.sql.*;
//TODO Crear PreparedStatemnts para cada una de las funcionalidades
public class TableToQuery implements CRUD {
	private Table table;
	private Connection conn;
	private StringBuilder campos;
	private StringBuilder condiciones;
	@Override
	public ResultSet create() {
		return null;
		
	}
	@Override
	public ResultSet read() throws SQLException, NoResultSetException {
		Statement stmt=conn.createStatement();
		if (condiciones.isEmpty()) {
			stmt.execute("select "+campos.toString()+" from "+table.name+";");
		} else {
			stmt.execute("select "+campos.toString()+" from "+table.name+" where "+condiciones.toString()+";");
		}
		if (stmt.getResultSet()==null) throw new NoResultSetException("Operacion read"
				+"no ha devuelto ningun valor");
		return stmt.getResultSet();
	}
	@Override
	public ResultSet update() {
		return null;
		
	}
	@Override
	public ResultSet delete() {
		return null;
		
	}
	TableToQuery(Table table,Connection conn) {
		this.table=table;
		this.conn=conn;
	}
	
}
