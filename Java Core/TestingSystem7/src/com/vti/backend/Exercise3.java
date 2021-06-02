package com.vti.backend;

import com.vti.ultis.FileUltis;
import com.vti.ultis.ScannerUltis;

public class Exercise3 {
	
	public void question1() {
// Kiểm tra file có tồn tại không?
		System.out.println("Nhập đường dẫn file: ");
		String pathname = ScannerUltis.inputString();	
		System.out.println(FileUltis.isFileExists(pathname));
	}
	
	public void question2() throws Exception {
	// Tạo file mới với tên file trong đường dẫn
		System.out.println("Tạo file mới với tên file trong đường dẫn");
		System.out.println("Nhập đường dẫn file: ");
		String pathname = ScannerUltis.inputString();
		FileUltis.createNewFile(pathname);
	// Tạo file mới với đường dẫn và tên file nhập riêng
		System.out.println("Tạo file mới với đường dẫn và tên file nhập riêng");
		System.out.println("Nhập đường dẫn file: ");
		pathname = ScannerUltis.inputString();
		System.out.println("Nhập tên file: ");
		String filename = ScannerUltis.inputString();
		FileUltis.createNewFile(pathname, filename);
	}
	
	public void question4() throws Exception {
	// Xóa file
		System.out.println("Nhập đường dẫn file cần xóa: ");
		String pathname = ScannerUltis.inputString();
		FileUltis.deleteFile(pathname);
	}
	
	public void question6() {
	// Xem file trong forder
		System.out.println("Nhập đường dẫn folder cần xem: ");
		String pathname = ScannerUltis.inputString();
		String[] fileString = FileUltis.getAllFileName(pathname);
		for (String string : fileString) {
			System.out.println(string);
		}
	}
	
	public void question7() {
//		Kiểm tra xem là file hay folder
		System.out.println("Nhập đường dẫn folder cần xem: ");
		String pathname = ScannerUltis.inputString();
		FileUltis.isFolderOrFile(pathname);
	}
	
	public void question8() throws Exception {
// 		Chuyển file sang thư mục khác
		System.out.println("Nhập đường dẫn file cũ: ");
		String oldpathname = ScannerUltis.inputString();
		System.out.println("Nhập đường dẫn file mới: ");
		String newpathname = ScannerUltis.inputString();
		FileUltis.moveFile(oldpathname, newpathname);
	}
	
	public void question9() throws Exception {
	// Đổi tên file
		System.out.println("Nhập đường dẫn file cũ: ");
		String oldpathname = ScannerUltis.inputString();
		System.out.println("Nhập đường dẫn file mới: ");
		String newpathname = ScannerUltis.inputString();
		FileUltis.renameFile(oldpathname, newpathname);
	}
	
	public void question10() throws Exception {
// 		Tạo folder mới với tên folder trong đường dẫn
		System.out.println("Tạo file mới với tên file trong đường dẫn");
		System.out.println("Nhập đường dẫn folder: ");
		String pathname = ScannerUltis.inputString();
		FileUltis.createNewFolder(pathname);
// 		Tạo folder mới với đường dẫn và tên folder nhập riêng
		System.out.println("Tạo file mới với đường dẫn và tên file nhập riêng");
		System.out.println("Nhập đường dẫn đến folder: ");
		pathname = ScannerUltis.inputString();
		System.out.println("Nhập tên folder: ");
		String filename = ScannerUltis.inputString();
		FileUltis.createNewFolder(pathname, filename);
	}
	
}
