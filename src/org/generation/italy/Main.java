package org.generation.italy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);								//Apertura dello scanner per ricevere input
				
		String risposta, sqCasa, sqFuori;									//dichiarazione delle variabili string
		int i, contatore;													//dichiarazione delle variabili int
		Boolean check, check2;
		
		HashMap<String, Integer> squadre = new HashMap<>();
		squadre.put("roma", 0);
		squadre.put("lazio", 0);
		squadre.put("inter", 0);
		squadre.put("milan", 0);
		squadre.put("napoli", 0);
	
		int[] classifica = new int[5];
		
		for(i=0; i<squadre.size(); i++)
		{
			classifica[i] = 0;
		}
		
		ArrayList<String> partite = new ArrayList<>();						//dichiarazione delle ArrayList che verranno usate
		
		ArrayList<Integer> puntCasa = new ArrayList<>();
		ArrayList<Integer> puntFuori = new ArrayList<>();
		
		risposta = "y";
		check = false;
		check2 = false;
		contatore = 0;
		
		do																	//ciclo do while che permette di inserire più partite
		{
			
			do	//ciclo do while che ripete l'inserimento della squadra in casa nel caso non combaci con le 5 dell'array squadre
			{
				check = false;
				System.out.print("Inserisci il nome della squadra in casa: ");
				sqCasa = sc.nextLine();
				sqCasa = sqCasa.toLowerCase();
				for(i = 0; i < squadre.size(); i++)	//ciclo for che scorre le squadre e le paragona alla squadra inserita dall'utente
				{
					if(squadre.containsKey(sqCasa))
					{
						check = true;
					}
				}
				if(check == false)
				{
					System.out.println("Squadra non valida.");
				}
			}
			while(check == false); //la variabile check viene usata per uscire dal loop quando la squadra inserita va bene
			
			
			
			do	//ciclo do while che ripete l'inserimento della squadra ospite nel caso non combaci con le 5 dell'array squadre
			{
				check2 = false;
				System.out.print("Inserisci il nome della squadra fuori casa: ");
				sqFuori = sc.nextLine();
				sqFuori = sqFuori.toLowerCase();
				for(i = 0; i < squadre.size(); i++)
				{
					if(squadre.containsKey(sqFuori))
						check2 = true;
				}
				if(check2 == false)
				{
					System.out.println("Squadra non valida.");
				}
			}
			while(check2 == false);
			
				
			System.out.print("Inserisci il punteggio della squadra in casa: ");
			puntCasa.add(Integer.parseInt(sc.nextLine()));
			
			System.out.print("Inserisci il punteggio della squadra ospite: ");
			puntFuori.add(Integer.parseInt(sc.nextLine()));
			
			partite.add(sqCasa+" - "+sqFuori+" Punteggio: "+puntCasa.get(contatore)+" - "+puntFuori.get(contatore));
			
			if(puntCasa.get(contatore) > puntFuori.get(contatore))
			{
				if(squadre.containsKey(sqCasa))
					squadre.put(sqCasa, squadre.get(sqCasa)+3);
			}
			
			if(puntCasa.get(contatore) < puntFuori.get(contatore))
			{
				if(squadre.containsKey(sqFuori))
					squadre.put(sqFuori, squadre.get(sqFuori)+3);
			}
			
			if(puntCasa.get(contatore) == puntFuori.get(contatore))
			{
					if(squadre.containsKey(sqCasa))
						squadre.put(sqFuori, squadre.get(sqFuori)+1);
					if(squadre.containsKey(sqFuori))
						squadre.put(sqCasa, squadre.get(sqCasa)+1);
			}
						
			System.out.println("Vuoi inserire un'altra partita? (y/n)");
			risposta = sc.nextLine();
			contatore++;
		}
		while(risposta.equals("y"));
		
		
		
		
		
		
		
		System.out.print("\n\n\n");
		
		
		System.out.println("Le partite inserite sono:");
		
		for(i=0; i<partite.size(); i++)
		{
			System.out.println(partite.get(i));
		}
		
		System.out.println("\nLa classifica finale è:");
		
		for(String s : squadre.keySet())
		{
			System.out.println(s+" - "+squadre.get(s));
		}
		
		
		sc.close();
	}

}
