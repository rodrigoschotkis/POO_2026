package com.exemplo;

public class Professor extends Funcionario {
    private int cargaHorariaSemanal;

    public Professor(String nome, double valorHora, int cargaHorariaSemanal) {
        super(nome, valorHora);
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public double getValorHora() {
        return getSalarioBase();
    }

    public int getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    @Override
    public double calcularSalarioLiquido() {
        double salarioMensal = getValorHora() * cargaHorariaSemanal;
        return salarioMensal - calcularInss();
    }

    public double calculaSalarioLiquido() {
        return calcularSalarioLiquido();
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + getNome() + '\'' +
                ", salarioBase=" + getSalarioBase() +
                ", cargaHorariaSemanal=" + cargaHorariaSemanal +
                '}';
    }
}
