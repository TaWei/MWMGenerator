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
import org.hibernate.Session;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import mwm.hibernate.HibernateUtil;

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

		for (CSVRecord record : records) {
		    Map<String,String> rowMap = record.toMap();
		    String tickerName = rowMap.get(TICKER_COLUMN_NAME);
		    rowMap.remove(TICKER_COLUMN_NAME);
    		for (Map.Entry<String, String> entry : rowMap.entrySet())
    		{
    		    String x = tickerName + " " + entry.getKey() + "/" + entry.getValue();
    		    Session session = HibernateUtil.getSessionFactory().openSession();
    			session.beginTransaction();
    			session.getTransaction().commit();
    			session.close();
    		}
		}
		
	}
	
	
}
