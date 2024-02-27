package Algoritmos;

import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 /*
 * @author ar90w
 */
public class productos_Medios {

    public static String semilla1 = "";
    public static String semilla2 = "";
    public static String Y = "";
    public static int cantidadNumeros;
    private static Set<String> numerosGenerados = new HashSet<>();

    public static void comprobarSemillas(String sm1,String sm2) {
        semilla1 = sm1;
        semilla2 = sm2;
        if (semilla1.length() > 3 && semilla2.length() > 3 && semilla1.length() == semilla2.length()) {
            JOptionPane.showMessageDialog(null, "Semillas válidas. Procesando...");
        } else {
            JOptionPane.showMessageDialog(null, "Las semillas deben tener más de 3 dígitos y la misma longitud. Reinicie el programa e intente de nuevo.");
            System.exit(0); // Termina el programa si las semillas no son válidas
        }
    }

    public static void generarPseudoAl(int cant) {
        StringBuilder resultados = new StringBuilder(); // Usa StringBuilder para acumular los números
        numerosGenerados.clear(); // Limpia el conjunto para una nueva generación

        for (int i = 0; i < cantidadNumeros; i++) {
            int longitudSemilla = semilla1.length();
            long producto = Long.parseLong(semilla1) * Long.parseLong(semilla2);
            String productoStr = String.valueOf(producto);
            int digitosExtra = productoStr.length() - longitudSemilla;
            int inicio = Math.max(digitosExtra / 2, 0); // Asegurar que el inicio no sea negativo
            Y = productoStr.substring(Math.min(inicio, productoStr.length()), Math.min(inicio + longitudSemilla, productoStr.length())); // Asegurar que los índices estén dentro de los límites

            if (!numerosGenerados.add(Y)) {
                // Si el número ya fue generado antes, detener la generación
                break;
            }
            // Convierte Y en un número decimal de formato "0.Y"
            String numeroPseudoaleatorio = "0." + Y;

            // Agrega el número generado al StringBuilder
            resultados.append(numeroPseudoaleatorio).append("\n");

            // Actualizar semillas para la próxima iteración
            semilla1 = semilla2;
            semilla2 = Y;
        }
    }

}
