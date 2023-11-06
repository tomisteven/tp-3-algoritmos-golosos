package Logica;

import java.util.HashSet;
import java.util.Set;

class GrafoPrincipal {

    private boolean[][] matrizAdyacencia;
    private int numVertices;
    private Vertice[] listaVertices;  // Cambiado a variable de instancia

    public GrafoPrincipal(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new boolean[numVertices][numVertices];
        listaVertices = new Vertice[numVertices];
    }

    public void agregarVertice(Vertice vertice) {
        if (vertice.getIndice() > 0 && vertice.getIndice() < numVertices) {
            boolean[][] nuevaMatriz = new boolean[numVertices + 1][numVertices + 1];
            for (int i = 0; i < numVertices; i++) {
                System.arraycopy(matrizAdyacencia[i], 0, nuevaMatriz[i], 0, numVertices);
            }
            matrizAdyacencia = nuevaMatriz;
            numVertices++;
            listaVertices[numVertices - 1] = vertice;  // Corregido

            // Agregar las aristas derecha e izquierda
            if (vertice.getAristaDerecha() >= 0 && vertice.getAristaDerecha() <= numVertices &&
                    vertice.getAristaIzquierda() >= 0 && vertice.getAristaIzquierda() <= numVertices) {

                matrizAdyacencia[numVertices - 1][vertice.getAristaDerecha()] = true;
                matrizAdyacencia[numVertices - 1][vertice.getAristaIzquierda()] = true;

                matrizAdyacencia[vertice.getAristaDerecha()][numVertices - 1] = true;
                matrizAdyacencia[vertice.getAristaIzquierda()][numVertices - 1] = true;
            } else {
                System.out.println("indice invalido");
            }
        } else {
            System.out.println("indice invalido, fuera");
        }
    }

    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = true;
        } else {
            System.out.println("Índices de vértices inválidos.");
        }
    }

    public void imprimirGrafo() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdyacencia[i][j]) {
                    System.out.println("Vértice " + i + " está conectado con Vértice " + j);
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

    public static void main(String[] args) {

        GrafoPrincipal grafo = new GrafoPrincipal(0);

        grafo.agregarVertice(new Vertice(0, 1, 2));
        grafo.agregarVertice(new Vertice(1, 2, 3));
        grafo.agregarVertice(new Vertice(2, 3, 4));
        grafo.agregarVertice(new Vertice(3, 4, 5));
        grafo.agregarVertice(new Vertice(4, 5, 6));
        grafo.agregarVertice(new Vertice(5, 6, 1));

        grafo.imprimirGrafo();


    }

}
