package fileCreators;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteCsvWriterProduct extends WriterProduct {
  
	private BufferedWriter out;
	
	public ConcreteCsvWriterProduct() throws IOException {
		out = new BufferedWriter(new FileWriter(".\\Freizeitbad.csv"));
	}
	
	@Override
	public void fuegeZeileHinzu(Object obj) throws IOException {
		out.write(((Freizeitbad) obj).gibFreizeitbadZurueck(';'));
		out.close();
	}

}
