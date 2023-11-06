package Logica;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

<<<<<<< HEAD
class GrafoPrincipal {
	private HashMap<Integer, HashSet<Integer>> _matriz;

	public GrafoPrincipal(ConjuntoDeVertice vertices) {
		_matriz = new HashMap<Integer, HashSet<Integer>>();

		for ( Integer vertice: vertices.conjuntoVertices()) {
			_matriz.put(vertice, new HashSet<Integer>());
		}
	}

	/* en esta sobre carga el agregarArista comun no se usa es solo para jugar */
	public void agregarVecino(int vertice, int vecinoNuevo) {

		validarVertice(vertice);
		existeVecino(vertice,vecinoNuevo);
		agregar(vertice,vecinoNuevo);
=======
public class GrafoPrincipal {
    private boolean[][] matrizAdyacencia;
    private int numVertices;
    private ArrayList<Integer> _vertices;

    public GrafoPrincipal(ArrayList<SolverArista> aristas) {
        _vertices = new ArrayList<Integer>();
        matrizAdyacencia = new boolean[aristas.size()][aristas.size()];
        agregarArista(aristas);
    }

    public void agregarVertices() {
        _vertices.add(null);
    }

    private void agregarArista(ArrayList<SolverArista> aristas) {
        for (int f = 0; f < aristas.size(); f++) {
            /*
             * agregarArista(aristas.get(f).getExtremoIzq(),
             * aristas.get(f).getExtremoDer());;
             */
            ;
>>>>>>> 37d08358d73eb1a9b0f2e89365c789ba179fee50

        }
    }

    public void agregarVertice(int vertice) {
        if (_vertices.contains(_vertices.get(vertice))) {
            System.out.println("El vertice ya existe");
        } else {
            _vertices.add(vertice);
        }
    }

    /* en esta sobre carga el agregarArista comun no se usa es solo para jugar */
    public void agregarArista(int fila, int col) {

        matrizAdyacencia[fila][col] = true;

    }

	private void agregar(int vertice, int vecinoNuevo) {
		_matriz.get(vertice).add(vecinoNuevo);
	}

	private void existeVecino(int vertice,int vecinoNuevo) {
		_matriz.get(vertice).contains(vecinoNuevo);
	}

	private void validarVertice(int vertice) {
		if(!_matriz.containsKey(vertice)) {
			throw new RuntimeException("valor de vertice invalido");
		}
	}

	public void imprimirGrafo() {
		for (Integer clave : _matriz.keySet()) {
			System.out.print("Vertice " + clave );
			for ( Integer valor: _matriz.get(clave)) {
				
					System.out.print(" esta conectado con Vertice " + valor);
			}
			System.out.println();
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
//				if (matrizAdyacencia[mejorVertice][i]) {
//					cubiertos[i] = true;
//				}
			}
		}

	//	return conjuntoDominante;
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

<<<<<<< HEAD
		return mejorVertice;
	}
=======
    public static void main(String[] args) {
        ArrayList<SolverArista> aristas = new ArrayList<SolverArista>();
>>>>>>> 37d08358d73eb1a9b0f2e89365c789ba179fee50

	public int tamanio() {
		return _matriz.size();
	}

	private int contarVecinosNoCubiertos(int vertice, boolean[] cubiertos) {
		int count = 0;
		for (int i = 0; i < tamanio(); i++) {
//			if (matrizAdyacencia[vertice][i] && !cubiertos[i]) {
//				count++;
//			}
		}
		return count;
	}
	public boolean existeVertice(int vertice) {
		return _matriz.containsKey(vertice);
	}

	// main

	public static void main(String[] args) {
//		ArrayList<Integer> aristas = new ArrayList<Integer>();
		ConjuntoDeVertice vertices = new ConjuntoDeVertice(); 
		vertices.agregarVertice(2);
		vertices.agregarVertice(9);
		vertices.agregarVertice(5);
		GrafoPrincipal grafo = new GrafoPrincipal(vertices);

		grafo.imprimirGrafo();
//		Set<Integer> conjuntoDominante = grafo.conjuntoDominanteHeuristico();
//		System.out.println(grafo.conjuntoDominanteHeuristico());
//		for (int v : conjuntoDominante) {
//			System.out.print(v + " ");
//		}
	}

}
