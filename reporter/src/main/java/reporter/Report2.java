package reporter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Report2 implements IReport {
	
	Repository repository = new Repository();
	ArrayList<Record> records = repository.getRecords();

	@Override
	public RaportOutput getReport(ArrayList<Record> records, HashMap<String, String> options) {

		HashMap<String, Integer> projectsAndHours = new HashMap<String, Integer>();
		
		for (Record record : records) {
			consumeLine(record, projectsAndHours);
		}
		
		ArrayList<RaportField> raportField = new ArrayList<RaportField>();
		
		for (String projectName : projectsAndHours.keySet()) {
			int projectHours = projectsAndHours.get(projectName);
			//RaportField raportField = new RaportField(projectName, projectHours);
		}
		
		return new RaportOutput(null, null);
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
		
	}*/

}
