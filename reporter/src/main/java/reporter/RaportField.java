package reporter;

public class RaportField {
	
	private String raportUnit;
	
	private int numberOfHours;
	
	public RaportField(String raportUnit, int numberOfHours) {
		this.raportUnit = raportUnit;
		this.numberOfHours = numberOfHours;
	}

	public String getRaportUnit() {
		return raportUnit;
	}

	public int getNumberOfHours() {
		return numberOfHours;
	}

}
