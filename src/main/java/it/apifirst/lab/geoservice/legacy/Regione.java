package it.apifirst.lab.geoservice.legacy;

@Deprecated
public class Regione {
    final String nome;

    Regione(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
