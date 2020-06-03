/**
 * Sample Skeleton for 'Alert.fxml' Controller Class
 */

package it.polito.tdp.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class AlertController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Indietro"
    private Button Indietro; // Value injected by FXMLLoader

    @FXML // fx:id="temperatura"
    private Text temperatura; // Value injected by FXMLLoader

    @FXML // fx:id="temperatura1"
    private Text temperatura1; // Value injected by FXMLLoader

    @FXML
    void handleIndietroAction(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Indietro != null : "fx:id=\"Indietro\" was not injected: check your FXML file 'Alert.fxml'.";
        assert temperatura != null : "fx:id=\"temperatura\" was not injected: check your FXML file 'Alert.fxml'.";
        assert temperatura1 != null : "fx:id=\"temperatura1\" was not injected: check your FXML file 'Alert.fxml'.";

    }
}
