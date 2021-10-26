package jeu;

public class Flotte {
	private Bateau porteAvion ; //bateau � 5 cases
	private Bateau croiseur; //bateau � 4 cases
	private Bateau contreTorpilleur1; //bateau � 3 cases
	private Bateau contreTorpilleur2; //bateau � 3 cases
	private Bateau torpilleur; //bateau � 2 cases
	private boolean estDecimee = false; 
	
	public Flotte() {
		super(); 
	}

	public Bateau getPorteAvion() {
		return porteAvion;
	}

	public void setPorteAvion (Position debut, Position fin) {
		this.porteAvion = new Bateau(debut,fin) ; 
	}

	public Bateau getCroiseur() {
		return croiseur;
	}

	public void setCroiseur(Position debut, Position fin) {
		this.croiseur = new Bateau (debut, fin);
	}

	public Bateau getContreTorpilleur1() {
		return contreTorpilleur1;
	}

	public void setContreTorpilleur1(Position debut, Position fin) {
		this.contreTorpilleur1 = new Bateau(debut, fin); 
	}

	public Bateau getContreTorpilleur2() {
		return contreTorpilleur2;
	}

	public void setContreTorpilleur2(Position debut, Position fin) {
		this.contreTorpilleur2 = new Bateau(debut,fin);
	}

	public Bateau getTorpilleur() {
		return torpilleur;
	}

	public void setTorpilleur(Position debut, Position fin) {
		this.torpilleur = new Bateau(debut, fin);
	}
	
	public EtatBateau touche (Position cible) { // methode permettant de v�rifier si une flotte est touch�e par une attaque.
		
		EtatBateau etatFlotte = EtatBateau.PASTOUCHE; 
		boolean poursuiteAttaque = true; 
		
		if (porteAvion.getEtatBateau() != EtatBateau.COULE) {
			etatFlotte = porteAvion.touche(cible);
			if (etatFlotte != EtatBateau.PASTOUCHE) poursuiteAttaque = false; 
		}
		
		if (croiseur.getEtatBateau() != EtatBateau.COULE && poursuiteAttaque) {
			etatFlotte = croiseur.touche(cible);
			if (etatFlotte != EtatBateau.PASTOUCHE) poursuiteAttaque = false; 
		}
		
		if (contreTorpilleur1.getEtatBateau() != EtatBateau.COULE && poursuiteAttaque) {
			etatFlotte = contreTorpilleur1.touche(cible);
			if (etatFlotte != EtatBateau.PASTOUCHE) poursuiteAttaque = false; 
		}
		
		if (contreTorpilleur2.getEtatBateau() != EtatBateau.COULE && poursuiteAttaque) {
			etatFlotte = contreTorpilleur2.touche(cible);
			if (etatFlotte != EtatBateau.PASTOUCHE) poursuiteAttaque = false; 
		}
		
		if (torpilleur.getEtatBateau() != EtatBateau.COULE && poursuiteAttaque) {
			etatFlotte = torpilleur.touche(cible);
			if (etatFlotte != EtatBateau.PASTOUCHE) poursuiteAttaque = false; 
		}
		
		return etatFlotte; 
	}

	public boolean EstDecimee() {// Verifie si la flotte est enti�rement d�truite.
		estDecimee = !(
				porteAvion.getEtatBateau() != EtatBateau.COULE ||
				croiseur.getEtatBateau() != EtatBateau.COULE ||
				contreTorpilleur1.getEtatBateau() != EtatBateau.COULE ||
				contreTorpilleur2.getEtatBateau() != EtatBateau.COULE ||
				torpilleur.getEtatBateau() != EtatBateau.COULE
				); 
		return estDecimee;	}
	

}
