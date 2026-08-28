package com.exemplo;

public class Carta {
    private final Naipe naipe;
    private final ValorCarta valor;

    public Carta(Naipe naipe, ValorCarta valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public ValorCarta getValor() {
        return valor;
    }
}
