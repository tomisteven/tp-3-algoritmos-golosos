package Logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
	}

	private void validarLoop(int vertice, int vecinoNuevo) {
		if (vertice == vecinoNuevo) {
			throw new RuntimeException("No puede existir loops");
		}
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

	}

	public void imprimirGrafo() {
		for (Integer clave : _matriz.keySet()) {
			System.out.print("Vertice " + " - " + clave);
		}

	}

	public Collection<ArrayList<Integer>> conjuntoVertice() {
		return _matriz.values();
	}

	/* public void esConexo() {
		Set<Integer> conjuntoDeVertice = new HashSet<Integer>();
		ArrayList<Integer> orden = ordenDeRecorrido();
		while (conjuntoDeVertice.size() != orden.size())
			for (int v : orden) {
				unir(conjuntoDeVertice, vecinos(v));
			}
		if (conjuntoDeVertice.size() == orden.size()) {
			System.out.println("Es conexo");
		} else {
			System.out.println("No es conexo");
		}
	} */

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
		for (int v : vecinos) {
			conjuntoDeVertice.add(v);
		}

	}

	ArrayList<Integer> ordenDeRecorrido() {
		ArrayList<Integer> orden = new ArrayList<Integer>();
		ArrayList<Integer> verticesPorRecorrer = vertices();

		while (0 != verticesPorRecorrer.size()) {
			int mayor = verticeConMasVecinos(verticesPorRecorrer);
			orden.add(mayor);
			// verticesPorRecorrer.remove(mayor);
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

	public HashMap<Integer, ArrayList<Integer>> getMatriz() {
		return _matriz;
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
	public List<String> obtenerListaDeVerticesYVecinos() {
        List<String> lista = new ArrayList<>();
        for (Integer vertice : _matriz.keySet()) {
            StringBuilder infoVertice = new StringBuilder();
            infoVertice.append("Vertice ").append(vertice).append(" - ");
            ArrayList<Integer> vecinos = _matriz.get(vertice);

            for (Integer vecino : vecinos) {
                infoVertice.append(vecino).append(" ");
            }

            lista.add(infoVertice.toString());
        }

        return lista;
    }


 	public static void main(String[] args) {
		Vertice vertices = new Vertice();
		vertices.agregarVertice(1);
		vertices.agregarVertice(2);
		vertices.agregarVertice(3);
		vertices.agregarVertice(4);
		vertices.agregarVertice(5);
		vertices.agregarVertice(6);

		Grafo grafo = new Grafo(vertices);
		grafo.agregarVecino(1, 2);
		grafo.agregarVecino(2, 3);
		grafo.agregarVecino(2, 6);
		grafo.agregarVecino(4, 2);
		grafo.agregarVecino(5, 4);


		/* GolosoDominante goloso = new GolosoDominante(grafo.getMatriz());

		System.out.println("CAMINO MINIMO" + goloso.conjuntoDominanteHeuristico()); */
/*
		grafo.esConexo(); */



	}

}
