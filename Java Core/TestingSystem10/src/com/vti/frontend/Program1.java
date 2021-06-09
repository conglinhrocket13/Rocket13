package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import com.vti.backend.Exercise1;

public class Program1 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Exercise1 a = new Exercise1();
		a.question1();
		a.question2();
		a.question3();
		a.question4();
		a.question5();
	}
}
