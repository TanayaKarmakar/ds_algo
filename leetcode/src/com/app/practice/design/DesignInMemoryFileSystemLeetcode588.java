package com.app.practice.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class StorageItem {
	protected String name;

	public StorageItem(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class DirectoryItem extends StorageItem {
	private List<StorageItem> items;

	public DirectoryItem(String name) {
		super(name);
		items = new ArrayList<>();
	}

	public void add(StorageItem item) {
		items.add(item);
	}
}

class FileItem extends StorageItem {
	StringBuilder contentBuilder;

	public FileItem(String name) {
		super(name);
		contentBuilder = new StringBuilder();
	}

	public void upsertContent(String content) {
		contentBuilder.append(content);
	}

	public String readContent() {
		return contentBuilder.toString();
	}
}

class FileSystem {
	Map<String, List<StorageItem>> storageMap;
	Map<String, StorageItem> ptrMap;
	private final String ROOT_PATH = "/";

	public FileSystem() {
		storageMap = new HashMap<>();
		storageMap.put(ROOT_PATH, new ArrayList<>());
		ptrMap = new HashMap<>();
		StorageItem rootDir = new DirectoryItem(ROOT_PATH);
		ptrMap.put(ROOT_PATH, rootDir);
	}

	public List<String> ls(String path) {
		List<String> items = new ArrayList<>();
		String lastItem = "";
		if (path.equals("/")) {
			lastItem = path;
		} else {
			String[] pathTokens = path.split("/");
			lastItem = pathTokens[pathTokens.length - 1];
		}
		List<StorageItem> storageItems = storageMap.get(lastItem);
		for (StorageItem item : storageItems) {
			items.add(item.getName());
		}

		Collections.sort(items);
		return items;
	}

	public void mkdir(String path) {
		mkdir(path, false);
	}

	public void addContentToFile(String filePath, String content) {
		mkdir(filePath, true);
		FileItem fileItem = (FileItem) getFileItem(filePath);
		fileItem.upsertContent(content);
	}

	public String readContentFromFile(String filePath) {
		FileItem fileItem = (FileItem) getFileItem(filePath);
		return fileItem.readContent();
	}

	private FileItem getFileItem(String filePath) {
		String lastToken = "";
		String[] pathTokens = filePath.split("/");
		lastToken = pathTokens[pathTokens.length - 1];
		FileItem fileItem = (FileItem) ptrMap.get(lastToken);
		return fileItem;
	}
	
	private void mkdir(String path, boolean isFile) {
		String[] pathTokens = path.split("/");

		int n = pathTokens.length;

		for (int i = n - 2; i >= 1; i--) {
			String childDir = pathTokens[i + 1];
			String parentDir = pathTokens[i];

			if (!ptrMap.containsKey(parentDir)) {
				StorageItem parentDirItem = new DirectoryItem(parentDir);
				ptrMap.put(parentDir, parentDirItem);
				storageMap.put(parentDir, new ArrayList<>());
			}

			if (!ptrMap.containsKey(childDir)) {
				StorageItem childDirItem;
				if(isFile) {
					childDirItem = new FileItem(childDir);
				} else {
					childDirItem = new DirectoryItem(childDir);
				}
				ptrMap.put(childDir, childDirItem);
				storageMap.put(childDir, new ArrayList<>());
				((DirectoryItem) ptrMap.get(parentDir)).add(childDirItem);
				storageMap.get(parentDir).add(childDirItem);
			}
		}
		
		String currentRootPath = pathTokens[1];
		List<StorageItem> items = storageMap.get(ROOT_PATH);
		boolean found = false;
		for(StorageItem item: items) {
			if(item.getName().equals(currentRootPath)) {
				found = true;
				break;
			}
		}
		if(!found)
			storageMap.get(ROOT_PATH).add(ptrMap.get(currentRootPath));
	}
}

public class DesignInMemoryFileSystemLeetcode588 {

	public static void main(String[] args) {
		FileSystem fs = new FileSystem();
		System.out.println(fs.ls("/"));
		fs.mkdir("/a/b/c");
		fs.addContentToFile("/a/b/c/d", "hello");
		System.out.println(fs.ls("/"));
		System.out.println(fs.readContentFromFile("/a/b/c/d"));
	}

}
