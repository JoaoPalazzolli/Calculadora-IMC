package entities;

public class Status {

    private static final String MAGREZA = "MAGREZA | 0";
    private static final String NORMAL = "NORMAL | 0";
    private static final String SOBREPESO = "SOBREPESO | I";
    private static final String OBESIDADE = "OBESIDADE | II";
    private static final String OBESIDADE_GRAVE = "OBESIDADE GRAVE | III";

    public static String pegarStatus(Double resultado) {

        if (resultado < 18.5) {
            return MAGREZA;
        } else if (resultado >= 18.5 && resultado <= 24.9) {
            return NORMAL;
        } else if (resultado >= 25.0 && resultado <= 29.9) {
            return SOBREPESO;
        } else if (resultado >= 30.0 && resultado <= 39.9) {
            return OBESIDADE;
        } else {
            return OBESIDADE_GRAVE;
        }
    }
}
