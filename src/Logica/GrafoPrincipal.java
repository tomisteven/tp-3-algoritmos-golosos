package Logica;

import java.util.HashSet;
import java.util.Set;

class GrafoPrincipal {
    private boolean[][] matrizAdyacencia;
    private int numVertices;

    public GrafoPrincipal(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new boolean[numVertices][numVertices];
    }

    public void agregarVertice(int vertice, int aristaDerecha, int aristaIzquierda) {
        if (vertice >= 0 && vertice <= numVertices) {
            boolean[][] nuevaMatriz = new boolean[numVertices + 1][numVertices + 1];
            for (int i = 0; i < numVertices; i++) {
                System.arraycopy(matrizAdyacencia[i], 0, nuevaMatriz[i], 0, numVertices);
            }
            matrizAdyacencia = nuevaMatriz;
            numVertices++;

            // Agregar las aristas derecha e izquierda
            if (aristaDerecha >= 0 && aristaDerecha <= numVertices && aristaIzquierda >= 0 && aristaIzquierda <= numVertices) {
                matrizAdyacencia[numVertices - 1][aristaDerecha - 1] = true;
                matrizAdyacencia[numVertices - 1][aristaIzquierda - 1] = true;
                matrizAdyacencia[aristaDerecha - 1][numVertices - 1] = true;
                matrizAdyacencia[aristaIzquierda - 1][numVertices - 1] = true;
            } else {
                System.out.println("Índices de vértices inválidos.");
            }
        } else {
            System.out.println("Índice de vértice inválido.");
        }
    }

    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = true;
        } else {
            System.out.println("indices de vertices invalidos.");
        }
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
        GrafoPrincipal grafo = new GrafoPrincipal(6);

        grafo.agregarVertice(1, 2, 3);
        grafo.agregarVertice(2, 3, 4);
        grafo.agregarVertice(3, 4, 5);
        grafo.agregarVertice(4, 5, 6);

        grafo.imprimirGrafo();
        Set<Integer> conjuntoDominante = grafo.conjuntoDominanteHeuristico();
        System.out.println(grafo.conjuntoDominanteHeuristico());
        for (int v : conjuntoDominante) {
            System.out.print(v + " ");
        }
    }

}
