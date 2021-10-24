package jeu;

import java.util.Arrays;

public class Plateau {
		/*Le plateau de jeu est repr�sent� par un tableau de 10 * 10 cases.
		 * Les cases sont not�es de 1 � 10 pour les lignes et de A � J pour les colonnes.
		 */
	private Case[][] tableau;

	public Plateau() {
		//Le constructeur par d�faut permettra de cr�er un plateau "vide", avec des tirets pour pour repr�senter les emplacements vides.
		super();
		// TODO Auto-generated constructor stub
		this.tableau = new Case[10][10];
		
		  for(int i = 0; i < 10; i++) { 
			  for (int j = 0; j < 10; j++) this.tableau[i][j] = Case.VIDE; 
			  } 
	}
	public Case[][] getTableau() {
		//M�thode permettant de renvoyer le tableau sous format de "case"
		return this.tableau; 
	}
	public Case getCase( int ligne,Colonne c) {
		// permet de renvoyer une case du plateau � partir d'une colonne c et une ligne l
		
		int cInt = c.ordinal(); 
		ligne -= 1 ; 
		return this.tableau[ligne][cInt]; 
		
	}

	public Case getCase (String position) {
		//Permet de renvoyer une case du plateau en saisissant une postion sous le format String. Exemple : "C3"
		int cInt = Colonne.valueOf(""+position.charAt(0)).ordinal(); 
		int ligne = position.charAt(1)-'1'; 
		return this.tableau[ligne][cInt]; 	
	}
	
	public void setCase(int ligne, Colonne c, Case value) {
		//permet de modifier une case du plateau d'apr�s la ligne et la colonne renseign�e
		int cInt = c.ordinal(); 
		ligne -= 1 ;
		this.tableau[ligne][cInt] = value; 	
	}
	
	public void setCase(String position, Case value) {
		//Permet de modifier une case du plateau d'apres la position renseign�e
		int cInt = Colonne.valueOf(""+position.charAt(0)).ordinal(); 
		int ligne = position.charAt(1)-'1';
		this.tableau[ligne][cInt] = value;
	}
	@Override
	public String toString() {
	// Permet d'afficher tout le plateau
		String affichage = "   "; 
		
		// pour afficher les colonnes
		for (Colonne c : Colonne.values()) affichage += c.name() + " ";
		
		for (int i = 0; i<this.tableau.length ; i++) 
		{
			int tailleL = this.tableau[i].length; 
			
			affichage +="\n"+(i+1);//affichage des lignes 
			if (i < 9) affichage +=" "; // pour les lignes 1 � 9, on ajoute un espace suppl�mentaire pour aligner avec la ligne 10
			for (int j = 0; j<tailleL; j++) affichage +=" "+this.tableau[i][j].getValeurCase(); //affichage de la valeur des case
		}
		return affichage ;
	}
	
	
	
	
	
}
