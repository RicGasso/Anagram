package it.polito.tdp.anagram.model;

import java.util.*;

public class Anagram {
	
	public List<String> anagrammi(String parola){
		List<String> risultato = new ArrayList<String>();
		permuta("", parola, 0, risultato); // lancia la ricorsione
		
		return risultato;
	}
	
	// livello = lunghezza della soluzione parziale
	// livello iniziale = 0
	// parziale = stringa che contiene l'anagramma in fase di costruzione
	// lettere = lettere della parola iniziale che non abbiamo ancora utilizzato
	// lettere = sotto-problema che dobbiamo risolvere
	private void permuta(String parziale, String lettere, int livello, List<String> risultato) {
		if(lettere.length() == 0) { // caso terminale
			//la soluzione parziale è anche una soluzione completa
			//if(parziale è una parola valida){ 
			risultato.add(parziale);
		}else {
			//fai ricorsione
			//sottoproblema = una lettera di "lettere" (un singolo carattere)
			for(int pos= 0; pos<lettere.length(); pos++) {
				char tentativo = lettere.charAt(pos);
				String nuovaParziale = parziale + tentativo;
				String nuovaLettere = lettere.substring(0, pos) + lettere.substring(pos+1);
						//togli il carattere pos da lettere;
				//if(nuovaParziale è un prefisso valido di almeno una parola nel vocabolario)
				//"aqz" -> no; "car" -> si (carro, carrello, ecc)
				permuta(nuovaParziale, nuovaLettere, livello+1, risultato);
			}
		}
		
	}
	
}
