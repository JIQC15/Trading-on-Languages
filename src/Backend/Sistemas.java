package Backend;

import java.util.ArrayList;
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
                    menu.metodoDiferencia(palabrasLenguaje1, palabrasLenguaje2);
                    break;
                case 3:
                    menu.metodoConcatenacion(palabrasLenguaje1, palabrasLenguaje2);
                    break;
                case 4:
                    menu.metodoPrefijos();
                    break;
                case 5:
                    menu.metodoSufijos();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Favor de ingresar una opcion valida!");

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
        System.out.println("Interseccion de palabras:");

        for (String palabra : palabrasLenguaje1) {
            if (Arrays.asList(palabrasLenguaje2).contains(palabra)) {
                System.out.println(palabra);
                hayInterseccion = true;
            }
        }

        if (!hayInterseccion) {
            System.out.println("∅ (conjunto vacío)");
        }
    }

    public void metodoDiferencia(String[] palabrasLenguaje1, String[] palabrasLenguaje2) {
        boolean hayDiferencia = false;
        System.out.println("Diferencia de palabras: ");

        for (String palabra : palabrasLenguaje1) {
            if (!(Arrays.asList(palabrasLenguaje2).contains(palabra))) {
                System.out.println(palabra);
                hayDiferencia = true;
            }
        }

        if (!hayDiferencia) {
            System.out.println("∅ (conjunto vacío)");
        }
    }

    public void metodoConcatenacion(String[] palabrasLenguaje1, String[] palabrasLenguaje2) {
        boolean hayConcatenacion = false;
        System.out.println("Concatenacion de Lenguajes: ");

        for (String palabra1 : palabrasLenguaje1) {
            for (String palabra2 : palabrasLenguaje2) {
                System.out.println(palabra1 + palabra2);
                hayConcatenacion = true;
            }
        }

        if (!hayConcatenacion) {
            System.out.println("∅ (conjunto vacío)");
        }
    }
    
    public void metodoPrefijos(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Prefijos de una palabra");
        System.out.println("-> Ingresa una palabra para mostrar los prefijos");
        String palabraIngresada = scanner.next();
        
        ArrayList<String> prefijos = new ArrayList<>();

        for(int i = palabraIngresada.length(); i > 0; i--){
            prefijos.add(palabraIngresada.substring(0, i));
        }
        
        prefijos.add("λ");
        
        System.out.print("{");
        for (int i = 0; i < prefijos.size(); i++) {
            System.out.print(prefijos.get(i));
            if (i < prefijos.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
    
    public void metodoSufijos(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Sufijos de una palabra");
        System.out.println("-> Ingresa una palabra para mostrar los sufijos");
        String palabraIngresada = scanner.next();
        
        ArrayList<String> sufijos = new ArrayList<>();
        
        for(int i = 0; i < palabraIngresada.length() ; i++){
            sufijos.add(palabraIngresada.substring(i));
        }
        
        sufijos.add("λ");
        
        System.out.print("{");
        for (int i = 0; i < sufijos.size(); i++) {
            System.out.print(sufijos.get(i));
            if (i < sufijos.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
