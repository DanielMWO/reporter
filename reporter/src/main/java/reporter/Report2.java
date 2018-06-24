package reporter;

import java.sql.Date;
import java.util.ArrayList;

public class Report2 implements IReport {
	
	Repository repository = new Repository();
	ArrayList<Record> records = repository.getRecords();

	@Override
	public RaportOutput getReport(Date date, String task, String projectName, String firstName, String lastName) {

		
		
		return null;
	}
	
	public static void main(String[] args) {
		
	}

}
