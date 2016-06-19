package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class DAOMap.
 * 
 * @author Group 5
 */
class DAOMap extends DAOEntity<Map> {

	/**
	 * Instantiates a new DAO map.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOMap(final Connection connection) throws SQLException {
		super(connection);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#create(model.Entity)
	 */
	@Override
	public boolean create(final Map entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#delete(model.Entity)
	 */
	@Override
	public boolean delete(final Map entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#update(model.Entity)
	 */
	@Override
	public boolean update(final Map entity) {
		// Not implemented
		return false;
	}

	/**
	 * Function to gets the best score for a given map
	 *
	 *@param key 
	 *			key of the map
	 *
	 *@return score
	 *			a int with the best score of the map inside
	 *
	 *	The function will use a procedure stored in the database to gets the best score
	 * 
	 */
	@Override
	public Map find(final String key) {
		Map map = new Map();

		try {
			final String sql = "{call mapByKey(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setString(1, key);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				map = new Map(resultSet.getInt("id_map"), key, resultSet.getString("mapcontent"));
			}
			return map;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
