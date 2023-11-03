package Logica;

import java.util.HashSet;
import java.util.Set;

public class Solver {
    // El grafo
    private Grafo _grafo;

    // inicio de la lista de aristas

    // La mejor clique hallada hasta el momento
    private Set<Integer> _mayor;

    // Auxiliar para la recursion
    private Set<Integer> _actual;

    // Cantidad de conjuntos generados
    private int _generados;

    // Un solver esta asociado a un unico grafo
    public Solver(Grafo grafo) {
        _grafo = grafo;
    }

    // Obtiene la clique maxima: O(n^2 * 2^n)
    public Set<Integer> resolver() {
        _mayor = new HashSet<Integer>();
        _actual = new HashSet<Integer>();

        generarDesde(0);
        return _mayor;
    }

    // Implementa la recursion
    private void generarDesde(int vertice) {
        if (vertice == _grafo.tamano()) {
            // Caso base
            if (Auxiliares.esClique(_grafo, _actual) && _actual.size() > _mayor.size())
                _mayor = clonar(_actual);

            // Cada subconjunto generado
            // System.out.println(_actual);
            _generados++;
        } else {
            // Caso recursivo
            _actual.add(vertice);
            generarDesde(vertice + 1);

            _actual.remove(vertice);
            generarDesde(vertice + 1);
        }
    }

    // Clonacion de un conjunto de enteros
    private Set<Integer> clonar(Set<Integer> conjunto) {
        Set<Integer> ret = new HashSet<Integer>();
        for (Integer i : conjunto)
            ret.add(i);

        return ret;
    }

    public int getGenerados() {
        return _generados;
    }

    public Grafo getGrafo() {
        return _grafo;
    }

    
    

    public static void main(String[] args) {
        Grafo grafo = new Grafo(3);

        Solver solver = new Solver(grafo);
        solver.resolver();
        

        System.out.println(solver.getGenerados() + " subconjuntos generados");
    }
}
