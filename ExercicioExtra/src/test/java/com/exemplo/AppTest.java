package com.exemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void funcionarioCalculaInssESalarioLiquido() {
        Funcionario funcionario = new Funcionario("Ana", 2500.0);

        assertEquals("Ana", funcionario.getNome());
        assertEquals(2500.0, funcionario.getSalarioBase());
        assertEquals(250.0, funcionario.calcularInss(), 0.001);
        assertEquals(2250.0, funcionario.calcularSalarioLiquido(), 0.001);
        assertEquals("Funcionario{nome='Ana', salarioBase=2500.0}", funcionario.toString());
    }

    @Test
    void tecnicoCalculaAdicionalEInssSobreSalarioBase() {
        Tecnico tecnico = new Tecnico("Carlos", 4000.0, 2);

        assertEquals(400.0, tecnico.calcularInss(), 0.001);
        assertEquals(3800.0, tecnico.calcularSalarioLiquido(), 0.001);
    }

    @Test
    void tecnicoAplicaAdicionaisDasCategoriasUmETres() {
        Tecnico categoriaUm = new Tecnico("Carlos", 4000.0, 1);
        Tecnico categoriaTres = new Tecnico("Carlos", 4000.0, 3);

        assertEquals(3600.0, categoriaUm.calcularSalarioLiquido(), 0.001);
        assertEquals(4200.0, categoriaTres.calcularSalarioLiquido(), 0.001);
    }

    @Test
    void categoriaTecnicoDeveEstarEntreUmETres() {
        assertThrows(IllegalArgumentException.class, () -> new Tecnico("Carlos", 4000.0, 4));
    }

    @Test
    void professorCalculaSalarioMensalPelasHorasSemanais() {
        Professor professor = new Professor("Maria", 100.0, 40);

        assertEquals(10.0, professor.calcularInss(), 0.001);
        assertEquals(3990.0, professor.calcularSalarioLiquido(), 0.001);
    }

    @Test
    void pesquisadorSomaHorasDePesquisaAsHorasSemanais() {
        Pesquisador pesquisador = new Pesquisador("João", 100.0, 30, 10);

        assertEquals(10.0, pesquisador.calcularInss(), 0.001);
        assertEquals(3990.0, pesquisador.calcularSalarioLiquido(), 0.001);
    }
}
