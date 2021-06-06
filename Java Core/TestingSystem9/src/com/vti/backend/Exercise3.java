package com.vti.backend;

import com.vti.entity.CPU;
import com.vti.entity.Car;

public class Exercise3 {

	public void Question1() {
		CPU cpu = new CPU();
		CPU.Processor Pr = new CPU.Processor();
		CPU.Ram ram = cpu.new Ram();
		System.out.println(Pr.getCache());
		System.out.println(ram.getClockSpeed());
	}
	
	public void Question2() {
		Car c = new Car("Mazda","8WD");
		Car.Engine E = c.new Engine("Crysler");
		c.Show(E);
	}
	
	public void Question3() {
		System.out.println("Output sẽ in ra 2 dòng 'Đây là inner class'");
	}
	
	public void Question4() {
		System.out.println("Ouput sẽ in ra 2 dòng:");
		System.out.println("Ngày: 31/10/2017");
		System.out.println("Giờ: 10:15:30");
	}
	
	
}
