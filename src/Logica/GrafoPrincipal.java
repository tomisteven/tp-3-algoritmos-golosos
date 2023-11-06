package Logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class GrafoPrincipal {
    private boolean[][] matrizAdyacencia;
    private int numVertices;

    public GrafoPrincipal(ArrayList<Arista> aristas) 
	{
		matrizAdyacencia = new boolean[aristas.size()][aristas.size()] ;
		agregarArista(aristas);
	}

	private void agregarArista(ArrayList<Arista> aristas) {
		for (int f = 0 ; f < aristas.size(); f++) {
			agregarArista(aristas.get(f).getExtremoIzq(), aristas.get(f).getExtremoDer());;
			;

			
		}
	}
	/* en esta sobre carga el agregarArista comun no se usa es solo para jugar */
	public void agregarArista(int fila, int col) {

		matrizAdyacencia[fila][col] = true;

	}

    public void imprimirGrafo() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdyacencia[i][j]) {
                    System.out.println("Vertice " + i + " esta conectado con Vertice " + j);
                }
            }
        }
    }

    public Set<Integer> conjuntoDominanteHeuristico() {
        Set<Integer> conjuntoDominante = new HashSet<>();
        boolean[] cubiertos = new boolean[numVertices];

        while (!todosCubiertos(cubiertos)) {
            int mejorVertice = encontrarMejorVertice(cubiertos);
            conjuntoDominante.add(mejorVertice);
            cubiertos[mejorVertice] = true;

            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[mejorVertice][i]) {
                    cubiertos[i] = true;
                }
            }
        }

        return conjuntoDominante;
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

        for (int i = 0; i < numVertices; i++) {
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

    private int contarVecinosNoCubiertos(int vertice, boolean[] cubiertos) {
        int count = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[vertice][i] && !cubiertos[i]) {
                count++;
            }
        }
        return count;
    }

    // main

    public static void main(String[] args) {
    	ArrayList<Arista> aristas = new ArrayList<Arista>();
    	aristas.add(new Arista(1,2));
    	aristas.add(new Arista(2,3));
    	aristas.add(new Arista(2,3));
    	aristas.add(new Arista(2,3));
    	aristas.add(new Arista(2,3));
    	aristas.add(new Arista(2,3));

        GrafoPrincipal grafo = new GrafoPrincipal(aristas);

        grafo.imprimirGrafo();
        Set<Integer> conjuntoDominante = grafo.conjuntoDominanteHeuristico();
        System.out.println(grafo.conjuntoDominanteHeuristico());
        for (int v : conjuntoDominante) {
            System.out.print(v + " ");
        }
    }

}
