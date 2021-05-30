package com.vti.entity;

import java.util.Random;
import java.util.Scanner;

public class Student implements  IStudent {
	private int id;
	private String name;
	private int group;
	public Scanner sc;
	public Random random;
	
	public Student() {
		sc = new Scanner(System.in);
		random = new Random();
	}
	
	public Student(int id, String name, int group) {
		this.id = id;
		this.name = name;
		this.group = group;
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

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	@Override
	public void RollUp() {
		System.out.println(name+" điểm danh");
		
	}

	@Override
	public void Study() {
		System.out.println(name+" đang học bài");
		
	}

	@Override
	public void Cleaning() {
		System.out.println(name+" đi dọn vệ sinh");
		
	}
	public void Add() {

		System.out.print("Nhập tên  : ");
		name = sc.nextLine();
		group = random.nextInt(3)+1;
	}
	
}
