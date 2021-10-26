package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket s = new Socket("localhost", 1234);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			
			
			System.out.println("Connexion réussie !");
			Scanner sc=new Scanner(System.in);
			String envoi="";
			String reponse =""; 
			
			while (!reponse.equals("quit")) {
				reponse = in.readLine();
				if (reponse.equals("ton tour")) {
					envoi = sc.nextLine();
					out.println(envoi);
				}
				else {
					System.out.println(reponse);
				}
				
			}
			
			sc.close();
			s.close();
			} catch(Exception e) {
				//affichage du message d'erreur
				e.printStackTrace();
			}

	}
}

