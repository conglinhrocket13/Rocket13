package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Student;

public class menu {
	public void menu() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<Student>();
		String leftAlignFormat = "| %-72s |%n";
		System.out.println();
		while(true){
			System.out.println();
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Mời chọn chức năng                                |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Tạo 10 học sinh, chia thành 3 nhóm");
			System.out.format(leftAlignFormat, "2. Kêu gọi cả lớp điểm danh.");
			System.out.format(leftAlignFormat, "3. Gọi nhóm 1 đi học bài");
			System.out.format(leftAlignFormat, "4. Gọi nhóm 2 đi dọn vệ sinh");
			System.out.format(leftAlignFormat, "5. Thoát");
			System.out.format("+--------------------------------------------------------------------------+%n");
			
			Question1 a = new Question1();
			int n;
			System.out.print("Nhập số: ");
			n=sc.nextInt();
			switch(n) {
				case 1:
					sc.nextLine();
					a.Add(list);
					break;
				case 2:
					System.out.println();
					System.out.println("-----Điểm danh-----");
					a.RollUp(list);
					break;
				case 3:
					System.out.println();
					System.out.println("-----Nhóm 1 đi học bài-----");
					a.Team1Study(list);
					break;
				case 4:
					System.out.println();
					System.out.println("-----Nhóm 2 đi dọn vệ sinh-----");
					a.Team2CleanUp(list);
					break;
				case 5:
					return;
				default:
					System.out.println("Nhập lại");
					break;
				}
			}
	}
}
