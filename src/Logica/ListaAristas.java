package Logica;

public class ListaAristas {

    private NodoArista inicio;
    private NodoArista fin;

    private int tamano;

    public ListaAristas() {
        this.inicio = null;
        this.fin = null;
        this.tamano = 0;
    }

    public NodoArista getInicio() {
        return inicio;
    }

    public void setInicio(NodoArista inicio) {
        this.inicio = inicio;
    }

    public NodoArista getFin() {
        return fin;
    }

    public void setFin(NodoArista fin) {
        this.fin = fin;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public void insertarArista(Arista nueva) {
        NodoArista nuevo = new NodoArista(nueva);
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
            tamano++;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
            tamano++;
        }
    }

    public void eliminarArista(NodoGrafo destino) {
        if (inicio.getArista().getDestino() == destino) {
            inicio = inicio.getSiguiente();
            tamano--;
        } else {
            NodoArista aux = inicio;
            while (aux.getSiguiente().getArista().getDestino() != destino) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
            tamano--;
        }
    }

    public void imprimirListaAristas() {
        NodoArista aux = inicio;
        while (aux != null) {
            System.out.println(aux.getArista().getOrigen().getNombre() + " -> " + aux.getArista().getDestino().getNombre() + " : " + aux.getArista().getPeso());
            aux = aux.getSiguiente();
        }
    }
}
