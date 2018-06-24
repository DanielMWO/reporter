package VisualizationPlots;

import java.awt.Color;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.knowm.xchart.style.Styler.LegendPosition;

import reporter.IRepository;
import reporter.RaportField;
import reporter.RaportOutput;
import reporter.Repository;

public class VisualizationPlots {
	public void PrintPieChartResult(RaportOutput report) {
		IRepository repo = new Repository();
		
		RaportOutput output = report;
		
		if(report == null)
			output = repo.getRaportOneOutput();
				
		VisualizationPlots plots = new VisualizationPlots();
		
		PieChart chart = plots.getChart(output);
	    new SwingWrapper<PieChart>(chart).displayChart();
	}
		
	 public PieChart getChart(RaportOutput output) {
		 
		    // Create Chart
		    PieChart chart = new PieChartBuilder().width(1024).height(768).title(output.getHeader().toUpperCase()).build();
		 
		    // Customize Chart
		    Color[] sliceColors = new Color[] { new Color(224, 68, 14), new Color(230, 105, 62), new Color(236, 143, 110), new Color(243, 180, 159), new Color(246, 199, 182) };
		    chart.getStyler().setLegendVisible(false);
		    chart.getStyler().setAnnotationType(AnnotationType.LabelAndPercentage);
		    chart.getStyler().setAnnotationDistance(.82);
		    chart.getStyler().setPlotContentSize(.9);
		 
		    // Series
		    
		    for(RaportField field : output.getRaportFields()) {
		    	chart.addSeries(field.getRaportUnit(), field.getNumberOfHours());
		    }		   		 
		    return chart;
		  }
}
