package Logica;

public class NodoGrafo {
    private String nombre;
    private ListaAristas listaAristas;
    private NodoGrafo siguiente;

    public NodoGrafo(String nombre) {
        this.nombre = nombre;
        this.listaAristas = new ListaAristas();
        this.siguiente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public ListaAristas getListaAristas() {
        return listaAristas;
    }

    public NodoGrafo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoGrafo siguiente) {
        this.siguiente = siguiente;
    }
}
