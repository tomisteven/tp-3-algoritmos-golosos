package Logica;
/*
import java.awt.Point*; */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grafo {

	private int[][] A;

	// La cantidad de vertices esta predeterminada desde el constructor
	public Grafo(int vertices) {
		A = new int[vertices][vertices];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				A[i][j] = -1;
			}
		}
	}
	public Grafo(ArrayList<SolverArista> aristas)
	{
		A = new int[aristas.size()][aristas.size()] ;
		agregarArista(aristas);
	}

	private void agregarArista(ArrayList<SolverArista> aristas) {
		for (int f = 0 ; f < tamano(); f++) {
			agregarArista(aristas.get(f).getExtremoIzq(), aristas.get(f).getExtremoDer());;
			;


		}
	}
	// Agregado de aristas
	public void agregarArista(int fila, int col, int peso) {
		verificarVertice(fila);
		verificarVertice(col);
		verificarDistintos(fila, col);

		A[fila][col] = peso;
		A[col][fila] = peso;
	}

	/* en esta sobre carga el agregarArista comun no se usa es solo para jugar */
	public void agregarArista(int fila, int col) {
		verificarVertice(fila);
		verificarVertice(col);
		verificarDistintos(fila, col);

		A[fila][col] = 1;
		A[col][fila] = 1;

	}

	/*
	 * Eliminacion de aristas es inecesario por la implementacion aristas negativas
	 * no tienen relacion
	 */
	public void eliminarArista(int fila, int col) {
		verificarVertice(fila);
		verificarVertice(col);
		verificarDistintos(fila, col);

		A[fila][col] = -1;
		A[col][fila] = -1;
	}

	// Informa si existe la arista especificada
	public boolean existeArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		return A[i][j] >= 0;
	}

	// Cantidad de vertices
	public int tamano() {
		return A.length;
	}

	// Vecinos de un vertice
	public Set<Integer> vecinos(int i) {
		verificarVertice(i);

		Set<Integer> ret = new HashSet<Integer>();
		for (int j = 0; j < this.tamano(); ++j)
			if (i != j) {
				if (this.existeArista(i, j))
					ret.add(j);
			}

		return ret;
	}

	// Verifica que sea un vertice valido
	private void verificarVertice(int i) {
		if (i < 0)
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);

		if (i >= A.length)
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y " + (i - 1));
	}

	// Verifica que i y j sean distintos
	private void verificarDistintos(int i, int j) {
		if (i == j)
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}

    //main
}
