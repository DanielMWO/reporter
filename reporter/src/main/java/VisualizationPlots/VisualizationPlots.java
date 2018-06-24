package VisualizationPlots;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.knowm.xchart.style.Styler.LegendPosition;

import VisualizationConsole.VisualizationConsole;
import reporter.ExcelParser;
import reporter.FileFinder;
import reporter.IExcelParser;
import reporter.IRepository;
import reporter.RaportField;
import reporter.RaportOutput;
import reporter.Record;
import reporter.Repository;

public class VisualizationPlots {
	public void PrintPieChartResult(RaportOutput report) {
		IRepository repo = new Repository();
		
		RaportOutput output = report;
		
		if(report == null)
			output = repo.getRaportOneOutput();
				
		VisualizationPlots plots = new VisualizationPlots();
		
		PieChart chart = plots.getChart(output);
		
		try {
			BitmapEncoder.saveBitmap(chart, "./" + output.getFileName(), BitmapFormat.PNG);
			Desktop.getDesktop().open(new File("./"+ output.getFileName()+".png").getParentFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
