package com.vti.entity;

import java.lang.reflect.Array;
import java.util.Scanner;

public class News implements INews{
	private int ID;
	private String Title;
	private String PublishDate;
	private String Author;
	private String Content;
	private float AverageRate;
	private int [] Rates= new int[3];
	public Scanner sc;
	
	public News() {
		sc = new Scanner(System.in);
	}
	
	public News(int iD, String title, String publishDate, String author, String content, float averageRate,
			int[] rates) {
		ID = iD;
		Title = title;
		PublishDate = publishDate;
		Author = author;
		Content = content;
		AverageRate = averageRate;
		Rates = rates;
	}



	@Override
	public String toString() {
		return String.format("%-10s | %-13s | %-20s | %-30s | %-5s",
				Title,PublishDate,Author,Content,AverageRate);
	}

	@Override
	public void Display() {
		System.out.println(this.toString());
		
	}
	
	public void Add() {
		System.out.println("------Điền thông tin mới------");
		System.out.print("Nhập tiêu đề        : ");
		Title = sc.nextLine();
		System.out.print("Nhập ngày phát hành : ");
		PublishDate = sc.nextLine();
		System.out.print("Nhập tác giả        : ");
		Author = sc.nextLine();
		System.out.print("Nhập nội dung       : ");
		Content = sc.nextLine();
	}
	
	@Override
	public float Calculate() {
		
		for(int i=0;i<3;i++) {
			System.out.print("Đánh giá "+(i+1)+" : ");
			Rates[i]= sc.nextInt();
		}
		return AverageRate=(Rates[0]+Rates[1]+Rates[2])/3;
	}
	
	public int[] getRates() {
		return Rates;
	}


	public void setRates(int[] rates) {
		Rates = rates;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public float getAverageRate() {
		return AverageRate;
	}

	
	
	
}
