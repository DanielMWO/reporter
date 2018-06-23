package reporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IExcelParser {
	ArrayList<Record> GetAllRecords(ArrayList<File> files) throws FileNotFoundException, IOException;
}
