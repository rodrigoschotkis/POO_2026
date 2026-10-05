package com.exemplo;

public class Pesquisador extends Professor {
    private int cargaHorariaDePesquisa;

    public Pesquisador(String nome, double valorHora, int cargaHorariaSemanal,
            int cargaHorariaDePesquisa) {
        super(nome, valorHora, cargaHorariaSemanal);
        this.cargaHorariaDePesquisa = cargaHorariaDePesquisa;
    }

    public int getCargaHorariaDePesquisa() {
        return cargaHorariaDePesquisa;
    }

    @Override
    public double calcularSalarioLiquido() {
        int totalHoras = getCargaHorariaSemanal() + cargaHorariaDePesquisa;
        double salarioMensal = getValorHora() * totalHoras;
        return salarioMensal - calcularInss();
    }

    @Override
    public double calculaSalarioLiquido() {
        return calcularSalarioLiquido();
    }

    @Override
    public String toString() {
        return "Pesquisador{" +
                "nome='" + getNome() + '\'' +
                ", salarioBase=" + getSalarioBase() +
                ", cargaHorariaDePesquisa=" + cargaHorariaDePesquisa +
                '}';
    }
}
