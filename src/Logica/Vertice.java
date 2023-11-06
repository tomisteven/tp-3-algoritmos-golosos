package Logica;

public class Vertice {
    private int indice;
    private int aristaDerecha;
    private int aristaIzquierda;

    public Vertice(int indice, int aristaDerecha, int aristaIzquierda) {
        this.indice = indice;
        this.aristaDerecha = aristaDerecha;
        this.aristaIzquierda = aristaIzquierda;
    }

    // Agrega getters si es necesario
    public int getIndice() {
        return indice;
    }

    public int getAristaDerecha() {
        return aristaDerecha;
    }

    public int getAristaIzquierda() {
        return aristaIzquierda;
    }
}
