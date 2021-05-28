package com.vti.entity;

import java.util.Scanner;

public class ClassA extends Examinee{
	private float Math;
	private float Physic;
	private float Chemistry;
	public Scanner sc;
	
	public ClassA() {
		sc = new Scanner(System.in);
		
	}
	public ClassA(int iD, String fullname, String address, 
				int priorityLevel,float math, float physic, float chemistry) {
		super(iD, fullname, address, priorityLevel);
		Math = math;
		Physic = physic;
		Chemistry = chemistry;
	}
	
	public float getMath() {
		return Math;
	}
	public void setMath(float math) {
		Math = math;
	}
	public float getPhysic() {
		return Physic;
	}
	public void setPhysic(float physic) {
		Physic = physic;
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
