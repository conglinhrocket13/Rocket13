package com.vti.entity;

import java.util.Scanner;

public class ClassC extends Examinee{
	private float Literary ;
	private float History;
	private float Geography;
	public Scanner sc;
	
	public ClassC() {
		sc = new Scanner(System.in);
	}

	public ClassC(int iD, String fullname, String address, int priorityLevel,
			float literary, float history, float geography) {
		super(iD, fullname, address, priorityLevel);
		Literary = literary;
		History = history;
		Geography = geography;
	}

	public float getLiterary() {
		return Literary;
	}

	public void setLiterary(float literary) {
		Literary = literary;
	}

	public float getHistory() {
		return History;
	}

	public void setHistory(float history) {
		History = history;
	}

	public float getGeography() {
		return Geography;
	}

	public void setGeography(float geography) {
		Geography = geography;
	}

	public void Add() {
		super.Add();
	}
	
}
