package com.vti.entity;

public class ExperienceCandidate extends Candidate{
	private int ExpInYear;
	private String ProSkill;
	
	public ExperienceCandidate(int candidateID, String firstName, String lastName, String phone, String email,
			String password, String type, int expInYear, String proSkill) {
		super(candidateID, firstName, lastName, phone, email, password, type);
		ExpInYear = expInYear;
		ProSkill = proSkill;
	}
	
	public ExperienceCandidate( String firstName, String lastName, String phone, String email,
			String password, int expInYear, String proSkill) {
		super(firstName, lastName, phone, email, password);
		ExpInYear = expInYear;
		ProSkill = proSkill;
	}

	public float getExpInYear() {
		return ExpInYear;
	}

	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}

	public String getProSkill() {
		return ProSkill;
	}

	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}

	@Override
	public String toString() {
		return super.toString()+ " | ExpInYear: " + ExpInYear + " | ProSkill: " + ProSkill;
	}
	
	
	
}
