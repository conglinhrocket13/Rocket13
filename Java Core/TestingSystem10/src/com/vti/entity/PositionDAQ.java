package com.vti.entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vti.ultis.jdbcUltis;

public class PositionDAQ {
	private jdbcUltis jdbc;

	public PositionDAQ() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	public ArrayList<Position> getListPosition() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM position";
		ResultSet resultSet = jdbc.executeQuery(sql);

		ArrayList<Position> listPosition = new ArrayList<Position>();
		while (resultSet.next()) {
			Position pos = new Position(resultSet.getInt(1), resultSet.getString(2));
			listPosition.add(pos);
		}
		jdbc.disConnection();
		return listPosition;
	}

	public Position getPosByID(int id) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM position WHERE PositionID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet result = preStatement.executeQuery();
		if (result.next()) {
			Position pos = new Position(result.getInt(1), result.getString(2));
			return pos;
		} else {
			jdbc.disConnection();
			return null;
		}

	}

	public boolean updateByPosId(int id, int idPos) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE account SET PositionID = ? WHERE (AccountID = ?);";		
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, idPos);
		preStatement.setInt(2, id);
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	
	}

}
