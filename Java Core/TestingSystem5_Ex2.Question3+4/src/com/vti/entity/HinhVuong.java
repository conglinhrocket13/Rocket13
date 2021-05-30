package com.vti.entity;

public class HinhVuong extends HinhChuNhat {

	public HinhVuong() {
		super();
		
	}

	public HinhVuong(int chieudai, int chieurong) {
		super(chieudai, chieurong);
		
	}
	public void Nhap() {
		System.out.print("Nhập độ dài cạnh  : ");
		super.setChieudai(super.sc.nextInt());
		super.setChieurong(getChieudai());
	}
	public void Xuat() {
		super.tinhChuVi();
		super.tinhDienTich();
	}
}
