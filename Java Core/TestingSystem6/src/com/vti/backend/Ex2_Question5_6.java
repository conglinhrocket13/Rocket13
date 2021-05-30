package com.vti.backend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2_Question5_6 {
	
	public static void main(String[] args) {
		
		System.out.println(inputAge());
	}
	
	public static int inputAge() {
		while(true) {	
			try {
				Scanner sc = new Scanner(System.in);
				int n;
				while(true) {
					System.out.print("Nhập vào tuổi : ");
					n=sc.nextInt();
					if(n<0) {
						System.out.println("Wrong inputing! The age must be greater"
								+" than 0, please input again.");
						System.out.println();
						break;
					}
					return n;
				}
			
			}catch (InputMismatchException e) {
				System.out.println("wrong inputing! Please input an age as int, input again.");
				System.out.println();
				
			}
		}
	}
}
