package com.vit.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Employee;
import com.vti.entity.Engineer;
import com.vti.entity.Worker;

public class submenu {
	public void submenu(ArrayList list) {
		Scanner sc = new Scanner(System.in);
		Boolean lap=false;
		String leftAlignFormat = "| %-72s |%n";
		System.out.println();
		do{
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Thêm mới công nhân");
			System.out.format(leftAlignFormat, "2. Thêm mới kỹ sư");
			System.out.format(leftAlignFormat, "3. Thêm mới nhân viên");
			System.out.format(leftAlignFormat, "4. Quay lại menu chính");
			System.out.format("+--------------------------------------------------------------------------+%n");
			
			int m;
			System.out.print("Nhập số: ");
			m=sc.nextInt();
			switch(m) {
				case 1:
					Worker a = new Worker();
					a.Add();
					list.add(a);
					System.out.println("Đã thêm thành công!");
					lap=true;
					break;
				case 2:
					Engineer b = new Engineer();
					b.Add();
					list.add(b);
					System.out.println("Đã thêm thành công!");
					lap=true;
					break;
				case 3:
					Employee c = new Employee();
					c.Add();
					list.add(c);
					System.out.println("Đã thêm thành công!");
					lap=true;
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
