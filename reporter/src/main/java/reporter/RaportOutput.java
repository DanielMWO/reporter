package reporter;

import java.util.List;

public class RaportOutput {

	private String header;
	
	private List<RaportField> raportFields;
	
	public RaportOutput(String header, List<RaportField> raportFields) {
		this.header = header;
		this.raportFields = raportFields;
	}

	public String getHeader() {
		return header;
	}

	public List<RaportField> getRaportFields() {
		return raportFields;
	}
	
}
