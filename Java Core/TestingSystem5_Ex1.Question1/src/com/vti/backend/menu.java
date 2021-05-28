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
		System.out.print("Nhập số: ");
		n=sc.nextInt();
		switch(n) {
			case 1:
				News a = new News();
				a.Calculate();
				list.add(a);
				break;
			case 2:
				System.out.println();
				System.out.println("---------- LIST NEWS ----------");
				System.out.printf("%-10s | %-13s | %-20s | %-30s | %-5s \n",
						"Title","PublishDate","Author","Content","AverageRate");
				System.out.println("___________|_______________|______________________|"
						+ "________________________________|______________");
				for (Object o : list) {
					System.out.println(o);
				}
				break;
			case 3:
				News b = new News();
				b.Calculate();
				
				list.add(b);
				System.out.println();
				System.out.println("---------- thông tin mới nhập ----------");
				b.Display();
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
