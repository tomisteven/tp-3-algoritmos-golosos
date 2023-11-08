package Logica;

import java.util.ArrayList;
import java.util.List;

public class Vertice {

	private ArrayList<Integer> _vertices;

	public Vertice() {
		_vertices = new ArrayList<Integer>();
	}

	public void agregarVertice(int vertice) {
		esVerticeValido(vertice);
		_vertices.add(vertice);
	}

	private void esVerticeValido(int vertice) {
		if (pertenece(vertice))
			throw new IllegalArgumentException(" Elemento ya ingresado");
	}

	public List<Integer> conjuntoVertices() {
		return verticesClonados();
	}

	public boolean pertenece(int elemento) {
		return _vertices.contains(elemento);
	}




	private List<Integer> verticesClonados() {
		List<Integer> ret = new ArrayList<Integer>();
		for (Integer vertice : _vertices) {
			ret.add(vertice);
		}

		return ret;
	}

	public void imprimirGrafo() {
		for (int i = 0; i < _vertices.size(); i++) {
			System.out.println(_vertices.get(i));
		}
	}

	public int tamanio() {
		return _vertices.size();
	}

}
