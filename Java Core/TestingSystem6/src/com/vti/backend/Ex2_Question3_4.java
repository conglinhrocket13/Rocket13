package com.vti.backend;

public class Ex2_Question3_4 {
	public static void main(String[] args) {
		
		try {
			int[] numbers = {1, 2, 3 };
			
			System.out.println(numbers[10]);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index out of bounds for length of array");
		}
			
		String[] Departments = {"Marketing", "Acounting", "HR"};
		getIndex(5, Departments);
	
	}
	
	public static void getIndex(int index, String[] a) {
		try {
		System.out.println(a[index]);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Cannot find department.");
		}
		
	}
}
