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
			String fileName = directory.getName();
			if (fileName.contains(".xls")) {
				fileList.add(directory);
			}
		}		
	}
	
	public FileFinder(String root) {
		this.root = root;
		this.rootFile = new File(root);
		if (!(rootFile.exists())) {
			System.out.println("Path does not exist!");
		}
		this.fileList = new ArrayList<File>();
		generateFileList(rootFile);
	}
	
	public ArrayList<File> getFileList() {
		return fileList;
	}
	
	/*public static void main(String[] args) {
		//FileFinder ff = new FileFinder("c:/Users/Student38/Desktop/projekt/drzewko");
		FileFinder ff = new FileFinder("src/main/ressources");
		for (File f : ff.getFileList()) {
			System.out.println(f.getAbsolutePath());
		}
	}*/
	
}
