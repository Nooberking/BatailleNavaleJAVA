package jeu;


public class Plateau {
		/*Le plateau de jeu est représenté par un tableau de 10 * 10 cases.
		 * Les cases sont notées de 1 à 10 pour les lignes et de A à J pour les colonnes.
		 */
	private Case[][] tableau;

	public Plateau() {
		//Le constructeur par défaut permettra de créer un plateau "vide", avec des tirets pour pour représenter les emplacements vides.
		super();
		// TODO Auto-generated constructor stub
		this.tableau = new Case[10][10];
		
		  for(int i = 0; i < 10; i++) { 
			  for (int j = 0; j < 10; j++) this.tableau[i][j] = Case.VIDE; 
			  } 
	}
	public Case[][] getTableau() {
		//Méthode permettant de renvoyer le tableau sous format de "case"
		return this.tableau; 
	}
	public Case getCase( Position position) {
		// permet de renvoyer une case du plateau à partir d'une position
		
		int ligne = position.getLigne();
		int colonne = position.getColonne(); 
		return this.tableau[ligne][colonne]; 
		
	}
	
	public void setCase(Position position, Case value) {
		//permet de modifier une case du plateau d'après la position renseignée
		int ligne = position.getLigne();
		int colonne = position.getColonne(); 
		this.tableau[ligne][colonne] = value; 	
	}

	public void ajoutBateau(Bateau bateau) {// Permet d'ajouter un bateau à l'affichage d'un plateau
		Position[] positions = bateau.getPositionsCases();
		Case[] etatCases = bateau.getEtatCasesOcupees(); 
		for (int i = 0; i < bateau.getTaille(); i++) this.setCase(positions[i], etatCases[i]);	
	}
	
	@Override
	public String toString() {
	// Permet d'afficher tout le plateau
		String affichage = ""; 
		String tagColonnes ="   ";
		int currentLigne = -1 ; 
		
		// pour afficher les colonnes
		for (Position pos : Position.values()) {
			int ligne = pos.getLigne(); 
			if (ligne == 0) tagColonnes += pos.name().charAt(0) + " ";
			if (currentLigne != ligne ) {
				currentLigne = ligne ; 
				affichage += (ligne==0 ?"" : "\n") + (ligne+1) +(ligne< 9 ? "  ": " ");
			}
			affichage += this.tableau[ligne][pos.getColonne()].getValeurCase() + " ";			
			
		}
		affichage = tagColonnes + "\n" + affichage; 
		return affichage ;
	}
	
	
	
	
	
}
