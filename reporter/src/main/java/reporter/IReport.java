package reporter;

import java.sql.Date;
import java.util.ArrayList;

public interface IReport {
	
	
	public RaportOutput getReport (Date date, String task, String projectName, String firstName, String lastName);;

}
