package com.exemplo;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Tecnico("Carlos", 4000.0, 1));
        funcionarios.add(new Tecnico("Mariana", 4500.0, 2));
        funcionarios.add(new Tecnico("Pedro", 5000.0, 3));
        funcionarios.add(new Professor("Maria", 60.0, 40));
        funcionarios.add(new Professor("Ana", 75.0, 30));
        funcionarios.add(new Professor("Lucas", 55.0, 20));
        funcionarios.add(new Pesquisador("João", 70.0, 40, 10));
        funcionarios.add(new Pesquisador("Beatriz", 80.0, 30, 8));
        funcionarios.add(new Pesquisador("Rafael", 65.0, 20, 12));

        int quantidadeTecnicos = 0;
        double totalSalarioPesquisadores = 0.0;
        double totalInssProfessores = 0.0;
        double totalSalarios = 0.0;

        for (Funcionario funcionario : funcionarios) {
            totalSalarios += funcionario.calcularSalarioLiquido();

            if (funcionario instanceof Tecnico) {
                quantidadeTecnicos++;
            }

            if (funcionario instanceof Pesquisador) {
                totalSalarioPesquisadores += funcionario.calcularSalarioLiquido();
            } else if (funcionario instanceof Professor) {
                totalInssProfessores += funcionario.calcularInss();
            }
        }

        double mediaSalario = totalSalarios / funcionarios.size();

        System.out.println("Funcionários na lista: " + funcionarios.size());
        System.out.println("Técnicos na lista: " + quantidadeTecnicos);
        System.out.printf("Salários líquidos dos pesquisadores: R$ %.2f%n",
                totalSalarioPesquisadores);
        System.out.printf("INSS dos professores: R$ %.2f%n", totalInssProfessores);
        System.out.printf("Média dos salários líquidos: R$ %.2f%n", mediaSalario);
    }
}
