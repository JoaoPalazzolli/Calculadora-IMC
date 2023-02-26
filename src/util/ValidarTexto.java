package util;

public class ValidarTexto {
    private static final String VALOR_INVALIDO = "Error: números são inválidos";

    public static void ApenasTextos(String text) {
        if (!text.matches("[^\\d]+")) {
            throw new ValidarTextoException(VALOR_INVALIDO);
        }
        // Passa para o método matches a regex
        // Se tiver número na string irá retornar falso
        // Note o uso de duas \\, uma sendo obrigatória para servir de caractere de
        // escape
    }
}
