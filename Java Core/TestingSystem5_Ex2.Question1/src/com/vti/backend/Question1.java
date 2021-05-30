package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Student;

public class Question1 {
	public Scanner sc;
	
	public Question1() {
		sc = new Scanner(System.in);
		
	}
	
	public void Add(ArrayList<Student> list) {
		for(int i=0;i<10;i++) {
			System.out.println("Nhập học sinh thứ "+(i+1));
			Student a = new Student();
			
			a.setId(i);
			a.Add();
			list.add(a);			
		}
	}
	
	public void RollUp(ArrayList<Student> list) {
		for (Student student : list) {
			student.RollUp();
		}
	}
	
	public void Team1Study(ArrayList<Student> list) {
		for(Student student : list) {
			if(student.getGroup()==1) {
				student.Study();
			}
		}
	}
	
	public void Team2CleanUp(ArrayList<Student> list) {
		for (Student student : list) {
			if(student.getGroup()==2) {
				student.Cleaning();
			}
		}
	}
}
