package com.vti.backend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2_Question8 {
	
	public static void main(String[] args) {
		
		inputInt("Bạn nhập sai giá trị! Hãy nhập số nguyên dương!");
		inputFloat("Bạn nhập sai giá trị! Hãy nhập số thực!");
		inputDouble("Bạn nhập sai giá trị! Hãy nhập số thực!");
		
	}
	
	public static int inputInt(String errorMessage) {
		while(true) {	
			try {
				Scanner sc = new Scanner(System.in);
				int n;
				System.out.print("Nhập số nguyên: ");
				n=sc.nextInt();
				return n;

			}catch (InputMismatchException e) {
				System.out.println(errorMessage);
				System.out.println();
				
			}
		}
	}
	
	public static float inputFloat(String errorMessage) {
		while(true) {	
			try {
				Scanner sc = new Scanner(System.in);
				float n;
					System.out.print("Nhập số thực: ");
					n=sc.nextFloat();
					return n;		
			}catch (InputMismatchException e) {
				System.out.println(errorMessage);
				System.out.println();
				
			}
		}
	}
	
	public static double inputDouble(String errorMessage) {
		while(true) {	
			try {
				Scanner sc = new Scanner(System.in);
				double n;
					System.out.print("Nhập số thực: ");
					n=sc.nextDouble();
					return n;		
			}catch (InputMismatchException e) {
				System.out.println(errorMessage);
				System.out.println();
				
			}
		}
	}
	
}
