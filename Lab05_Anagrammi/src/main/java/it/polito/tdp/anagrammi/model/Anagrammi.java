package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;

public class Anagrammi {

	
	ParolaDAO dizionario = new ParolaDAO();
	
	public void calcolaAnagrammi(String parola, List<String> corretti, List<String> errati) {
				
		permutazioni(parola, corretti, errati, "", 0);
			
	}
	
	
	private void permutazioni(String parola, List<String> corretti, List<String> errati, String parziale, int livello) {
		
		if(parola.length()==0) {
			
			if(dizionario.esisteParola(parziale)) {
				corretti.add(parziale);
			} else {
				errati.add(parziale);
			}
			
		} else {
			
			for(int i=0; i<parola.length(); i++) {
				
				String nuovaParola = parola.substring(0, i) + parola.substring(i+1);
				String nuovaParziale = parziale+parola.charAt(i);
				
				permutazioni(nuovaParola, corretti, errati, nuovaParziale, livello+1);
				
			}
			
			
		}
		
	}
}
