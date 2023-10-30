package Logica;

public class Arista {

    private NodoGrafo origen;
    private NodoGrafo destino;
    private int peso;

    public Arista(NodoGrafo origen, NodoGrafo destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public NodoGrafo getOrigen() {
        return origen;
    }

    public void setOrigen(NodoGrafo origen) {
        this.origen = origen;
    }

    public NodoGrafo getDestino() {
        return destino;
    }

    public void setDestino(NodoGrafo destino) {
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

}
