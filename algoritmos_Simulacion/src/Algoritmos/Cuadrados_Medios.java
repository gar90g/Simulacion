package Algoritmos;

import java.util.HashSet;
import java.util.Set;

public class Cuadrados_Medios {

    public static String X = ""; // Semilla como cadena

    public String operaciones() {
        long numero = Long.parseLong(X);
        long cuadrado = numero * numero;
        String resultadoCuadrado = String.valueOf(cuadrado);

        // Asegurar que la cadena del cuadrado tenga una longitud mínima
        // basada en la longitud original de X (semilla).
        while (resultadoCuadrado.length() < X.length() * 2) {
            resultadoCuadrado = "0" + resultadoCuadrado;
        }

        int digitosParaQuitar = (resultadoCuadrado.length() - X.length()) / 2;
        // Asegurar que los índices para substring sean válidos.
        int inicio = Math.max(digitosParaQuitar, 0);
        int fin = Math.min(resultadoCuadrado.length() - digitosParaQuitar, resultadoCuadrado.length());

        String digitosDelMedio = resultadoCuadrado.substring(inicio, fin);
        if (digitosDelMedio.length() > X.length()) {
            digitosDelMedio = digitosDelMedio.substring(0, X.length());
        }
        X = digitosDelMedio; // Actualizar la semilla con los dígitos del medio

        // Convertir los dígitos en un número decimal de la forma 0.XXXX
        String numeroDecimal = "0." + X;
        return numeroDecimal; // Devolver el número en formato decimal
    }

    public String cuadradosMedios(String v, int cant) {
        Set<String> numerosVistos = new HashSet<>(); // Para almacenar los números generados y detectar repeticiones
        X = v;
        if (X.length() < 4) {
            return "La semilla debe tener más de 3 dígitos. Intenta de nuevo.";
        }

        StringBuilder numerosGenerados = new StringBuilder();
        int cantidadDeNumeros = cant;
        for (int i = 0; i < cantidadDeNumeros; i++) {
            String nuevoNumero = operaciones();
            if (!numerosVistos.add(nuevoNumero)) { // Si el número ya estaba en el set, se detiene la generación
                numerosGenerados.append("Se detectó repetición. Generación detenida.\n");
                break;
            }
            numerosGenerados.append(nuevoNumero).append("\n"); // Acumular los números generados con un salto de línea
        }

        return numerosGenerados.toString(); // Retorna la cadena de números generados
    }
}
