package com.designpatterns.structural.bridge;

public class BridgeTest {

	public static void main(String[] args) {
		FileDownloadAbstraction abstractor = 
				new FileDownloadAbstractionImpl(new WindowsFileDownloadImplementor());
		
		abstractor.store();
		
		abstractor = 
				new FileDownloadAbstractionImpl(new LinuxFileDownloadImplementor());
		
		abstractor.store();

	}

}
