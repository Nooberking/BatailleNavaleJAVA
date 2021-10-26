package jeu;

public enum Case {
	VIDE('-'),// case vide ou pas encore cibl�e
	INTACT('O'),//case occup�e par un bateau du joueur 
	TOUCHE('X'),//bateau touch�
	COULE('C'),// case ayant provoqu� le naufrage d'un bateau
	MANQUE('M'); // tir manqu�
	
	private char valeurCase; //affichage sur le plateau
	
	private Case (char valeurCase) {
		this.valeurCase = valeurCase; 	
	}
	
	public char getValeurCase() {
		return this.valeurCase; 
	}

}
