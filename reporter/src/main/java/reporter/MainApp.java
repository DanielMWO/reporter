/**
 * 
 */
package reporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Daniel
 *
 */
public class MainApp {
	
	private static String root;
	private static ArrayList<File> files;
	private static ArrayList<Record> data;
	private static ArrayList<Record> reportResult;
	
	
	
	// raport D:/Dane/ -y 2018 -m 01 03 12 -d monday -u Kowalski_Jan Nowak_Jan -p Projekt1 -t PerProjekt -o xls
	public static void runApp(String kalatlog, String project)  {}
	
	
	
	// Podanie "root" dirtectory  i odepbrtanie losty plików 
	
	private static ArrayList<File> getFiles(String root) {
		FileFinder fileFinder = new FileFinder(root);
		ArrayList<File> files = fileFinder.getFileList();
		return files;
	}
	// Przekazanie listy plików i otrzymanie wynikow
	
	private static ArrayList<Record> getData (ArrayList<File> files) throws FileNotFoundException, IOException {
		IExcelParser parser = new ExcelParser();
		ArrayList<Record> data;
		try {
			data = parser.GetAllRecords(files);
			return data;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	return null;
	}
	
	// Przekazanie Danych do Raportu i odebranie paczki danych 
	private static ArrayList<Record> getReport(){
		IReport report = new Report1();
		//ArrayList<Record> reportData = report.getReport(date, task, projectName, firstName, lastName);
		return null;
	}
		
		public static void runApp (String kalatlog) throws FileNotFoundException, IOException  {
			files = getFiles(kalatlog);
			System.out.println(files.toString());
			data = getData(files);
			System.out.println(data.toString());
			reportResult = getReport();
		}
			
			
			
			
			
		}
	
	

