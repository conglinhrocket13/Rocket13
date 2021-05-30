package com.vti.entity;

import java.util.Scanner;

public class HinhChuNhat {
	private int chieudai;
	private int chieurong;
	public Scanner sc;
	
	public HinhChuNhat() {
		sc = new Scanner(System.in);
		
	}
	
	public void Nhap() {
		System.out.print("Nhập chiều dài  : ");
		chieudai = sc.nextInt();
		System.out.print("Nhập chiều rộng : ");
		chieurong = sc.nextInt();
	}
	
	public void Xuat() {
		tinhChuVi();
		tinhDienTich();
	}
	
	public int tinhChuVi() {
		System.out.println("Tính Chu vi HCN/Hình Vuông");
		return (chieudai+chieurong)*2;
	}
	
	public int tinhDienTich() {
		System.out.println("Tính Diện tích HCN/Hình Vuông");
		return chieudai*chieurong;
	}
	
	public HinhChuNhat(int chieudai, int chieurong) {
		this.chieudai = chieudai;
		this.chieurong = chieurong;
	}

	public int getChieudai() {
		return chieudai;
	}

	public void setChieudai(int chieudai) {
		this.chieudai = chieudai;
	}

	public int getChieurong() {
		return chieurong;
	}

	public void setChieurong(int chieurong) {
		this.chieurong = chieurong;
	}
	
	
	
}
