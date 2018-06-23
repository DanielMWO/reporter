package reporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public interface IExcelParser {
	ArrayList<Record> GetAllRecords(ArrayList<File> files) throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException, ParseException;
}
