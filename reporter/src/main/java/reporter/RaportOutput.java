package reporter;

import java.util.ArrayList;

public class RaportOutput {

	private String header;
	
	private ArrayList<RaportField> raportFields;
	
	public RaportOutput(String header, ArrayList<RaportField> raportFields) {
		this.header = header;
		this.raportFields = raportFields;
	}

	public String getHeader() {
		return header;
	}

	public ArrayList<RaportField> getRaportFields() {
		return raportFields;
	}
	
}
