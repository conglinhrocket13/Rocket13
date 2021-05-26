package com.vti.entity;

import java.util.Scanner;

public class Magazine extends Document{
	private int release_num;
	private int release_month;
	
	private Scanner sc;
	
	public Magazine() {
		super();
		
	}
	public Magazine(int id, String publishing, int amount,int release_num, int release_month) {
		super(id, publishing, amount);
		this.release_num = release_num;
		this.release_month = release_month;
	}
	public int getRelease_num() {
		return release_num;
	}
	public void setRelease_num(int release_num) {
		this.release_num = release_num;
	}
	public int getrelease_month() {
		return release_month;
	}
	public void setrelease_month(int release_month) {
		this.release_month = release_month;
	}
	@Override
	public String toString() {
		return super.toString()+String.format(" %-12s | %d",release_num,release_month);
	}

	public void Add() {
		sc = new Scanner(System.in);
		super.Add();
		System.out.print("Nhập số phát hành     : ");
		this.release_num = sc.nextInt();
	}
}
