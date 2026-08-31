package com.exemplo;

import java.util.Scanner;

public class Blackjack {
    private Baralho baralho = new Baralho();
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador vencedor = null;
    private Scanner scan = new Scanner(System.in);

    public void iniciarJogo() {
        System.out.println(getBoasVindas());

        String nome1 = promptString("Digite o nome do Jogador 1:");
        String nome2 = promptString("Digite o nome do Jogador 2:");
        jogador1 = new Jogador(nome1);
        jogador2 = new Jogador(nome2);
        System.out.println("Jogadores cadastrados: " + nome1 + " e " + nome2 + ".");

        baralho.embaralha();
        distribuirCartasIniciais();
        jogarPartida();
    }

    private void distribuirCartasIniciais() {
        for (int i = 0; i < 2; i++) {
            jogador1.getDeck().adicionaCarta(baralho.pegaDeCima());
            jogador2.getDeck().adicionaCarta(baralho.pegaDeCima());
        }
        System.out.println("\n=== CARTAS NA MESA ===");
        mostrarMao(jogador1);
        mostrarMao(jogador2);
    }

    private void jogarPartida() {
        while (vencedor == null && !partidaTerminou()) {
            if (!jogador1.isPassou()) {
                jogarVez(jogador1);
            }
            if (vencedor != null) break;

            if (!jogador2.isPassou()) {
                jogarVez(jogador2);
            }
        }
        mostrarResultado();
    }

    private boolean partidaTerminou() {
        boolean ambosPassaram = jogador1.isPassou() && jogador2.isPassou();
        boolean ambosCom5 = jogador1.getDeck().getQuantidade() >= 5
                         && jogador2.getDeck().getQuantidade() >= 5;
        return ambosPassaram || ambosCom5;
    }

    private void jogarVez(Jogador jogador) {
        while (true) {
            System.out.println("\n--- Vez de " + jogador.getNome() + " ---");
            mostrarMao(jogador);

            if (jogador.getDeck().getQuantidade() >= 5) {
                System.out.println(jogador.getNome() + " já tem 5 cartas. Vez encerrada.");
                jogador.setPassou(true);
                return;
            }

            Acao acao = escolherAcao();

            if (acao == Acao.STAND) {
                System.out.println(jogador.getNome() + " passou a vez.");
                jogador.setPassou(true);
                return;
            }

            Carta nova = baralho.pegaDeCima();
            jogador.getDeck().adicionaCarta(nova);
            System.out.println(jogador.getNome() + " comprou: " + nova);

            int pontos = jogador.getDeck().soma();

            if (pontos > 21) {
                System.out.println(jogador.getNome() + " estourou com " + pontos + " pontos!");
                jogador.setPassou(true);
                vencedor = outroJogador(jogador);
                return;
            }

            if (pontos == 21) {
                System.out.println(jogador.getNome() + " fez 21. Blackjack!");
                vencedor = jogador;
                return;
            }
        }
    }

    private Jogador outroJogador(Jogador jogador) {
        return (jogador == jogador1) ? jogador2 : jogador1;
    }

    private void mostrarResultado() {
        System.out.println("\n=== RESULTADO FINAL ===");
        mostrarMao(jogador1);
        mostrarMao(jogador2);

        if (vencedor != null) {
            System.out.println("Vencedor: " + vencedor.getNome() + "!");
            return;
        }

        int p1 = jogador1.getDeck().soma();
        int p2 = jogador2.getDeck().soma();

        if (p1 > p2) {
            System.out.println("Vencedor: " + jogador1.getNome() + "!");
        } else if (p2 > p1) {
            System.out.println("Vencedor: " + jogador2.getNome() + "!");
        } else {
            System.out.println("Empate!");
        }
    }

    private void mostrarMao(Jogador jogador) {
        System.out.println(jogador.getNome() + " (" + jogador.getDeck().soma() + " pontos):");
        System.out.print(jogador.getDeck());
    }

    private Acao escolherAcao() {
        while (true) {
            System.out.println("1 - Hit");
            System.out.println("2 - Stand");
            String resposta = scan.nextLine().trim();

            switch (resposta) {
                case "1":
                    return Acao.HIT;
                case "2":
                    return Acao.STAND;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private String getBoasVindas() {
        return """
                === BLACKJACK ===
                Jogo para 2 jogadores.
                Vence a rodada quem ficar mais perto de 21 sem estourar.
                Hit = pedir mais uma carta
                Stand = passar a vez
                Boa sorte!""";
    }

    private String promptString(String prompt) {
        while (true) {
            System.out.println(prompt);
            String resposta = scan.nextLine();
            if (!resposta.trim().isEmpty()) {
                return resposta;
            }
            System.out.println("Erro! Nome de usuário vazio. Por favor digite algo.");
        }
    }
}
