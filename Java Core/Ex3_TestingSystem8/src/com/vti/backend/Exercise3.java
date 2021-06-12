package com.vti.backend;

import com.vti.entity.Employee;
import com.vti.entity.MyMap;
import com.vti.entity.Phone;
import com.vti.entity.Staff;
import com.vti.entity.Student;

public class Exercise3 {
	public <T> void question1_2_3_4() {
		Student<Integer> a = new Student<Integer>(3, "A");
		Student<Float> b = new Student<Float>(3.5f, "B");
		Student<Double> c = new Student<Double>(5.3, "C");
		
		print(a);
		print(b);
		print(c);
		
		Integer[] num1 = {1 , 2, 3 ,4 ,5};
		Float[] num2 = {1.1f, 2.2f, 3.3f, 4.4f};
		
		printA(num1);
		printA(num2);
	}

	public static <T> void print(T a) {
		System.out.println(a);
	}
	
	public static <E> void printA(E[] arr) {
		for (E e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	public void question5() {
		Integer[] IntSalaries = { 1000, 1500, 2000};
		Employee<Integer> Em1 = new Employee<Integer>("A", IntSalaries);
		Float[] FloatSalaries = { 1000f, 1500f, 2000.5f};
		Employee<Float> Em2 = new Employee<Float>("B", FloatSalaries);
		Double[] DoubleSalaries = { 1000.5, 1500.3,2000.7};
		Employee<Double> Em3 = new Employee<Double>("C", DoubleSalaries);
		
		Em1.ShowEmployee();
		Em2.ShowEmployee();
		Em3.ShowEmployee();
	}
	

	public void question6() {
		MyMap<Integer , String> student = new MyMap<Integer , String>(1, "A");
		System.out.println("Lấy Key trong MyMap  : "+student.getKey());
		System.out.println("Lấy Value trong MyMap: "+student.getValue());
	}
	
	public void question7() {
		Phone<String , String> phone1 = new Phone<String, String>("phone1@gmail.com", "0386575641");
		Phone<Integer , String> phone2 = new Phone<Integer, String>(1, "0386352311");
		Phone<String , String> phone3 = new Phone<String, String>("Trần Văn A", "0386575641");
		System.out.println("Thông tin 1 - Key: "+phone1.getKey()+" | NumberPhone: "+phone1.getNumberPhone());
		System.out.println("Thông tin 2 - Key: "+phone2.getKey()+" | NumberPhone: "+phone2.getNumberPhone());
		System.out.println("Thông tin 3 - Key: "+phone3.getKey()+" | NumberPhone: "+phone3.getNumberPhone());
		
	}
	
	public void question8() {
		Staff<Integer, String> staff1 = new Staff<Integer, String>(1, "staff1");
		Staff<Long, String> staff2 = new Staff<Long, String>(2l, "staff2");
		System.out.println("Thông tin 1 - Key: "+staff1.getID()+" | NumberPhone: "+staff1.getName());
		System.out.println("Thông tin 2 - Key: "+staff2.getID()+" | NumberPhone: "+staff2.getName());
	}
}
