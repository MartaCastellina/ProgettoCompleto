/**
 * Sample Skeleton for 'InserisciFarmaco.fxml' Controller Class
 */

package it.polito.tdp.Controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.GispICT.Farmaco;
import it.polito.tdp.GispICT.FarmacoNelReparto;
import it.polito.tdp.GispICT.MartaModel;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InserisciFarmacoController {
	private MartaModel model;
	MartaDAO dao=new MartaDAO();  

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtIdFarmaco"
    private TextField txtIdFarmaco; // Value injected by FXMLLoader

    @FXML // fx:id="txtNomeFarmaco"
    private TextField txtNomeFarmaco; // Value injected by FXMLLoader

    @FXML // fx:id="txtQty"
    private TextField txtQty; // Value injected by FXMLLoader


    @FXML // fx:id="date"
    private DatePicker date; // Value injected by FXMLLoader

    @FXML // fx:id="comboReparti"
    private ComboBox<?> comboReparti; // Value injected by FXMLLoader

    @FXML // fx:id="btnBack"
    private Button btnBack; // Value injected by FXMLLoader

    @FXML // fx:id="btnConfirm"
    private Button btnConfirm; // Value injected by FXMLLoader
    @FXML // fx:id="allertText"
    private TextArea allertText; // Value injected by FXMLLoader
    @FXML // fx:id="btnVerifica"
    private Button btnVerifica; // Value injected by FXMLLoader


    @FXML
    void handleConfirm(ActionEvent event) throws IOException {
    	   	
     	  	
    	try {

			if (txtIdFarmaco.getText().isEmpty()) {
				allertText.setText("Add the ID");
				return;
			}
			
			if (txtQty.getText().isEmpty()) {
				allertText.setText("Insert qty");
			}    	
		

			// Prendo l'ID in input
			int idFarmaco = Integer.parseInt(txtIdFarmaco.getText());

			
			
			Farmaco farmaco = model.getFarmaco(idFarmaco);
			if (farmaco == null) {
				allertText.setText("There is no medication with this ID, please add a new one");
				return;
			}

			txtNomeFarmaco.setText(farmaco.getNome());
			String nomeFarmaco=farmaco.getNome();
			int qty=Integer.parseInt(txtQty.getText());
			LocalDate dataScadenza=date.getValue();
			
			FarmacoNelReparto farmacoDaInserire=new FarmacoNelReparto(farmaco.getNome(),dataScadenza,idFarmaco,qty,
					"Pneumology",106);
			model.aggiungiFarmacoNelReparto(farmacoDaInserire);
			
			

		} catch (NumberFormatException e) {
			allertText.setText("Insert an IDPharma correct");
		} catch (RuntimeException e) {
			allertText.setText("Error DB Connection");
		}
    	//Da qui in poi è per passare alla prossima Scena
    	Parent secondaSchermataParent=FXMLLoader.load(getClass().getResource("/fxml/FarmacoInserito.fxml"));
    	Scene secondaSchermataScene=new Scene(secondaSchermataParent);
    	//Questa riga prende le informazioni dello stage
    	Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(secondaSchermataScene);
    	window.show();

    }

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
    void handleVerifica(ActionEvent event) {
    	this.model=new MartaModel();
    	try {

			if (txtIdFarmaco.getText().isEmpty()) {
				txtIdFarmaco.setText("Add the ID");
				return;
			}
			int idFarmaco = Integer.parseInt(txtIdFarmaco.getText());
			Farmaco farmaco = model.getFarmaco(idFarmaco);
			txtNomeFarmaco.setText(farmaco.getNome());
			allertText.clear();
    	} catch (NumberFormatException e) {
			allertText.setText("Insert a correct ID-form \n(i.e. only numbers are allowed)");
		} catch (RuntimeException e) {
			txtNomeFarmaco.clear();
			allertText.setText("There is no  medication with this ID. \nPlease send a request to our team!");
		}
    }
    //Questo non lo usiamo più perché abbiamo messo il reparto pneumologia
    void setCombo() {
    	List reparti=new ArrayList <Reparto>();
    	reparti=dao.listaReparti();
    	comboReparti.getItems().addAll(reparti);
    	
    }


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	 assert txtIdFarmaco != null : "fx:id=\"txtIdFarmaco\" was not injected: check your FXML file 'InserisciFarmaco.fxml'.";
         assert txtNomeFarmaco != null : "fx:id=\"txtNomeFarmaco\" was not injected: check your FXML file 'InserisciFarmaco.fxml'.";
         assert txtQty != null : "fx:id=\"txtQty\" was not injected: check your FXML file 'InserisciFarmaco.fxml'.";
         assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'InserisciFarmaco.fxml'.";
         assert comboReparti != null : "fx:id=\"comboReparti\" was not injected: check your FXML file 'InserisciFarmaco.fxml'.";
         assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'InserisciFarmaco.fxml'.";
         assert btnConfirm != null : "fx:id=\"btnConfirm\" was not injected: check your FXML file 'InserisciFarmaco.fxml'.";
         assert allertText != null : "fx:id=\"allertText\" was not injected: check your FXML file 'InserisciFarmaco.fxml'.";
         assert btnVerifica != null : "fx:id=\"btnVerifica\" was not injected: check your FXML file 'InserisciFarmaco.fxml'.";
        
    }

}
