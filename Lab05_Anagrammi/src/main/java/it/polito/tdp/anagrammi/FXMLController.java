package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagrammi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Anagrammi model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCalcolaAnagrammi;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doDisable(ActionEvent event) {
    	
    	if(this.txtCalcolaAnagrammi.getText()!="") {
    		this.btnCalcolaAnagrammi.setDisable(false);
    	}
    	
    }
    
    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {

    	String parola = this.txtCalcolaAnagrammi.getText();
    	
    	if((parola==null) || (!parola.equals(""))) {
    		this.txtAnagrammiCorretti.setText("Devi inserire una parola");
    	}
    	
    	if(!parola.matches("[a-zA-Z]*")) {
    		this.txtAnagrammiCorretti.setText("Hai inserito una parola con formato errato");
    	}
    	
    	List<String> corretti = new ArrayList<>();
    	List<String> errati = new ArrayList<>();
    	
    	model.calcolaAnagrammi(parola, corretti, errati);
    	
    	//TODO: riempire le text area con le liste
    	
    	this.btnCalcolaAnagrammi.setDisable(true);
    }

    @FXML
    void doReset(ActionEvent event) {

    	this.txtCalcolaAnagrammi.clear();
    	this.txtAnagrammiCorretti.clear();
    	this.txtAnagrammiErrati.clear();
    	this.btnCalcolaAnagrammi.setDisable(true);
    	
    }
    
    public void setModel(Anagrammi model) {
    	
    	this.model = model;
    	
    }

    @FXML
    void initialize() {
        assert txtCalcolaAnagrammi != null : "fx:id=\"txtCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
