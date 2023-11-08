package Logica;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class GolosoDominante {

    private HashMap<Integer, ArrayList<Integer>> _matriz;

    public GolosoDominante(HashMap<Integer, ArrayList<Integer>> matriz) {
        _matriz = matriz;
    }

    public Set<Integer> conjuntoDominanteHeuristico() {
        Set<Integer> conjuntoDominante = new HashSet<>();
        Set<Integer> verticesCubiertos = new HashSet<>();

        while (verticesCubiertos.size() < _matriz.size()) {
            int mejorVertice = -1;
            int maxVecinosNoCubiertos = -1;

            for (int vertice : _matriz.keySet()) {
                if (!verticesCubiertos.contains(vertice)) {
                    ArrayList<Integer> vecinos = _matriz.get(vertice);
                    int vecinosNoCubiertos = 0;

                    for (int vecino : vecinos) {
                        if (!verticesCubiertos.contains(vecino)) {
                            vecinosNoCubiertos++;
                        }
                    }

                    if (vecinosNoCubiertos > maxVecinosNoCubiertos) {
                        maxVecinosNoCubiertos = vecinosNoCubiertos;
                        mejorVertice = vertice;
                    }
                }
            }

            if (mejorVertice != -1) {
                conjuntoDominante.add(mejorVertice);
                verticesCubiertos.add(mejorVertice);

                for (int vecino : _matriz.get(mejorVertice)) {
                    verticesCubiertos.add(vecino);
                }
            } else {
                break; // No se pudo cubrir más vértices
            }
        }
        System.out.println("Conjunto Dominante: " + conjuntoDominante);
        return conjuntoDominante;
    }

    public Set<Integer> conjuntoDominanteHeuristico2() {
        Set<Integer> conjuntoDominante = new HashSet<>();
        Set<Integer> verticesNoCubiertos = new HashSet<>(_matriz.keySet());

        while (!verticesNoCubiertos.isEmpty()) {
            int mejorVertice = -1;
            int maxGrado = -1;

            for (int vertice : verticesNoCubiertos) {
                int grado = _matriz.get(vertice).size();
                if (grado > maxGrado) {
                    maxGrado = grado;
                    mejorVertice = vertice;
                }
            }

            conjuntoDominante.add(mejorVertice);
            verticesNoCubiertos.remove(mejorVertice);

            for (int vecino : _matriz.get(mejorVertice)) {
                verticesNoCubiertos.remove(vecino);
            }
        }

        return conjuntoDominante;
    }


}
