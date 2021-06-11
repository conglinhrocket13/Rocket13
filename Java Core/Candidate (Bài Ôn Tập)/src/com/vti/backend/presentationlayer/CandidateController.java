package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.businesslayer.CandidateService;
import com.vti.entity.ExperienceCandidate;
import com.vti.entity.FresherCandidate;
import com.vti.ultis.ScannerUltis;

public class CandidateController {
	private CandidateService service;
	private ScannerUltis sc;
	
	public CandidateController() throws FileNotFoundException, IOException {
		service = new CandidateService();
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
	
	public boolean createExperience()
			throws ClassNotFoundException, SQLException {
		System.out.print("Nhập FirstName: ");
		String firstname = sc.inputString();
		System.out.print("Nhập LastName : ");
		String lastname = sc.inputString();
		System.out.print("Nhập Phone    : ");
		String phone = sc.inputPhoneNumber();
		
		String email = setEmail();
		
		System.out.print("Nhập Password : ");
		String pass = sc.inputPassword();
		
		System.out.print("Nhập ExpInYear: ");
		int expyear = sc.inputFunction(0, 10, "Năm kinh nghiệm từ 0-10 năm!");
		System.out.print("Nhập ProSkill : ");
		
		String skill = setSkill();
		
		ExperienceCandidate Exp = new ExperienceCandidate(firstname, lastname, phone, email, pass, expyear, skill);
		
		return service.createExperience(Exp);
	}

	public boolean createFresher()
			throws SQLException, ClassNotFoundException {
		System.out.print("Nhập FirstName: ");
		String firstname = sc.inputString();
		System.out.print("Nhập LastName : ");
		String lastname = sc.inputString();
		System.out.print("Nhập Phone    : ");
		String phone = sc.inputPhoneNumber();
		
		String email = setEmail();
		
		System.out.println("(Lưu ý: Mật khẩu phải từ 6 đến 15 ký tự trong đó có ít nhất 1 ký tự in hoa) ");
		System.out.print("Nhập Password :");
		String pass = sc.inputPassword();
		
		String rank = setGraduationRank();
		FresherCandidate Fresh = new FresherCandidate(firstname, lastname, phone, email, pass, rank);
		return service.createFresher(Fresh);
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
	
	public String setSkill() {
		while(true) {
			System.out.println("Hãy chọn loại skill: ");
			System.out.println("1.Java      2. SQL      3.JavaScript     4.PHP");
			int choose = sc.inputInt();
			switch (choose) {
			case 1:
				return "Java";
			case 2:
				return "SQL";
			case 3:
				return "JavaScript";
			case 4:
				return "PHP";
			default:
				System.err.print("Số không hợp lệ! Nhập lại: ");
				break;
			}
		}
	}
	
	public String setGraduationRank() {
		while(true) {
			System.out.println("Hãy chọn loại tốt nghiệp: ");
			System.out.println("1. Excellence      2. Good      3.Fair      4.Poor)");
			int choose = sc.inputInt();
			switch (choose) {
			case 1:
				return "Excellence";
			case 2:
				return "Good";
			case 3:
				return "Fair";
			case 4:
				return "Poor";
			default:
				System.err.print("Số không hợp lệ! Nhập lại: ");
				break;
			}
		}
	}
}
