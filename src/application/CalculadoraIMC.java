package application;

import java.util.Scanner;

import entities.Calculadora;
import entities.CalculadoraException;
import util.ValidarTexto;
import util.ValidarTextoException;

public class CalculadoraIMC {

    private static final String INICIO = "Calculadora IMC";
    private static final String DIGITE_PESO = "\nDigite o seu peso: ";
    private static final String DIGITE_ALTURA = "\nDigite a sua altura: ";
    private static final String VALOR_INVALIDO = "\nError: o valor digitado é inválido";
    private static final String LIMPAR_TELA = "\033[H\033[2J";
    private static final String CLASSIFICACAO_GRAU = "Classificação | Grau\n";
    private static final String DESEJA_CONTINUAR = "\n\nDeseja continuar? (S/N) ";
    private static final String IMC_ACIMA = "\n\nEle está acima do recomendado\nO ideal é estar entre 18.5 e 24.9";
    private static final String IMC_ABAIXO = "\n\nEle está abaixo do recomendado\nO ideal é estar entre 18.5 e 24.9";
    private static final String IMC_NORMAL = "\n\nEle é considerado normal\nParabéns!!!";
    private static final String MAGREZA = "MAGREZA";
    private static final String NORMAL = "NORMAL";
    private static final String SOBREPESO = "SOBREPESO";
    private static final String OBESIDADE = "OBESIDADE";

    private static String continuar = "S";

    public static void iniciarIMC() {
        Scanner sc = new Scanner(System.in);

        limparTela();

        while (!continuar.equals("N")) {
            try {
                if (continuar.equals("S")) {
                    System.out.println(INICIO);
                    System.out.print(DIGITE_ALTURA);
                    Double altura = Double.parseDouble(sc.nextLine());
                    System.out.print(DIGITE_PESO);
                    Double peso = Double.parseDouble(sc.nextLine());

                    limparTela();

                    String status = Calculadora.calcular(peso, altura);

                    System.out.printf(separarTabela(status), CLASSIFICACAO_GRAU, status);
                }

                do {
                    System.out.print(DESEJA_CONTINUAR);
                    continuar = sc.nextLine().substring(0, 1).toUpperCase();
                    ValidarTexto.ApenasTextos(continuar);
                    limparTela();
                } while (!continuar.equals("S") && !continuar.equals("N"));

            } catch (CalculadoraException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
                limparTela();
            } catch (NumberFormatException e) {
                System.out.println(VALOR_INVALIDO);
                sc.nextLine();
                limparTela();
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println(VALOR_INVALIDO);
                sc.nextLine();
                limparTela();
                continuar = "O";
            } catch (ValidarTextoException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
                limparTela();
                continuar = "O";
            }
        }

        sc.close();
    }

    private static void limparTela() {
        System.out.print(LIMPAR_TELA);
        System.out.flush();
    }

    private static String separarTabela(String status) {
        String[] vStatus = status.split(" ");

        if (vStatus[0].equals(MAGREZA)) {
            return "%-27s%-15s" + IMC_ABAIXO;
        } else if (vStatus[0].equals(NORMAL)) {
            return "%-28s%-15s" + IMC_NORMAL;
        } else if (vStatus[0].equals(SOBREPESO) || vStatus[0].equals(OBESIDADE) && !vStatus[1].equals("GRAVE")) {
            return "%-25s%-15s" + IMC_ACIMA;
        } else {
            return "  %-15s%-25s" + IMC_ACIMA;
        }
    }
}
