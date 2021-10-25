package jeu;

public class Joueur {
	private String pseudo; 
	private Plateau plateau ;
	private Flotte flotte; 
	
	public Joueur() {
		super(); 
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public Flotte getFlotte() {
		return flotte;
	}

	public void setFlotte(Flotte flotte) {
		this.flotte = flotte;
	}
	
	

}
