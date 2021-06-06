package com.vti.backend;

import java.util.ArrayList;

import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

public class Exercise1_Quest1 {
	public void Question1(){
		ArrayList<Student> list = new ArrayList<Student>();
		Student a1 = new Student("Sinh viên trùng");
		Student a2 = new Student("Sinh viên trùng");
		Student a3 = new Student("Sinh viên trùng");
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		while(true) {
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1.  Thêm mới Sinh viên");
			System.out.format(leftAlignFormat, "2.  Danh sách Sinh viên");
			System.out.format(leftAlignFormat, "3.  In ra tổng số phần tử của sinh viên");
			System.out.format(leftAlignFormat, "4.  Lấy phần tử thứ 4 của sinh viên");
			System.out.format(leftAlignFormat, "5.  In ra phần tử đầu và phần tử cuối của sinh viên");
			System.out.format(leftAlignFormat, "6.  Thêm 1 phần tử vào vị trí đầu của List");
			System.out.format(leftAlignFormat, "7.  Thêm 1 phần tử vào vị trí cuối của List");
			System.out.format(leftAlignFormat, "8.  Tìm kiếm sinh viên theo ID");
			System.out.format(leftAlignFormat, "9.  Tìm kiếm sinh viên theo tên");
			System.out.format(leftAlignFormat, "10. In ra các sinh viên có trùng tên");
			System.out.format(leftAlignFormat, "11. Xóa tên của sinh viên theo ID");
			System.out.format(leftAlignFormat, "12. Xóa sinh viên theo ID");
			System.out.format(leftAlignFormat, "13. Tạo 1 ArrayList tên là studentCopies và add tất cả "
												+ "students vào studentCopies");
			System.out.format(leftAlignFormat, "14. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.print("Nhập số: ");
			int choose = ScannerUltis.inputInt();
			String name;
			Boolean done = false;
			int id;
			switch (choose) {
			case 1:
				System.out.print("Nhập số sinh viên muốn thêm: ");
				int n = ScannerUltis.inputInt();
				for(int i =0;i<n;i++) {
					Student a = new Student();
					list.add(a);
				}
				break;
			case 2:
				System.out.println("------------------------- DANH SÁCH -------------------------");
				for (Student student : list) {
					System.out.println(student);
				}
				break;
			case 3:
				System.out.println("Hiện có "+list.size()+" Student trong danh sách!");
				break;
			case 4:
				System.out.println(list.get(3));
				break;
			case 5:
				System.out.println(list.get(0));
				System.out.println(list.get(list.size()-1));
				break;
			case 6:
				System.out.print("Nhập tên sinh viên muốn thêm: ");
				name = ScannerUltis.inputString();
				list.add(0, new Student(name));
				System.out.println("Thêm thành công! ");
				break;
			case 7:
				System.out.print("Nhập tên sinh viên muốn thêm: ");
				name = ScannerUltis.inputString();
				list.add(new Student(name));
				System.out.println("Thêm thành công! ");
				break;
			case 8:
				System.out.print("Nhập ID sinh viên muốn tìm: ");
				id = ScannerUltis.inputIntPositive();
				for (Student student : list) {
					if(student.getId()==id) {
						System.out.println(student);
						done = true;
					}
				}
				if(done==true){
					break;
				}else {
					System.out.println("Không tìm thấy!!!");
					break;
				}
			case 9:
				ScannerUltis.fixScan();
				System.out.print("Nhập tên sinh viên muốn tìm: ");
				name = ScannerUltis.inputString();
				for (Student student : list) {
					if(student.getName().equals(name)) {
						System.out.println(student);
						done=true;
					}
				}
				if(done==true){
					break;
				}else {
					System.out.println("Không tìm thấy!!!");
					break;
				}
			case 10:
				for(int i=0;i<list.size();i++) {
					for(int j=i+1;j<list.size();j++) {
						if(list.get(i).getName().equals(list.get(j).getName())) {
							System.out.println(list.get(i)+ " ");
						}
					}
				}
				break;
			case 11:
				System.out.print("Nhập vào ID cần xóa tên: ");
				id = ScannerUltis.inputIntPositive();
				for (Student student : list) {
					if (student.getId() == id) {
					student.setName(null);
					done=true;
					}
				}
				if(done==true){
					System.out.println("Xóa tên thành công!");
					break;
				}else {
					System.out.println("Không tồn tại ID này ");
					break;
				}
			case 12:
				System.out.print("Nhập vào ID của student cần xóa: ");
				id = ScannerUltis.inputIntPositive();
				for (Student student2 : list) {
					if (student2.getId() == id) {		
						done=true;
						}
				}
				if(done==true){
					list.removeIf(student -> student.getId()==id);
					System.out.println("Xóa thành công!");
					break;
				}else {
					System.out.println("Không tồn tại ID này ");
					break;
				}
			case 13:
				ArrayList<Student> arrayCopy = new ArrayList<Student>();
				arrayCopy.addAll(list);
				System.out.println("In phần tử trong ArrayCopy: ");
				for (Student st : arrayCopy) {
					System.out.println(st);
				}
				break;
			case 14:
				System.out.println("Chào tạm biệt!");
				return;
			default:
				System.out.println("Nhập lại!!!");
				break;
			}
		}
	}
}
