package reporter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Report2 implements IReport {

	@Override
	public RaportOutput getReport(ArrayList<Record> records, HashMap<String, String> options) {

		HashMap<String, Integer> projectsAndHours = new HashMap<String, Integer>();
		
		for (Record record : records) {
			consumeLine(record, projectsAndHours);
		}
		
		ArrayList<RaportField> raportFields = new ArrayList<RaportField>();
		
		for (String projectName : projectsAndHours.keySet()) {
			int projectHours = projectsAndHours.get(projectName);
			RaportField raportField = new RaportField(projectName, projectHours);
			raportFields.add(raportField);
		}
		
		System.out.println("noga");
		
		return new RaportOutput("Raport 2 \n Projekt \t liczba godzin", raportFields);
	}
	
	private void consumeLine(Record record, HashMap<String, Integer> projectsAndHours) {
		if (projectsAndHours.containsKey(record.ProjectName)) {
			int oldValue = projectsAndHours.get(record.ProjectName);
			int newValue = oldValue + record.Hours;
			projectsAndHours.replace(record.ProjectName, newValue);
		}
		else {
			projectsAndHours.put(record.ProjectName, record.Hours);
		}
	}

	/*public static void main(String[] args) {
		
		Repository repository = new Repository();
		ArrayList<Record> records = repository.getRecords();
		
		Report2 report2 = new Report2();
		RaportOutput raportOutput = report2.getReport(records, null);
		
		System.out.println(raportOutput.getHeader());
		
		for (RaportField raportField : raportOutput.getRaportFields()) {
			System.out.println(raportField.getRaportUnit()+"\t"+raportField.getNumberOfHours());
		}
		
	}*/

}
