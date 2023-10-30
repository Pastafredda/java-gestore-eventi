package org.lessons.java;

        import java.time.LocalDate;
        import java.util.ArrayList;
        import java.util.List;

public class ProgrammEventi {
    private String titolo;
    private List <Evento> eventi;

    public ProgrammEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    public void setEventi(List<Evento> eventi) {
        this.eventi = eventi;
    }

    public void addEvento(Evento evento){
        eventi.add(evento);
    }

    //un metodo che restituisce una lista con tutti gli eventi presenti in una certa data
    public List<Evento> eventiData(LocalDate date){
        List<Evento> eventiCorrispondenti = new ArrayList<>();
        for (int i = 0; i < eventi.size() ; i++) {
            Evento evento = eventi.get(i);
            if (evento.getData().equals(date)){
                eventiCorrispondenti.add(evento);
            }
        }
        return eventiCorrispondenti;
    }

    public int eventiSize(){
        return eventi.size();
    }

    public void svuotaEventi(){
        eventi.clear();
    }

}
