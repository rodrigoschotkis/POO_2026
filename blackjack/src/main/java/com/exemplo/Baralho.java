package com.exemplo;
import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
    private ArrayList<Carta> cartas;

    public Baralho() {
        cartas = new ArrayList<>(52);

        for (Naipe n : Naipe.values()) {
            for (ValorCarta v : ValorCarta.values()) {
                Carta c = new Carta(n,v);
                cartas.add(c);
            }
        }
    }

    public void embaralha() {
        Collections.shuffle(cartas);
    }

    public Carta pegaDeCima() {
        return cartas.remove(cartas.size()-1);
    }
}
