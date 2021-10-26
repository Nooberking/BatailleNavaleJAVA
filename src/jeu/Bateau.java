package jeu;

public class Bateau {
	
	private int taille; 
	private Position[] positionsCases;
	private Case[] etatCasesOcupees; 
	private EtatBateau etatBateau; 
	
	public Bateau(){
		super();
		this.etatBateau = EtatBateau.INTACT; 
	}
	
	public Bateau(Position depart, Position fin) {
		int ligneDepart = depart.getLigne(); 
		int colonneDepart = depart.getColonne(); 
		int ligneFin = fin.getLigne(); 
		int colonneFin = fin.getColonne(); 
		
		
		if (ligneDepart == ligneFin) {
			this.taille = Math.abs(colonneFin - colonneDepart) + 1;
			this.positionsCases = new Position[this.taille];
			this.etatCasesOcupees = new Case[this.taille]; 
			this.positionsCases[0] = depart; 
			this.etatCasesOcupees[0] = Case.INTACT; 
			for (int i = 1; i<this.taille; i++) {
				this.positionsCases[i] = Position.valueOf(Position.colonneIndex(i)+(ligneDepart+1)); 
				this.etatCasesOcupees[i] = Case.INTACT; 
			} 
		}
		else if (colonneDepart == colonneFin) {
			this.taille = Math.abs(ligneFin - ligneDepart) + 1; 
			this.positionsCases = new Position[this.taille];
			this.etatCasesOcupees = new Case[this.taille]; 
			this.positionsCases[0] = depart; 
			this.etatCasesOcupees[0] = Case.INTACT;  
			for (int j = 1; j<this.taille; j++) {
				this.positionsCases[j] = Position.valueOf(Position.colonneIndex(colonneDepart)+(j + 1)); 
				this.etatCasesOcupees[j] = Case.INTACT; 
			} 
		}
		this.etatBateau = EtatBateau.INTACT; 
	}

	public Position[] getPositionsCases() {
		return positionsCases;
	}

	public void setPositionsCases(Position[] positionsCases) {
		this.positionsCases = positionsCases;
		this.taille = positionsCases.length; 
	}

	public Case[] getEtatCasesOcupees() {
		return etatCasesOcupees;
	}

	public void setEtatCasesOcupees(Case[] etatCasesOcupees) {
		this.etatCasesOcupees = etatCasesOcupees;
		this.taille = etatCasesOcupees.length; 
	}
	

	public int getTaille() {
		return taille;
	}

	public EtatBateau getEtatBateau() {
		return etatBateau;
	}
	
	public EtatBateau touche(Position cible) {
		
		this.etatBateau = EtatBateau.PASTOUCHE; 
		boolean peutCouler = true ;
		
		for(int i = 0; i<this.taille;i++) {
			if (this.etatCasesOcupees[i] == Case.INTACT) {
				if(cible ==this.positionsCases[i]) {
					this.etatBateau = EtatBateau.TOUCHE;
					this.etatCasesOcupees[i]= Case.TOUCHE; 
				}
				else peutCouler = false;
					
			}
		}
		if (this.etatBateau == EtatBateau.TOUCHE && peutCouler) {
			this.etatBateau = EtatBateau.COULE;
			for (int i=0; i<this.taille ; i++ ) {
				this.etatCasesOcupees[i]= Case.COULE; 
			}
		}
		
		return this.getEtatBateau(); 
	}
	
	

}
