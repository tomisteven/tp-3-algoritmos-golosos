package Logica;

public class Arista {

    private int _extremoDer;
    private int _extremoIzq;

    public Arista(int extremoIzq, int extremoDer) {
        _extremoIzq = extremoIzq;
        _extremoDer = extremoDer;
    }

    public int getExtremoIzq() {
        return _extremoIzq;
    }

    public int getExtremoDer() {
        return _extremoDer;
    }
}
