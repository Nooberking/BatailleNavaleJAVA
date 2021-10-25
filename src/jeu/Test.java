package jeu;

public class Test {

	public static void main(String[] args) {
		
		// Test des méthodes de plateau

		Plateau p1 = new Plateau();
		System.out.println("affichage du plateau vide \n" + p1);

		System.out.println("etat en A1 : " + p1.getCase(Position.A1));
		System.out.println("avec la postion : " + p1.getCase("A1"));
		  
		  
		p1.setCase(Position.A1, Case.INTACT); p1.setCase("B2", Case.COULE);
		  
		System.out.println("avec un changement de valeur des cases : \n");
		System.out.println( "etat en A1 : " + p1.getCase(Position.A1));
		  
		System.out.println("Valeur en A1 : " +
		p1.getCase(Position.A1).getValeurCase());
		System.out.println("avec la postion, etat en B2 : " + p1.getCase("B2"));
		System.out.println("avec la position, valeur en B2 : " +
		p1.getCase("B2").getValeurCase()+"\n"); System.out.println(p1);
		
		// Test des méthodes de bateau 
		
		Plateau p2 = new Plateau(); 
		System.out.println("affichage du plateau vide \n" + p2);
		Bateau b1 = new Bateau(Position.A1, Position.A5); 
		System.out.println(b1.getEtatBateau());
		Case[] posTemp = b1.getEtatCasesOcupees();
		for (Case post :posTemp)System.out.println(post);
		p2.ajoutBateau(b1);
		System.out.println("ajout d'un bateau b1 \n" + p2);
		Bateau b2 = new Bateau(); 
		
		Position[] pos = new Position[4];
		pos[0] = Position.C2;
		pos[1] = Position.D2;
		pos[2] = Position.E2;
		pos[3] = Position.F2;
		b2.setPositionsCases(pos);
		
		Case[] etatCases = new Case[4]; 
		etatCases[0] = Case.INTACT;
		etatCases[1] = Case.INTACT;
		etatCases[2] = Case.INTACT;
		etatCases[3] = Case.INTACT;
		b2.setEtatCasesOcupees(etatCases);
		
		p2.ajoutBateau(b2);
		System.out.println("ajout d'un bateau b2 \n" + p2);
		
		System.out.println("Résultat de l'attaque en A3 de b1 : " + b1.touche(Position.A3));
		p2.ajoutBateau(b1);
		System.out.println("attaque du bateau b1 \n" + p2);
		
		System.out.println("Résultat de l'attaque en A1 de b2 : " + b2.touche(Position.A1));
		System.out.println("Résultat de l'attaque en C2 de b2 : " + b2.touche(Position.C2));
		System.out.println("Résultat de l'attaque en D2 de b2 : " + b2.touche(Position.D2));
		System.out.println("Résultat de l'attaque en E2 de b2 : " + b2.touche(Position.E2));
		System.out.println("Résultat de l'attaque en F2 de b2 : " + b2.touche(Position.F2));
		p2.ajoutBateau(b2);
		System.out.println("résultat final de l'assaut \n" + p2);
		
	

	}

}
