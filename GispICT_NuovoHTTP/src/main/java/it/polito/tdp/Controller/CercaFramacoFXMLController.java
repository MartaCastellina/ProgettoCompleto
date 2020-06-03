package it.polito.tdp.Controller;
import it.polito.tdp.GispICT.FarmacoNelReparto;
import it.polito.tdp.db.LedaDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBaseBuilder;
import javafx.scene.control.MenuButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class CercaFramacoFXMLController {
	private FarmacoNelReparto temp;
	private int Qtemp;

	 private LedaDAO Leda= new LedaDAO();
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML
    private Text conferma;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Invia"
    private Button Invia; // Value injected by FXMLLoader

    @FXML // fx:id="Indietro"
    private Button Indietro; // Value injected by FXMLLoader
    
    @FXML
    private Text disponibile;

    @FXML // fx:id="Cerca"
    private Button Cerca; // Value injected by FXMLLoader

    @FXML
    private ComboBox<?> Menureparti;
    @FXML
    private ComboBox<?> MenuQuantita;

    @FXML
    private Text quantitadesiderata;
    @FXML
    private TextField Ricerca;
    
    @FXML
    private ComboBox<?> Menureparti1;

    @FXML
    private Text disponibile1;
    private Boolean mioreparto;

    @FXML
    void handleCercaAction(ActionEvent event) throws IOException {
        Menureparti.getItems().clear();
        Menureparti.setVisible(true);
        disponibile.setVisible(true);
        Menureparti1.getItems().clear();
        Menureparti1.setVisible(true);
        disponibile1.setVisible(true);
    	String s;
    	s=Ricerca.getText();
    	setMenuReparti(s);
    	cancella();
    	 conferma.setText("");
        setMenuRepartiP(s);
    	
    	
    }
    void cancella(){
    	if(Menureparti.getItems().isEmpty())
    	{
    	
    	System.out.format("Il farmaco non è presente in magazzino");
    	Menureparti.setVisible(false);
        disponibile.setText("Medicine is not available");}
    	
    }
    @FXML
    void Selezionafarmaco(ActionEvent event) {
    	FarmacoNelReparto Farmacosel=(FarmacoNelReparto) Menureparti.getValue();
    	setTemp(Farmacosel);
    	int qty= Farmacosel.getQuantita();
    	int list=0;
    	List lista= new ArrayList<Integer>();
    	for(int i=1;i<=qty;i++) {
    		
    		list++;
    		lista.add(list);
    		
    	}
    	MenuQuantita.getItems().addAll(lista);
    	MenuQuantita.setVisible(true);
    	quantitadesiderata.setVisible(true);
    	this.setMioreparto(false);
    }
    @FXML
    void Selezionafarmaco1(ActionEvent event) {
    	FarmacoNelReparto Farmacosel=(FarmacoNelReparto) Menureparti1.getValue();
	setTemp(Farmacosel);
	int qty= Farmacosel.getQuantita();
	int list=0;
	List lista= new ArrayList<Integer>();
	for(int i=1;i<=qty;i++) {
		
		list++;
		lista.add(list);
		
	}
	MenuQuantita.getItems().addAll(lista);
	MenuQuantita.setVisible(true);
	quantitadesiderata.setVisible(true);
	this.setMioreparto(true);

    }
    @FXML
    void selQuantita(ActionEvent event) {
    	
    	MenuQuantita.setVisible(false);
    	quantitadesiderata.setVisible(false);
    	 Menureparti.setVisible(false);
         disponibile.setVisible(false);
         Menureparti1.setVisible(false);
         disponibile1.setVisible(false);
         //setQtemp((int) MenuQuantita.getValue());
    	if(mioreparto)
    		{conferma.setText("Withdraw "+MenuQuantita.getValue()+" "+getTemp().getNomeF()+" from  "+getTemp().getNomeR()+"?");}
    	else
    		conferma.setText("Send a request to "+getTemp().getNomeR()+" for "+MenuQuantita.getValue()+" "+getTemp().getNomeF()+"?");
    	Invia.setVisible(true);

    }
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
    void handleInviaAction(ActionEvent event) {
    	if(mioreparto) {
    Leda.decrementa(getTemp(),(int) MenuQuantita.getValue());
    MenuQuantita.getItems().clear();
    conferma.setText("Withdrawal of "+Leda.riordino(temp.getNomeF())+"");}
    	else
    		conferma.setText("Request sent.");
    Invia.setVisible(false);
    Ricerca.clear();
   
    }

    void setMenuReparti(String s) {
    	List farmaci= new ArrayList<FarmacoNelReparto>();
        farmaci=Leda.listaReparti(s);
        Collections.sort(farmaci);
        Menureparti.getItems().addAll(farmaci);
        }
    void setMenuRepartiP(String s) {
    	List farmaci= new ArrayList<FarmacoNelReparto>();
        farmaci=Leda.listaRepartiP(s);
        Collections.sort(farmaci);
        Menureparti1.getItems().addAll(farmaci);
        }
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Invia != null : "fx:id=\"Invia\" was not injected: check your FXML file 'CercaFarmaco.fxml'.";
        assert Indietro != null : "fx:id=\"Indietro\" was not injected: check your FXML file 'CercaFarmaco.fxml'.";
        assert Cerca != null : "fx:id=\"Cerca\" was not injected: check your FXML file 'CercaFarmaco.fxml'.";
        assert Menureparti != null : "fx:id=\"Menureparti\" was not injected: check your FXML file 'CercaFarmaco.fxml'.";
        Menureparti.setVisible(false);
        assert MenuQuantita != null : "fx:id=\"MenuQuantita\" was not injected: check your FXML file 'CercaFarmaco.fxml'.";
        disponibile.setVisible(false);
        MenuQuantita.setVisible(false);
        quantitadesiderata.setVisible(false);
        Invia.setVisible(false);
        Menureparti1.setVisible(false);
        disponibile1.setVisible(false);
    }
	public FarmacoNelReparto getTemp() {
		return temp;
	}
	public void setTemp(FarmacoNelReparto temp) {
		this.temp = temp;
	}
	public int getQtemp() {
		return Qtemp;
	}
	public void setQtemp(int qtemp) {
		Qtemp = qtemp;
	}
	public Boolean getMioreparto() {
		return mioreparto;
	}
	public void setMioreparto(Boolean mioreparto) {
		this.mioreparto = mioreparto;
	}

}