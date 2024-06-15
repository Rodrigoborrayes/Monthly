package Grafo;
import java.util.*;

public class Grafo {
    private Map<String, Vertice> vertices;
    private List<Arista> aristas;

    public Grafo() {
        this.vertices = new HashMap<>();
        this.aristas = new ArrayList<>();
    }

    public boolean agregarVertice(String dato) {
        if (vertices.containsKey(dato)) {
            return false;
        }
        vertices.put(dato, new Vertice(dato));
        return true;
    }

    public boolean agregarArista(String inicio, String fin, int peso) {
        if (!vertices.containsKey(inicio) || !vertices.containsKey(fin)) {
            return false;
        }

        Vertice verticeInicio = vertices.get(inicio);
        Vertice verticeFin = vertices.get(fin);

        // Validar que no haya aristas repetidas
        for (Arista arista : aristas) {
            if ((arista.getInicio().equals(verticeInicio) && arista.getFin().equals(verticeFin)) ||
                (arista.getInicio().equals(verticeFin) && arista.getFin().equals(verticeInicio))) {
                return false;
            }
        }

        Arista nuevaArista = new Arista(verticeInicio, verticeFin, peso);
        verticeInicio.setAristas(nuevaArista);
        verticeFin.setAristas(nuevaArista);
        aristas.add(nuevaArista);
        return true;
    }

    public void dfs(String inicio) {
        Set<String> visitados = new HashSet<>();
        Stack<String> pila = new Stack<>();
        pila.push(inicio);

        while (!pila.isEmpty()) {
            String vertice = pila.pop();
            if (!visitados.contains(vertice)) {
                visitados.add(vertice);
                System.out.print(vertice + " ");
                Vertice v = vertices.get(vertice);
                for (Arista arista : v.getAristas()) {
                    Vertice vecino = arista.getFin().equals(v) ? arista.getInicio() : arista.getFin();
                    if (!visitados.contains(vecino.getDato())) {
                        pila.push(vecino.getDato());
                    }
                }
            }
        }
    }

    public void bfs(String inicio) {
        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();
        cola.add(inicio);

        while (!cola.isEmpty()) {
            String vertice = cola.poll();
            if (!visitados.contains(vertice)) {
                visitados.add(vertice);
                System.out.print(vertice + " ");
                Vertice v = vertices.get(vertice);
                for (Arista arista : v.getAristas()) {
                    Vertice vecino = arista.getFin().equals(v) ? arista.getInicio() : arista.getFin();
                    if (!visitados.contains(vecino.getDato())) {
                        cola.add(vecino.getDato());
                    }
                }
            }
        }
    }

    public boolean validarPeso(int peso) {
        return peso > 0;
    }
}
