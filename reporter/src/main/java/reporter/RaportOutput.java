package reporter;

import java.util.List;

public class RaportOutput {

	private String header;
	
	private List<RaportField> raportFields;
	
	private String[] raportHeaders;
	
	public RaportOutput(String header, List<RaportField> raportFields) {
		this.header = header;
		this.raportFields = raportFields;
		raportHeaders = new String[2];
		//raportHeaders[0] = header.split(" ")[3];
		//raportHeaders[1] = header.split(" ")[5];
	}

	public String getHeader() {
		return header;
	}

	public List<RaportField> getRaportFields() {
		return raportFields;
	}
	
	public String[] getRaportHeaders() {
		return raportHeaders;
	}
	
}
