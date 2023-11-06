package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
		existeVecino(vertice, vecinoNuevo);
		agregar(vertice, vecinoNuevo);
	}

	private void agregar(int vertice, int vecinoNuevo) {
		_matriz.get(vertice).add(vecinoNuevo);
		_matriz.get(vecinoNuevo).add(vertice);
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
		if (vecinos(vertice).contains(vertice)) {
			throw new RuntimeException("No puede existir loops");
		}
	}

	public void imprimirGrafo() {
		for (Integer clave : _matriz.keySet()) {
			System.out.print("Vertice " + " - " + clave);
		}

	}

	public Set<Integer> conjuntoDominanteHeuristico() {
		Set<Integer> conjuntoDominante = new HashSet<>();
		boolean[] cubiertos = new boolean[tamanio()];

		while (!todosCubiertos(cubiertos)) {
			int mejorVertice = encontrarMejorVertice(cubiertos);
			conjuntoDominante.add(mejorVertice);
			cubiertos[mejorVertice] = true;

			for (int i = 0; i < tamanio(); i++) {
				// if (matrizAdyacencia[mejorVertice][i]) {
				// cubiertos[i] = true;
				// }
			}
		}

		// return conjuntoDominante;
		return null;
	}

	private boolean todosCubiertos(boolean[] cubiertos) {
		for (boolean cubierto : cubiertos) {
			if (!cubierto) {
				return false;
			}
		}
		return true;
	}

	private int encontrarMejorVertice(boolean[] cubiertos) {
		int mejorVertice = -1;
		int maxVecinosNoCubiertos = -1;

		for (int i = 0; i < tamanio(); i++) {
			if (!cubiertos[i]) {
				int vecinosNoCubiertos = contarVecinosNoCubiertos(i, cubiertos);
				if (vecinosNoCubiertos > maxVecinosNoCubiertos) {
					maxVecinosNoCubiertos = vecinosNoCubiertos;
					mejorVertice = i;
				}
			}
		}

		return mejorVertice;
	}

	public int tamanio() {
		return _matriz.size();
	}

	private int contarVecinosNoCubiertos(int vertice, boolean[] cubiertos) {
		int count = 0;
		for (int i = 0; i < tamanio(); i++) {
			// if (matrizAdyacencia[vertice][i] && !cubiertos[i]) {
			// count++;
			// }
		}
		return count;
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
	}

}
