package serveur;

import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Serveur {
	
	public static void main(String[] args) {
		try {
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
			Date date = new Date(); 
			ServerSocket reception = new ServerSocket(1234); 
			System.out.println(format.format(date) + " : " + "Serveur de Jeu Bataille Navale Lancé ! ");
			int idPartie = 1 ; 
			while(true) {
				System.out.println(format.format(date) + " : " + "Partie n°" + idPartie + " créée !");
				Socket joueur1 = reception.accept(); 
				System.out.println(format.format(date) + " : " + "\nUn joueur vient de se connecter ! \nEn attente d'un Joueur 2 ...");
				Socket joueur2 = reception.accept(); 
				System.out.println(format.format(date) + " : " + "Un  autre joueur vient de se connecter ! \nLancement de la partie ...");
				new ThreadPartie(idPartie, joueur1, joueur2, date, format).start(); 
				System.out.println(format.format(date) + " : " + "Partie n°"+ idPartie +" lancée !\n");
				idPartie++;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}

}
