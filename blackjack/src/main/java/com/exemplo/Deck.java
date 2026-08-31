package com.exemplo;
import java.util.ArrayList;

public class Deck {
    private ArrayList<Carta> cartas;

    public Deck() {
        cartas = new ArrayList<>();
    }

    public void adicionaCarta(Carta carta) {
        cartas.add(carta);
    }

    public int soma() {
        int soma = 0;
        int ases = 0;

        for (Carta c : cartas) {
            soma = soma + c.getValor().getPontos();
            if (c.getValor() == ValorCarta.AS) {
                ases++;
            }
        }

        while (soma > 21 && ases > 0) {
            soma -= 10;
            ases--;
        }
        return soma;
    }

    public void limpa() {
        cartas.clear();
    }

    public int getQuantidade() {
    return cartas.size();
}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Carta c : cartas) {
            sb.append("  - ").append(c).append("\n");
        }
        return sb.toString();
    }
}
