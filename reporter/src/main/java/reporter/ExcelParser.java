package reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelParser implements IExcelParser {

	public ArrayList<Record> GetAllRecords(ArrayList<File> files) throws FileNotFoundException, IOException {
		
		for(File file : files) {
			try (InputStream inp = new FileInputStream(file)) {
				Workbook wb = WorkbookFactory.create(inp);
				
				
				
			}
		}
		
		return null;
	}
}
