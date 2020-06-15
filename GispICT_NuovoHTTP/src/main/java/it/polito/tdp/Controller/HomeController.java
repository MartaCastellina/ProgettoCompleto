/**
 * Sample Skeleton for 'FinestraHome.fxml' Controller Class
 */

package it.polito.tdp.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.GispICT.MartaModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeController {

	
	MartaModel model;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCercaFarmaco"
    private Button btnCercaFarmaco; // Value injected by FXMLLoader

    @FXML // fx:id="btnAggiungi"
    private Button btnAggiungi; // Value injected by FXMLLoader

    @FXML // fx:id="btnStatistiche"
    private Button btnStatistiche; // Value injected by FXMLLoader

    @FXML // fx:id="btnMagazzinoReparti"
    private Button btnMagazzinoReparti; // Value injected by FXMLLoader

    @FXML // fx:id="btnPreleva"
    private Button btnPreleva; // Value injected by FXMLLoader

    @FXML // fx:id="btnInScadenza"
    private Button btnInScadenza; // Value injected by FXMLLoader
   
    @FXML // fx:id="btnRequest"
    private Button btnRequest; // Value injected by FXMLLoader


    @FXML
    void handleAggiungi(ActionEvent event) throws IOException {

    	//Passo il model su cui sto lavorando    	
    	
    	FXMLLoader loader=new FXMLLoader();
    	loader.setLocation(getClass().getResource("/fxml/InserisciFarmaco.fxml"));
    	Parent secondaSchermataParent=loader.load();
    	
    	Scene secondaSchermataScene=new Scene(secondaSchermataParent);
    	//Accediamo al controller e chiamiamo metodo, prende il controller da Scene2
    	InserisciFarmacoController controller= loader.getController();

    	
    	//Questa riga prende le informazioni dello stage
    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(secondaSchermataScene);
    	
    	window.show();
    	
    
    }

    @FXML
    void handleCercaFarmaco(ActionEvent event) throws IOException {
    	//qui bisogna poi passare il model
    	
    	Parent secondaSchermataParent=FXMLLoader.load(getClass().getResource("/fxml/CercaFarmacoLettura.fxml"));
    	Scene secondaSchermataScene=new Scene(secondaSchermataParent);
    	//Questa riga prende le informazioni dello stage
    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(secondaSchermataScene);
    	window.show();
    }

    @FXML
    void handleInScadenza(ActionEvent event) throws IOException {
    	Parent secondaSchermataParent=FXMLLoader.load(getClass().getResource("/fxml/FarmaciInScadenza.fxml"));
    	Scene secondaSchermataScene=new Scene(secondaSchermataParent);
    	//Questa riga prende le informazioni dello stage
    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(secondaSchermataScene);
    	window.show();
    }

    @FXML
    void handleMostraMagazzino(ActionEvent event) throws IOException {
    	Parent secondaSchermataParent=FXMLLoader.load(getClass().getResource("/fxml/MagazzinoReparti.fxml"));
    	Scene secondaSchermataScene=new Scene(secondaSchermataParent);
    	//Questa riga prende le informazioni dello stage
    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(secondaSchermataScene);
    	window.show();

    }

    @FXML
    void handlePreleva(ActionEvent event) throws IOException {
    	Parent secondaSchermataParent=FXMLLoader.load(getClass().getResource("/fxml/PrelevaFarmaco.fxml"));
    	Scene secondaSchermataScene=new Scene(secondaSchermataParent);
    	//Questa riga prende le informazioni dello stage
    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(secondaSchermataScene);
    	window.show();
    }

    @FXML
    void handleStatistiche(ActionEvent event) throws IOException {
    	Parent secondaSchermataParent=FXMLLoader.load(getClass().getResource("/fxml/Statistiche.fxml"));
    	Scene secondaSchermataScene=new Scene(secondaSchermataParent);
    	//Questa riga prende le informazioni dello stage
    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(secondaSchermataScene);
    	window.show();
    }
    @FXML
    void handleRequests(ActionEvent event) throws IOException {
    	Parent secondaSchermataParent=FXMLLoader.load(getClass().getResource("/fxml/Richieste.fxml"));
    	Scene secondaSchermataScene=new Scene(secondaSchermataParent);
    	
    	//Questa riga prende le informazioni dello stage
    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(secondaSchermataScene);
    	window.show();
    }
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCercaFarmaco != null : "fx:id=\"btnCercaFarmaco\" was not injected: check your FXML file 'FinestraHome.fxml'.";
        assert btnAggiungi != null : "fx:id=\"btnAggiungi\" was not injected: check your FXML file 'FinestraHome.fxml'.";
        assert btnStatistiche != null : "fx:id=\"btnStatistiche\" was not injected: check your FXML file 'FinestraHome.fxml'.";
        assert btnMagazzinoReparti != null : "fx:id=\"btnMagazzinoReparti\" was not injected: check your FXML file 'FinestraHome.fxml'.";
        assert btnPreleva != null : "fx:id=\"btnPreleva\" was not injected: check your FXML file 'FinestraHome.fxml'.";
        assert btnInScadenza != null : "fx:id=\"btnInScadenza\" was not injected: check your FXML file 'FinestraHome.fxml'.";
        assert btnRequest != null : "fx:id=\"btnRequest\" was not injected: check your FXML file 'FinestraHome.fxml'.";
       
    }

	public void setModel(MartaModel model) {
		this.model=model;
		
	}
	

	
	
}
