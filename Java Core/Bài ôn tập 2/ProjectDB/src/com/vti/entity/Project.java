package com.vti.entity;

public class Project {
	private int ProID;
	private String ProName;
	private int TeamSize;
	private int LeaderID;
	
	public Project(int proID, String proName, int teamSize) {
		ProID = proID;
		ProName = proName;
		TeamSize = teamSize;
	}

	public int getProID() {
		return ProID;
	}

	public void setProID(int proID) {
		ProID = proID;
	}

	public String getProName() {
		return ProName;
	}

	public void setProName(String proName) {
		ProName = proName;
	}

	public int getTeamSize() {
		return TeamSize;
	}

	public void setTeamSize(int teamSize) {
		TeamSize = teamSize;
	}


	@Override
	public String toString() {
		return "ID: " + ProID + " | ProName: " + ProName + " | TeamSize: " + TeamSize;
	}
	
	
	
	
}
