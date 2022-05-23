package org.example;

public class Piatti {
    int id;
    String nomeProdotto;
    String descrizione;
    double costo;
    Piatti(){}

    public Piatti(int id, String nomeProdotto, String descrizione, double costo) {
        this.id = id;
        this.nomeProdotto = nomeProdotto;
        this.descrizione = descrizione;
        this.costo = costo;
    }

    }