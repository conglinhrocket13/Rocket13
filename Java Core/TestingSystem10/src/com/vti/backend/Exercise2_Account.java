package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.AccountDAO;
import com.vti.entity.Department;
import com.vti.entity.DepartmentDAO;
import com.vti.entity.Position;
import com.vti.entity.PositionDAO;
import com.vti.ultis.ScannerUltis;

public class Exercise2_Account {
	private static ArrayList<Account> list;
	private AccountDAO accDAO;
	private ScannerUltis sc;
	
	public Exercise2_Account() throws FileNotFoundException, IOException {
		list = new ArrayList<Account>();
		accDAO = new AccountDAO();
		sc = new ScannerUltis();
	}
	
	public void question1() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		list = accDAO.getListAccount();
		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-21s | %-21s | %-16s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+-----------------------+-----------------------+------------------+%n");
		System.out.format(
				"|ID  | Email                 |   Username      |     FullName          |     Department        |     Position          | Create Date      |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+-----------------------+-----------------------+------------------+%n");

		for (Account acc : list) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullname(),
					acc.getDepartment().getName(), acc.getPosition().getName(), acc.getCreateDate());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+-----------------------+-----------------------+------------------+%n");

	}
	
	public void question2() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Tìm thông tin Account có ID =5");
		Account acc2 = accDAO.getAccByID(5);
		if (acc2 != null) {
			String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-21s | %-21s | %-16s | %n";
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+-----------------------+-----------------------+------------------+%n");
			System.out.format(
					"|ID  | Email                 |   Username      |     FullName          |     Department        |     Position          | Create Date      |%n");
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+-----------------------+-----------------------+------------------+%n");

			System.out.format(leftAlignFormat, acc2.getId(), acc2.getEmail(), acc2.getUsername(), acc2.getFullname(),
					acc2.getDepartment().getName(), acc2.getPosition().getName(), acc2.getCreateDate());

			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+-----------------------+-----------------------+------------------+%n");

		} else {
			System.out.println("Account không tồn tại!");
		}

	}
	
	public void question3() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Tìm kiếm Account theo ID: ");
		System.out.println("Nhập vào ID cần tìm kiếm: ");
		int idFind = ScannerUltis.inputIntPositive();
		Account acc2 = accDAO.getAccByID(idFind);
		if (acc2 != null) {
			String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-21s | %-21s | %-16s | %n";
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+-----------------------+-----------------------+------------------+%n");
			System.out.format(
					"|ID  | Email                 |   Username      |     FullName          |     Department        |     Position          | Create Date      |%n");
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+-----------------------+-----------------------+------------------+%n");

			System.out.format(leftAlignFormat, acc2.getId(), acc2.getEmail(), acc2.getUsername(), acc2.getFullname(),
					acc2.getDepartment(), acc2.getPosition(), acc2.getCreateDate());

			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+-----------------------+-----------------------+------------------+%n");

		} else {
			System.out.println("Account không tồn tại!");
		}
	}
	
	public void question4() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Kiểm tra tên account đã có trên hệ thống ? ");
		System.out.println("Nhập vào tên cần kiểm tra: ");
		String nameCheck = ScannerUltis.inputString();
		Boolean checkResult = accDAO.isAccNameExists(nameCheck);
		if (checkResult) {
			System.out.println("Tên tài khoản đã có trên hệ thống.");
			question1();
		} else {
			System.out.println("Tên tài khoản chưa có trên hệ thống.");
		}
	  }
	

	public void question5() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
			Account acc = new Account();
			System.out.println("Nhập vào Email: ");
			acc.setEmail(ScannerUltis.inputString());
			System.out.println("Nhập vào UserName: ");
			acc.setUsername(ScannerUltis.inputString());
			System.out.println("Nhập vào FullName: : ");
			acc.setFullname(ScannerUltis.inputString());
			System.out.println("Hãy chọn phòng nhân viên ! ");
			int depid = getDep();	
			System.out.println("Hãy chọn Position nhân viên ! ");
			int posid = getPos();	
			if (accDAO.createAccount(acc, depid, posid)) {
				System.out.println("Tạo thành công: ");
				question1();
			} else {
				System.out.println("Tạo không thành công, hãy kiểm tra lại");
			}		
	}
	
	public int getDep() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			DepartmentDAO depDAO = new DepartmentDAO();
			List<Department> listDep = depDAO.getListDepartment();
			System.out.println("---------DANH SÁCH PHÒNG----------");
			for (Department department : listDep) {
				System.out.println(department);
			}
			System.out.print("Chọn phòng theo ID: ");
			int depid = ScannerUltis.inputIntPositive();
			if(depDAO.getDepByID(depid) != null) {
				return depid;
			}else {
				System.out.println("Không có phòng này! Chọn lại!");
			}
		}
	}
	
	public int getPos() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		PositionDAO posDAO = new PositionDAO();
		List<Position> listpos = posDAO.getListPosition();
		while(true) {
			System.out.println("---------DANH SÁCH POSITION----------");
			for (Position position : listpos) {
				System.out.println(position);
			}
			System.out.println("Chọn Position theo ID:");
			int posid = ScannerUltis.inputIntPositive();
			if(posDAO.getPosByID(posid) != null){
				return posid;
			}else {
					System.out.println("Không có position này! Chọn lại!");
			}
		}
	}
	
	public void question6() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		question1();
		int ID = checkID();
		System.out.println("Nhập vào tên mới: ");
		sc.fixScan();
		String newName = ScannerUltis.inputString();
		if (accDAO.updateFullName(ID, newName)) {
			System.out.println("Đổi tên phòng thành công! ");
			question1();
		} else {
			System.out.println("Đã có lỗi xảy ra!");
		}
	}
	
	public int checkID() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			System.out.print("Nhập ID account: ");
			int id = ScannerUltis.inputIntPositive();
			Account acc = accDAO.getAccByID(id);
			if (acc == null) {
				System.out.println("ID không tồn tại!");
			} else {
				return id;
			}
		}
	}
	
	public void question7() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		question1();
		int ID = checkID();
		if (accDAO.delAccByID(ID)) {
			System.out.println("Xóa phòng thành công");
			question1();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}

	}
}
