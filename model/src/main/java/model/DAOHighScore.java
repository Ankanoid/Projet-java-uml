package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class DAOHighScore.
 * 
 * @author Group 5
 */
class DAOHighScore extends DAOEntity<HighScore> {

	/**
	 * Instantiates a new DAO HighScore.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOHighScore(final Connection connection) throws SQLException {
		super(connection);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#create(model.Entity)
	 */
	@Override
	public boolean create(final HighScore entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#delete(model.Entity)
	 */
	@Override
	public boolean delete(final HighScore entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#update(model.Entity)
	 */
	@Override
	public boolean update(final HighScore entity) {
		// Not implemented
		return false;
	}

	/**
	 * Function to Add a score to the current map
	 *
	 * @param score, key (of the map)
	 * 			the actual score and the key of the map
	 * 
	 */			
	@Override
	public HighScore find(final int score, final String key) {
		HighScore highScore = new HighScore();

		try {
			final String sql = "{call addScoreByMap(?, ?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, score);
			call.setString(2, key);
			call.execute();
			return highScore;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
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
	public HighScore find(final String key) {
		HighScore highScore = new HighScore();

		try {
			final String sql = "{call scoreMapByKey(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setString(1, key);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				highScore = new HighScore(resultSet.getInt("id_score"), key, resultSet.getInt("score"));
			}
			return highScore;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public HighScore find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
