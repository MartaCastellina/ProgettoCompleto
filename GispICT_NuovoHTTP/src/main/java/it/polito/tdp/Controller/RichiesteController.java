/**
 * Sample Skeleton for 'Richieste.fxml' Controller Class
 */

package it.polito.tdp.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.GispICT.Richiesta;
import it.polito.tdp.db.MartaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RichiesteController {
	MartaDAO dao=new MartaDAO();
	List<Richiesta> richieste;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Indietro"
    private Button Indietro; // Value injected by FXMLLoader

    @FXML // fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML // fx:id="txtArea"
    private TextArea txtArea; // Value injected by FXMLLoader

    @FXML // fx:id="btnAccept1"
    private Button btnAccept1; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeny1"
    private Button btnDeny1; // Value injected by FXMLLoader

    @FXML // fx:id="btnAccept2"
    private Button btnAccept2; // Value injected by FXMLLoader

    @FXML // fx:id="btnAccept3"
    private Button btnAccept3; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeny2"
    private Button btnDeny2; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeny3"
    private Button btnDeny3; // Value injected by FXMLLoader
    @FXML // fx:id="txtAccettata1"
    private Text txtAccettata1; // Value injected by FXMLLoader

    @FXML // fx:id="txtRifiutata1"
    private Text txtRifiutata1; // Value injected by FXMLLoader

    @FXML // fx:id="txtAccettata2"
    private Text txtAccettata2; // Value injected by FXMLLoader

    @FXML // fx:id="txtAccettata3"
    private Text txtAccettata3; // Value injected by FXMLLoader

    @FXML // fx:id="txtRifiutata2"
    private Text txtRifiutata2; // Value injected by FXMLLoader

    @FXML // fx:id="txtRifiutata3"
    private Text txtRifiutata3; // Value injected by FXMLLoader

    @FXML
    void handleIndietroAction(ActionEvent event) throws IOException {
    	Parent secondaSchermataParent=FXMLLoader.load(getClass().getResource("/fxml/FinestraHome.fxml"));
    	Scene secondaSchermataScene=new Scene(secondaSchermataParent);
    	//Questa riga prende le informazioni dello stage
    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(secondaSchermataScene);
    	window.show();
    }
    @FXML
    void handleAccetta1(ActionEvent event) throws IOException {
    	Richiesta richiesta=new Richiesta();
    	System.out.println(richieste.get(0).toString());
    	richiesta=richieste.get(0);
    	dao.accetta(richiesta);
    	//dao.cancella(richiesta); // NON LA CANCELLA
    	txtAccettata1.setVisible(true);
    	btnAccept1.setVisible(false);
    	btnDeny1.setVisible(false);
    }

    @FXML
    void handleAccetta2(ActionEvent event) throws IOException {
    	Richiesta richiesta=new Richiesta();
    	System.out.println(richieste.get(1).toString());
    	richiesta=richieste.get(1);
    	dao.accetta(richiesta);
    	//dao.cancella(richiesta); // NON LA CANCELLA 
    	txtAccettata2.setVisible(true);
    	btnAccept2.setVisible(false);
    	btnDeny2.setVisible(false);
    }

    @FXML
    void handleAccetta3(ActionEvent event) throws IOException {
    	Richiesta richiesta=new Richiesta();
    	System.out.println("richiesta 3 => " +richieste.get(2).toString());
    	richiesta=richieste.get(2);
    	System.out.println("richiesta 3 => " +richiesta);
    	dao.accetta(richiesta);
    	//dao.cancella(richiesta); // NON LA CANCELLA
    	txtAccettata3.setVisible(true);
    	btnAccept3.setVisible(false);
    	btnDeny3.setVisible(false);
    }
    @FXML
    void handleRifiuta1(ActionEvent event) throws IOException {
    	txtRifiutata1.setVisible(true);
    	btnAccept1.setVisible(false);
    	btnDeny1.setVisible(false);
    }

    @FXML
    void handleRifiuta2(ActionEvent event) throws IOException {
    	txtRifiutata2.setVisible(true);
    	btnAccept2.setVisible(false);
    	btnDeny2.setVisible(false);
    }

    @FXML
    void handleRifiuta3(ActionEvent event) throws IOException {
    	txtRifiutata3.setVisible(true);
    	btnAccept3.setVisible(false);
    	btnDeny3.setVisible(false);
    }
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Indietro != null : "fx:id=\"Indietro\" was not injected: check your FXML file 'Richieste.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Richieste.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Richieste.fxml'.";
        assert btnAccept1 != null : "fx:id=\"btnAccept1\" was not injected: check your FXML file 'Richieste.fxml'.";
        assert btnDeny1 != null : "fx:id=\"btnDeny1\" was not injected: check your FXML file 'Richieste.fxml'.";
        assert btnAccept2 != null : "fx:id=\"btnAccept2\" was not injected: check your FXML file 'Richieste.fxml'.";
        assert btnAccept3 != null : "fx:id=\"btnAccept3\" was not injected: check your FXML file 'Richieste.fxml'.";
        assert btnDeny2 != null : "fx:id=\"btnDeny2\" was not injected: check your FXML file 'Richieste.fxml'.";
        assert btnDeny3 != null : "fx:id=\"btnDeny3\" was not injected: check your FXML file 'Richieste.fxml'.";
        assert txtAccettata1 != null : "fx:id=\"txtAccettata1\" was not injected: check your FXML file 'Richieste.fxml'.";
        assert txtRifiutata1 != null : "fx:id=\"txtRifiutata1\" was not injected: check your FXML file 'Richieste.fxml'.";
        assert txtAccettata2 != null : "fx:id=\"txtAccettata2\" was not injected: check your FXML file 'Richieste.fxml'.";
        assert txtAccettata3 != null : "fx:id=\"txtAccettata3\" was not injected: check your FXML file 'Richieste.fxml'.";
        assert txtRifiutata2 != null : "fx:id=\"txtRifiutata2\" was not injected: check your FXML file 'Richieste.fxml'.";
        assert txtRifiutata3 != null : "fx:id=\"txtRifiutata3\" was not injected: check your FXML file 'Richieste.fxml'.";

        btnAccept1.setVisible(true);
        btnAccept2.setVisible(true);
        btnAccept3.setVisible(true);
        btnDeny1.setVisible(true);
        btnDeny2.setVisible(true);
        btnDeny3.setVisible(true);
        txtAccettata1.setVisible(false);
        txtAccettata2.setVisible(false);
        txtAccettata3.setVisible(false);
        txtRifiutata1.setVisible(false);
        txtRifiutata2.setVisible(false);
        txtRifiutata3.setVisible(false);
        
        
        setTxtArea();
    }

	private void setTxtArea() {
		richieste=new ArrayList<Richiesta>();
		richieste=dao.getRichieste(106);
		for (Richiesta r:richieste) {
			txtArea.appendText("\n"+r.toString()+"\n");
		}
		System.out.println(richieste);
		
	}

}

