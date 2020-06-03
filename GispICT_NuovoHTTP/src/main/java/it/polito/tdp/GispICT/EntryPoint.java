package it.polito.tdp.GispICT;

import javafx.application.Application;
import static javafx.application.Application.launch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import it.polito.tdp.Controller.HomeController;
import it.polito.tdp.db.DBConnectionMarta;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class EntryPoint extends Application  {


	
    @Override
    public void start(Stage stage) throws Exception {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FinestraHome.fxml"));
		AnchorPane root = (AnchorPane)loader.load();
		final HomeController controller = loader.getController();
		MartaModel model = new MartaModel();
		controller.setModel(model);
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        
        stage.setTitle("DigitalMED");
        stage.setScene(scene);
        stage.show();
	
	
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	Thread t2=new Http();
    	t2.start();
    	
    	launch(args);
    	
    }

	

	

}
