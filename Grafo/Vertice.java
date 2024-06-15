package Grafo;
import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String dato;
    private List<Arista> listaAristas;

    public Vertice(String valor) {
        this.dato = valor;
        this.listaAristas = new ArrayList<>();
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String valor) {
        this.dato = valor;
    }

    public List<Arista> getAristas() {
        return listaAristas;
    }

    public void setAristas(Arista arista) {
        if (listaAristas == null) {
            listaAristas = new ArrayList<>();
        }
        listaAristas.add(arista);
    }

    @Override
    public String toString() {
        return "Vertice: " + getDato();
    }
}
    