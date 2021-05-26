package com.vti.entity;

import java.time.LocalDate;
import java.util.Scanner;

public class Newspaper extends Document{
	private LocalDate release_date;
	
	private Scanner sc;

	public Newspaper() {
		super();		
	}

	public Newspaper(int id, String publishing, int amount,LocalDate release_date) {
		super(id, publishing, amount);
		this.release_date = release_date;
	}

	public LocalDate getRelease_date() {
		return release_date;
	}

	public void setRelease_date(LocalDate release_date) {
		this.release_date = release_date;
	}

	@Override
	public String toString() {
		return super.toString()+" "+release_date;
	}
	
	public void Add() {
		sc = new Scanner(System.in);
		super.Add();
		int day;
		int month;
		int year;
		System.out.print("Nhập ngày phát hành   : ");
		day = sc.nextInt();
		System.out.print("Nhập tháng phát hành  : ");
		month= sc.nextInt();
		System.out.print("Nhập năm phát hành    : ");
		year= sc.nextInt();
		this.release_date = LocalDate.of(year, month, day);
	}

}
