package compagnia_aerea;

import java.util.ArrayList;

public class Volo {

	//Dichiarazioni
	
	private int maxP, occupati, rimanenti; //posti massimi di un volo, posti occupati e quelli rimanenti
	private Cliente[] posti;    //array che contiene i clienti del volo
	private ArrayList<Cliente> attesa;  //arraylist che contiene i clienti in attesa
	private int sentinella; //variabile a parte che mi dice qual'è il primo posto libero in posti
	
	//Metodo costruttore
	
	public Volo(int maxP) {
		this.maxP = maxP; 
		posti = new Cliente[maxP]; 
		attesa = new ArrayList<Cliente>();
		sentinella = 0;
		occupati = 0;
		rimanenti = maxP - occupati;
	}

	//getters

	public int getMaxP() {return maxP;}
	public int getRimanenti() {return rimanenti;}
	public Cliente[] getPosti() {return posti;}
	
	//Metodo prenota
	
	public String prenota(Cliente nome) {
		if (occupati >= maxP) {
			sentinella = -1;
			attesa.add(nome);
			return "Spiacenti, il volo è al completo, il cliente è aggiunto alla lista di attesa";
		}
		else {
			for (int i = 0; i < maxP; i++) {
				
				if (posti[i] == null) {
					sentinella = i;
					break;
				}
			}
			
			posti[sentinella] = new Cliente(nome);
			occupati ++;
			rimanenti = maxP - occupati;
			return "Cliente aggiunto correttamente";
		}

	}
	
	public void ListaPosti() {
		
		System.out.println("Lista posti: ");
		
		for (int i = 0; i < maxP; i ++) {
			System.out.print("Cliente " + i + ": " + posti[i] + ", ");
			
		}
		
		System.out.println("\n");
	}


	public void ListaAttesa() {
		System.out.println("Lista attesa: ");
		
		int x = 0;
		
		for (Cliente i : attesa) {
			System.out.print("Cliente " + x + ": " + i + ", ");
			x ++;
		}
		
		System.out.println("\n");
	}
	
    public String togliCliente(Cliente nome) {

        for(int i = 0; i < maxP; i ++) {
            if (nome == posti[i]) {
                if (attesa.size() > 0) {
                    posti[i] = attesa.getFirst();
                    attesa.removeFirst();
                }
                else {
                    posti[i] = null;
                }
                
                
                return "Cliente rimosso con successo";
            }
        }

        for (Cliente x : attesa) {
            if (nome == x) {
                attesa.remove(x);
                return "Cliente rimosso con successo";
            }
            
        }
        return "Errore, cliente non trovato";
    }

	// public void prova() {

	// 	System.out.println(posti[0]);
	// 	System.out.println(posti[1]);
	// 	System.out.println(posti[2]);
	// }
	
}
