package compagnia_aerea;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Dichiarazioni
		
		Scanner tastiera = new Scanner(System.in); //input
		Volo v1 = new Volo(3); //variabile principale   
		int risp;   //eventuali risposte
		Cliente nome = new Cliente("nome"); //variabile nome da mandare nei metodi
		//String nome;
		//Inizio menu
		
		while(true) {
			
			System.out.println("Posti massimi: " + v1.getMaxP() + "\nPosti rimanenti: " + v1.getRimanenti());
			
			System.out.println("0: Uscita, 1: Prenotare, 2: Disdire > ");
			risp = tastiera.nextInt();
			
			//Controllo
			
			while (risp < 0 || risp > 2) {
				
				System.out.println("Errore, inserire un numero valido > ");
				risp = tastiera.nextInt();
			}
			
			//Controllo uscita
			
			if (risp == 0) {
                System.out.println("Arrivederci");
				break;
			}
			else if (risp == 1) {
				
				//Inserimento del nome del cliente
				
				System.out.println("Inserire il mome del cliente >");
				//nome.setNome(tastiera.next());  //inserimento del nome
				//nome.setNome(tastiera.next());
				nome = new Cliente(tastiera.next());
				//Controllo se il nome è valido
				
				while(nome.getNome().length() == 0) {
					System.out.println("Inserire il nome del cliente > ");
					//nome.setNome(tastiera.nextLine());
					nome.setNome(tastiera.next());
				}
				//Metodo che mi aggiunge il cliente
				
				System.out.println(v1.prenota(nome));   //manda la variabile nome nel parametro del metodo

				}
			else {
				v1.ListaPosti();    //stampa a schermo i posti del volo
				v1.ListaAttesa();   //stampa a schermo la lista dell'attesa


                System.out.println("Inserire il cliente da togliere: ");
				nome = new Cliente(tastiera.next());
                
                


				
				
				
				
				
			}
			
		
		
		}
			tastiera.close();
			
		} // Void
	
	} //Main