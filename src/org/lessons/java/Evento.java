package org.lessons.java;

import java.time.LocalDate;
import java.util.Date;

public class Evento {
    private String titolo;
    private LocalDate data;

    private int postiTotale;

    private int postiPrenotati;

    public Evento(String titolo, LocalDate data, int postiTotale) {
        if (data.isBefore(LocalDate.now())){
            throw new  IllegalArgumentException("Inserisci una data valida");
        }
        if (postiTotale <=0){
            throw new IllegalArgumentException("Non ci sono abbastanza posti totali");
        }
        this.titolo = titolo;
        this.data = data;
        this.postiTotale = postiTotale;
        this.postiPrenotati= 0;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data.isBefore(LocalDate.now())){
            throw new  IllegalArgumentException("Inserisci una data valida");
        }
        this.data = data;
    }

    public int getPostiTotale() {
        return postiTotale;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    public void prenota(int value){
        if (value <= 0){
            throw new IllegalArgumentException("Non puoi prenotare per 0 o meno persone");
        }else if (postiPrenotati + value > postiTotale){
            throw new IllegalArgumentException("Ci dispiace abbiamo raggiunto la capienza massima");
        } else if (data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Ci dispiace quest'evento è passato");
        } else {
            postiPrenotati += value;
        }
    }
    public void disdici(int value){
        if (value <= 0){
            throw new IllegalArgumentException("Non puoi prenotare per 0 o meno persone");
        }else if (data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Ci dispiace quest'evento è passato");
        } else if (postiPrenotati - value < 0){
            throw new IllegalArgumentException("Non ci sono state abbastanza prenotazioni, impossibile disdire");
        } else {
            postiPrenotati -= value;
        }
    }

    @Override
    public String toString() {
        return "Evento{" +
                "titolo='" + titolo + '\'' +
                ", data=" + data +
                '}';
    }
}
