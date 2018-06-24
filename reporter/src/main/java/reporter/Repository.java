package reporter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Repository implements IRepository {

	public ArrayList<Record> getRecords() {
		ArrayList<Record> records = new ArrayList<Record>();
				
		SimpleDateFormat dateFormat = new SimpleDateFormat("M-dd-yyyy");
		
		try {
			records.add(new Record(dateFormat.parse("04-02-2018"), "Task1", 8, "Project1", "Jan", "Kowalski"));
			records.add(new Record(dateFormat.parse("05-04-2018"), "Task2", 7, "Project4", "Norbert", "Wojtycza"));
			records.add(new Record(dateFormat.parse("12-13-2017"), "Task3", 2, "Project3", "Artur", "Wojty³a"));
			records.add(new Record(dateFormat.parse("04-29-2018"), "Task4", 1, "Project2", "Milena", "Milenowska"));
			records.add(new Record(dateFormat.parse("08-22-2017"), "Task1", 3, "Project1", "Anita", "Zuzannawska"));
		}
		catch (ParseException e) {
			e.printStackTrace();
		}		
		return records;
	}

	public RaportOutput getRaportOneOutput() {
		ArrayList<RaportField> fields = new ArrayList<RaportField>();
		RaportOutput output;
		
		fields.add(new RaportField("Jan Kowalski", 8));
		fields.add(new RaportField("Jacek Nowak", 33));
		fields.add(new RaportField("Milena Milenowsa", 13));
		fields.add(new RaportField("Anita Zuzannowska", 7));
		
		output = new RaportOutput("Raport 1", fields);
		return output;
	}
}


