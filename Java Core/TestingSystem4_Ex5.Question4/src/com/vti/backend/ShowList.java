package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Book;
import com.vti.entity.Magazine;
import com.vti.entity.Newspaper;

public class ShowList {
	public void ShowList(ArrayList list) {
		Scanner sc = new Scanner(System.in);
		
		int c1=0;
		for (Object o: list) {
			if (o instanceof Book) {
				c1++;
			}
		}
		if(c1>0) {
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
		}
		
		int c2=0;
		for (Object o: list) {
			if (o instanceof Magazine) {
				c2++;
			}
		}
		if(c2>0) {
			System.out.println();
			System.out.println("---------- LIST TẠP CHÍ ----------");
			System.out.printf("%-10s | %-20s | %-16s | %-12s | %-5s \n",
					"Mã Tài Liệu","NXB","Số bản phát hành","Số phát hành","Tháng phát hành");
			System.out.printf("____________|______________________|__________________|"
					+ "______________|_______________\n");
			for (Object o: list) {
				if (o instanceof Magazine) {
					System.out.println(o);
				}
			}
		}
		
		int c3=0;
		for (Object o: list) {
			if (o instanceof Newspaper) {
				c3++;
			}
		}
		if(c3>0) {
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
			}
		}
	}
}
