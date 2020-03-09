package com.designpatterns.structural.bridge;

public class FileDownloadAbstractionImpl implements FileDownloadAbstraction {
	private FileDownloadImplementor provider;
	
	public FileDownloadAbstractionImpl(FileDownloadImplementor provider) {
		super();
		this.provider = provider;
	}

	@Override
	public Object download() {
		return provider.downloadFile();
	}

	@Override
	public void store() {
		provider.storeFile();
	}

}
