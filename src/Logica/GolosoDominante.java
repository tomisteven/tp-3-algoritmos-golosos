package Logica;

import java.util.*;


public class GolosoDominante {

    private HashMap<Integer, ArrayList<Integer>> _matriz;

    public GolosoDominante(HashMap<Integer, ArrayList<Integer>> matriz) {
        _matriz = matriz;
    }



    public Set<Integer> conjuntoDominanteHeuristico() {
        // Inicializamos el conjunto dominante y los vértices cubiertos
        Set<Integer> conjuntoDominante = new HashSet<>();
        Set<Integer> verticesCubiertos = new HashSet<>();

        // Mientras no se hayan cubierto todos los vértices
        while (verticesCubiertos.size() < _matriz.size()) {
            int mejorVertice = -1;
            int maxVecinosNoCubiertos = -1;

            // Iteramos sobre todos los vértices
            for (int vertice : _matriz.keySet()) {
                if (!verticesCubiertos.contains(vertice)) {
                    ArrayList<Integer> vecinos = _matriz.get(vertice);
                    int vecinosNoCubiertos = 0;

                    // Contamos los vecinos no cubiertos
                    for (int vecino : vecinos) {
                        if (!verticesCubiertos.contains(vecino)) {
                            vecinosNoCubiertos++;
                        }
                    }

                    // Si encontramos un vértice con más vecinos no cubiertos, lo seleccionamos
                    if (vecinosNoCubiertos > maxVecinosNoCubiertos) {
                        maxVecinosNoCubiertos = vecinosNoCubiertos;
                        mejorVertice = vertice;
                    }
                }
            }

            // Si encontramos un vértice, lo añadimos al conjunto dominante y actualizamos l
            // s vértices cubiertos
            if (mejorVertice != -1) {
                conjuntoDominante.add(mejorVertice);
                verticesCubiertos.add(mejorVertice);

                // Añadimos también los vecinos a los vértices cubiertos
                for (int vecino : _matriz.get(mejorVertice)) {
                    verticesCubiertos.add(vecino);
                }
            } else {
                break; // No se pudo cubrir más vértices
            }
        }

        // Imprimimos el conjunto dominante y lo retornamos
        System.out.println("Conjunto Dominante: " + conjuntoDominante);
        return conjuntoDominante;
    }



}
