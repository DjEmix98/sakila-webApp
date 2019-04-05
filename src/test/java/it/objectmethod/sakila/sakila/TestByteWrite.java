package it.objectmethod.sakila.sakila;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.sakila.sakila.entity.Actor;
import it.objectmethod.sakila.sakila.file.ByteWrite;

public class TestByteWrite {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ByteWrite write = new ByteWrite();
		List<Actor> attoriList= new ArrayList<>();
		OutputStream out=null;
		out= new FileOutputStream("C:\\csv\\attori.csv");
		Actor attori = new Actor();
		for(int i=0;i<5;i++) {
			
			attori.setNome(""+i);
			attori.setCognome(""+i*2);
			attoriList.add(attori);
		}
		
		
		write.attoriToCSV(attoriList,out);
	}

}
