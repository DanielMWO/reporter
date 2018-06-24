package VisualizationConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import reporter.IRepository;
import reporter.RaportField;
import reporter.RaportOutput;
import reporter.Repository;

public class VisualizationConsole {
	
	public void PrintResult(RaportOutput report, String firstColumnHeader) {
		IRepository repo = new Repository();

		RaportOutput output = report;
		
		if(report == null)
			output = repo.getRaportOneOutput();
						
		List<RaportField> rowsList = output.getRaportFields();
		
		List<List<String>> model = new ArrayList<List<String>>();
				
		for(RaportField field : rowsList) {
			List<String> columns = new ArrayList<String>();
			
			columns.add(field.getRaportUnit());
			columns.add(String.valueOf(field.getNumberOfHours()));	
			
			model.add((ArrayList<String>) columns);
		}		
		
		List<String> headersList = Arrays.asList(firstColumnHeader.toUpperCase(), "HOURS");
		List<List<String>> rowsListToPrint = model;
		
		
		Board board = new Board(50);
		String tableString = board.setInitialBlock(new Table(board, 50, headersList, rowsListToPrint).tableToBlocks()).build().getPreview();
		System.out.println(tableString);
	}
}
