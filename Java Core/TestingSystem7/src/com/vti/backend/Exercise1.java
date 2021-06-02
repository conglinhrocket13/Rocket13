package com.vti.backend;

import java.util.ArrayList;

import com.vti.entity.PrimaryStudent;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.Student;

public class Exercise1 {
	public void question1_2() {
		Student a = new Student();
		Student b = new Student();
		Student c = new Student();
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(a);
		list.add(b);
		list.add(c);
		for (Student student : list) {
			System.out.println(student);
		}
		
		System.out.println("Chuyển sang Đại học công nghệ");
		a.setCollege("Đại học Công Nghệ");
		for (Student student : list) {
			System.out.println(student);
		}
		
		System.out.println("Mỗi bạn đóng 100k");
		System.out.println("Quỹ: "+ (a.moneyGroup += 300));
		System.out.println("Student 1 lấy 50k mua bimbim, kẹo liên hoan");
		System.out.println("Quỹ: "+ (a.moneyGroup -= 50));
		System.out.println("Student 2 lấy 20k mua bánh mì");
		System.out.println("Quỹ: "+ (a.moneyGroup -= 20));
		System.out.println("Student 2 lấy 150k mua đồ dùng học tập cho nhóm");
		System.out.println("Quỹ: "+ (a.moneyGroup -= 150));
		System.out.println("Nhóm mỗi người đóng lại 50k");
		System.out.println("Quỹ: "+ (a.moneyGroup += 150));
	}
	
	public void question4() {
		Student a = new Student();
		System.out.println(a);
		
		a.changeCollege();
		System.out.println(a);
		
	}
	
	public void question5() {
		Student a = new Student();
		Student b = new Student();
		Student c = new Student();
		
		System.out.println(a.CountAcc() +" Student đã thêm!");
	}
	
	public void question6() {
		PrimaryStudent a1 = new PrimaryStudent();
		PrimaryStudent a2 = new PrimaryStudent();
		SecondaryStudent b1 = new SecondaryStudent();
		SecondaryStudent b2 = new SecondaryStudent();
		SecondaryStudent b3 = new SecondaryStudent();
		SecondaryStudent b4 = new SecondaryStudent();
		
		System.out.println(a1.CountAcc() +" PrimaryStudent đã thêm!");
		System.out.println(b1.CountAcc() +" SecondaryStudent đã thêm!");
	}
	
	public void question7() {
		for(int i=0;i<8;i++) {
			System.out.println("Nhập học sinh thứ "+(i+1));
			Student a = new Student();			
		}
	}
}
