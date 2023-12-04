package gui.guiFreizeitbaeder;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import business.FreizeitbaederModel;
import javafx.stage.Stage;

public class FreizeitbaederControl implements observer.Observer{
	
	private FreizeitbaederView freizeitbaederView;
	private FreizeitbaederModel freizeitbaederModel;

	public FreizeitbaederControl(Stage primaryStage){
		this.freizeitbaederModel = freizeitbaederModel.getTheInstance();
		this.freizeitbaederModel.addObserver(this);
		this.freizeitbaederView = new FreizeitbaederView(this, primaryStage, 
			freizeitbaederModel);
		
	}
	
	void schreibeFreizeitbadInDatei(String typ){
	   	try{
	   		if("csv".equals(typ)){
	   			freizeitbaederModel.schreibeFreizeitbadInCsvDatei();
	   			freizeitbaederView.zeigeInformationsfensterAn(
	   				"Das Freizeitbad wurde gespeichert!");
	   		}
	   		else{
	   			freizeitbaederModel.schreibeFreizeitbadInTxtDatei();
	   			freizeitbaederView.zeigeInformationsfensterAn(
	   					"Das Freizeitbad wurde gespeichert!");
	   		}
	    } 
		catch(IOException exc){
			freizeitbaederView.zeigeFehlermeldungAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			freizeitbaederView.zeigeFehlermeldungAn(
				"Unbekannter Fehler beim Speichern!");
		}
    }

	/*@Override
	public void update(Observable obs, Object o) {
		// TODO Auto-generated method stub
		if(obs.getClass().getSimpleName().equals("FreizeitbaederModel")){
			this.freizeitbaederView.zeigeFreizeitbadAn();
		}
	}
	*/
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.freizeitbaederView.zeigeFreizeitbadAn();
	}

}
