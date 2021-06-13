package com.vti.entity;

public class ProjectAccount {
	private int ProID;
	private int AccID;
	
	public ProjectAccount(int proID, int accID) {
		ProID = proID;
		AccID = accID;
	}

	public int getProID() {
		return ProID;
	}

	public void setProID(int proID) {
		ProID = proID;
	}

	public int getAccID() {
		return AccID;
	}

	public void setAccID(int accID) {
		AccID = accID;
	}

	@Override
	public String toString() {
		return "ProjectAccount [ProID=" + ProID + ", AccID=" + AccID + "]";
	}
	
	
}
