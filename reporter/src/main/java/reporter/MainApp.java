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

	// Podanie "root" dirtectory i odepbrtanie losty plik�w

	private static ArrayList<File> getFiles(String root) {
		FileFinder fileFinder = new FileFinder(root);
		ArrayList<File> files = fileFinder.getFileList();
		System.out.println(files.toString());
		return files;
	}
	// Przekazanie listy plik�w i otrzymanie wynikow

	private static ArrayList<Record> getData(ArrayList<File> files) throws FileNotFoundException, IOException {
		IExcelParser parser = new ExcelParser();
		ArrayList<Record> data;
		try {
			data = parser.GetAllRecords(files);
			return data;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Przekazanie Danych do Raportu i odebranie paczki danych
	private static ArrayList<Record> getReport(int type) {
		switch (type) {

		case 1:

			IReport report = new Report1();
			// ArrayList<Record> reportData = report.getReport(date, task, projectName,
			// firstName, lastName);
			return null;

		case 2:

			IReport report2 = new Report1();
			// ArrayList<Record> reportData = report.getReport(date, task, projectName,
			// firstName, lastName);
			return null;

		}

		IReport report = new Report1();
		// ArrayList<Record> reportData = report.getReport(date, task, projectName,
		// firstName, lastName);
		return null;
	}

	// raport typ1 suma po poszczeg�lnych pracownikach
	public static void runAppRap1(String kalatlog) throws FileNotFoundException, IOException {
		files = getFiles(kalatlog);
		System.out.println(files.toString());
		data = getData(files);
		System.out.println(data.toString());
		reportResult = getReport(1);
	}

	// raport D:/Dane/ -y 2018 -m 01 03 12 -d monday -u Kowalski_Jan Nowak_Jan -p
	// Projekt1 -t PerProjekt -o xls
	// raport typ 2 suma po poszczeg�lnyhch projektach

	public static void runAppRap2(String kalatlog) throws FileNotFoundException, IOException {
		files = getFiles(kalatlog);
		System.out.println(files.toString());
		data = getData(files);
		System.out.println(data.toString());
		reportResult = getReport(2);
	}

	public static void runAppRap2(String kalatlog, int rok) {
	}

	
	public static void main(String[] args) throws FileNotFoundException, IOException  {
		
		root = "src/main/resources/2012";
		files = getFiles(root);
		data = getData(files);
		System.out.println("");
		System.out.println(data.toString());
		
	}
	
}
