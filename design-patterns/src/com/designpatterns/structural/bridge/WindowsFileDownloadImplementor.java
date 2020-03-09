package com.designpatterns.structural.bridge;

public class WindowsFileDownloadImplementor implements FileDownloadImplementor {

	@Override
	public Object downloadFile() {
		return new Object();
	}

	@Override
	public void storeFile() {
		System.out.println("File Downloading finished in Windows !!!!!");
	}

}
