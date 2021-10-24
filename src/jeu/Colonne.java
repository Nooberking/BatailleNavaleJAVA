package jeu;

public enum Colonne {
	A,B,C,D,E,F,G,H,I,J; 
	
	public Colonne conversionColonne(String colonne) {
		return Colonne.valueOf(colonne);
	}

}
