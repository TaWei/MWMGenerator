package mwm;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.commons.csv.*;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class DataImporter {
	private static String TICKER_COLUMN_NAME = "Ticker";
	public DataImporter(){
		
	}
	
	public void importCsv(File fileToImport) throws IOException{
		Reader in = null;
		try {
			in = new FileReader(fileToImport);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		CSVParser records = CSVFormat.EXCEL.withHeader().parse(in);
		Map<String,Integer> headerColumnMap = records.getHeaderMap();
		Set<String> headers = headerColumnMap.keySet();
		
		long startTime = System.currentTimeMillis();

		
		
		for (CSVRecord record : records) {
		    Map<String,String> rowMap = record.toMap();
		    String tickerName = rowMap.get(TICKER_COLUMN_NAME);
		    rowMap.remove(TICKER_COLUMN_NAME);
    		for (Map.Entry<String, String> entry : rowMap.entrySet())
    		{
    		    String x = tickerName + " " + entry.getKey() + "/" + entry.getValue();
    		    x = x + "";
    		}
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}
	
	
}
