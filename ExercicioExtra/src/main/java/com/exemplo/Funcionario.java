package com.exemplo;

public class Funcionario {
    private String nome;
    private double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double calcularInss() {
        return salarioBase * 0.10;
    }

    public double calcularSalarioLiquido() {
        return salarioBase - calcularInss();
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", salarioBase=" + salarioBase +
                '}';
    }
}
