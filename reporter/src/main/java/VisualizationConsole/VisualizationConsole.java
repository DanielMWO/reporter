package VisualisastionConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import reporter.IRepository;
import reporter.RaportField;
import reporter.RaportOutput;
import reporter.Repository;

public class VisualisationConsole {
	public void PrintResult() {
		IRepository repo = new Repository();
		
		RaportOutput output = repo.getRaportOneOutput();
		
		List<RaportField> rowsList = output.getRaportFields();
		
		List<List<String>> model = new ArrayList<List<String>>();
				
		for(RaportField field : rowsList) {
			List<String> columns = new ArrayList<String>();
			
			columns.add(field.raportUnit);
			columns.add(String.valueOf(field.numberOfHours));	
			
			model.add((ArrayList<String>) columns);
		}		
		
		List<String> headersList = Arrays.asList(output.getHeader(), "HOURS");
		List<List<String>> rowsListToPrint = model;
		
		
		Board board = new Board(50);
		String tableString = board.setInitialBlock(new Table(board, 50, headersList, rowsListToPrint).tableToBlocks()).build().getPreview();
		System.out.println(tableString);
	}
}
