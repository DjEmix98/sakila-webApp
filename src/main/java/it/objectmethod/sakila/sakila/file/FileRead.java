package it.objectmethod.sakila.sakila.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;


public class FileRead {

	public List<String[]> leggiTutto(Reader reader) throws IOException {
		
		CSVReader csvReader = new CSVReader(reader);
	    List<String[]> lista = new ArrayList<>();
	    lista = csvReader.readAll();
	    reader.close();
	    csvReader.close();
	    return lista;
	}
	
	public static  List<String[]> lettura() throws Exception {
		FileRead csv = new FileRead();
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("C:\\csv\\Attori.csv"));
		Reader reader =  new BufferedReader(new InputStreamReader(inputStream));
		return csv.leggiTutto(reader);
	}
	
	
}
