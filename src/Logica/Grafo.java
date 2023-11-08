package Logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Grafo {

	private HashMap<Integer, ArrayList<Integer>> _matriz;

	public Grafo(Vertice vertices) {
		_matriz = new HashMap<Integer, ArrayList<Integer>>();

		for (Integer vertice : vertices.conjuntoVertices()) {
			_matriz.put(vertice, new ArrayList<Integer>());
		}
	}

	/* en esta sobre carga el agregarArista comun no se usa es solo para jugar */
	public void agregarVecino(int vertice, int vecinoNuevo) {

		validarVertice(vertice);
		validarVertice(vecinoNuevo);
		validarLoop(vertice, vecinoNuevo);
		existeVecino(vertice, vecinoNuevo);
		agregar(vertice, vecinoNuevo);
		agregar(vecinoNuevo, vertice);
	}

	private void validarLoop(int vertice, int vecinoNuevo) {
		if (vertice == vecinoNuevo) {
			throw new RuntimeException("No puede existir loops");
		}
	}

	private void agregar(int vertice, int vecinoNuevo) {
		_matriz.get(vertice).add(vecinoNuevo);
	}

	private void existeVecino(int vertice, int vecinoNuevo) {
		if (vecinos(vertice).contains(vecinoNuevo)) {
			throw new RuntimeException("valor de vertice invalido, ya existe vecino");
		}
	}

	void validarVertice(int vertice) {
		if (!vertices().contains(vertice)) {
			throw new RuntimeException("valor de vertice invalido");
		}

	}

	public void imprimirGrafo() {
		for (Integer clave : _matriz.keySet()) {
			System.out.print("Vertice " + " - " + clave);
		}

	}

	public Collection<ArrayList<Integer>> conjuntoVertice() {
		return _matriz.values();
	}

	public Set<Integer> solucion() {
		Set<Integer> ret = new HashSet<Integer>();
		ArrayList<Integer> orden = ordenDeRecorrido();
		Set<Integer> conjuntoDeVertice = new HashSet<Integer>();

		while (conjuntoDeVertice.size() != orden.size())
			for (int v : orden) {
				unir(conjuntoDeVertice, vecinos(v));
				ret.add(v);
			}
		return ret;
	}

	private void unir(Set<Integer> conjuntoDeVertice, ArrayList<Integer> vecinos) {
		for(int v :vecinos) {
			conjuntoDeVertice.add(v);
		}

	}

	 ArrayList<Integer> ordenDeRecorrido() {
		ArrayList<Integer> orden = new ArrayList<Integer>();
		ArrayList<Integer> verticesPorRecorrer = vertices();

		while (0 != verticesPorRecorrer.size()) {
			int mayor = verticeConMasVecinos(verticesPorRecorrer);
			orden.add(mayor);
//			verticesPorRecorrer.remove(mayor);
		}
		return orden;
	}

	private Integer verticeConMasVecinos(ArrayList<Integer> verticesPorRecorrer) {
		int cantVecinos = vecinos(verticesPorRecorrer.get(0)).size();
		for (Integer v : verticesPorRecorrer)
			if (cantVecinos < vecinos(v).size())
				cantVecinos = vecinos(v).size();
		return cantVecinos;
	}

	public int tamanio() {
		return _matriz.size();
	}

	public boolean existeVertice(int vertice) {
		return _matriz.containsKey(vertice);
	}

	public ArrayList<Integer> vecinos(int vertice) {

		return _matriz.get(vertice);
	}

	public int cantidadVecinos(int vertice) {
		return vecinos(vertice).size();
	}

	public ArrayList<Integer> vertices() {
		ArrayList<Integer> vertices = new ArrayList<Integer>();
		for (Integer vertice : _matriz.keySet()) {
			vertices.add(vertice);
		}
		return vertices;
	}

	public void imprimirGrafoCompleto() {
		for (Integer vertice : _matriz.keySet()) {
			System.out.print("Vertice " + vertice + " - ");
			ArrayList<Integer> vecinos = _matriz.get(vertice);
			for (Integer vecino : vecinos) {
				System.out.print(vecino + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Vertice vertices = new Vertice();
		vertices.agregarVertice(1);
		vertices.agregarVertice(2);
		vertices.agregarVertice(3);
		vertices.agregarVertice(4);
		vertices.agregarVertice(5);

		Grafo grafo = new Grafo(vertices);
		grafo.agregarVecino(1, 2);
		grafo.agregarVecino(1, 3);
		grafo.agregarVecino(1, 4);
		grafo.agregarVecino(1, 5);
		grafo.agregarVecino(2, 3);
		grafo.agregarVecino(2, 4);
		grafo.agregarVecino(4, 5);
		grafo.agregarVecino(5, 3);
		

		grafo.imprimirGrafoCompleto();
		System.out.println("Cantidad de vecinos de 1: " + grafo.cantidadVecinos(1));
		System.out.println("conjunto dominante : " + grafo.solucion().toString());

	}

}
