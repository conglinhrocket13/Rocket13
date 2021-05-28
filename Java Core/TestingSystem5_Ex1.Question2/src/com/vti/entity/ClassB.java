package com.vti.entity;

import java.util.Scanner;

public class ClassB extends Examinee {
	private float Math;
	private float Biological;
	private float Chemistry;
	public Scanner sc;
	
	public ClassB() {
		sc = new Scanner(System.in);
	}

	public ClassB(int iD, String fullname, String address, int priorityLevel,
			float math, float biological, float chemistry) {
		super(iD, fullname, address, priorityLevel);
		Math = math;
		Biological = biological;
		Chemistry = chemistry;
	}


	public float getMath() {
		return Math;
	}
	public void setMath(float math) {
		Math = math;
	}
	public float getBiological() {
		return Biological;
	}
	public void setBiological(float biological) {
		Biological = biological;
	}
	public float getChemistry() {
		return Chemistry;
	}
	public void setChemistry(float chemistry) {
		Chemistry = chemistry;
	}
	
	public void Add() {
		super.Add();
	}
}