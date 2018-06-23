package reporter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Repository implements IRepository {

	public ArrayList<Record> getRecords() {
		ArrayList<Record> records = new ArrayList<Record>();
				
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
		
		try {
			records.add(new Record(dateFormat.parse("02-04-2018"), "Task1", 8, "Project1", "Jan", "Kowalski"));
			records.add(new Record(dateFormat.parse("04-05-2018"), "Task2", 7, "Project4", "Norbert", "Wojtycza"));
			records.add(new Record(dateFormat.parse("13-12-2017"), "Task3", 2, "Project3", "Artur", "Wojty³a"));
			records.add(new Record(dateFormat.parse("29-04-2018"), "Task4", 1, "Project2", "Milena", "Milenowska"));
			records.add(new Record(dateFormat.parse("22-08-2017"), "Task1", 3, "Project1", "Anita", "Zuzannawska"));
		}
		catch (ParseException e) {
			e.printStackTrace();
		}		
		return records;
	}
}


