package com.exemplo;

public class Tecnico extends Funcionario {
    private int categoria;

    public Tecnico(String nome, double salarioBase, int categoria) {
        super(nome, salarioBase);
        setCategoria(categoria);
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        if (categoria < 1 || categoria > 3) {
            throw new IllegalArgumentException("A categoria do técnico deve ser 1, 2 ou 3.");
        }
        this.categoria = categoria;
    }

    @Override
    public double calcularSalarioLiquido() {
        double adicional = 0.0;
        if (categoria == 2) {
            adicional = getSalarioBase() * 0.05;
        } else if (categoria == 3) {
            adicional = getSalarioBase() * 0.15;
        }
        return getSalarioBase() + adicional - calcularInss();
    }

    public double calculaSalarioLiquido() {
        return calcularSalarioLiquido();
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "categoria=" + categoria +
                ", nome='" + getNome() + '\'' +
                ", salarioBase=" + getSalarioBase() +
                '}';
    }
}
