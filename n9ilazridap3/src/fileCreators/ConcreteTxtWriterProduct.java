package fileCreators;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteTxtWriterProduct extends WriterProduct {
  
	private BufferedWriter out;
	
	public ConcreteTxtWriterProduct() throws IOException {
		out = new BufferedWriter(new FileWriter(".\\Freizeitbad.txt"));
	}
	
	@Override
	public void fuegeZeileHinzu(Object obj) throws IOException {
		out.write(("Daten des Freizeitbades:"+((Freizeitbad) obj).gibFreizeitbadZurueck(' ')));
		out.close();
	}

}
