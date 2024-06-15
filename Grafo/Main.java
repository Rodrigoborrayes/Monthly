package Grafo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = new Grafo();
        int opcion;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar vertice");
            System.out.println("2. Agregar arista");
            System.out.println("3. Recorrer en profundidad (DFS)");
            System.out.println("4. Recorrer en anchura (BFS)");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opcion: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número: ");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor del vertice: ");
                    String valorVertice = scanner.next();
                    if (grafo.agregarVertice(valorVertice)) {
                        System.out.println("Vertice agregado.");
                    } else {
                        System.out.println("El vertice ya existe.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el vertice de inicio: ");
                    String inicio = scanner.next();
                    System.out.print("Ingrese el vertice de fin: ");
                    String fin = scanner.next();
                    System.out.print("Ingrese el peso de la arista: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Por favor, ingrese un número para el peso: ");
                        scanner.next();
                    }
                    int peso = scanner.nextInt();
                    if (grafo.validarPeso(peso)) {
                        if (grafo.agregarArista(inicio, fin, peso)) {
                            System.out.println("Arista agregada.");
                        } else {
                            System.out.println("Error al agregar la arista (vértices no existen o arista ya existe).");
                        }
                    } else {
                        System.out.println("Peso no válido (debe ser mayor que 0).");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el vertice de inicio para DFS: ");
                    String inicioDFS = scanner.next();
                    System.out.println("Recorrido en profundidad (DFS):");
                    grafo.dfs(inicioDFS);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Ingrese el vertice de inicio para BFS: ");
                    String inicioBFS = scanner.next();
                    System.out.println("Recorrido en anchura (BFS):");
                    grafo.bfs(inicioBFS);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
