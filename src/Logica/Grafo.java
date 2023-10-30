package Logica;
/*
import java.awt.Point*; */

import java.util.HashSet;
import java.util.List;
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

	// Agregado de aristas
	public void agregarArista(int fila, int col, int peso) {
		verificarVertice(fila);
		verificarVertice(col);
		verificarDistintos(fila, col);

		A[fila][col] = peso;
		A[col][fila] = peso;
	}

	public int pesoMax() {
		int pesoMAximo = 0;
		for (int fila = 0; fila < this.tamano(); fila++) {
			for (int col = 0; col < this.tamano(); col++) {
				if (fila != col)
					if (pesoMAximo == 0) {
						pesoMAximo = pesoArista(fila, col);
					} else {

						pesoMAximo = Math.max(pesoMAximo, pesoArista(fila, col));
					}
			}
		}
		return pesoMAximo;
	}


    private int pesoMin() {
        int pesoMinimo = 0;
        for (int fila = 0; fila < this.tamano(); fila++) {
            for (int col = 0; col < this.tamano(); col++) {
                if (fila != col)
                    if (pesoMinimo == 0) {
                        pesoMinimo = pesoArista(fila, col);
                    } else {

                        pesoMinimo = Math.min(pesoMinimo, pesoArista(fila, col));
                    }
            }
        }
        return pesoMinimo;
    }

    public int pesoPromedio() {
        int pesoPromedio = 0;
        for (int fila = 0; fila < this.tamano(); fila++) {
            for (int col = 0; col < this.tamano(); col++) {
                if (fila != col)
                    pesoPromedio += pesoArista(fila, col);
            }
        }
        return pesoPromedio / (this.tamano() * (this.tamano() - 1));
    }




	/* public Point verticesRelacionado(int pesoMax) {
		return buscarPeso(pesoMax);
	}

	private Point buscarPeso(int pesoMax) {
		Point p = new Point();
		for (int fila = 0; fila < this.tamano(); fila++) {
			for (int col = 0; col < this.tamano(); col++) {
				if (fila != col && this.pesoArista(fila, col) == pesoMax)
					p.setLocation(fila, col);
			}
		}

		return p;
	} */

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

		// return A[i][j] == A[j][i];
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

	/* manejo de cosas del grafo */
	public void agregarVecinos(List<Vertice> Vertices) {
		//System.out.println(Verticess.size());

		for (int fila = 0; fila < Vertices.size(); fila++) {
			agregarVecinos(fila, Vertices.get(fila), Vertices);
		}

	}

	private void agregarVecinos(int fila, Vertice Vertice, List<Vertice> Vertices) {
		//System.out.println(Verticess.size());
		for (int col = 0; col < Vertices.size(); col++) {
			if (fila != col)
				agregarArista(fila, col, Vertice.calcularSimilaridad(Vertices.get(col).getIntereses()));
		}
	}

	public int pesoArista(int fil, int col) {
		verificarVertice(fil);
		verificarVertice(col);
		verificarDistintos(fil, col);
		return A[fil][col];
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


    public void imprimirGrafo() {
        for (int fila = 0; fila < this.tamano(); fila++) {
            for (int col = 0; col < this.tamano(); col++) {
                if (fila != col)
                    System.out.println(fila + " -> " + col + " : " + this.pesoArista(fila, col));
            }
        }
    }

    //main

    public static void main(String[] args) {
        Grafo g = new Grafo(5);
        g.agregarArista(0, 1, 1);
        g.agregarArista(0, 2, 2);
        g.agregarArista(0, 3, 5);
        g.agregarArista(0, 4, 3);
        g.agregarArista(1, 2, 6);
        g.agregarArista(1, 3, 2);
        g.agregarArista(1, 4, 1);
        g.agregarArista(2, 3, 3);
        g.agregarArista(2, 4, 6);
        g.agregarArista(3, 4, 4);
        g.imprimirGrafo();
        System.out.println("Peso maximo: " + g.pesoMax());
        System.out.println("Peso minimo: " + g.pesoMin());
        System.out.println("Peso promedio: " + g.pesoPromedio());
    }



}
