package business;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import fileCreators.ConcreteCsvWriterCreator;
import fileCreators.ConcreteTxtWriterCreator;
import fileCreators.WriterCreator;
import fileCreators.WriterProduct;
import observer.Observer;

public final class FreizeitbaederModel implements observer.Observable{
	
	private Freizeitbad freizeitbad;
	private static FreizeitbaederModel theInstance=null;
	private ArrayList<observer.Observer> observers= new ArrayList<observer.Observer>();
	
	private FreizeitbaederModel() {
	}

	public static FreizeitbaederModel getTheInstance() {
		if(theInstance==null)
		theInstance = new FreizeitbaederModel();
		return theInstance;
	}
	
	public Freizeitbad getFreizeitbad() {
		return this.freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
		//setChanged();
		notifyObservers();
	}
	
	public void schreibeFreizeitbadInCsvDatei()
	    throws IOException{
		WriterCreator writerCreator = new ConcreteCsvWriterCreator();
		WriterProduct writer = writerCreator.factoryMethod();
		writer.fuegeZeileHinzu(this.freizeitbad);
 	}
	
	public void schreibeFreizeitbadInTxtDatei()
		    throws IOException{
			WriterCreator writerCreator = new ConcreteTxtWriterCreator();
			WriterProduct writer = writerCreator.factoryMethod();
			writer.fuegeZeileHinzu(this.freizeitbad);
//		    BufferedWriter aus = new BufferedWriter(new FileWriter("Freizeitbad.csv"));
//		    aus.write(this.getFreizeitbad().gibFreizeitbadZurueck(';'));
//	        aus.close();
	 	}

	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.remove(obs);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(int i =0; i<observers.size();i++){
			observers.get(i).update();
		}
	}

}	