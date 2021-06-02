package com.vti.backend;

import com.vti.ultis.IOManager;
import com.vti.ultis.ScannerUltis;

public class Exercise4 {
	public void question1() throws Exception {
// 	Đọc file	
	System.out.println("Nhập đường dẫn file cần đọc: ");
	String pathname = ScannerUltis.inputString();
	String content = IOManager.readFile(pathname);
	System.out.println(content);
	}
	
	public void question2() throws Exception {
//	Ghi file
	System.out.println("Nhập đường dẫn file cần ghi: ");
	String pathname = ScannerUltis.inputString();
	System.out.println("Nhập nội dung ghi: ");
	String content = ScannerUltis.inputString();
	System.out.println();
// Xem file sau khi ghi
	content = IOManager.readFile(pathname);
	System.out.println(content);
	}
}
