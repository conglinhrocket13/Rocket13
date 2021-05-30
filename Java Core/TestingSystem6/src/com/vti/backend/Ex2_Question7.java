package com.vti.backend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2_Question7 {
	
	public static void main(String[] args) {
		
		inputInt("Bạn nhập sai giá trị! Hãy nhập số nguyên dương!");
		
	}
	
	public static int inputInt(String errorMessage) {
		while(true) {	
			try {
				Scanner sc = new Scanner(System.in);
				int n;
				while(true) {
					System.out.print("Nhập vào số nguyên dương: ");
					n=sc.nextInt();
					if(n<0) {
						System.out.println("Số vừa nhập không phải số nguyên dương! Nhập lại!");
						System.out.println();
						break;
					}
					return n;
				}
			
			}catch (InputMismatchException e) {
				System.out.println(errorMessage);
				System.out.println();
				
			}
		}
	}
}
