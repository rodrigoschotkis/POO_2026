package com.exemplo;

public class Jogador {
    private String nome;
    private Deck deck = new Deck();
    private boolean passou = false;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Deck getDeck() {
        return deck;
    }

    public boolean isPassou() {
        return passou;
    }

    public void setPassou(boolean passou) {
        this.passou = passou;
    }
}
