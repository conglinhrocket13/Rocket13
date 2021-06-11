package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.presentationlayer.CandidateController;
import com.vti.ultis.ScannerUltis;

public class CandidateFuntion {
	private CandidateController controller;
	private ScannerUltis sc;
	
	
	public CandidateFuntion() throws FileNotFoundException, IOException {
		controller = new CandidateController();
		sc = new ScannerUltis();
	}


	public void menu() throws ClassNotFoundException, SQLException{
		while(true) {
			System.out.println();
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Login");
			System.out.format(leftAlignFormat, "2. Add New Candidate");
			System.out.format(leftAlignFormat, "3. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.print("Nhập số: ");
			
			int choose = sc.inputInt();
			
			switch (choose) {
			case 1:				
				Login();
				break;
			case 2:
				submenu();
				break;
			case 3:
				return;
			default:
					System.err.println("Số không hợp lệ! Nhập lại!");
					break;
			}
		}
	}
	
	private void Login() throws ClassNotFoundException, SQLException {
		Boolean loop = false;
		do{
			sc.fixScan();
			Boolean check = controller.Login();
			if(check) {
				System.out.println("Login Success!");
				loop = true;
			}else {
				System.err.println("Login Fail! Check your email or password!");
				System.err.println("1.Try again      2.Back menu");
				System.err.print("Nhập số: ");
				int n = sc.inputInt();
				switch(n) {
				case 1:
					break;
				case 2:
					loop=true;
					break;
				default:
					System.err.println("Số không hợp lệ! Tự động quay lại menu!");
					loop=true;
					break;
				}
			}
		}while(loop == false);
	}
	
	private void submenu() throws ClassNotFoundException, SQLException {
		Boolean loop = false;
		do {
			System.out.println();
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Add New ExperienceCandidate");
			System.out.format(leftAlignFormat, "2. Add new FresherCandidate");
			System.out.format(leftAlignFormat, "3. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.print("Nhập số: ");
			
			int choose = sc.inputInt();
			
			switch (choose) {
			case 1:	
				sc.fixScan();
				controller.createExperience();
				System.out.println("Tạo ExperienceCandidate thành công !");
				loop = true;
				break;
			case 2:
				sc.fixScan();
				controller.createFresher();
				System.out.println("Tạo FresherCandidate thành công !");
				loop = true;
				break;
			case 3:
				loop = true;
				break;
			default:
					System.err.println("Số không hợp lệ! Nhập lại!");
					break;
			}
			
		}while(loop==false);
	}
}
