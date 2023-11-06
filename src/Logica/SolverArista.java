package Logica;

public class SolverArista {

    private ConjuntoDeVertice _vertices;

    public SolverArista(ConjuntoDeVertice vertices) {
        _vertices = vertices;
    }
    public void agregarVertices(ConjuntoDeVertice vertices) {
    	_vertices = vertices;
    }
    public boolean existenVertices(int vertice1, int vertice2 ) {
    	return _vertices.pertenece(vertice1) && _vertices.pertenece(vertice2);
    }
}
