package jeu;

public enum Case {
	VIDE('-'),
	INTACT('O'),
	TOUCHE('X'),
	COULE('C'),
	MANQUE('M'); 
	
	private char valeurCase; 
	
	private Case (char valeurCase) {
		this.valeurCase = valeurCase; 	
	}
	
	public char getValeurCase() {
		return this.valeurCase; 
	}

}
