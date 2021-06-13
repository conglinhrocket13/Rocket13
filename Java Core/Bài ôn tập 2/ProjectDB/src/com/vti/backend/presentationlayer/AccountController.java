package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.Manager.ProSkill;
import com.vti.ultis.ScannerUltis;

public class AccountController {
	private AccountService service;
	private ScannerUltis sc;
	
	public AccountController() throws FileNotFoundException, IOException {
		service = new AccountService();
		sc = new ScannerUltis();
	}
	
	public boolean Login() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.print("Nhập Email   : ");
		String email = sc.inputEmail();
		System.out.print("Nhập Password: ");
		String password = sc.inputString();

		return service.Login(email, password);
	}
	
	public boolean createManager()
			throws ClassNotFoundException, SQLException {
		System.out.print("Nhập FullName: ");
		String fullname = sc.inputString();
		
		String email = setEmail();
		
		System.out.println("(Lưu ý: Mật khẩu phải từ 6 đến 15 ký tự trong đó có ít nhất 1 ký tự in hoa) ");
		System.out.print("Nhập Password : ");
		String pass = sc.inputPassword();
		
		System.out.print("Nhập ExpInYear: ");
		int expyear = sc.inputFunction(0, 10, "Năm kinh nghiệm từ 0-10 năm!");
		System.out.print("Nhập ProSkill : ");
		
		Manager a = new Manager();
		ProSkill skill = a.creatProskill();
		
		Manager acc = new Manager(fullname, email, pass, expyear, skill);
		
		return service.createManager(acc);
	}

	public boolean createEmployee()
			throws SQLException, ClassNotFoundException {
		System.out.print("Nhập FullName: ");
		String fullname = sc.inputString();
		
		String email = setEmail();
		
		System.out.println("(Lưu ý: Mật khẩu phải từ 6 đến 15 ký tự trong đó có ít nhất 1 ký tự in hoa) ");
		System.out.print("Nhập Password :");
		String pass = sc.inputPassword();
		
		Employee acc = new Employee(fullname, email, pass);
		return service.createEmployee(acc);
	}
	
	public List<Manager> getListManagersInProject(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return service.getListManagersInProject(id);
	}

	
	public List getProjectAccounts(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return service.getProjectAccounts(id);
	}
	
	
	public String setEmail() throws ClassNotFoundException, SQLException {
		while(true) {
			System.out.print("Nhập Email    : ");
			String email = sc.inputEmail();
			Boolean check = service.isEmailExists(email);
			if(check) {
				System.out.println("Email này đã được sử dụng! Mời nhập lại Email khác!");
			}else {
				return email;
			}
		}
	}
	
}
