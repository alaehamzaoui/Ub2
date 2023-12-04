package gui.sportartikel;

import business.baelle.BaelleModel;
import javafx.stage.Stage;

public class SportartikelControl {
	
	private SportartikelView sportartikelView;
	
	private BaelleModel baelleModel;

	public SportartikelControl(Stage stage){
		this.baelleModel = BaelleModel.getInstance();
		this.sportartikelView = new SportartikelView(this, stage, 
			baelleModel);
	}

}
