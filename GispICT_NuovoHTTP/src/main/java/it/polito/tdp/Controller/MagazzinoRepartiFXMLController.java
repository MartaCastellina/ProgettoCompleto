

package it.polito.tdp.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.GispICT.FarmacoNelReparto;
import it.polito.tdp.GispICT.Reparto;
import it.polito.tdp.db.MartaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class MagazzinoRepartiFXMLController {
	MartaDAO dao=new MartaDAO();
	int id=106;
    @FXML
    private Label medication;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;


    @FXML // fx:id="btnBack"
    private Button btnBack; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtElenco"
    private TextArea txtElenco; // Value injected by FXMLLoader
   

    @FXML
    void handleGoBack(ActionEvent event) throws IOException {
    	Parent secondaSchermataParent=FXMLLoader.load(getClass().getResource("/fxml/FinestraHome.fxml"));
    	Scene secondaSchermataScene=new Scene(secondaSchermataParent);
    	//Questa riga prende le informazioni dello stage
    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(secondaSchermataScene);
    	window.show();
    }
    @FXML
    void popolaTxt1() { 
    	txtElenco.setVisible(true);
    	medication.setVisible(true);
    	String result="";
    	List<FarmacoNelReparto> farmaci=new ArrayList<FarmacoNelReparto>();
    	farmaci=dao.getFarmaciNelReparto(id);
    	for (FarmacoNelReparto f: farmaci) {
    		result+=f.getNomeF()+": "+f.getQuantita()+" units with ExpDate " +f.getScadenza()+"\n";
    	}
    	txtElenco.setText(result);
    }
    /*
    void popolaComboBox() {
    	cmbWard.getItems().clear();
    	List reparti=new ArrayList<Reparto>();
    	reparti=dao.listaReparti();
    	cmbWard.getItems().addAll(reparti);
    	
    }
    */
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	 assert medication != null : "fx:id=\"medication\" was not injected: check your FXML file 'MagazzinoReparti.fxml'.";
         assert txtElenco != null : "fx:id=\"txtElenco\" was not injected: check your FXML file 'MagazzinoReparti.fxml'.";
         assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'MagazzinoReparti.fxml'.";
        // assert cmbWard != null : "fx:id=\"cmbWard\" was not injected: check your FXML file 'MagazzinoReparti.fxml'.";
       // popolaComboBox();
         popolaTxt1();
        
    }
}