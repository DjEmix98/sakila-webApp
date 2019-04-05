package it.objectmethod.sakila.sakila;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.sakila.sakila.entity.Actor;
import it.objectmethod.sakila.sakila.file.ByteWrite;

public class MyOutputStream  {
	
	public static void main(String[] args) throws IOException {
		
		OutputStream os = new OutputStream() {
			
			@Override
			public void write(int b) throws IOException {
				System.out.println("arrivato un int ");
			}
			
		};
		
		List<Actor> attoriList= new ArrayList<>();
		Actor attori = new Actor();
		for(int i=0;i<5;i++) {
			
			attori.setNome(""+i);
			attori.setCognome(""+i*2);
			attoriList.add(attori);
		}
		
		new ByteWrite().attoriToCSV(attoriList, os);
	}

}
