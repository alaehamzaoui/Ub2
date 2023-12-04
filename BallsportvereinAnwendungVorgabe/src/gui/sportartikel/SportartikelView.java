package gui.sportartikel;

import obs.Observable;
import obs.Observer;

//import java.awt.event.WindowEvent;
import javafx.stage.*;
import business.baelle.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import ownUtil.MeldungsfensterAnzeiger;

public class SportartikelView  implements Observer{
	
	private SportartikelControl sportartikelControl;
  	private BaelleModel baelleModel;	
	
    //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane = new  Pane();
    private Label lblAnzeigeTrikots    		= new Label("Anzeige Trikots");
    private Label lblAnzeigeBaelle          = new Label("Anzeige B�lle");
    private TextArea txtAnzeigeTrikots      = new TextArea();
    private TextArea txtAnzeigeBaelle       = new TextArea();  
    private Button btnAnzeigeBaelle         = new Button("Anzeige");
    private Stage stage;
    //-------Ende Attribute der grafischen Oberflaeche-------
     
    public SportartikelView(SportartikelControl sportartikelControl, 
    	Stage stage, BaelleModel baelleModel){
    	Scene scene = new Scene(this.pane, 640, 340);
    	stage.setScene(scene);
    	stage.setTitle("Anzeige von Sportartikeln");
    	stage.show();
    	this.sportartikelControl = sportartikelControl;
    	this.baelleModel = baelleModel;
    	this.baelleModel.addObserver(this);
    	this.stage = stage;
		this.initKomponenten();
		this.initListener();
   	}
  
    private void initKomponenten(){
    	// Label
 	    Font font = new Font("Arial", 20);
 	    lblAnzeigeTrikots.setLayoutX(20);
        lblAnzeigeTrikots.setLayoutY(40);
        lblAnzeigeTrikots.setFont(font);
        lblAnzeigeTrikots.setStyle("-fx-font-weight: bold;"); 
        lblAnzeigeBaelle.setLayoutX(310);
        lblAnzeigeBaelle.setLayoutY(40);
        lblAnzeigeBaelle.setFont(font);
        lblAnzeigeBaelle.setStyle("-fx-font-weight: bold;"); 
        pane.getChildren().addAll(lblAnzeigeTrikots, lblAnzeigeBaelle);    
      	// Textbereiche	
    	txtAnzeigeTrikots.setEditable(false);
       	txtAnzeigeTrikots.setLayoutX(20);
       	txtAnzeigeTrikots.setLayoutY(90);
       	txtAnzeigeTrikots.setPrefWidth(220);
       	txtAnzeigeTrikots.setPrefHeight(185);
       	txtAnzeigeBaelle.setEditable(false);
       	txtAnzeigeBaelle.setLayoutX(310);
       	txtAnzeigeBaelle.setLayoutY(90);
       	txtAnzeigeBaelle.setPrefWidth(300);
       	txtAnzeigeBaelle.setPrefHeight(185);
        pane.getChildren().add(txtAnzeigeBaelle);        	
       	// Buttons
       	btnAnzeigeBaelle.setLayoutX(310);
       	btnAnzeigeBaelle.setLayoutY(290);
       	pane.getChildren().add(btnAnzeigeBaelle); 
    }
   
    private void initListener() {
  	   btnAnzeigeBaelle.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeBaelleAn();
	        	} 
   	    });
  	   stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				SportartikelView.this.baelleModel
				 .removeObserver(SportartikelView.this);
			}
  	   	});
	 }
   
   public void zeigeBaelleAn(){
   		String text = "";
   		for(int i = 0; i < baelleModel.holeBaelle().length; i++) {
   		    text = text + baelleModel.holeBaelle()[i].gibZurueck('|') + "\n";
   		}
   		txtAnzeigeBaelle.setText(text);
    }
    
  //  public void update(Observer obs, Object obj) {
  //	 if(obs.getClass().getSimpleName().equals("BaelleModel")){
   	public void update() {
   		String text = "";
   	 for(int i = 0; i < baelleModel.holeBaelle().length; i++) {
   	 text = text + baelleModel.holeBaelle()[i]
   	.gibZurueck('|') + "\n";
   	 }
   	 txtAnzeigeBaelle.setText(text);
	  }
   
    private void zeigeInformationsfensterAn(String meldung){
 		new MeldungsfensterAnzeiger(AlertType.INFORMATION,
 			"Information", meldung).zeigeMeldungsfensterAn();
    }
    

}
