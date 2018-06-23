package reporter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class FileFinder {
	
	private ArrayList<File> fileList;
	private String root;
	private File rootFile;
	
	private void generateFileList(File directory) {
		if (directory.isDirectory()) {
			for (File f : directory.listFiles()) {
				generateFileList(f);
			}
		}
		else {
			fileList.add(directory);
		}		
	}
	
	public FileFinder(String root) {
		this.root = root;
		this.rootFile = new File(root);
		this.fileList = new ArrayList<File>();
		generateFileList(rootFile);
	}
	
	public ArrayList<File> getFileList() {
		return fileList;
	}
	
	/*public static void main(String[] args) {
		FileFinder ff = new FileFinder("c:/Users/Student38/Desktop/projekt/drzewko");
		for (File f : ff.getFileList()) {
			System.out.println(f.getAbsolutePath());
		}
	}*/
	
}
