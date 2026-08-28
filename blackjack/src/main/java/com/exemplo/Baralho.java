package com.exemplo;
import java.util.ArrayList;

public class Baralho {
    private ArrayList<Carta> cartas;

    public void inicializa() {
        cartas = new ArrayList<>(52);

        for (Naipe n:Naipe.values()) {
            for (ValorCarta v:ValorCarta.values()) {
                Carta c = new Carta(n,v);
                cartas.add(c);
            }
        }
    }

    
}
