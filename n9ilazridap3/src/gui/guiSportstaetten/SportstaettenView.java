package gui.guiSportstaetten;
   
import business.FreizeitbaederModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class SportstaettenView {
	
	private FreizeitbaederModel freizeitbaederModel;
	private SportstaettenControl sportstaettenControl;
	
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane     				       
 		= new  Pane();
    	private Label lblAnzeigeFreizeitbaeder     
 		= new Label("Anzeige Freizeitbäder");
    	private TextArea txtAnzeigeFreizeitbaeder  = new TextArea();
    	private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public SportstaettenView(SportstaettenControl sportstaettenControl, Stage primaryStage,
			FreizeitbaederModel freizeitbaederModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von Sportstätten");
    		primaryStage.show();
    		this.sportstaettenControl = sportstaettenControl;
        	this.freizeitbaederModel = freizeitbaederModel;
    		this.initKomponenten();
    		this.initListener();
    	}
    	
		private void initKomponenten(){
    		// Label
       	lblAnzeigeFreizeitbaeder.setLayoutX(310);
    		lblAnzeigeFreizeitbaeder.setLayoutY(40);
    		Font font = new Font("Arial", 24);
    		lblAnzeigeFreizeitbaeder.setFont(font);
    		lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeFreizeitbaeder);    
        	// Textbereich	
        	txtAnzeigeFreizeitbaeder.setEditable(false);
     		txtAnzeigeFreizeitbaeder.setLayoutX(310);
    		txtAnzeigeFreizeitbaeder.setLayoutY(90);
     		txtAnzeigeFreizeitbaeder.setPrefWidth(220);
    		txtAnzeigeFreizeitbaeder.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeFreizeitbaeder);        	
        	// Button
          	btnAnzeigeFreizeitbaeder.setLayoutX(310);
        	btnAnzeigeFreizeitbaeder.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeFreizeitbaeder); 
   }
   
   private void initListener() {
	    btnAnzeigeFreizeitbaeder.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeFreizeitbadAn();
	        	} 
   	    });
    }
   
    void zeigeFreizeitbadAn(){
    		if(freizeitbaederModel.getFreizeitbad() != null){
    			txtAnzeigeFreizeitbaeder.setText(
    				freizeitbaederModel.getFreizeitbad()
 				.gibFreizeitbadZurueck(' '));
    		}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Freizeitbad aufgenommen!");
    		}
    }	
   
    void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(meldung)
 			.zeigeMeldungsfensterAn();
    }	
    
}