package Logica;

public class NodoArista {
    private Arista arista;
    private NodoArista siguiente;

    public NodoArista(Arista arista) {
        this.arista = arista;
        this.siguiente = null;
    }

    public Arista getArista() {
        return arista;
    }

    public NodoArista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoArista siguiente) {
        this.siguiente = siguiente;
    }
}
