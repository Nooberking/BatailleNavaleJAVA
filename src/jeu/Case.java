package jeu;

public enum Case {
	VIDE('-'),
	TOUCHE('X'),
	COULE('C'),
	MONBATEAU('B'),
	MANQUE('M'); 
	
	private char valeurCase; 
	
	private Case (char valeurCase) {
		this.valeurCase = valeurCase; 	
	}
	
	public char getValeurCase() {
		return this.valeurCase; 
	}

}
