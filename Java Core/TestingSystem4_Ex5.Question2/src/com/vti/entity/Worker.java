package com.vti.entity;

import java.util.Scanner;

public class Worker extends Staff {
	private int rank;
	private Scanner sc;
	
	public Worker() {
		super();
	
	}

	public Worker(String fullname, int age, Gender gender, String address, int rank) {
		super(fullname, age, gender, address);
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return super.toString()+String.format("%-10s | %-10s","Worker",rank);
	}

	public void Add() {
		sc= new Scanner(System.in);
		System.out.println("---------Thêm công nhân mới---------");
		super.Add();
		System.out.print("Nhập bậc       : ");
		this.rank = sc.nextInt();
	}
	
}
