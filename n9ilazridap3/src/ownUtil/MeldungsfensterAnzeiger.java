package ownUtil;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MeldungsfensterAnzeiger {
	
	protected String meldung;
	
	public MeldungsfensterAnzeiger(String meldung){
		this.meldung = meldung;
		if(meldung == null || "".equals(meldung)){
			this.meldung = "Die Meldung ist nicht vorhanden.";
		}
	}

    public void zeigeMeldungsfensterAn(){
    	Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Information");
	    alert.setContentText(this.meldung);
	    alert.showAndWait();
    }   

}
