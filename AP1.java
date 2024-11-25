import java.util.Scanner;
import javax.swing.JOptionPane;

public class AP1 {

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Calculadora de Desconto");
            System.out.println("2 - Calculadora ITBI");
            System.out.println("3 - Sistema de Avaliação");
            System.out.println("4 - Calculadora de Aposentadoria");
            System.out.println("5 - Circuito de Resistências");
            System.out.println("6 - Sistema de Login");
            System.out.println("7 - Gerador de Tabuada");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> CalculadoraDesconto.executar();
                case 2 -> CalculadoraITBI.executar();
                case 3 -> SistemaAvaliacao.executar();
                case 4 -> CalculadoraAposentadoria.executar();
                case 5 -> CircuitoResistencias.executar();
                case 6 -> SistemaLogin.executar();
                case 7 -> GeradorTabuada.executar();
                case 0 -> {
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    // Classe 1: Calculadora de Desconto
    static class CalculadoraDesconto {
        public static void executar() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o valor do produto: ");
            double valorProduto = scanner.nextDouble();
            System.out.print("Digite a porcentagem de desconto: ");
            double porcentagemDesconto = scanner.nextDouble();

            double desconto = valorProduto * (porcentagemDesconto / 100);
            double precoFinal = valorProduto - desconto;

            System.out.printf("Desconto: R$ %.2f%n", desconto);
            System.out.printf("Preço final: R$ %.2f%n", precoFinal);
        }
    }

    // Classe 2: Calculadora ITBI
    static class CalculadoraITBI {
        public static void executar() {
            double valorTransacao = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de transação do imóvel:"));
            double valorVenal = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor venal do imóvel:"));
            double porcentagemITBI = Double.parseDouble(JOptionPane.showInputDialog("Digite a porcentagem do ITBI:"));

            double baseCalculo = Math.max(valorTransacao, valorVenal);
            double imposto = baseCalculo * (porcentagemITBI / 100);

            JOptionPane.showMessageDialog(null, String.format("Imposto ITBI: R$ %.2f", imposto));
        }
    }

    // Classe 3: Sistema de Avaliação
    static class SistemaAvaliacao {
        public static void executar() {
            double nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota da primeira prova:"));
            double nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota da segunda prova:"));
            double trabalho = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota do trabalho:"));

            double media = (nota1 + nota2 + trabalho) / 3;
            String status = (media >= 6) ? "Aprovado" : "Reprovado";

            JOptionPane.showMessageDialog(null, String.format("Média: %.2f\nStatus: %s", media, status));
        }
    }

    // Classe 4: Calculadora de Aposentadoria
    static class CalculadoraAposentadoria {
        public static void executar() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite sua idade: ");
            int idade = scanner.nextInt();
            System.out.print("Digite seu sexo (M/F): ");
            char sexo = scanner.next().toUpperCase().charAt(0);
            System.out.print("Digite os anos de contribuição: ");
            int anosContribuicao = scanner.nextInt();

            int idadeMinima = (sexo == 'F') ? 60 : 65;
            int contribuicaoMinima = 35;

            if (idade >= idadeMinima || anosContribuicao >= contribuicaoMinima) {
                System.out.println("Você já pode se aposentar!");
            } else {
                int anosFaltantes = Math.max(idadeMinima - idade, contribuicaoMinima - anosContribuicao);
                System.out.printf("Faltam %d anos para você se aposentar.%n", anosFaltantes);
            }
        }
    }

    // Classe 5: Circuito de Resistências
    static class CircuitoResistencias {
        public static void executar() {
            Scanner scanner = new Scanner(System.in);
            double[] resistencias = new double[4];
            double soma = 0, maior = Double.MIN_VALUE, menor = Double.MAX_VALUE;

            for (int i = 0; i < 4; i++) {
                System.out.printf("Digite o valor da resistência %d: ", i + 1);
                resistencias[i] = scanner.nextDouble();
                soma += resistencias[i];
                maior = Math.max(maior, resistencias[i]);
                menor = Math.min(menor, resistencias[i]);
            }

            System.out.printf("Resistência equivalente: %.2f%n", soma);
            System.out.printf("Maior resistência: %.2f%n", maior);
            System.out.printf("Menor resistência: %.2f%n", menor);
        }
    }

    // Classe 6: Sistema de Login
    static class SistemaLogin {
        public static void executar() {
            Scanner scanner = new Scanner(System.in);
            final String LOGIN_CORRETO = "java8";
            final String SENHA_CORRETA = "java8";

            for (int tentativas = 1; tentativas <= 3; tentativas++) {
                System.out.print("Digite o login: ");
                String login = scanner.next();
                System.out.print("Digite a senha: ");
                String senha = scanner.next();

                if (LOGIN_CORRETO.equals(login) && SENHA_CORRETA.equals(senha)) {
                    System.out.println("Acesso concedido!");
                    return;
                } else {
                    System.out.printf("Login ou senha incorretos. Tentativa %d de 3.%n", tentativas);
                }
            }
            System.out.println("Acesso bloqueado!");
        }
    }

    // Classe 7: Gerador de Tabuada
    static class GeradorTabuada {
        public static void executar() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite um número para gerar a tabuada: ");
            int numero = scanner.nextInt();

            System.out.printf("Tabuada do %d:%n", numero);
            for (int i = 1; i <= 10; i++) {
                System.out.printf("%d x %d = %d%n", numero, i, numero * i);
            }
        }
    }
}
