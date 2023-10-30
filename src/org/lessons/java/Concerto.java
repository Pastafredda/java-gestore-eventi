package org.lessons.java;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento{
    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, LocalDate data, int postiTotale, LocalTime ora, BigDecimal prezzo) {
        super(titolo, data, postiTotale);
        this.ora = ora;
        this.prezzo= prezzo;
        dataFormatter();
        priceFormatter();
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String dataFormatter(){
        LocalDateTime dateTime = getData().atTime(getOra());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return formatter.format(dateTime);
    }

    public String priceFormatter(){
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.ITALY);
        return format.format(prezzo);
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "ora=" + dataFormatter() +
                ", prezzo=" + priceFormatter() +
                '}';
    }
}

