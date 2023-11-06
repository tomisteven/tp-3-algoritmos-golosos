package Logica;

public class Arista {
    private int _extremoDer;
    private int _extremoIzq;

    public Arista( int extremoDer,int extremoIzq) {
        _extremoDer = extremoDer;
        _extremoIzq= extremoIzq;
    }

    public int getExtremoDer() {
        return _extremoDer;
    }

    public int getExtemoIzq() {
        return _extremoIzq;
    }
}
