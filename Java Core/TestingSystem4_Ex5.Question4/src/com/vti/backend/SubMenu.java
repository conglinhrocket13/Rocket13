package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Book;
import com.vti.entity.Magazine;
import com.vti.entity.Newspaper;

public class SubMenu {
	public void SubMenu(int id,ArrayList list) {
		Scanner sc = new Scanner(System.in);
		
		String leftAlignFormat = "| %-72s |%n";
		Boolean lap=false;
		int month;
		Boolean checkmonth=false;
		System.out.println();
		do{
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Thêm mới Sách");
			System.out.format(leftAlignFormat, "2. Thêm mới Tạp chí");
			System.out.format(leftAlignFormat, "3. Thêm mới Báo");
			System.out.format(leftAlignFormat, "4. Quay lại menu chính");
			System.out.format("+--------------------------------------------------------------------------+%n");
			
			int m;
			System.out.print("Nhập số: ");
			m=sc.nextInt();
			switch(m) {
				case 1:
					Book a = new Book();
					
					a.setId(id);
					a.Add();
					list.add(a);
					System.out.println("Đã thêm thành công!");
					lap=true;
					id++;
					break;
					
				case 2:
					Magazine b = new Magazine();
					
					b.setId(id);	
					b.Add();
					
					do {
						System.out.print("Nhập tháng phát hành: ");
						month=sc.nextInt();
						switch(month) {
						case 1: case 2 : case 3: case 4: case 5: case 6:case 7: case 8: case 9: case 10: case 11: case 12:
							b.setrelease_month(month);
							checkmonth=true;
							break;
						default:
							System.out.println("Tháng không hợp lệ! Mời nhập lại");
							break;
						}
					}while(checkmonth==false);
					list.add(b);
					System.out.println("Đã thêm thành công!");
					id++;
					lap=true;
					break;
				case 3:						
					Newspaper c = new Newspaper();
					c.setId(id);
					c.Add();
					list.add(c);
					System.out.println("Đã thêm thành công!");
					lap=true;
					id++;
					break;
				case 4:
					lap=true;
					break;
				default:
					System.out.println("Nhập lại");
					break;
					}
			}while(lap==false);
	}
}
