package org.lessons.java;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un nuovo evento");
        try {
            System.out.println("Titolo evento?");
            String titolo = scanner.nextLine();
            System.out.println("Inserisci una data anno-mese-giorno");
            LocalDate data = LocalDate.parse(scanner.nextLine());
            System.out.println("Inserisci i posti totali dell'evento");
            int postiTotali = Integer.parseInt(scanner.nextLine());
            Evento evento = new Evento(titolo, data, postiTotali);
            System.out.println("Hai creato un evento");
            System.out.println(evento);
            boolean exit = false;
            while (!exit){
                System.out.println("Vuoi prenotare dei posti? si/no");
                exit = scanner.nextLine().equals("no");
                if (!exit){
                    try{
                        System.out.println("Quanti posti vuoi prenotare");
                        int postiPrenotati = Integer.parseInt(scanner.nextLine());
                        evento.prenota(postiPrenotati);
                        System.out.println("Hai prenotato " + postiPrenotati + " " + "posti");
                        int postiRimasti = evento.getPostiTotale() - evento.getPostiPrenotati();
                        System.out.println("Sono rimasti "  + postiRimasti + " " + "posti");
                    }catch (IllegalArgumentException e) {
                        System.out.println("Errore: " + e.getMessage());
                    }
                }

            }
            System.out.println("Vuoi disdire dei posti? si/no");
            if (scanner.nextLine().equals("si")){
                try {
                    System.out.println("Quanti posti vuoi disdire");
                    int postiDisdetti = Integer.parseInt(scanner.nextLine());
                    evento.disdici(postiDisdetti);
                    System.out.println("Hai disdetto " + postiDisdetti);
                    int postiRimasti = evento.getPostiTotale() - evento.getPostiPrenotati();
                    System.out.println("Sono rimasti "  + postiRimasti + " " + "posti");
                }catch (IllegalArgumentException e) {
                    System.out.println("Errore: " + e.getMessage());
                }
            }


        }catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }finally {
            scanner.close();
        }
    }
}
