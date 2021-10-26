package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;

import jeu.Case;
import jeu.EtatBateau;
import jeu.Flotte;
import jeu.Joueur;
import jeu.Plateau;
import jeu.Position;

public class ThreadPartie extends Thread{
	int id; 
	private Joueur j1; 
	private Joueur j2;
	BufferedReader inJ1 ;
	BufferedReader inJ2 ;
	DateFormat format;
	Date date;
	
	static PrintWriter outJ1; 
	static PrintWriter outJ2; 
	
	public ThreadPartie(int id, Socket joueur1, Socket joueur2, Date date, DateFormat format) {
		try {
			this.date =date; 
			this.format =format;
			this.id  = id;
			this.j1 = new Joueur(); 
			this.j2 = new Joueur(); 
			inJ1 = new BufferedReader(new InputStreamReader(joueur1.getInputStream()));
			inJ2 = new BufferedReader(new InputStreamReader(joueur2.getInputStream())); 
			outJ1 = new PrintWriter(joueur1.getOutputStream(),true); 
			outJ2 = new PrintWriter(joueur2.getOutputStream(),true);

			//saisie des pseudos
			outJ1.println("Bienvenue dans le jeu de Bataille Navale !\nSaisis ton Pseudo :"); 
			outJ2.println("Bienvenue dans le jeu de Bataille Navale !\nEn attente que joueur 1 saisisse son Pseudo ...");
			outJ1.println("ton tour");// permeet d'activer le scanner chez le client
			j1.setPseudo(inJ1.readLine());
			outJ1.println("Enchanté " + j1.getPseudo() + ".\nEn attente que joueur 2 saisisse son Pseudo..."); 
			outJ2.println("Le joueur 1 a saisi son Pseudo !\nSaisis ton Pseudo : "); 
			outJ2.println("ton tour");
			
			//placement des bateaux
			j2.setPseudo(inJ2.readLine());outJ2.println("Le joueur 1 place ces bateaux ...");
			placeFlotte(inJ1, outJ1, j1);
			outJ1.println("Le joueur 2 place ces bateaux ...");
			placeFlotte(inJ2, outJ2, j2);
			
			outJ1.println("Ca y est tout est en place, la partie peut commencer !");
			outJ2.println("Ca y est tout est en place, la partie peut commencer !");
		}catch (Exception e) {}
	}
	
	public void afficherPlateau (PrintWriter outJ, Joueur j) {//permet d'afficher le plateau d'un joueur dans sa console
		
		String plateau = j.getMonPlateau().toString(); 
		outJ.println("Voici ton plateau : \n" + plateau); 	
	}
	
	public void placeFlotte (BufferedReader inJ, PrintWriter outJ, Joueur j) {// permet de placer les bateaux d'un joueur 
		try {
			this.afficherPlateau(outJ, j);
			outJ.println("A toi de placer tes bateaux ! Pour se faire tu pourras saisir la case de départ de ton bateau et la case de fin en suivant le modèle 'COLONNELigne'. Exemple : C5") ;
			outJ.println ("Tu dois placer : \n "
					+ "- un Porte-Avion (5 cases)\n"
					+ "- un Croiseur (4 cases)\n"
					+ "- deux Contre-torpilleurs (3 cases)\n"
					+ "- un Torpilleur (2 cases)\n"); 
			int tailleBateau =  0; 
			int tailleNecessaire = 5; 

			Flotte flotte = new Flotte(); 
			Plateau plateau = new Plateau(); 
			while (tailleBateau != tailleNecessaire) 
			{
				switch (tailleNecessaire) {

				case 5 : //porte-avion
					//saisie des positions
					outJ.println("Place ton Porte-Avion (5 cases)\n Saisis la case de départ : ");
					outJ.println("ton tour");
					Position caseDepart = Position.valueOf(inJ.readLine());
					outJ.println("Saisis la case de fin : "); 
					outJ.println("ton tour");
					Position caseFin =Position.valueOf(inJ.readLine());
					
					if( !caseDepart.aligne(caseFin)) {// Si les positions choisies ne sont pas alignées
						outJ.println("Erreur ! Les cases choisies ne sont pas alignés !");
						break; 
					}
					else {
						tailleBateau = caseDepart.nbCases(caseFin); 
						if(tailleBateau != tailleNecessaire) {//Si le nombre de cases choisies ne correspond pas à la taille du bateau
							outJ.println("Erreur ! Le nombre de cases choisies ne correspond pas !");
							break;
						}
						else {
							//ajout du bateau dans la flotte et le plateau
							tailleNecessaire -=1;
							flotte.setPorteAvion(caseDepart, caseFin);
							plateau.ajoutBateau(flotte.getPorteAvion());
							//l'absence de brek ici est normal comma ça nous pouvons passer au cas suivant 
							//et si une erreur est produite, la boucle reprendra du dernier cas concerné par l'erreur.
						}
					}

				case 4 :// Croiseur
					outJ.println(plateau);
					outJ.println("Place ton Croiseur (4 cases)\n Saisis la case de départ : ");
					outJ.println("ton tour");
					caseDepart = Position.valueOf(inJ.readLine());
					outJ.println("Saisis la case de fin : "); 
					outJ.println("ton tour");
					caseFin =Position.valueOf(inJ.readLine());
					
					if( !caseDepart.aligne(caseFin)) {
						outJ.println("Erreur ! Les cases choisies ne sont pas alignés !");
						break; 
					}
					else {
						tailleBateau = caseDepart.nbCases(caseFin); 
						if(tailleBateau != tailleNecessaire) {
							outJ.println("Erreur ! Le nombre de cases choisies ne correspond pas !");
							break;
						}
					
						else {
							tailleNecessaire -=1 ; 
							flotte.setCroiseur(caseDepart, caseFin);
							plateau.ajoutBateau(flotte.getCroiseur()); 
						}
					}

				case 3 ://Contre-torpilleur 1
					outJ.println(plateau);
					outJ.println("Place ton premier contre-torpilleur (3 cases)\n Saisis la case de départ : ");
					outJ.println("ton tour");
					caseDepart = Position.valueOf(inJ.readLine());
					outJ.println("Saisis la case de fin : "); 
					outJ.println("ton tour");
					caseFin =Position.valueOf(inJ.readLine());
					if( !caseDepart.aligne(caseFin)) {
						outJ.println("Erreur ! Les cases choisies ne sont pas alignés !");
						break; 
					}
					else {
						tailleBateau = caseDepart.nbCases(caseFin); 
						if(tailleBateau != tailleNecessaire) {
							outJ.println("Erreur ! Le nombre de cases choisies ne correspond pas !");
							break;
						}
						else {
							tailleNecessaire -=1 ; 
							flotte.setContreTorpilleur1(caseDepart, caseFin);
							plateau.ajoutBateau(flotte.getContreTorpilleur1());
						}
					}

				case 2 ://Contre-torpilleur 2
					outJ.println(plateau);
					outJ.println("Place ton deuxième contre-torpilleur (3 cases)\n Saisis la case de départ : ");
					outJ.println("ton tour");
					caseDepart = Position.valueOf(inJ.readLine());
					outJ.println("Saisis la case de fin : "); 
					outJ.println("ton tour");
					caseFin =Position.valueOf(inJ.readLine());
					if( !caseDepart.aligne(caseFin)) {
						outJ.println("Erreur ! Les cases choisies ne sont pas alignés !");
						break; 
					}
					else {
						tailleBateau = caseDepart.nbCases(caseFin); 
						if(tailleBateau != tailleNecessaire+1) {//Dans le cas précédent, la taille nécessaire a été décrémentée alors 
							//qu'il s'agit d'un bateau de même taille que le précédent pour faire la séparation dans le switch case, d'ou le +1
							outJ.println("Erreur ! Le nombre de cases choisies ne correspond pas !");
							break;
						}
						else {
							tailleNecessaire -=1 ; 
							flotte.setContreTorpilleur2(caseDepart, caseFin);
							plateau.ajoutBateau(flotte.getContreTorpilleur2());

						}
					}

				case 1 ://Torpilleur
					outJ.println(plateau);
					outJ.println("Place ton Torpilleur (2 cases)\n Saisis la case de départ : ");
					outJ.println("ton tour");
					caseDepart = Position.valueOf(inJ.readLine());
					outJ.println("Saisis la case de fin : "); 
					outJ.println("ton tour");
					caseFin =Position.valueOf(inJ.readLine());
					if( !caseDepart.aligne(caseFin)) {
						outJ.println("Erreur ! Les cases choisies ne sont pas alignés !");
						break; 
					}
					else {
						tailleBateau = caseDepart.nbCases(caseFin); 
						if(tailleBateau != tailleNecessaire+1) {
							outJ.println("Erreur ! Le nombre de cases choisies ne correspond pas !");
							break;
						}
						else {
							tailleNecessaire -=1 ; 
							flotte.setTorpilleur(caseDepart, caseFin);
							plateau.ajoutBateau(flotte.getTorpilleur());
						}
					}
				default : // association joueur-flotte-plateau
					j.setFlotte(flotte);
					tailleBateau = 0 ;
					j.setMonPlateau(plateau);
					outJ.println(j.getMonPlateau());
					outJ.println("Ta flotte est prête !");	
				}
			}
		}catch (Exception e) {}	
	}
	
	public boolean tourDeJeu(BufferedReader inJ, PrintWriter outJ, Joueur j, PrintWriter outV,  Joueur victime) {// Permet de définir un tour complet d'un joueur
		try {
			Plateau joueurChange = j.getPlateauAdverse();
			Plateau victimeChange = victime.getMonPlateau();
			outJ.println("C'est à toi de jouer ! "); 
			outJ.println("Voici l'état de ta flotte : \n" + j.getMonPlateau() + "\n");
			outJ.println("Voici ton avancée\n" + joueurChange);
			boolean dejaVise = true; 
			while(dejaVise) {
				//début de l'attaque
				outJ.println("Il est temps de choisir la case que tu souhaites attaquer !\n Saisis la case cible : ");
				outJ.println("ton tour"); 
				Position cible = Position.valueOf(inJ.readLine()); 
				if (j.getPlateauAdverse().getCase(cible) != Case.VIDE ) {//vérification si la case a déjà été ciblée précédemment.
					outJ.println("ERREUR : La case a déjà été ciblée !");
				}
				else {
					dejaVise =false; 
					EtatBateau resultat = victime.getFlotte().touche(cible);
					switch (resultat) {
					case PASTOUCHE : 
						outJ.println("OH NON ! Tu as manqué ! "); 
						
						joueurChange.setCase(cible, Case.MANQUE);
						victimeChange.setCase(cible, Case.MANQUE);
						outV.println("Ton adverse a manqué !!!");
						break;
						
					case TOUCHE : 
                        outJ.println("OH YES ! Tu as touché ! "); 
						joueurChange.setCase(cible, Case.TOUCHE);
						victimeChange.setCase(cible, Case.TOUCHE);
						outV.println("Ton adverse a Touché !!!");
						break;
						
					case COULE : 
						outJ.println("OHHH ! Tu as coulé un bateau ! "); 
						joueurChange.setCase(cible, Case.COULE);
						victimeChange.setCase(cible, Case.COULE);
						outV.println("Ton adverse a coulé un bateau !!!");
						break;
						
					default:
						break;
					}
				}
				
			}
			//actualisation des plateaux.
			j.setPlateauAdverse(joueurChange);
			victime.setMonPlateau(victimeChange) ;
			
			return victime.getFlotte().EstDecimee();
		} catch (IOException e) {return false;}
	}
	
	public void run() {
		try {
			String pseudo1 = j1.getPseudo(); 
			String pseudo2 = j2.getPseudo();
			boolean finDeJeu = false; 
			boolean tourJ1 = true; 
			
			System.out.println(format.format(date) + " : Partie n°"+this.id+ " : " + pseudo1 + " vs " + pseudo2 );
			while (!finDeJeu) {
				if(tourJ1) {//le Joueur 1 attaque 
					tourJ1 =false ;
					outJ2.println("Ton adversaire choisit sa cible ...");
					finDeJeu  = tourDeJeu(inJ1, outJ1, j1, outJ2, j2);
					}
				else {//le Joueur 2 attaque
					tourJ1 = true;
					outJ1.println("Ton adversaire choisit sa cible ...");
					finDeJeu  = tourDeJeu(inJ2, outJ2, j2, outJ1, j1);
				}
			}
			if(tourJ1) {//Le Joueur 2 a gagné
				outJ2.println("Tu es le grand vainqueur !!! "); 
				outJ1.println("Tu as perdu...."); 
				System.out.println(format.format(date) + " : " + "Le vainqueur de la partie n°"+this.id+" est : " + pseudo2);
			}
			else {//Le  Joueur 1 a gané
				outJ1.println("Tu es le grand vainqueur !!! "); 
				outJ2.println("Tu as perdu...."); 
				System.out.println(format.format(date) + " : " + "Le vainqueur de la partie n°"+this.id + " est : " + pseudo1);	
			}
			inJ1.close();
			inJ2.close();
			outJ1.close();
			outJ2.close();
			
		} catch (Exception e) {}
	}
	

}
