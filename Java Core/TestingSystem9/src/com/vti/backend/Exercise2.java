package com.vti.backend;

import java.util.Date;

import com.vti.entity.Student;

public class Exercise2 {
	public void Question1() {
		@SuppressWarnings("deprecation")
		Date d = new Date(2020 - 1900, 05 -1, 18);
	}
	
	public void Question2() {
		@SuppressWarnings("deprecation")
		
		Student st1 = new Student("Student1");
		System.out.println("Sinh viên tạo --- ID: "+st1.getId()+" | Name: "+st1.getName());
			
		Student st2 = new Student("Student2");
		System.out.println("Sinh viên tạo --- ID: "+st2.getIDwithMSV()+" | Name: "+st2.getName());
	
	}
}
