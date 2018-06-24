package VisualizationExcel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import reporter.RaportField;
import reporter.RaportOutput;
import reporter.Repository;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DataToExcel {

	
	// Initializing data to insert into the excel file

	public void writeRaportToExcel(RaportOutput output, String[] columns) {
		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Sheet
		Sheet sheet = workbook.createSheet(output.getHeader());

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.GREEN.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);
						
		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("MM-dd-yyyy"));

		List<RaportField> fields = output.getRaportFields();
		
		// Create Other rows and cells with employees data
		int rowNum = 1;
		for (RaportField field : fields) {
			Row row = sheet.createRow(rowNum++);
			
			row.createCell(0).setCellValue(field.getRaportUnit());
			row.createCell(1).setCellValue(field.getNumberOfHours());			
		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(output.getHeader()+".xls");
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) throws IOException, InvalidFormatException {
//		String[] columns = { "Employee", "Hours" };
//		
//		Repository repo = new Repository();
//		
//		RaportOutput raportOutput = repo.getRaportOneOutput();
//				
//		DataToExcel excel = new DataToExcel();
//		
//		excel.writeRaportToExcel(raportOutput, columns);
//	}

}
