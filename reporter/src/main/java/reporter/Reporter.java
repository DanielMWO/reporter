package reporter;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.DefaultParser;

@SuppressWarnings("deprecation")
public class Reporter {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		Option help = new Option ("help", "display Help");
		
		Option path   = OptionBuilder.withArgName( "path" )
                .hasArg()
                .withDescription(  "use given path for report" )
                .create( "path" );
		
		Option years   = OptionBuilder.withArgName( "years" )
                .hasArg()
                .withDescription(  "use given years for report" )
                .create( "y" );
		
		Option months   = OptionBuilder.withArgName( "months" )
                .hasArg()
                .withDescription(  "use given months for report" )
                .create( "m" );
		
		Option days   = OptionBuilder.withArgName( "days" )
                .hasArg()
                .withDescription(  "use given days for report" )
                .create( "d" );
		
		Option users   = OptionBuilder.withArgName( "users" )
                .hasArg()
                .withDescription(  "use given users for report" )
                .create( "u" );
		
		Option projects   = OptionBuilder.withArgName( "projects" )
                .hasArg()
                .withDescription(  "use given projects for report" )
                .create( "p" );
		
		Option type   = OptionBuilder.withArgName( "type" )
                .hasArg()
                .withDescription(  "type of report" )
                .create( "t" );
		
		Option output   = OptionBuilder.withArgName( "output type" )
                .hasArg()
                .withDescription(  "type of output for report" )
                .create( "o" );
		
		Options options = new Options();
		options.addOption( help );
		options.addOption( path );//
		options.addOption( years );
		options.addOption( months );
		options.addOption( days );
		options.addOption( users );//
		options.addOption( projects );//
		options.addOption( type );
		options.addOption( output );//
			
		// create the parser
		CommandLineParser parser = new DefaultParser();
		try {
	        // parse the command line arguments
	        CommandLine line = parser.parse( options, args );
	        
	        // has the path argument been passed?
	        if( line.hasOption( "path" ) ) {
	        	if( line.hasOption( "t" ) ) {
		        	String path1 = line.getOptionValue( "path" );
		        	String type1 = line.getOptionValue( "t" );
		        	System.out.println(path1);
		        	if (type1.equals("PerPerson")) {
		        		MainApp.runAppRap1(path1);
		        	}
		        	if (type1.equals("PerProjekt")) {
		        		MainApp.runAppRap2(path1);
		        	}

		        }

	        }
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