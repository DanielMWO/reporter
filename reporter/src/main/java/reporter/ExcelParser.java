package reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelParser implements IExcelParser {

	public ArrayList<Record> GetAllRecords(ArrayList<File> files) {
		
		ArrayList<Record> records = new ArrayList<Record>();
		
		for(File file : files) {
			try (InputStream inp = new FileInputStream(file)) {
				Workbook wb = WorkbookFactory.create(inp);
				Sheet sheet;
				Row row;
				Cell cell;
								
				int numberOfSheets = wb.getNumberOfSheets();	
				
				for(int i = 0; i < numberOfSheets ; i++) {				
					sheet = wb.getSheetAt(i);
					
					int numberOfRows = sheet.getPhysicalNumberOfRows();	
					System.out.println(file.getName() + " " + sheet.getSheetName() + " " + numberOfRows);
					
					if (numberOfRows<=1) {
						throw new Exception ("Uwaga, pusty arkusz nr: "+ numberOfSheets + " w pliku: " + file);
					}
					
					for(int j = 1; j < numberOfRows; j++) {
						
						row = sheet.getRow(j);
						
						//sprawdzanie poprawności komórek
						if (String.valueOf(row.getCell(2).getNumericCellValue()) == "") {
							((Cell) row).setCellValue("0");
						}
						
						String fileName = file.getName().substring(0, file.getName().lastIndexOf("."));
						
						String[] fullName = fileName.split("\\_"); 					
						
						System.out.println((int)row.getCell(2).getNumericCellValue());
						
						Record record = new Record(
								row.getCell(0).getDateCellValue(),
								row.getCell(1).getStringCellValue(),
								(int)row.getCell(2).getNumericCellValue(),
								sheet.getSheetName(),
								fullName[1],
								fullName[0]);
						
						records.add(record);					
					}					
					
				}			    		    
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		
		return records;
	}
}
