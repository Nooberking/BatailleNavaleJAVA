package jeu;

public enum Case {
	VIDE('-'),// case vide ou pas encore ciblée
	INTACT('O'),//case occupée par un bateau du joueur 
	TOUCHE('X'),//bateau touché
	COULE('C'),// case ayant provoqué le naufrage d'un bateau
	MANQUE('M'); // tir manqué
	
	private char valeurCase; //affichage sur le plateau
	
	private Case (char valeurCase) {
		this.valeurCase = valeurCase; 	
	}
	
	public char getValeurCase() {
		return this.valeurCase; 
	}

}
