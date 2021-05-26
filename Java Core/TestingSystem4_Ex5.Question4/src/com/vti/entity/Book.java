package com.vti.entity;

import java.util.Scanner;

public class Book extends Document{
	private String author;
	private int numofpage;
	
	private Scanner sc;
	
	public Book() {
		super();

	}
	public Book(int id, String publishing, int amount,String author, int numofpage) {
		super(id, publishing, amount);
		this.author = author;
		this.numofpage = numofpage;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getNumofpage() {
		return numofpage;
	}
	public void setNumofpage(int numofpage) {
		this.numofpage = numofpage;
	}
	@Override
	public String toString() {
		return super.toString()+String.format(" %-20s | %d",author,numofpage);
	}
	
	public void Add() {
		sc = new Scanner(System.in);
		super.Add();
		System.out.print("Nhập tên tác giả      : ");
		this.author = sc.nextLine();
		System.out.print("Nhập tổng số trang    : ");
		this.numofpage = sc.nextInt();
	}
	
}
