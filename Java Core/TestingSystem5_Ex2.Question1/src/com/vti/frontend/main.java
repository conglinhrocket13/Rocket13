package com.vti.frontend;

import java.util.ArrayList;
import java.util.Iterator;

import com.vti.entity.Student;

public class main {
	public static void main(String[] args) {
		Student[] list = new Student [10] ;

		for(int i=0;i<10;i++) {
			System.out.println("Nhập học sinh thứ "+(i+1));
			Student a = new Student();
			
			a.setId(i);
			a.Add();
			list[i]=a;
			
		}
		System.out.println();
		System.out.println("-----Điểm danh-----");
		for(int i=0;i<10;i++) {
			list[i].RollUp();
		}
		
		System.out.println();
		System.out.println("-----Nhóm 1 đi học bài-----");
		for(int i=0;i<10;i++) {
			if(list[i].getGroup()==1) {
				list[i].Lesson();
			}
		}
		System.out.println();
		System.out.println("-----Nhóm 2 đi dọn vệ sinh-----");
		for (int i=0;i<10;i++) {
			if(list[i].getGroup()==2) {
				list[i].CleanUp();
			}
		}
	}
}
