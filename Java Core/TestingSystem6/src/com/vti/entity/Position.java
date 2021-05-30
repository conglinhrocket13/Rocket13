package com.vti.entity;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.vti.entity.Position.PositionName;

public class Position {
	private int id;
	private PositionName name;
	private Scanner sc;
	
	public enum PositionName{
		DEV, TEST, SCRUM_MASTER, PM
	}
	
	public Position() {
		sc = new Scanner(System.in);
		id = inputID();
		name = inputName();
	}
	
	private int inputID() {
		while(true) {	
			try {
				System.out.print("Nhập ID : ");
				int n=sc.nextInt();
				return n;

			}catch (InputMismatchException e) {
				System.out.println("Hãy nhập ID là số nguyên!");
				sc.nextLine();
				System.out.println();
				
			}
		}
	}
	
	private PositionName inputName() {
			while(true) {
				try {
					System.out.println("Nhập vào tên position (1. DEV | 2.TEST | 3.SCRUM_MASTER | 4.PM) Chọn số!");
					System.out.print("Nhập số : ");
					int n=sc.nextInt();
					switch(n) {
					case 1:
						name=PositionName.DEV;
						return name;
					case 2:
						name=PositionName.TEST;
						return name;
					case 3:
						name=PositionName.SCRUM_MASTER;
						return name;
					case 4:
						name=PositionName.PM;
					default:
						System.out.println("Số không hợp lệ! Nhập lại");
						break;
					}
				} catch (Exception e) {
					System.out.println("Giá trị bạn vừa nhập không phải số! Hãy nhập lại!");
				}
			}
	}
	
	
	@Override
	public String toString() {
		return "Position | ID: " + id + "| Name:" + name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PositionName getName() {
		return name;
	}

	public void setName(PositionName name) {
		this.name = name;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	
}
