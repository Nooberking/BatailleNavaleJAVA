package jeu;

public class Test {

	public static void main(String[] args) {
		
		// Test des méthodes de plateau

		Plateau p1 = new Plateau();
		System.out.println("affichage du plateau vide \n" + p1);

		System.out.println("etat en A1 : " + p1.getCase(1, Colonne.A));
		System.out.println("avec la postion : " + p1.getCase("A1"));
		  
		  
		p1.setCase(1, Colonne.A, Case.MONBATEAU); p1.setCase("B2", Case.COULE);
		  
		System.out.println("avec un changement de valeur des cases : \n");
		System.out.println( "etat en A1 : " + p1.getCase(1,Colonne.A));
		  
		System.out.println("Valeur en A1 : " +
		p1.getCase(1,Colonne.A).getValeurCase());
		System.out.println("avec la postion, etat en B2 : " + p1.getCase("B2"));
		System.out.println("avec la position, valeur en B2 : " +
		p1.getCase("B2").getValeurCase()+"\n"); System.out.println(p1);
		 

	}

}
