
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ar90w
 */
public class Cuadrados_Medios {
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

        // Convertir los dígitos en un número decimal de la forma 0.XXXX
        String numeroDecimal = "0." + X;
        return numeroDecimal; // Devolver el número en formato decimal
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
        int cantidadDeNumeros = 10; // Ajusta este valor según necesites
        for (int i = 0; i < cantidadDeNumeros; i++) {
            numerosGenerados.append(operaciones()).append("<br>"); // Acumular los números generados
        }
        numerosGenerados.append("</html>");

        // Mostrar los números generados en un diálogo
        JOptionPane.showMessageDialog(null, numerosGenerados.toString());
    }
}
