package com.designpatterns.structural.bridge;

public class LinuxFileDownloadImplementor implements FileDownloadImplementor {

	@Override
	public Object downloadFile() {
		return new Object();
	}

	@Override
	public void storeFile() {
		System.out.println("File downloading finished in Linux !!!!!");
	}

}
