package it.objectmethod.sakila.sakila.file;



import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import it.objectmethod.sakila.sakila.entity.Actor;

@Component
public class ByteWrite {

	public byte[] attoriToCSV(List<Actor> attori, OutputStream out) throws IOException{

		
		
		for(Actor a: attori) {
			out.write(attoreToString(a).getBytes());
		}
		
		return out.toString().getBytes();
	}
	
	public String attoreToString(Actor attore) {
		return attore.getNome()+";"+attore.getCognome()+";";
	}
}
