package VisualizationPlots;

import reporter.IRepository;
import reporter.RaportOutput;
import reporter.Repository;

public class VisualizationPlots {
	public void PrintResult() {
		IRepository repo = new Repository();
		
		RaportOutput output = repo.getRaportOneOutput();
		
		
	}
}
