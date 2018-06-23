package reporter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class FileFinder {
	
	private ArrayList<File> fileList;

	private File[] listFilesFromDirectory(File dir) {
		return dir.listFiles();
	}
	
	private void addFilesToList(File[] vals) {
		Collections.addAll(fileList, vals);
	}
	
	public FileFinder(String root) {
		
	}
	
	public ArrayList<File> getFileList() {
		return fileList;
	}
	
}
