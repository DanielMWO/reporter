package reporter.models;

import java.util.Date;


public class Record {
	public Date Date;
	public String Task;
	public int Hours;
	
	public String ProjectName;
	public String FirstName;
	public String LastName;
	
	public Record(Date date, String task, int hours, String projectName, String firstName, String lastName) {
		Date = date;
		Task = task;
		Hours = hours;
		ProjectName = projectName;
		FirstName = firstName;
		LastName = lastName;
	}
}


