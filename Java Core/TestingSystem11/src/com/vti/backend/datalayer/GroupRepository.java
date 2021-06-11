package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.datalayer.IGroupRepository;
import com.vti.entity.Group;
import com.vti.ultis.jdbcUltis;

public class GroupRepository implements IGroupRepository {
	private jdbcUltis jdbc;

	public GroupRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public List<Group> getListGroups() throws ClassNotFoundException, SQLException {
		List<Group> groups = new ArrayList<>();
		String sql = "SELECT * FROM `Group`";
		ResultSet resultSet = jdbc.executeQuery(sql);
		while (resultSet.next()) {
			Group group = new Group(resultSet.getInt(1), resultSet.getString(2));
			groups.add(group);
		}
		jdbc.disConnection();
		return groups;
	}
	
}
