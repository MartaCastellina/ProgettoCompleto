package it.polito.tdp.Controller;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.GispICT.FarmacoNelReparto;
import it.polito.tdp.db.LedaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class CercaFramacoLetturaFXMLController {
	private LedaDAO Leda= new LedaDAO();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Indietro;

    @FXML
    private Label label;

    @FXML
    private TextField Ricerca;

    @FXML
    private TextArea Reparti;
    
    @FXML
    private Button Cerca;

    @FXML
    void handleIndietroAction(ActionEvent event) throws IOException {
    	System.out.format("Il farmaco non è presente in magazzino1");
    	Parent secondaSchermataParent=FXMLLoader.load(getClass().getResource("/fxml/FinestraHome.fxml"));
    	Scene secondaSchermataScene=new Scene(secondaSchermataParent);
    	//Questa riga prende le informazioni dello stage
    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(secondaSchermataScene);
    	window.show();
    }
    @FXML
    void Cerca(ActionEvent event) {
    	String s;
    	s=Ricerca.getText();
    	Reparti.setText(Leda.Farmaci(s));

    }
    
    
        	
        
       

    @FXML
    void initialize() {
        assert Indietro != null : "fx:id=\"Indietro\" was not injected: check your FXML file 'CercaFarmacoLettura.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'CercaFarmacoLettura.fxml'.";
        assert Ricerca != null : "fx:id=\"Ricerca\" was not injected: check your FXML file 'CercaFarmacoLettura.fxml'.";
        assert Reparti != null : "fx:id=\"Reparti\" was not injected: check your FXML file 'CercaFarmacoLettura.fxml'.";
        assert Cerca != null : "fx:id=\"Cerca\" was not injected: check your FXML file 'CercaFarmacoLettura.fxml'.";
       
    }
}