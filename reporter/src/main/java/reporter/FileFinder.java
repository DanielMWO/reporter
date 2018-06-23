package reporter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class FileFinder {
	
	private ArrayList<File> fileList;
	private String root;
	private File rootFile = new File(root);

	private File[] listFilesFromDirectory(File dir) {
		return dir.listFiles();
	}
	
	private void addFilesToList(File[] vals) {
		Collections.addAll(fileList, vals);
	}
	
	private void generateFileList(File directory) {
		
		if(directory.isDirectory()) {
			for (File f : directory.listFiles()) {
				generateFileList(f);
			}
		}
		else {
			fileList.add(f);
		}
			
	}
	
	public FileFinder(String root) {
		this.root = root;
		this.fileList = new ArrayList<File>();
	}
	
	public ArrayList<File> getFileList() {
		return fileList;
	}
	
}
