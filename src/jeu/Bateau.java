package jeu;

public class Bateau {

	
	private int taille; 
	private Position[] positionsCases;// liste regroupant la possition des cases occupées par un bateau
	private Case[] etatCasesOcupees; // liste regroupant les états des différentes cases constituant le bateau
	private EtatBateau etatBateau; 
	
	public Bateau(){// Bateau initialisé comme étant intact
		super();
		this.etatBateau = EtatBateau.INTACT; 
	}
	
	public Bateau(Position depart, Position fin) { //Constructeur permettant de définir un Bateau selon la case de début et la case de fin du bateau
		int ligneDepart = depart.getLigne(); 
		int colonneDepart = depart.getColonne(); 
		int ligneFin = fin.getLigne(); 
		int colonneFin = fin.getColonne(); 
		
		//On vérfie si le bateau est aligné 
		if (ligneDepart == ligneFin) {//verticalement
			this.taille = Math.abs(colonneFin - colonneDepart) + 1;
			this.positionsCases = new Position[this.taille];
			this.etatCasesOcupees = new Case[this.taille]; 
			this.positionsCases[0] = depart; 
			this.etatCasesOcupees[0] = Case.INTACT; 
			for (int i = 1; i<this.taille; i++) { //On renseigne toutes les cases occupées par le bateau 
				this.positionsCases[i] = Position.valueOf(Position.colonneIndex(i)+(ligneDepart+1)); 
				this.etatCasesOcupees[i] = Case.INTACT; 
			} 
		}
		else if (colonneDepart == colonneFin) {//horizontalement
			this.taille = Math.abs(ligneFin - ligneDepart) + 1; 
			this.positionsCases = new Position[this.taille];
			this.etatCasesOcupees = new Case[this.taille]; 
			this.positionsCases[0] = depart; 
			this.etatCasesOcupees[0] = Case.INTACT;  
			for (int j = 1; j<this.taille; j++) {//On renseigne toutes les cases occupées par le bateau 
				this.positionsCases[j] = Position.valueOf(Position.colonneIndex(colonneDepart)+(j + 1)); 
				this.etatCasesOcupees[j] = Case.INTACT; 
			} 
		}
		this.etatBateau = EtatBateau.INTACT; 
	}

	public Position[] getPositionsCases() {
		return positionsCases;
	}



	public Case[] getEtatCasesOcupees() {
		return etatCasesOcupees;
	}

	public int getTaille() {
		return taille;
	}

	public EtatBateau getEtatBateau() {
		return etatBateau;
	}
	
	public EtatBateau touche(Position cible) { //méthode renvoyant l'état du bateau selon une attaque dans la position cible.
		
		this.etatBateau = EtatBateau.PASTOUCHE;
		boolean peutCouler = true ;
		
		//Parcours des cases occupées par le bateau
		for(int i = 0; i<this.taille;i++) { 
			if (this.etatCasesOcupees[i] == Case.INTACT) {
				// une case intacte du bateau a été trouvée
				if(cible ==this.positionsCases[i]) {
					//cette case correspond à la case ciblée
					this.etatBateau = EtatBateau.TOUCHE;
					this.etatCasesOcupees[i]= Case.TOUCHE; 
				}
				else peutCouler = false; // Cela signifie qu'une case intacte non ciblée par l'attaque a été trouvée, donc le bateau ne peut pas couler.
					
			}
		}
		if (this.etatBateau == EtatBateau.TOUCHE && peutCouler) {
			this.etatBateau = EtatBateau.COULE; // le bateau a coulé
			for (int i=0; i<this.taille ; i++ ) {
				this.etatCasesOcupees[i]= Case.COULE; //toutes les cases qui l'occupent sont dans l'état "coulé"
			}
		}
		
		return this.getEtatBateau(); 
	}
	
	

}
