package com.vti.entity;

public class FresherCandidate extends Candidate{
	private String GraduationRank;

	public FresherCandidate(int candidateID, String firstName, String lastName, String phone, String email,
			String password, String type, String graduationRank) {
		super(candidateID, firstName, lastName, phone, email, password, type);
		GraduationRank = graduationRank;
	}
	
	public FresherCandidate( String firstName, String lastName, String phone, String email,
			String password, String graduationRank) {
		super(firstName, lastName, phone, email, password);
		GraduationRank = graduationRank;
	}

	public String getGraduationRank() {
		return GraduationRank;
	}

	public void setGraduationRank(String graduationRank) {
		GraduationRank = graduationRank;
	}

	@Override
	public String toString() {
		return super.toString()+" | GraduationRank: " + GraduationRank;
	}
	
	
	
}
