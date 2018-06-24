package reporter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;

@SuppressWarnings("deprecation")
public class Reporter {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		Option help = new Option ("help", "display Help");
		
		Option path   = OptionBuilder.withArgName( "path" )
                .hasArg()
                .withDescription(  "use given path for report (e.g. D:/Dane/)" )
                .create( "path" );
		
		Option years   = OptionBuilder.withArgName( "years" )
                .hasArg()
                .withDescription(  "use given years for report (e.g. 2018 or 2017 2018)" )
                .create( "y" );
		
		Option months   = OptionBuilder.withArgName( "months" )
                .hasArg()
                .withDescription(  "use given months for report (e.g 03 or 03 05 12)" )
                .create( "m" );
		
		Option days   = OptionBuilder.withArgName( "days" )
                .hasArg()
                .withDescription(  "use given days for report (e.g monday)" )
                .create( "d" );
		
		Option users   = OptionBuilder.withArgName( "users" )
                .hasArg()
                .withDescription(  "use given users for report (e.g.Kowalski_Jan)" )
                .create( "u" );
		
		Option projects   = OptionBuilder.withArgName( "projects" )
                .hasArg()
                .withDescription(  "use given projects for report (e.g.Projekt1)" )
                .create( "p" );
		
		Option type   = OptionBuilder.withArgName( "type" )
                .hasArg()
                .withDescription(  "type of report (PerProjekt or PerPerson) " )
                .create( "t" );
		
		Option output   = OptionBuilder.withArgName( "output" )
                .hasArg()
                .withDescription(  "type of output for report(console or graph or xls)" )
                .create( "o" );
		
		Options options = new Options();
		options.addOption( help );
		options.addOption( path );
		options.addOption( years );
		options.addOption( months );
		options.addOption( days );
		options.addOption( users );
		options.addOption( projects );
		options.addOption( type );
		options.addOption( output );
			
		
		
		
		// create the parser
		CommandLineParser parser = new DefaultParser();
		try {
	        // parse the command line arguments
	        CommandLine line = parser.parse( options, args );
	        
	        // has the path argument been passed?
	        
	        HashMap<String, String> myMap = new HashMap<String, String>();
	        
	        if( line.hasOption( "y" ) ) {
	        	String years1 = line.getOptionValue( "y" );
	        	myMap.put("years", years1);
	        }
	        if( line.hasOption( "m" ) ) {
	        	String months1 = line.getOptionValue( "m" );
	        	myMap.put("months", months1);
	        }
	        if( line.hasOption( "d" ) ) {
	        	String days1 = line.getOptionValue( "d" );
	        	myMap.put("days", days1);
	        }
	        if( line.hasOption( "u" ) ) {
	        	String users1 = line.getOptionValue( "u" );
	        	myMap.put("users", users1);
	        }
	        if( line.hasOption( "p" ) ) {
	        	String projects1 = line.getOptionValue( "p" );
	        	myMap.put("projects", projects1);
	        }

	       if( line.hasOption( "help" ) ) {
	        	

	            String header = "................................HELP...............................";
	            String footer = "..................................................................."+"\n"+"command example: -path src/main/resources/2012 -y 2012 -m may -d monday -u Kowalski_Jan -p Projekt1 -o graph -t PerPerson";
	           
	            HelpFormatter formatter = new HelpFormatter();
	            formatter.printHelp("app", header, options, footer, true);
	    			
	        	
	       }
	        
	        if( line.hasOption( "path" ) ) {
	        	if( line.hasOption( "t" ) ) {
	        		if( line.hasOption( "o" ) ) {
	        			String path1 = line.getOptionValue( "path" );
		        		String type1 = line.getOptionValue( "t" );
		        		String output1 = line.getOptionValue( "o" );
		        		if (output1.equals("console")) {
		        			if (type1.equals("PerPerson")) {
		        				MainApp.runAppRap1(path1, output1, myMap);
		        				//MainApp.runAppRap1(path1);
		        			}
		        			if (type1.equals("PerProjekt")) {
		        				MainApp.runAppRap2(path1, output1, myMap);
		        				//MainApp.runAppRap2(path1);
		        			}
		        		}else if(output1.equals("graph")){
		        			if (type1.equals("PerPerson")) {
		        				MainApp.runAppRap1(path1, output1, myMap);
		        				//MainApp.runAppRap1(path1);
		        			}
		        			if (type1.equals("PerProjekt")) {
		        				MainApp.runAppRap2(path1, output1, myMap);
		        				//MainApp.runAppRap2(path1);
		        			}
		        		}else if(output1.equals("xls")){
		        			if (type1.equals("PerPerson")) {
		        				MainApp.runAppRap1(path1, output1, myMap);
		        				//MainApp.runAppRap1(path1);
		        			}
		        			if (type1.equals("PerProjekt")) {
		        				MainApp.runAppRap2(path1, output1, myMap);
		        				//MainApp.runAppRap2(path1);
		        			}
		        		}else {
		        			System.out.println("Dostępne typy wyniku to: console / graph / xls");
		        		}
	        		}

	        		String path1 = line.getOptionValue( "path" );
	        		String type1 = line.getOptionValue( "t" );
	        		
	        		if (type1.equals("PerPerson")) {
	        			MainApp.runAppRap1(path1);
	        			//MainApp.runAppRap1(path1);
	        		}
	        		if (type1.equals("PerProjekt")) {
	        			MainApp.runAppRap2(path1);
	        			//MainApp.runAppRap2(path1);
	        		}
	        	}else {
	        	System.out.println("Musisz podać ścieżkę oraz typ raportu");}
	        }else {
	        System.out.println("Musisz podać ścieżkę oraz typ raportu");}
	    }
	    catch( ParseException exp ) {
	        // oops, something went wrong
	        System.err.println( "Parsing failed.  Reason: " + exp.getMessage() );
	     } 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


// MainApp
// 
// raport D:/Dane/ -y 2018 -m 01 03 12 -d monday -u Kowalski_Jan Nowak_Jan -p Projekt1 -t PerProjekt -o xls
// 