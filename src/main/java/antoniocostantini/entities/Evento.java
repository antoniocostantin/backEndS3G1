package antoniocostantini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "titolo", nullable = false)
    private String titolo;
    @Column(name = "data_evento", nullable = false)
    private LocalDate data_evento;
    @Column(name = "descrizione", nullable = true)
    private String descrizione;
    @Column(name = "tipo_evento", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventType tipo_evento;
    @Column(name = "numero_massimo_partecipanti", nullable = true)
    private int numero_massimo_partecipanti;

    public Evento(long id, String titolo, LocalDate data_evento, String descrizione, int numero_massimo_partecipanti, EventType tipo_evento) {
        this.id = id;
        this.titolo = titolo;
        this.data_evento = data_evento;
        this.descrizione = descrizione;
        this.numero_massimo_partecipanti = numero_massimo_partecipanti;
        this.tipo_evento = tipo_evento;
    }

    public Evento(String titolo, String descrizione, LocalDate data_evento, EventType tipo_evento, int numero_massimo_partecipanti) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.data_evento = data_evento;
        this.tipo_evento = tipo_evento;
        this.numero_massimo_partecipanti = numero_massimo_partecipanti;
    }

    public Evento() {

    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data_evento=" + data_evento +
                ", descrizione='" + descrizione + '\'' +
                ", tipo_evento='" + tipo_evento + '\'' +
                ", numero_massimo_partecipanti=" + numero_massimo_partecipanti +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData_evento() {
        return data_evento;
    }

    public void setData_evento(LocalDate data_evento) {
        this.data_evento = data_evento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public EventType getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = EventType.valueOf(tipo_evento);
    }

    public int getNumero_massimo_partecipanti() {
        return numero_massimo_partecipanti;
    }

    public void setNumero_massimo_partecipanti(int numero_massimo_partecipanti) {
        this.numero_massimo_partecipanti = numero_massimo_partecipanti;
    }
}
