import javax.swing.*;

public class Principal {

    public static String X = ""; // Semilla como cadena

    public static String operaciones() {
        long numero = Long.parseLong(X);
        long cuadrado = numero * numero;
        String resultadoCuadrado = String.valueOf(cuadrado);
        int digitosParaQuitar = (resultadoCuadrado.length() - X.length()) / 2;
        String digitosDelMedio = resultadoCuadrado.substring(digitosParaQuitar, resultadoCuadrado.length() - digitosParaQuitar);
        if (digitosDelMedio.length() > X.length()) {
            digitosDelMedio = digitosDelMedio.substring(0, X.length());
        }
        X = digitosDelMedio; // Actualizar la semilla con los dígitos del medio
        return X; // Devolver el número generado
    }

    public static void main(String[] args) {
        do {
            X = JOptionPane.showInputDialog("Introduce la semilla (debe tener más de 3 dígitos):");
            if (X.length() < 4) {
                JOptionPane.showMessageDialog(null, "La semilla debe tener más de 3 dígitos. Intenta de nuevo.");
            } else {
                break;
            }
        } while (true);

        StringBuilder numerosGenerados = new StringBuilder("<html>Números generados:<br>");
        int cantidadDeNumeros = 10; // Generar 10 números, ajusta este valor según necesites
        for (int i = 0; i < cantidadDeNumeros; i++) {
            numerosGenerados.append(operaciones()).append("<br>"); // Acumular los números generados
        }
        numerosGenerados.append("</html>");

        // Mostrar los números generados en un diálogo
        JOptionPane.showMessageDialog(null, numerosGenerados.toString());
    }
}

