package reporter;

import java.io.File;
import java.util.ArrayList;

public interface IExcelParser {
	ArrayList<Record> GetAllRecords(ArrayList<File> files);
}
