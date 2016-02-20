package mwm;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.Set;

import org.apache.commons.csv.*;

import mwm.entity.Stock;
import mwm.repositories.StockRepository;

public class DataImporter {
	private static String TICKER_COLUMN_NAME = "Ticker";
	public DataImporter(){
		
	}
	
	public CSVParser importCsv(File fileToImport) throws IOException{
		Reader in = null;
		try {
			in = new FileReader(fileToImport);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return CSVFormat.EXCEL.withHeader().parse(in);
	}
	
	public void importPrices(CSVParser records, String classification){
		StockRepository stockRepo = new StockRepository();
		
		Map<String,Integer> headerColumnMap = records.getHeaderMap();
		Set<String> headers = headerColumnMap.keySet();
		for (CSVRecord record : records) {
		    Map<String,String> rowMap = record.toMap();
		    String tickerName = rowMap.get(TICKER_COLUMN_NAME);
		    rowMap.remove(TICKER_COLUMN_NAME);
		    
			for (Map.Entry<String, String> entry : rowMap.entrySet())
			{
			    String x = tickerName + " " + entry.getKey() + "/" + entry.getValue();
			}
		}
	}
	
	
	
	
}
