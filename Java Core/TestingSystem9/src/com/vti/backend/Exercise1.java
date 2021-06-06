package com.vti.backend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.Locale;

public class Exercise1 {
	public void Ex3_Quest1() {
		Locale local = new Locale("vn","VN");
		DateFormat Date1 = DateFormat.getDateInstance(DateFormat.DEFAULT, local);
		Date d = new Date();
		System.out.println(Date1.format(d));
		DateFormat Date2 = DateFormat.getDateInstance(DateFormat.FULL, local);
		System.out.println(Date2.format(d));
		DateFormat Date3 = DateFormat.getDateInstance(DateFormat.LONG, local);
		System.out.println(Date3.format(d));
		DateFormat Date4 = DateFormat.getDateInstance(DateFormat.MEDIUM, local);
		System.out.println(Date4.format(d));
		DateFormat Date5 = DateFormat.getDateInstance(DateFormat.SHORT, local);
		System.out.println(Date5.format(d));
	}
	
	public void EX3_Quest2() {
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(simpleDateFormat3.format(new Date()));
		
	}
	
	public void EX3_Quest3() {
		LocalDate d = LocalDate.now();
		System.out.println(d.getYear());
		
	}
	
	public void EX3_Quest4() {
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("MM-yyyy");
		System.out.println(simpleDateFormat3.format(new Date()));
	}
	
	public void EX3_Quest5() {
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("MM-dd");
		System.out.println(simpleDateFormat3.format(new Date()));
	}
}
