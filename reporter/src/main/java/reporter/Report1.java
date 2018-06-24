package reporter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Report1 implements IReport{
	
	@Override
	public RaportOutput getReport(ArrayList<Record> records, HashMap<String, String> options) {

		HashMap<String, Integer> peopleAndHours = new HashMap<String, Integer>();
		
		for (Record record : records) {
			consumeLine(record, peopleAndHours);
		}
		
		ArrayList<RaportField> raportFields = new ArrayList<RaportField>();
		
		for (String personName : peopleAndHours.keySet()) {
			int projectHours = peopleAndHours.get(personName);
			RaportField raportField = new RaportField(personName, projectHours);
			raportFields.add(raportField);
		}
				
		return new RaportOutput("Raport 1 \n Projekt \t liczba godzin", raportFields);
	}
	
	private void consumeLine(Record record, HashMap<String, Integer> projectsAndHours) {
		String nameAndSurname = record.FirstName+" "+record.LastName;
		if (projectsAndHours.containsKey(nameAndSurname)) {
			int oldValue = projectsAndHours.get(nameAndSurname);
			int newValue = oldValue + record.Hours;
			projectsAndHours.replace(nameAndSurname, newValue);
		}
		else {
			projectsAndHours.put(nameAndSurname, record.Hours);
		}
	}

	/*public static void main(String[] args) {
		
		Repository repository = new Repository();
		ArrayList<Record> records = repository.getRecords();
		
		Report1 report1 = new Report1();
		RaportOutput raportOutput = report1.getReport(records, null);
		
		System.out.println(raportOutput.getHeader());
		
		for (RaportField raportField : raportOutput.getRaportFields()) {
			System.out.println(raportField.getRaportUnit()+"\t"+raportField.getNumberOfHours());
		}
		
	}*/

}
