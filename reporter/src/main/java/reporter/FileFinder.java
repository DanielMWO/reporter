package reporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import VisualizationConsole.VisualizationConsole;

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
	
//	public static void main(String[] args) {
//		//FileFinder ff = new FileFinder("c:/Users/Student38/Desktop/projekt/drzewko");
//		//FileFinder ff = new FileFinder("src/main/resources");
//		FileFinder ff = new FileFinder("src/main/resources/2012/01");
//		for (File f : ff.getFileList()) {
//			System.out.println(f.getAbsolutePath());
//		}
//
//	}
}
	

