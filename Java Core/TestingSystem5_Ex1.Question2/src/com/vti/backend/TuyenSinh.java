package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.ClassA;
import com.vti.entity.ClassB;
import com.vti.entity.ClassC;
import com.vti.entity.Examinee;
import com.vti.entity.ITuyenSinh;


public class TuyenSinh implements ITuyenSinh{

	public Scanner sc;
	public ArrayList list;
	public TuyenSinh() {
		sc = new Scanner(System.in);
		list = new ArrayList();
	}
	
	@Override
	public void Add() {
		Boolean lap=false;
		String leftAlignFormat = "| %-72s |%n";
		int id = list.size()+1;
		
		do{
			
			System.out.println();
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Thêm thí sinh khối A");
			System.out.format(leftAlignFormat, "2. Thêm thí sinh khối B");
			System.out.format(leftAlignFormat, "3. Thêm thí sinh khối C");;
			System.out.format("+--------------------------------------------------------------------------+%n");
			
			int n;
			System.out.print("Nhập số: ");
			n=sc.nextInt();
			switch(n) {
				case 1:
					ClassA a = new ClassA();
					a.setID(id);
					a.Add();
					list.add(a);
					lap=true;
					break;
				case 2:
					ClassB b = new ClassB();
					b.setID(id);
					b.Add();
					list.add(b);
					lap=true;
					break;
				case 3:
					ClassC c = new ClassC();
					c.setID(id);
					c.Add();
					list.add(c);
					lap=true;
					break;
				default:
					System.out.println("Nhập lại");
					break;
				}
			}while(lap==false);
		
	}

	@Override
	public void Info() {
		System.out.println();
		System.out.println("--------THÍ SINH KHỐI A--------");
		System.out.println("_________________________________________________________");
		for (Object o: list) {
			if(o instanceof ClassA) {
				System.out.println(o);
			}
		}
		System.out.println();
		System.out.println("--------THÍ SINH KHỐI B--------");
		System.out.println("_________________________________________________________");
		for (Object o: list) {
			if(o instanceof ClassB) {
				System.out.println(o);
			}
		}
		System.out.println();
		System.out.println("--------THÍ SINH KHỐI C--------");
		System.out.println("_________________________________________________________");
		for (Object o: list) {
			if(o instanceof ClassC) {
				System.out.println(o);
			}
		}
		
	}

	@Override
	public void Find() {
		int n;
		System.out.print("Nhập số báo danh: ");
		n=sc.nextInt();
		Boolean check = false;
		
		for (Object o : list) {
			Examinee a = (Examinee)o;
			if(a.getID()==n) {
				if(o instanceof ClassA) {
					System.out.print("Khối A | ");
					System.out.println(o);
				}
				if(o instanceof ClassB){
					System.out.print("Khối B | ");
					System.out.println(o);

				}
				if(o instanceof ClassC) {
					System.out.print("Khối C | ");
					System.out.println(o);
				}
				check = true;
			}
		}
		if(check==false) {
			System.out.println("Không tìm thấy!!!");
		}
	}
}
