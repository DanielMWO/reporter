package reporter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public interface IReport {
	
	public RaportOutput getReport(ArrayList<Record> records, HashMap<String, String> options);

}
