package reporter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Report1 implements IReport{
	
	@Override
	public RaportOutput getReport(ArrayList<Record> records, HashMap<String, String> options) {

		HashMap<String, Integer> peopleAndHours = new HashMap<String, Integer>();
		
		for (Record record : records) {
			if (lineAppropriateForConsumption(record, options)) {
				consumeLine(record, peopleAndHours);
			}
		}
		
		ArrayList<RaportField> raportFields = new ArrayList<RaportField>();
		
		for (String personName : peopleAndHours.keySet()) {
			int projectHours = peopleAndHours.get(personName);
			RaportField raportField = new RaportField(personName, projectHours);
			raportFields.add(raportField);
		}
				
		return new RaportOutput("Raport 1 \n Projekt \t liczba godzin", raportFields);
	}
	
	private boolean lineAppropriateForConsumption(Record record, HashMap<String, String> options) {
		if (options.keySet().contains("years")) {
			System.out.println("years filtering");
			System.out.println(options.get("years"));
			if (yearFilter(record, options.get("years"))) {
				return false;
			}
		}
		/*if (options.keySet().contains("months")) {
			System.out.println("months filtering");
			System.out.println(options.get("months"));
			if (monthFilter(record, options.get("months"))) {
				return false;
			};
		}
		if (options.keySet().contains("days")) {
			System.out.println("days filtering");
			System.out.println(options.get("days"));
			if (dayFilter(record, options.get("days"))) {
				return false;
			};
		}
		if (options.keySet().contains("users")) {
			System.out.println("users filtering");
			System.out.println(options.get("users"));
			if (personFilter(record, options.get("users"))) {
				return false;
			};
		}
		if (options.keySet().contains("projects")) {
			System.out.println("projects filtering");
			System.out.println(options.get("projects"));
			if (projectFilter(record, options.get("projects"))) {
				return false;
			};
		}*/
		return true;
	}

	/*private boolean projectFilter(Record record, String string) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean personFilter(Record record, String string) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean dayFilter(Record record, String string) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean monthFilter(Record record, String string) {
		// TODO Auto-generated method stub
		return true;
	}*/

	private boolean yearFilter(Record record, String string) {
		int recordYear = record.Date.getYear()+1900;
		String[] filteredYears = string.split(" ");
		for (String year : filteredYears) {
			if (Integer.parseInt(year) == recordYear) {
				return false;
			}
		}
		return true;
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

	public static void main(String[] args) {
		
		Repository repository = new Repository();
		ArrayList<Record> records = repository.getRecords();
		
		Report1 report1 = new Report1();
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("years", "2016 2017");
		RaportOutput raportOutput = report1.getReport(records, options );
		
		System.out.println(raportOutput.getHeader());
		
		for (RaportField raportField : raportOutput.getRaportFields()) {
			System.out.println(raportField.getRaportUnit()+"\t"+raportField.getNumberOfHours());
		}
		
	}

}
