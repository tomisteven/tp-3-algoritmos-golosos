package UI;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoDeVertice {
	private ArrayList<Integer> _vertices;

	public ConjuntoDeVertice() {
		_vertices = new ArrayList<Integer>();
	}

	public void agregarVertice(int vertice) {
		esVerticeValido(vertice);
		_vertices.add(vertice);
	}

	private void esVerticeValido(int vertice) {
		if (_vertices.contains(vertice))
			throw new IllegalArgumentException(" Elemento ya ingresado");
	}

	public List<Integer> conjuntoVertices() {
		return verticesClonados();
	}

	private List<Integer> verticesClonados() {
		List<Integer> ret = new ArrayList<Integer>();
		for (Integer vertice : _vertices) {
			ret.add(vertice);
		}

		return ret;
	}
}
