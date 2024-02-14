
import javax.swing.*;

class pMedios {

    public static String semilla1 = "";
    public static String semilla2 = "";
    public static String Y = "";
    public static int cantidadNumeros;

    public static void comprobarSemillas() {
        semilla1 = JOptionPane.showInputDialog(null, "Introduzca la primera semilla (más de 3 dígitos):");
        semilla2 = JOptionPane.showInputDialog(null, "Introduzca la segunda semilla (debe tener la misma longitud que la primera):");
        if (semilla1.length() > 3 && semilla2.length() > 3 && semilla1.length() == semilla2.length()) {
            JOptionPane.showMessageDialog(null, "Semillas válidas. Procesando...");
        } else {
            JOptionPane.showMessageDialog(null, "Las semillas deben tener más de 3 dígitos y la misma longitud. Reinicie el programa e intente de nuevo.");
            System.exit(0); // Termina el programa si las semillas no son válidas
        }
    }

    public static void generarPseudoAl() {
        StringBuilder resultados = new StringBuilder("<html>Números pseudoaleatorios generados:<br>"); // Usa StringBuilder para acumular los números
        for (int i = 0; i < cantidadNumeros; i++) {
            int longitudSemilla = semilla1.length();
            long producto = Long.parseLong(semilla1) * Long.parseLong(semilla2);
            String productoStr = String.valueOf(producto);
            int digitosExtra = productoStr.length() - longitudSemilla;
            int inicio = digitosExtra / 2;
            Y = productoStr.substring(inicio, inicio + longitudSemilla);

            // Convierte Y en un número decimal de formato "0.Y"
            String numeroPseudoaleatorio = "0." + Y;

            // Agrega el número generado al StringBuilder, con un salto de línea para cada número
            resultados.append(numeroPseudoaleatorio).append("<br>");

            semilla1 = semilla2; // Actualiza semilla1 con el valor de semilla2 para la próxima iteración
            semilla2 = Y; // Actualiza semilla2 con el nuevo número generado
        }
        resultados.append("</html>"); // Cierra el formato HTML
        JOptionPane.showMessageDialog(null, resultados.toString()); // Muestra todos los números generados de una vez
    }

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(null, "¿Cuántos números pseudoaleatorios desea generar?");
        try {
            cantidadNumeros = Integer.parseInt(input);
            comprobarSemillas();
            generarPseudoAl();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe introducir un número válido. Reinicie el programa e intente de nuevo.");
            System.exit(0);
        }
    }
}
