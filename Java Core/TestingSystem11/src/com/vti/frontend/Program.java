package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Program {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		AccountFunction function = new AccountFunction();
		
		function.Program();
	}
}
