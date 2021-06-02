package com.vti.backend;

import com.vti.entity.MyMath;
import com.vti.entity.Student_Ex2;

public class Exercise2 {
	public void question1() {
		System.out.println(MyMath.sum(10));
		
		System.out.println(MyMath.max(8, 3));
		System.out.println(MyMath.min(8, 3));
		System.out.println(MyMath.sum(8, 3));
	}
	
	public void question2() {
		Student_Ex2 a = new Student_Ex2();
		System.out.println(a);
	}
	
	public void question3() {
		Student_Ex2 a = new Student_Ex2();
		System.out.println(a);
		Student_Ex2 b = new Student_Ex2();
		System.out.println(a);
		a.Study();
		System.out.println(b);
		b.Study();
	}
	
	public void question4() {
		System.out.println("Thêm final trước từ khóa class của PrimaryStuden và SecondaryStudent");
	}
}
