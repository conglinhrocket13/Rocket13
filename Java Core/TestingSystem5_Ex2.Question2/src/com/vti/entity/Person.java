package com.vti.entity;

import java.util.Scanner;

public abstract class Person {
	private String name;
	private Gender gender;
	private String address;
	private String birthday;

	public enum Gender {
		MALE , FEMALE , UNKNOW
	}
	
	public Scanner sc;
	public Person() {
		sc = new Scanner(System.in);
	}
	
	@Override
	public String toString() {
		return "Tên: " + name + " | Giới tính: " + gender + " | Ngày sinh: "
				+birthday + " | Address: " + address;
	}
	public void inputInfo() {
		System.out.print("Nhập tên     : ");
		name=sc.nextLine();
		this.AddGender();
		sc.nextLine();
		System.out.println("Nhập ngày sinh (theo định dạng ngày/tháng/năm) ");
		System.out.print("Ngày sinh    : ");
		birthday=sc.nextLine();
		System.out.print("Nhập địa chỉ : ");
		address=sc.nextLine();
		
	}
	
	public void AddGender() {
		while(true) {
			System.out.println("Nhập giới tính (1. Nam   , 2. Nữ   , 3. Chưa xác định)");
			System.out.print("Nhập số      : ");
			int n = sc.nextInt();
			switch(n) {
			case 1:
				gender = Gender.MALE;
				return;
			case 2:
				gender = Gender.FEMALE;
				return;
			case 3:
				gender = Gender.UNKNOW;
				return;
			default:
				System.out.println("Số nhập không hợp lệ hãy nhập lại!");
				break;
			}
		}	
	}
	
	public void showInfo() {
		String a = null;
		if(gender.equals(Gender.MALE)) {
			a="Nam";
		}
		if(gender.equals(Gender.FEMALE)) {
			a="Nữ";
		}
		if(gender.equals(Gender.UNKNOW)) {
			a="Chưa xác định";
		}
		System.out.println("Họ Tên       : "+name);
		System.out.println("Giới tính    : "+a);
		System.out.println("Ngày sinh    : "+birthday);
		System.out.println("Địa chỉ      : "+ address);
	}
	
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Person(String name, Gender gender, String address,String birthday) {
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
	}
	
	
}
