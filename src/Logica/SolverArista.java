package Logica;

import java.awt.AWTException;

public class SolverArista {

    private ConjuntoDeVertice _vertices;
    private Grafo g ;

    public SolverArista(ConjuntoDeVertice vertices) {
        _vertices = vertices;
        g = new Grafo(_vertices.tamanio());
    }
    public void agregarVertices(ConjuntoDeVertice vertices) {
    	_vertices = vertices;
    }
    private boolean existenVertices(int vertice1, int vertice2 ) {
    	return _vertices.pertenece(vertice1) && _vertices.pertenece(vertice2)
    			;
    }
    public void agregarAristaEntre(int vertice1, int vertice2) {
    	validarVertice(vertice1,vertice2); 
    	g.agregarArista(vertice1, vertice2);
    }
	private void validarVertice(int vertice1, int vertice2) {
		if(!existenVertices(vertice1, vertice2)) {
			throw new IllegalArgumentException(" Vertices no encontrados");
		}
	}
	
}
