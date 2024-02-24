package Backend;

import java.util.Arrays;
import java.util.Scanner;

public class Sistemas {

     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] palabrasLenguaje1 = obtenerPalabras(input, "lenguaje 1");
        String[] palabrasLenguaje2 = obtenerPalabras(input, "lenguaje 2");

        // Imprimir las palabras ingresadas
        System.out.println("Palabras en lenguaje 1: " + Arrays.toString(palabrasLenguaje1));
        System.out.println("Palabras en lenguaje 2: " + Arrays.toString(palabrasLenguaje2));
        
        Sistemas menu = new Sistemas();
        int opcionSeleccionada;

        do {
            opcionSeleccionada = menu.mostrarMenuOpciones();

            switch (opcionSeleccionada) {
                case 1:
                    menu.metodoInterseccion(palabrasLenguaje1, palabrasLenguaje2);
                    break;
                case 2:
                    // Opción 2
                    break;
                // Agrega más casos según sea necesario

            }
        } while (opcionSeleccionada != 6);

        System.out.println("Saliendo del sistema.");
    }

    private static String[] obtenerPalabras(Scanner input, String nombreLenguaje) {
        System.out.println("¿Cuantas palabras tiene el " + nombreLenguaje + "?");
        int cantidadPalabras = input.nextInt();

        System.out.println("Ingresa las " + cantidadPalabras + " palabras de " + nombreLenguaje);
        String[] palabras = new String[cantidadPalabras];

        for (int i = 0; i < cantidadPalabras; i++) {
            palabras[i] = input.next();
        }

        return palabras;
    }

    public int mostrarMenuOpciones() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nMenu: ");
        System.out.println("1. Interseccion");
        System.out.println("2. Diferencia");
        System.out.println("3. Concatenacion");
        System.out.println("4. Prefijos de una palabra");
        System.out.println("5. Sufijos de una palabra");
        System.out.println("6. Salir del sistema");
        System.out.println("-> Ingresa la opcion a ejecutar: ");
        int opcion = input.nextInt();

        return opcion;
    }

    public void metodoInterseccion(String[] palabrasLenguaje1, String[] palabrasLenguaje2) {
        boolean hayInterseccion = false;

        System.out.println("Intersección de palabras:");

        for (String palabra : palabrasLenguaje1) {
            if (Arrays.asList(palabrasLenguaje2).contains(palabra)) {
                System.out.println(palabra);
                hayInterseccion = true;
            }
        }

        // Mostrar el símbolo de vacío si no hay intersección
        if (!hayInterseccion) {
            System.out.println("∅ (conjunto vacío)");
        }
    }
    
}
