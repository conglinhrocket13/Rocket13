package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Book;
import com.vti.entity.Document;
import com.vti.entity.Magazine;
import com.vti.entity.Newspaper;

public class Quest4 {
	public void question4() {
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
			System.out.format(leftAlignFormat, "1. Thêm mới tài liệu mới");
			System.out.format(leftAlignFormat, "2. Xóa tài liệu theo mã tài liệu");
			System.out.format(leftAlignFormat, "3. Hiện thị thông tin về tài liệu");
			System.out.format(leftAlignFormat, "4. Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo");
			System.out.format(leftAlignFormat, "5. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.print("Nhập số: ");
				
			choose = sc.nextInt();
			int n;
			int delID;
			int id=1;

			Boolean check = false;
						
			switch (choose) {
			case 1:
					SubMenu submenu = new SubMenu();
					submenu.SubMenu(id, list);
					System.out.println();
					break;
					
			case 2:	
				System.out.println("Mời nhập vào mã tài liệu cần xóa !!");
				System.out.print("Mã tài liệu : ");
				sc.nextLine();
				delID = sc.nextInt();
				for (Object o : list) {	
					Document d= (Document)o;
					
					if( d.getId()==delID){
						listRemove.add(o);
						
						check=true;
					}	
				}
				
				if(check==true) {
					System.out.println();
					System.out.println("Bạn xác định muốn xóa không?");
					System.out.println("1. Có		2.Không");
					int j;
					j=sc.nextInt();
					if(j==1) {
						list.removeAll(listRemove);
						System.out.println("Đã xóa '"+delID+"' khỏi danh sách!");
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
				
			case 3:
				ShowList show = new ShowList();
				show.ShowList(list);
				
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
				FindType find = new FindType();
				find.FindType(list);
				System.out.println();
				System.out.println("Bạn có muốn tiếp tục không?");
				System.out.println("1. Có		2.Không");
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
