package entities;

public class Calculadora {

    private static final String PESO_INVALIDO = "Error: o peso digitado é inválido";
    private static final String ALTURA_INVALIDA = "Error: a altura digitada é invalida";
    private static final String IMC = "\n\nO seu IMC é: ";
    private static final Integer MAXIMO_CARACTERES_PESO = 5;
    private static final Integer MAXIMO_CARACTERES_ALTURA = 4;
    private static final Double LIMITE_MINIMO_ALTURA = 0.5;
    private static final Double LIMITE_MAXIMO_ALTURA = 2.6;
    private static final Double LIMITE_MINIMO_PESO = 1.0;
    private static final Double LIMITE_MAXIMO_PESO = 500.0;

    public static String calcular(Double peso, Double altura) {
        verificarValores(peso, altura);
        // Peso ÷ (Altura × Altura)
        Double resultado = peso / Math.pow(altura, 2);
        return Status.pegarStatus(resultado) + IMC + String.format("%.2f", resultado);
    }

    private static void verificarValores(Double peso, Double altura) {
        if (peso.toString().length() > MAXIMO_CARACTERES_PESO || peso < LIMITE_MINIMO_PESO
                || peso > LIMITE_MAXIMO_PESO) {
            throw new CalculadoraException(PESO_INVALIDO);
        }
        if (altura.toString().length() > MAXIMO_CARACTERES_ALTURA || altura < LIMITE_MINIMO_ALTURA
                || altura > LIMITE_MAXIMO_ALTURA) {
            throw new CalculadoraException(ALTURA_INVALIDA);
        }
    }
}
