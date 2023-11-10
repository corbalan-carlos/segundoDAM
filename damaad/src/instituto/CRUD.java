package instituto;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Interfaz CRUD, implementada por la clase TableToQuery
 */
public interface CRUD {
	public ResultSet create() throws SQLException,NoResultSetException;
	public ResultSet read() throws SQLException,NoResultSetException;
	public ResultSet update() throws SQLException, NoResultSetException;
	public ResultSet delete() throws SQLException, NoResultSetException;
}
