package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.entity.Manager;
import com.vti.entity.Manager.ProSkill;
import com.vti.ultis.ScannerUltis;

public class demo {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		ProjectDBFuntion a = new ProjectDBFuntion();
		a.menu();
	}
}
