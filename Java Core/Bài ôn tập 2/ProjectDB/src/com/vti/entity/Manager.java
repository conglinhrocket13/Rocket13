package com.vti.entity;

import com.vti.ultis.ScannerUltis;

public class Manager extends Account{
	private int ExpInYear;
	private ProSkill ProSkill;
	
	public enum ProSkill{
		Dev , Test , Java , SQL
	}

	public ProSkill DataBaseProskill(String skill) {
		
		if(skill.equals("Dev")) {
			return ProSkill.Dev;
		}
		else if(skill.equals("Test")) {
			return ProSkill.Test;
		}
		else if(skill.equals("Java")) {
			return ProSkill.Java;
		}
		else{
			return ProSkill.SQL;
		}
	}
	
	public ProSkill creatProskill() {
		ProSkill a = null;
		Boolean loop = false;
		do {
			System.out.println("Tạo ProSkill");
			System.out.println("1. Dev    2.Test   3.Java   4.SQL");
			System.out.print("Nhập: ");
			int n = ScannerUltis.inputInt();
			switch (n) {
			case 1:
				a= ProSkill.Dev;
				loop = true;
				break;
			case 2:
				a= ProSkill.Test;
				loop = true;
				break;
			case 3:
				a= ProSkill.Java;
				loop = true;
				break;
			case 4:
				a= ProSkill.SQL;
				loop = true;
				break;
			default:
				System.err.println("Nhập lại");
				System.out.println();
				break;
			}
		}while(loop==false);
		
		return a;
	}
	
	
	public Manager() {
		super();
	}
	
	public Manager(String fullName, String email, String password,
			int expInYear, com.vti.entity.Manager.ProSkill proSkill) {
		super(fullName, email, password);
		ExpInYear = expInYear;
		ProSkill = proSkill;
	}
	
	public Manager(int accID, String fullName, String email, String password,
			int expInYear, com.vti.entity.Manager.ProSkill proSkill) {
		super(accID, fullName, email, password);
		ExpInYear = expInYear;
		ProSkill = proSkill;
	}

	public int getExpInYear() {
		return ExpInYear;
	}

	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}

	public ProSkill getProSkill() {
		return ProSkill;
	}

	public void setProSkill(ProSkill proSkill) {
		ProSkill = proSkill;
	}


	@Override
	public String toString() {
		return super.toString()+" | ExpInYear: " + ExpInYear + " | ProSkill: " + ProSkill +" | Type: Manager";
	}

	
	
}
