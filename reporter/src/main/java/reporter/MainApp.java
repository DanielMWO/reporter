/**
 * 
 */
package reporter;

import java.io.File;
import java.util.ArrayList;

/**
 * @author Daniel
 *
 */
public class MainApp {

	
	
	
	// Podanie "root" dirtectory  i odepbrtanie losty plików 
	
	public ArrayList<File> getFiles(String root) {
		FileFinder fileFinder = new FileFinder(root);
		ArrayList<File> files = fileFinder.getFileList();
		return files;
	}
	// Przekazanie listy plików i otrzymanie wynikow
	
	public ArrayList<Record> getData (ArrayList<File> files) {
		IExcelParser parser = new ExcelParser();
		ArrayList<Record> data = parser.GetAllRecords(files);
		return data;
	}
	
	// Przekazanie Danych do Raportu i odebranie paczki danych 
	
	
	
	
}
