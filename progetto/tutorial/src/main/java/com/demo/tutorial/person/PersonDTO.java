package com.demo.tutorial.person;

public class PersonDTO {
    private String nome;
    private String cognome;
    private int eta;

    public PersonDTO() {

    }

    public PersonDTO(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public String getNome() {
        return nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome + ", " + cognome + ", " + eta;
    }
}
