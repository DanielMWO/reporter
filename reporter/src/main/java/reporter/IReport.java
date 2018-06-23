package reporter;

import java.sql.Date;
import java.util.ArrayList;

public interface IReport {
	
	
	public ArrayList<Record> getReport (Date date, String task, String projectName, String firstName, String lastName);;

}
