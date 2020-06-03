/**
 * Sample Skeleton for 'Statistiche.fxml' Controller Class
 */

package it.polito.tdp.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.GispICT.Farmaco;
import it.polito.tdp.GispICT.FarmacoNelReparto;
import it.polito.tdp.db.MartaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class StatisticheController {
	MartaDAO dao=new MartaDAO();
	int id=106;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML
    private ImageView grafico3;
    @FXML
    private ImageView grafico4;

    @FXML
    private ImageView grafico5;

    @FXML
    private ImageView grafico6;

    @FXML
    private ImageView grafico7;

    @FXML
    private ImageView grafico8;

    @FXML
    private ImageView grafico9;

    @FXML
    private ImageView grafico10;

    @FXML // fx:id="grafico"
    private ImageView grafico; // Value injected by FXMLLoader

    @FXML // fx:id="cmbFarmaco"
    private ComboBox<Farmaco> cmbFarmaco; // Value injected by FXMLLoader

    @FXML // fx:id="btnBack"
    private Button btnBack; // Value injected by FXMLLoader
    @FXML // fx:id="image2"
    private ImageView image2; // Value injected by FXMLLoader

    @FXML
    void handleBack(ActionEvent event) throws IOException {
    	
    	Parent secondaSchermataParent=FXMLLoader.load(getClass().getResource("/fxml/FinestraHome.fxml"));
    	Scene secondaSchermataScene=new Scene(secondaSchermataParent);
    	//Questa riga prende le informazioni dello stage
    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(secondaSchermataScene);
    	window.show();
    }
    @FXML
    void handleMostraGrafico(ActionEvent event) {
    	Farmaco f=new Farmaco (1,"Oki");
    	if(cmbFarmaco.getValue().equals(f)) {
    		image2.setVisible(true);
    		grafico.setVisible(false);
    		grafico3.setVisible(false);
    		grafico4.setVisible(false);
    		grafico5.setVisible(false);
    		grafico6.setVisible(false);
    		grafico7.setVisible(false);
    		grafico8.setVisible(false);
    		grafico9.setVisible(false);
    		grafico10.setVisible(false);
    	}
    	 if (cmbFarmaco.getValue().getFID()==2){
    		image2.setVisible(false);
    		grafico.setVisible(true);
    		grafico3.setVisible(false);
    		grafico4.setVisible(false);
    		grafico5.setVisible(false);
    		grafico6.setVisible(false);
    		grafico7.setVisible(false);
    		grafico8.setVisible(false);
    		grafico9.setVisible(false);
    		grafico10.setVisible(false);
    	}
    	 if (cmbFarmaco.getValue().getFID()==3){
     		image2.setVisible(false);
     		grafico.setVisible(false);
     		grafico3.setVisible(true);
     		grafico4.setVisible(false);
    		grafico5.setVisible(false);
    		grafico6.setVisible(false);
    		grafico7.setVisible(false);
    		grafico8.setVisible(false);
    		grafico9.setVisible(false);
    		grafico10.setVisible(false);
     		
     		
     	}
    	 if (cmbFarmaco.getValue().getFID()==4){
      		image2.setVisible(false);
      		grafico.setVisible(false);
      		grafico3.setVisible(false);
      		grafico4.setVisible(true);
    		grafico5.setVisible(false);
    		grafico6.setVisible(false);
    		grafico7.setVisible(false);
    		grafico8.setVisible(false);
    		grafico9.setVisible(false);
    		grafico10.setVisible(false);
      	
      		
      	}
    	 if (cmbFarmaco.getValue().getFID()==5){
     		image2.setVisible(false);
     		grafico.setVisible(false);
     		grafico3.setVisible(false);
     		grafico4.setVisible(false);
     		grafico5.setVisible(true);
     		grafico6.setVisible(false);
     		grafico7.setVisible(false);
     		grafico8.setVisible(false);
     		grafico9.setVisible(false);
     		grafico10.setVisible(false);
     	}
     	 if (cmbFarmaco.getValue().getFID()==6){
      		image2.setVisible(false);
      		grafico.setVisible(false);
      		grafico3.setVisible(false);
      		grafico4.setVisible(false);
     		grafico5.setVisible(false);
     		grafico6.setVisible(true);
     		grafico7.setVisible(false);
     		grafico8.setVisible(false);
     		grafico9.setVisible(false);
     		grafico10.setVisible(false);
      		
      		
      	}
     	 if (cmbFarmaco.getValue().getFID()==7){
       		image2.setVisible(false);
       		grafico.setVisible(false);
       		grafico3.setVisible(false);
       		grafico4.setVisible(false);
     		grafico5.setVisible(false);
     		grafico6.setVisible(false);
     		grafico7.setVisible(true);
     		grafico8.setVisible(false);
     		grafico9.setVisible(false);
     		grafico10.setVisible(false);
       	
       		
       	}
     	if (cmbFarmaco.getValue().getFID()==8){
     		image2.setVisible(false);
     		grafico.setVisible(false);
     		grafico3.setVisible(false);
     		grafico4.setVisible(false);
     		grafico5.setVisible(false);
     		grafico6.setVisible(false);
     		grafico7.setVisible(false);
     		grafico8.setVisible(true);
     		grafico9.setVisible(false);
     		grafico10.setVisible(false);
     	}
     	 if (cmbFarmaco.getValue().getFID()==9){
      		image2.setVisible(false);
      		grafico.setVisible(false);
      		grafico3.setVisible(false);
      		grafico4.setVisible(false);
     		grafico5.setVisible(false);
     		grafico6.setVisible(false);
     		grafico7.setVisible(false);
     		grafico8.setVisible(false);
     		grafico9.setVisible(true);
     		grafico10.setVisible(false);
      		
      		
      	}
     	 if (cmbFarmaco.getValue().getFID()==10){
       		image2.setVisible(false);
       		grafico.setVisible(false);
       		grafico3.setVisible(false);
       		grafico4.setVisible(false);
     		grafico5.setVisible(false);
     		grafico6.setVisible(false);
     		grafico7.setVisible(false);
     		grafico8.setVisible(false);
     		grafico9.setVisible(false);
     		grafico10.setVisible(true);
       	
       		
       	}
     	 else {}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
       
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'Statistiche.fxml'.";
        assert grafico != null : "fx:id=\"grafico\" was not injected: check your FXML file 'Statistiche.fxml'.";
        assert cmbFarmaco != null : "fx:id=\"cmbFarmaco\" was not injected: check your FXML file 'Statistiche.fxml'.";
        assert image2 != null : "fx:id=\"image2\" was not injected: check your FXML file 'Statistiche.fxml'.";
        assert grafico3 != null : "fx:id=\"grafico3\" was not injected: check your FXML file 'Statistiche.fxml'.";
        assert grafico4 != null : "fx:id=\"grafico4\" was not injected: check your FXML file 'Statistiche.fxml'.";
        assert grafico5 != null : "fx:id=\"grafico5\" was not injected: check your FXML file 'Statistiche.fxml'.";
        assert grafico6 != null : "fx:id=\"grafico6\" was not injected: check your FXML file 'Statistiche.fxml'.";
        assert grafico7 != null : "fx:id=\"grafico7\" was not injected: check your FXML file 'Statistiche.fxml'.";
        assert grafico8 != null : "fx:id=\"grafico8\" was not injected: check your FXML file 'Statistiche.fxml'.";
        assert grafico9 != null : "fx:id=\"grafico9\" was not injected: check your FXML file 'Statistiche.fxml'.";
        assert grafico10 != null : "fx:id=\"grafico10\" was not injected: check your FXML file 'Statistiche.fxml'.";

        popola();
        grafico3.setVisible(false);
        grafico4.setVisible(false);
 		grafico5.setVisible(false);
 		grafico6.setVisible(false);
 		grafico7.setVisible(false);
 		grafico8.setVisible(false);
 		grafico9.setVisible(false);
 		grafico10.setVisible(false);
    }
	private void popola() {
		
		List <Farmaco> farmaci=new ArrayList<Farmaco>();
		farmaci=dao.getFarmaci();
		System.out.println(farmaci);
		cmbFarmaco.getItems().addAll(farmaci);
		
	}
}