package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vti.entity.Account;
import com.vti.entity.AccountDAQ;
import com.vti.entity.Department;
import com.vti.entity.DepartmentDAQ;
import com.vti.ultis.ScannerUltis;

public class Exercise2_Account {
	private static ArrayList<Account> list;
	private AccountDAQ accDAQ;
	private ScannerUltis sc;
	
	public Exercise2_Account() throws FileNotFoundException, IOException {
		list = new ArrayList<Account>();
		accDAQ = new AccountDAQ();
		sc = new ScannerUltis();
	}
	
	public void question1() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		list = accDAQ.getListAccount();
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
		Account acc2 = accDAQ.getAccByID(5);
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
		Account acc2 = accDAQ.getAccByID(idFind);
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
			System.out.println("Account không tồn tại!S");
		}
	}
	
	public void question4() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Kiểm tra tên account đã có trên hệ thông? ");
		System.out.println("Nhập vào tên cần kiểm tra: ");
		String nameCheck = ScannerUltis.inputString();
		Boolean checkResult = accDAQ.isAccNameExists(nameCheck);
		if (checkResult) {
			System.out.println("Tên tài khoản đã có trên hệ thống.");
			question1();
		} else {
			System.out.println("Tên tài khoản chưa có trên hệ thống.");
		}
	  }

}
