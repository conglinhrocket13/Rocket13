package com.vti.backend;

import java.util.Scanner;



public class menu {
	public void menu() {
		int choose;
		Scanner sc = new Scanner(System.in);
		
		TuyenSinh a = new TuyenSinh();
		
		while (true){
			System.out.println();
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Thêm mới thí sinh.");
			System.out.format(leftAlignFormat, "2. Hiện thị thông tin của thí sinh và khối thi của thí sinh.");
			System.out.format(leftAlignFormat, "3. Tìm kiếm theo số báo danh");
			System.out.format(leftAlignFormat, "4. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.print("Nhập số: ");
				
			choose = sc.nextInt();
			int n;
						
			switch (choose) {
			case 1:
				a.Add();
				break;
					
			case 2:	
				a.Info();
				break;
				
			case 3:
				a.Find();
				break;

			case 4:
					System.out.println("Chào tạm biệt!");
					return;
					
			default:
					System.out.println("Nhập lại:");
					break;
			}
		}
	}
}
