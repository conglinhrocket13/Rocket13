package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.backend.presentationlayer.ProjectController;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.Project;
import com.vti.ultis.ScannerUltis;

public class ProjectDBFuntion {
	private AccountController Acontroller;
	private ProjectController Pcontroller;
	private ScannerUltis sc;
	
	
	public ProjectDBFuntion() throws FileNotFoundException, IOException {
		Acontroller = new AccountController();
		Pcontroller = new ProjectController();
		sc = new ScannerUltis();
	}


	public void menu() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		while(true) {
			System.out.println();
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Login");
			System.out.format(leftAlignFormat, "2. Add New Account");
			System.out.format(leftAlignFormat, "3. Get List Account In A Project by ProjectID");
			System.out.format(leftAlignFormat, "4. Get List Account is Manager In A Project");
			System.out.format(leftAlignFormat, "5. Exit");
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
				getListProjectAccounts();
				break;
			case 4:
				getListManagersInProject();
				break;
			case 5:
				System.out.println("Chào tạm biệt!");
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
			Boolean check = Acontroller.Login();
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
			System.out.format(leftAlignFormat, "1. Add New Manager");
			System.out.format(leftAlignFormat, "2. Add new Employee");
			System.out.format(leftAlignFormat, "3. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.print("Nhập số: ");
			
			int choose = sc.inputInt();
			
			switch (choose) {
			case 1:	
				sc.fixScan();
				Acontroller.createManager();
				System.out.println("Tạo ExperienceCandidate thành công !");
				loop = true;
				break;
			case 2:
				sc.fixScan();
				Acontroller.createEmployee();
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
	
	private void getListProjectAccounts() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Boolean loop=false;
		do {
			List<Project> ListProject = Pcontroller.getListProjects();
			
			String leftAlignFormat = "| %-10d | %-46s | %-10d |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        LIST PROJECT                                      |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("| %-10s | %-46s | %-10s |%n", "ProjectID","Project Name","Team Size");
			System.out.println("|____________|________________________________________________|____________|");
			
			for (Project project : ListProject) {
				System.out.format(leftAlignFormat,project.getProID(),project.getProName(),project.getTeamSize());
			}
			System.out.format("+--------------------------------------------------------------------------+%n");

			System.out.println("Nhập ID của Project bạn muốn xem thành viên");
			System.out.print("Nhập ID: ");
			int id = ScannerUltis.inputFunction(1, ListProject.size(), "ID không tồn tại!");
			
			String name = Pcontroller.getProByID(id).getProName();
			
			List ListAcc = Acontroller.getProjectAccounts(id);
			System.out.format("+-----------------------------------------------------------------------"
					+ "-----------------------------+%n");
			System.out.format("|%-30s %-68s |%n"," ","List Account In "+name);
			System.out.format("+-----------------------------------------------------------------------"
					+ "-----------------------------+%n");
			System.out.format("|%-10s | %-22s | %-22s | %-10s | %-10s | %-10s |%n",
					"AccountID","FullName","Email","Type","ExpInYear","ProSkill");
			System.out.println("|___________|________________________|________________________|"
					+ "____________|____________|____________|");
			String format = "|%-10d | %-22s | %-22s | %-10s | %-10s | %-10s |%n";
			for (Object object : ListAcc) {
				if(object instanceof Manager) {
					System.out.format(format,((Manager) object).getAccID(),((Manager) object).getFullName(),
							((Manager) object).getEmail(),"Manager",((Manager) object).getExpInYear(),
							((Manager) object).getProSkill());
				}else {
					System.out.format(format,((Employee) object).getAccID(),((Employee) object).getFullName(),
							((Employee) object).getEmail(),"Employee"," "," ");
				}
			}
			System.out.format("+-----------------------------------------------------------------------"
					+ "-----------------------------+%n");
			loop = true;
			
		}while(loop==false);
	}
	
	private void getListManagersInProject() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Boolean loop=false;
		do {
			List<Project> ListProject = Pcontroller.getListProjects();
			
			String leftAlignFormat = "| %-10d | %-46s | %-10d |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        LIST PROJECT                                      |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("| %-10s | %-46s | %-10s |%n", "ProjectID","Project Name","Team Size");
			System.out.println("|____________|________________________________________________|____________|");
			
			for (Project project : ListProject) {
				System.out.format(leftAlignFormat,project.getProID(),project.getProName(),project.getTeamSize());
			}
			System.out.format("+--------------------------------------------------------------------------+%n");

			System.out.println("Nhập ID của Project bạn muốn xem thành viên");
			System.out.print("Nhập ID: ");
			int id = ScannerUltis.inputFunction(1, ListProject.size(), "ID không tồn tại!");
			
			String name = Pcontroller.getProByID(id).getProName();
			
			List<Manager> ListAcc = Acontroller.getListManagersInProject(id);
			System.out.format("+-----------------------------------------------------------------------"
					+ "-----------------------------+%n");
			System.out.format("|%-30s %-68s |%n"," ","List Manager In "+name);
			System.out.format("+-----------------------------------------------------------------------"
					+ "-----------------------------+%n");
			System.out.format("|%-10s | %-22s | %-22s | %-10s | %-10s | %-10s |%n",
					"AccountID","FullName","Email","Type","ExpInYear","ProSkill");
			System.out.println("|___________|________________________|________________________|"
					+ "____________|____________|____________|");
			String format = "|%-10d | %-22s | %-22s | %-10s | %-10s | %-10s |%n";
			for (Manager manager : ListAcc) {
				System.out.format(format,manager.getAccID(),manager.getFullName(),manager.getEmail(),
						"Manager",manager.getExpInYear(),manager.getProSkill());
			}
			System.out.format("+-----------------------------------------------------------------------"
					+ "-----------------------------+%n");
			loop = true;
			
		}while(loop==false);
	}
}
