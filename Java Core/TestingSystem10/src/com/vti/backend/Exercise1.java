package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.vti.ultis.ScannerUltis;
import com.vti.ultis.jdbcUltis;

public class Exercise1 {
	private jdbcUltis jdbc;
	private ScannerUltis sc;
	public Exercise1() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
		sc = new ScannerUltis();
	}
	
	public void question1() throws ClassNotFoundException, SQLException {
		System.out.println("Test kết nối!");
		jdbc.connectionTestting();
	}
	
	public void question2() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM position;";
		ResultSet posResult = jdbc.executeQuery(sql);
		System.out.println("Thông tin Position : ");
		String leftAlignFormat = "| %-6d | %-21s |%n";

		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | PositionName          |%n");
		System.out.format("+--------+-----------------------+%n");
		while (posResult.next()) {
			System.out.format(leftAlignFormat, posResult.getInt(1), posResult.getString(2));
		}
		System.out.format("+--------+-----------------------+%n");
	}
	
	public void question3() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập Positon cần tạo 1.DEV, 2.TEST, 3.SCRUM MASTER, 4.PM ");
		System.out.print("Nhập số: ");
		String sql = "INSERT INTO position (PositionName) VALUES (?);";
		PreparedStatement PrS =  jdbc.createPrepareStatement(sql);
		String postname = getName();
		PrS.setString(1,postname);
		if(PrS.executeUpdate()==1) {
			System.out.println("Tạo thành công!");
			question2();
		}else {
			System.out.println("Đã có lỗi xảy ra!");
		}
	
	}
	
	private String getName() {
		while (true) {
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				return "Dev";

			case 2:
				return "Test";

			case 3:
				return "Scrum Master";

			case 4:
				return "PM";

			default:
				System.out.println("Nhập lại");
				break;
			}
		}
	}

	public void question4() throws ClassNotFoundException, SQLException {
		question2();
		System.out.print("Nhập ID position cần đổi tên:  ");
		int id = sc.inputIntPositive();
		System.out.print("Nhập tên mới position cần đổi:  ");
		sc.fixScan();
		String postname = sc.inputString();
		String sql = "UPDATE position SET PositionName = ? WHERE PositionID = ?;";
		PreparedStatement PrS =  jdbc.createPrepareStatement(sql);
		PrS.setString(1,postname);
		PrS.setInt(2,id);
		if(PrS.executeUpdate()==1) {
			System.out.println("Đổi tên thành công!");
			question2();
		}else {
			System.out.println("Đã có lỗi xảy ra!");
		}
		question2();
	}
	
	public void question5() throws ClassNotFoundException, SQLException {
		question2();
		System.out.print("Nhập ID position cân xóa:  ");
		int id = sc.inputIntPositive();
		String sql = "DELETE FROM position WHERE PositionID = ?;";
		PreparedStatement PrS =  jdbc.createPrepareStatement(sql);
		PrS.setInt(1,id);
		if(PrS.executeUpdate()==1) {
			System.out.println("Xóa thành công!");
			question2();
		}else {
			System.out.println("Đã có lỗi xảy ra!");
		}
		question2();
	}
}
