package tallertercercorte;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TallerOrdenamiento {

    private static List<Integer> lista = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Genera una lista de ejemplo o permite al usuario ingresar datos
        lista.add(5);
        lista.add(2);
        lista.add(9);
        lista.add(1);
        lista.add(6);

        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Seleccionar método de ordenación");
            System.out.println("2. Buscar el número más cercano a un valor dado");
            System.out.println("3. Contar números dentro de un rango");
            System.out.println("4. Sumar los primeros n elementos");
            System.out.println("5. Buscar el índice de un número dado");
            System.out.println("6. Calcular la media, mediana y moda");
            System.out.println("7. Encontrar el segundo mayor y el segundo menor valor");
            System.out.println("8. Invertir la lista ordenada");
            System.out.println("9. Mostrar la lista ordenada");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: seleccionarMetodoOrdenacion(scanner);
                    break;
                case 2: buscarNumeroCercano(scanner);
                    break;
                case 3: contarNumerosEnRango(scanner);
                    break;
                case 4: sumarPrimerosNElementos(scanner);
                    break;
                case 5: buscarIndiceDeNumero(scanner);
                    break;
                case 6: calcularMediaMedianaModa();
                    break;
                case 7: encontrarSegundoMayorYMenor();
                    break;
                case 8: invertirLista();
                    break;
                case 9: mostrarLista();
                    break;
                case 10: System.out.println("Saliendo del programa...");
                    break;
                default: System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 10);
        
        scanner.close();
    }

    private static void seleccionarMetodoOrdenacion(Scanner scanner) {
        System.out.println("Métodos de ordenación:");
        System.out.println("1. Burbuja");
        System.out.println("2. Inserción");
        System.out.println("3. Selección");
        System.out.print("Seleccione un método: ");
        int metodo = scanner.nextInt();

        switch (metodo) {
            case 1:
                ordenamientoBurbuja();
                break;
            case 2:
                ordenamientoInsercion();
                break;
            case 3:
                ordenamientoSeleccion();
                break;
            default:
                System.out.println("Método no válido.");
        }
    }

    private static void ordenamientoBurbuja() {
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - i - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    int temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
        System.out.println("Lista ordenada por burbuja: " + lista);
    }

    private static void ordenamientoInsercion() {
        for (int i = 1; i < lista.size(); i++) {
            int key = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j) > key) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, key);
        }
        System.out.println("Lista ordenada por inserción: " + lista);
    }

    private static void ordenamientoSeleccion() {
        for (int i = 0; i < lista.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(j) < lista.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = lista.get(minIndex);
            lista.set(minIndex, lista.get(i));
            lista.set(i, temp);
        }
        System.out.println("Lista ordenada por selección: " + lista);
    }

    private static void buscarNumeroCercano(Scanner scanner) {
        System.out.print("Ingrese un valor: ");
        int valor = scanner.nextInt();
        int cercano = lista.get(0);
        for (int num : lista) {
            if (Math.abs(num - valor) < Math.abs(cercano - valor)) {
                cercano = num;
            }
        }
        System.out.println("Número más cercano a " + valor + " es " + cercano);
    }

    private static void contarNumerosEnRango(Scanner scanner) {
        System.out.print("Ingrese el límite inferior del rango: ");
        int a = scanner.nextInt();
        System.out.print("Ingrese el límite superior del rango: ");
        int b = scanner.nextInt();
        int count = 0;
        for (int num : lista) {
            if (num >= a && num <= b) {
                count++;
            }
        }
        System.out.println("Números en el rango [" + a + ", " + b + "]: " + count);
    }

    private static void sumarPrimerosNElementos(Scanner scanner) {
        System.out.print("Ingrese el número de elementos a sumar: ");
        int n = scanner.nextInt();
        int suma = 0;
        for (int i = 0; i < n && i < lista.size(); i++) {
            suma += lista.get(i);
        }
        System.out.println("Suma de los primeros " + n + " elementos: " + suma);
    }

    private static void buscarIndiceDeNumero(Scanner scanner) {
        System.out.print("Ingrese el número a buscar: ");
        int numero = scanner.nextInt();
        int index = lista.indexOf(numero);
        if (index != -1) {
            System.out.println("Índice de " + numero + " es: " + index);
        } else {
            System.out.println("Número no encontrado en la lista.");
        }
    }

    private static void calcularMediaMedianaModa() {
        double suma = 0;
        for (int num : lista) {
            suma += num;
        }
        double media = suma / lista.size();
        System.out.println("Media: " + media);

        List<Integer> listaOrdenada = new ArrayList<>(lista);
        Collections.sort(listaOrdenada);
        double mediana = listaOrdenada.size() % 2 == 0
                ? (listaOrdenada.get(listaOrdenada.size() / 2 - 1) + listaOrdenada.get(listaOrdenada.size() / 2)) / 2.0
                : listaOrdenada.get(listaOrdenada.size() / 2);
        System.out.println("Mediana: " + mediana);

        // Cálculo de la moda (frecuencia)
        int moda = listaOrdenada.get(0);
        int maxCount = 1, currentCount = 1;
        for (int i = 1; i < listaOrdenada.size(); i++) {
            if (listaOrdenada.get(i) == listaOrdenada.get(i - 1)) {
                currentCount++;
            } else {
                currentCount = 1;
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                moda = listaOrdenada.get(i);
            }
        }
        System.out.println("Moda: " + moda);
    }

    private static void encontrarSegundoMayorYMenor() {
        List<Integer> listaOrdenada = new ArrayList<>(lista);
        Collections.sort(listaOrdenada);
        int segundoMenor = listaOrdenada.size() > 1 ? listaOrdenada.get(1) : listaOrdenada.get(0);
        int segundoMayor = listaOrdenada.size() > 1 ? listaOrdenada.get(listaOrdenada.size() - 2) : listaOrdenada.get(listaOrdenada.size() - 1);
        System.out.println("Segundo menor: " + segundoMenor);
        System.out.println("Segundo mayor: " + segundoMayor);
    }

    private static void invertirLista() {
        Collections.reverse(lista);
        System.out.println("Lista invertida: " + lista);
    }

    private static void mostrarLista() {
        System.out.println("Lista actual: " + lista);
    }
}
