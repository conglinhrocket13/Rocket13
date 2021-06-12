package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;

public class AccountFunction {
	public void Program() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		AccountController a = new AccountController();
		List<Account> listacc = a.getListAccounts();
		
		for (Account account : listacc) {
			System.out.println(account);
		}
	}
}
