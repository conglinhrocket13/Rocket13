package com.vit.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Employee;
import com.vti.entity.Engineer;
import com.vti.entity.Staff;
import com.vti.entity.Worker;

public class Quest2 {
	public void question2() {
		Scanner sc = new Scanner(System.in);
		ArrayList list= new ArrayList();
		ArrayList listRemove= new ArrayList();
		int choose;
		while (true){
			System.out.println();
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Thêm mới cán bộ");
			System.out.format(leftAlignFormat, "2. Tìm kiếm theo họ tên");
			System.out.format(leftAlignFormat, "3. Hiện thị thông tin về danh sách các cán bộ");
			System.out.format(leftAlignFormat, "4. Nhập vào tên của cán bộ và delete cán bộ đó");
			System.out.format(leftAlignFormat, "5. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.print("Nhập số: ");
				
			choose = sc.nextInt();
			int n;
			String text;
			Boolean check = false;
			
			switch (choose) {
			case 1:
				submenu sub = new submenu();
				sub.submenu(list);
				System.out.println();
					break;
					
			case 2:
				System.out.println("Mời nhập vào tên cần tìm !!");
				System.out.print("Họ tên : ");
				sc.nextLine();
				text = sc.nextLine();
				for (Object o : list) {	
					Staff s = (Staff)o;
					
					if( s.getFullname().equals(text)){
						check=true;
					}		
				}
				if(check==true) {
					System.out.println();
					System.out.printf("%-15s | %-5s | %-10s | %-25s | %-9s | %-10s \n", 
								"Họ Tên","Tuổi","Giới Tính","Địa chỉ","Chức vụ","Khác");
					System.out.printf("________________|_______|____________|"
								+ "___________________________|___________|____________\n");
					for (Object o : list) {
						
						Staff s = (Staff)o;
						
						if( s.getFullname().equals(text)){		
							System.out.println(o);
						}
					}
				}else {
					System.out.println("Không tìm thấy!");
				}
				System.out.println();
				System.out.println("Bạn có muốn tiếp tục không?");
				System.out.println("1. Có		2.Không");
				n= sc.nextInt();
				if(n==2) {
					System.out.println("Chào tạm biệt!");
					return;
				}
				break;
			case 3:
				System.out.println();
				System.out.println("---------- DANH SÁCH CÁN BỘ ----------");
				System.out.printf("%-15s | %-5s | %-10s | %-25s | %-9s | %-10s \n", 
						"Họ Tên","Tuổi","Giới Tính","Địa chỉ","Chức vụ","Khác");
				System.out.printf("________________|_______|____________|"
						+ "___________________________|___________|____________\n");
				for (Object object : list) {
					Staff s = (Staff)object;
					System.out.println(s);
				}
				System.out.println();
				System.out.println("Bạn có muốn tiếp tục không?");
				System.out.println("1. Có		2.Không");
				n= sc.nextInt();
				if(n==2) {
					System.out.println("Chào tạm biệt!");
					return;
				}
				break;
			case 4:	
				System.out.println("Mời nhập vào tên cần xóa !!");
				System.out.print("Họ tên : ");
				sc.nextLine();
				text = sc.nextLine();
				
				for (Object o : list) {	
					Staff s = (Staff)o;
					
					if( s.getFullname().equals(text)){
						listRemove.add(o);
						check=true;
					}	
				}
				
				if(check==true) {
					System.out.println();
					System.out.println("Bạn xác định muốn xóa các cán bộ có tên '"+text+ "' không?");
					System.out.println("1. Có		2.Không");
					int j;
					j=sc.nextInt();
					if(j==1) {
						list.removeAll(listRemove);
						System.out.println("Đã xóa '"+text+"' khỏi danh sách!");
					}else {
						System.out.println("Quay lại menu chính?");
						System.out.println("1. Quay lại		2. Thoát");
						n= sc.nextInt();
						if(n==2) {
							System.out.println("Chào tạm biệt!");
							return;
						}
						continue;
					}
				}else {
					System.out.println("Không có cán bộ này trong danh sách!");
				}
				
				System.out.println("Quay lại menu chính?");
				System.out.println("1. Quay lại		2. Thoát");
				n= sc.nextInt();
				if(n==2) {
					System.out.println("Chào tạm biệt!");
					return;
				}
				break;
			case 5:
					System.out.println("Chào tạm biệt!");
					return;
			default:
					System.out.println("Nhập lại:");
					break;
			}
		}
	}
}

