package com.vti.entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Department {
	private int id;
	private String name;
	private Scanner sc;
	
	
	public Department() throws Exception {
		sc = new Scanner(System.in);
		id = inputID();
		sc.nextLine();
		name = inputName();
	}
	
	private int inputID() {
		while(true) {	
			try {
				System.out.print("Nhập ID: ");
				int id=sc.nextInt();	
				
				return id;

			}catch (InputMismatchException e) {
				System.out.println("Hãy nhập ID là số nguyên!");
				sc.nextLine();
				System.out.println();
			}
		}
	}
	
	private String inputName() throws Exception {
		while(true) {	
			try {
				System.out.print("Nhập tên Dep : ");
				String name=sc.nextLine();
				return name;

			}catch (Exception e) {
				throw new Exception();
			}
		}
	}
	
	
	@Override
	public String toString() {
		return "Department | ID: " + id + "| Name: " + name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
