package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.News;

public class menu {
	public void menu() {
	Scanner sc = new Scanner(System.in);
	String leftAlignFormat = "| %-72s |%n";
	
	ArrayList list = new ArrayList();
	
	while(true){
		System.out.format("+--------------------------------------------------------------------------+%n");
		System.out.format("|                        Choose please                                     |%n");
		System.out.format("+--------------------------------------------------------------------------+%n");
		System.out.format(leftAlignFormat, "1. Insert news");
		System.out.format(leftAlignFormat, "2. View list news");
		System.out.format(leftAlignFormat, "3. Average rate");
		System.out.format(leftAlignFormat, "4. Exit");
		System.out.format("+--------------------------------------------------------------------------+%n");
		
		int n;
		int id=1;
		System.out.print("Nhập số: ");
		n=sc.nextInt();
		switch(n) {
			case 1:
				sc.nextLine();
				News a = new News();
				a.setID(id);
				a.Add();
				System.out.println("Nhập vào 3 đánh giá 1-5 sao!");
			
				a.Calculate();
				list.add(a);
				id++;
				break;
			case 2:
				System.out.println();
				System.out.println("---------- LIST NEWS ----------");
				System.out.println();
				System.out.printf("%-10s | %-13s | %-20s | %-30s | %-5s \n",
						"Title","PublishDate","Author","Content","AverageRate");
				System.out.println("___________|_______________|______________________|"
						+ "________________________________|______________");
				for (Object o : list) {
					System.out.println(o);
				}
				System.out.println();
				System.out.println("Bạn có muốn tiếp tục không?");
				System.out.println("1. CÓ                2. KHÔNG");
				System.out.print("Nhập: ");
				n=sc.nextInt();
				if(n==1) {
					break;
				}else { 
					System.out.println("Chào tạm biệt!");
					return;	
				}
			case 3:
				sc.nextLine();
				News b = new News();
				b.setID(id);
				b.Add();
				b.Calculate();
				System.out.println();
				System.out.println("---------- thông tin mới nhập ----------");
				System.out.println();
				System.out.printf("%-10s | %-13s | %-20s | %-30s | %-5s \n",
						"Title","PublishDate","Author","Content","AverageRate");
				System.out.println("___________|_______________|______________________|"
						+ "________________________________|______________");
				
				System.out.println();
				b.Display();
				System.out.println();
				System.out.println("Bạn có muốn lưu thông tin mới nhập không?");
				System.out.println("1. CÓ                2. KHÔNG");
				System.out.print("Nhập: ");
				n=sc.nextInt();
				if(n==1) {
					list.add(b);
					id++;
					break;
				}
				break;
			case 4:
				return;
			default:
				System.out.println("Nhập lại");
				break;
			}
		}
	}
}
