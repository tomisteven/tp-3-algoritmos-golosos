package Logica;

import java.awt.AWTException;
import java.util.ArrayList;

public class SolverArista {

	private Vertice _vertices;
	private Grafo g;
	private ArrayList<Arista> _aristas;

	public SolverArista(Vertice vertices) {
		_vertices = vertices;
		g = new Grafo(vertices);
	}

	public void agregarVertices(Vertice vertices) {
		_vertices = vertices;
	}

	public void ingresarAristas(ArrayList<Arista> aristas) {
		_aristas = aristas;
		for (Arista arista : aristas) {
			g.agregarVecino(arista.getExtemoIzq(), arista.getExtremoDer());
		}
	}

	public void agregarAristaEntre(int vertice1, int vertice2) {
		g.agregarVecino(vertice1, vertice2);
		;
	}

	public Vertice getVertices() {
		return _vertices;
	}

}
