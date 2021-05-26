package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Book;
import com.vti.entity.Magazine;
import com.vti.entity.Newspaper;

public class FindType {
	public void FindType(ArrayList list) {
		Boolean lap1=false;
		String leftAlignFormat = "| %-72s |%n";
		Scanner sc = new Scanner(System.in);
		System.out.println();
		do{
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Chọn loại muốn tìm                                |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Sách");
			System.out.format(leftAlignFormat, "2. Tạp chí");
			System.out.format(leftAlignFormat, "3. Báo");
			System.out.format(leftAlignFormat, "4. Quay lại menu chính");
			System.out.format("+--------------------------------------------------------------------------+%n");
			
			int m;
			System.out.print("Nhập số: ");
			m=sc.nextInt();
			switch(m) {
				case 1:
					System.out.println();
					System.out.println("---------- LIST SÁCH ----------");
					System.out.printf("%-11s | %-20s | %-16s | %-20s | %-7s \n", 
							"Mã Tài Liệu","Nhà Xuất Bản","Số bản phát hành","Tác giả","Số trang");
					System.out.printf("____________|______________________|__________________|"
							+ "______________________|____________\n");
					for (Object o: list) {
						if (o instanceof Book) {
							System.out.println(o);
						}
					}
					lap1=true;
					break;
				case 2:
					System.out.println();
					System.out.println("---------- LIST TẠP CHÍ ----------");
					System.out.printf("%-10s | %-20s | %-16s | %-12s | %-5s \n",
							"Mã Tài Liệu","NXB","Số bản phát hành","Số phát hành","Tháng phát hành");
					System.out.printf("____________|______________________|__________________|"
							+ "______________|____________\n");
					for (Object o: list) {
						if (o instanceof Magazine) {
							System.out.println(o);
						}
					}
					lap1=true;
					break;
				case 3:
					System.out.println();
					System.out.println("---------- LIST BÁO ----------");
					System.out.printf("%-11s | %-20s | %-16s | %-15s\n", 
							"Mã Tài Liệu","Nhà Xuất Bản","Số bản phát hành","Ngày phát hành");
					System.out.printf("____________|______________________|__________________|"
							+ "_________________\n");
					for (Object o: list) {
						if (o instanceof Newspaper) {
							System.out.println(o);
						}
					}lap1=true;
					break;
				case 4:
					lap1=true;
					break;
				default:
					System.out.println("Nhập lại");
					break;							
			}
		}while(lap1==false);
	}
}
