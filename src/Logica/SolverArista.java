package Logica;

public class SolverArista {

    private int _extremoDer;
    private int _extremoIzq;

    public SolverArista(int extremoIzq, int extremoDer) {
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
