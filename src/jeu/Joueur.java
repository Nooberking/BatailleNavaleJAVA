package jeu;

public class Joueur {
	private String pseudo; 
	private Plateau monPlateau ;// Plateau où sera situe les bateaux du joueur
	private Plateau plateauAdverse;// plateau où sera conservé son avancée 
	private Flotte flotte; 
	
	public Joueur() {
		super(); 
		this.monPlateau = new Plateau(); 
		this.plateauAdverse = new Plateau();
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Plateau getMonPlateau() {
		return monPlateau;
	}

	public void setMonPlateau(Plateau plateau) {
		this.monPlateau = plateau;
	}

	public Flotte getFlotte() {
		return flotte;
	}

	public void setFlotte(Flotte flotte) {
		this.flotte = flotte;
	}

	public Plateau getPlateauAdverse() {
		return plateauAdverse;
	}

	public void setPlateauAdverse(Plateau plateauAdverse) {
		this.plateauAdverse = plateauAdverse;
	}
	
	

}
