import java.util.Random;
import java.util.Scanner;

public class Basquete {
    static Scanner entrada = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        System.out.print("Digite o nome do jogador: ");
        String nome = entrada.nextLine();

        int habilidade = 50;
        int cestas = 0;
        int saldo = 500;
        int partidas = 0;
        int opcao;

        do {
            opcao = exibirMenu();

            switch (opcao) {

                case 1:
                    mostrarJogador(nome, habilidade, cestas, saldo, partidas);
                    break;

                case 2:
                    if (saldo >= 300) {
                        if (habilidade < 100) {

                            saldo -= 300;

                            int resultado = random.nextInt(10) + 1;

                            habilidade = treinar(habilidade, resultado);

                            System.out.println("Resultado do treino: " + resultado);
                            System.out.println("Habilidade atual: " + habilidade);

                        } else {
                            System.out.println("Habilidade já está no máximo!");
                        }
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                    break;

                case 3:
                    System.out.println("Escolha a estratégia:");
                    System.out.println("1 - Defensiva");
                    System.out.println("2 - Equilibrada");
                    System.out.println("3 - Ofensiva");

                    int estrategia = entrada.nextInt();
                    int bonus = 0;

                    if (estrategia == 1) {
                        bonus = 0;
                    } else if (estrategia == 2) {
                        bonus = 5;
                    } else if (estrategia == 3) {
                        bonus = 12;
                    } else {
                        System.out.println("Estratégia inválida!");
                        break;
                    }

                    int sorte = random.nextInt(11);

                    int desempenho = calcularDesempenho(
                            habilidade, bonus, sorte
                    );

                    int cestasPartida = calcularCestas(desempenho);
                    int premio = calcularPremio(desempenho);

                    cestas += cestasPartida;
                    saldo += premio;
                    partidas++;

                    System.out.println("Desempenho: " + desempenho);

                    if (desempenho >= 75) {
                        System.out.println("Resultado: Vitória!");
                    } else {
                        System.out.println("Resultado: Derrota!");
                    }

                    System.out.println("Cestas realizadas: " + cestasPartida);
                    System.out.println("Prêmio: R$ " + premio);
                    System.out.println("Sorte: " + sorte);

                    break;

                case 4:
                    System.out.println("Partidas realizadas: " + partidas);
                    System.out.println("Total de cestas: " + cestas);
                    System.out.println("Saldo atual: R$ " + saldo);
                    break;

                case 0:
                    System.out.println("Programa encerrado!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        entrada.close();
    }

    public static int exibirMenu() {

        System.out.println("\n===== CAMPEONATO DE BASQUETE =====");
        System.out.println("1 - Visualizar jogador");
        System.out.println("2 - Treinar");
        System.out.println("3 - Participar de partida");
        System.out.println("4 - Consultar resultados");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");

        return entrada.nextInt();
    }

    public static void mostrarJogador(
            String nome, int habilidade, int cestas, int saldo, int partidas
    ) {

        System.out.println("\n===== DADOS DO JOGADOR =====");
        System.out.println("Nome: " + nome);
        System.out.println("Habilidade: " + habilidade);
        System.out.println("Cestas: " + cestas);
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("Partidas: " + partidas);
    }

    public static int treinar(int habilidade, int resultado) {

        if (resultado >= 6) {
            habilidade += 8;

            if (habilidade > 100) {
                habilidade = 100;
            }

            System.out.println("Treinamento bem-sucedido!");

        } else {
            System.out.println("Treinamento não teve sucesso!");
        }

        return habilidade;
    }

    public static int calcularDesempenho(
            int habilidade, int bonus, int sorte
    ) {

        return habilidade + bonus + sorte;
    }

    public static int calcularCestas(int desempenho) {

        if (desempenho >= 90) {
            return 30;
        } else if (desempenho >= 75) {
            return 25;
        } else if (desempenho >= 60) {
            return 15;
        } else {
            return 5;
        }
    }

    public static int calcularPremio(int desempenho) {

        if (desempenho >= 90) {
            return 1000;
        } else if (desempenho >= 75) {
            return 700;
        } else if (desempenho >= 60) {
            return 400;
        } else {
            return 200;
        }
    }
}

