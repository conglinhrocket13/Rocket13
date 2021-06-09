package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vti.entity.Department;
import com.vti.entity.DepartmentDAQ;
import com.vti.ultis.ScannerUltis;

public class Exercise2 {
	private static ArrayList<Department> list;
	private DepartmentDAQ dept;
	private ScannerUltis sc;
	
	public Exercise2() throws FileNotFoundException, IOException {
		list = new ArrayList<Department>();
		dept = new DepartmentDAQ();
		sc = new ScannerUltis();
	}

	public void question1() throws ClassNotFoundException, SQLException {
		list = dept.getListDepartment();
		
		String leftAlignFormat = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | Department Name       |%n");
		System.out.format("+--------+-----------------------+%n");

		for (Department department : list) {
			System.out.format(leftAlignFormat, department.getId(), department.getName());
		}
		System.out.format("+--------+-----------------------+%n");

	}
	
	public void question2() throws ClassNotFoundException, SQLException {
		System.out.println("Tìm thông tin phòng có ID =5");
		Department dp = dept.getDepByID(5);
		if (dp != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Department Name       |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, dp.getId(), dp.getName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Không tồn tại phòng này trên HT");
		}
	}
	
	public void question3() throws ClassNotFoundException, SQLException {
		System.out.print("Nhập id phòng cần tìm: ");
		int id = sc.inputIntPositive();
		Department dp = dept.getDepByID(id);
		if (dp != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Department Name       |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, dp.getId(), dp.getName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Không tồn tại phòng này trên HT");
		}
	}
	
	public void question4() throws ClassNotFoundException, SQLException {
		System.out.print("Nhập vào tên cần kiểm tra: ");
		String name = sc.inputString();
		Boolean check = dept.isDepNameExists(name);
		if (check) {
			System.out.println("Tên đã có trên hệ thống.");
			question1();
		} else {
			System.out.println("Tên chưa có trên hệ thống.");
		}
	}
	
	private String checkName() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.print("Nhập vào tên phòng cần tạo: ");
			String newName = sc.inputString();
			if (dept.isDepNameExists(newName)) {
				System.out.println("Tên đã được sử dụng!");
			} else {
				return newName;
			}

		}
	}
	
	public void question5() throws ClassNotFoundException, SQLException {
		String newNameDep = checkName();
		if (dept.CreateDep(newNameDep)) {
			System.out.println("Tạo thành công.");
			question1();
		} else {
			System.out.println("Đã có lỗi xảy ra!");
		}
	}
	
	private int checkID() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.print("Nhập ID phòng: ");
			int id = ScannerUltis.inputIntPositive();
			Department dep = dept.getDepByID(id);
			if (dep == null) {
				System.out.println("ID không tồn tại!");
			} else {
				return id;
			}
		}
	}
	
	public void question6() throws ClassNotFoundException, SQLException {
		question1();
		int ID = checkID();
		System.out.println("Nhập vào tên mới: ");
		sc.fixScan();
		String newName = ScannerUltis.inputString();
		if (dept.UpdateDepName(ID, newName)) {
			System.out.println("Đổi tên phòng thành công! ");
			question1();
		} else {
			System.out.println("Đã có lỗi xảy ra!");
		}
	}
	
	public void question7() throws ClassNotFoundException, SQLException {
		question1();
		int ID = checkID();
		if (dept.delDepByID(ID)) {
			System.out.println("Xóa phòng thành công");
			question1();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}

	}
}
