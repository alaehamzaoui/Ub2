package gui.guiSportstaetten;

import java.util.Observable;
import java.util.Observer;

import business.FreizeitbaederModel;
import javafx.stage.Stage;

public class SportstaettenControl implements observer.Observer{

	private SportstaettenView sportstaettenView;
	private FreizeitbaederModel freizeitbaederModel;
	
	public SportstaettenControl(Stage primaryStage){
		this.freizeitbaederModel = freizeitbaederModel.getTheInstance();
		this.freizeitbaederModel.addObserver(this);
		this.sportstaettenView = new SportstaettenView(this, primaryStage, freizeitbaederModel);
	}

	/* AUS JAVA UTIL
	@Override
	public void update(Observable obs, Object o) {
		// TODO Auto-generated method stub
		if(obs.getClass().getSimpleName().equals("FreizeitbaederModel")){
			this.sportstaettenView.zeigeFreizeitbadAn();
		}
		
	}
	*/

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.sportstaettenView.zeigeFreizeitbadAn();
	}
}
