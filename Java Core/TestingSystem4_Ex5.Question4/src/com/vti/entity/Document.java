package com.vti.entity;

import java.util.Scanner;

public class Document {
	private int id;
	private String publishing;
	private int amount;
	
	private Scanner sc;
	
	public Document() {}
	
	public Document(int id, String publishing, int amount) {
		super();
		this.id = id;
		this.publishing = publishing;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		String a= String.format("%,d",amount);
		return String.format("%-11s | %-20s | %-16s |",id,publishing,a);
	}
	
	public void Add() {
		sc = new Scanner(System.in);
		
		System.out.print("Nhập tên NXB          : ");
		this.publishing = sc.nextLine();
		System.out.print("Nhập số bản phát hành : ");
		this.amount = sc.nextInt();
	}
}
