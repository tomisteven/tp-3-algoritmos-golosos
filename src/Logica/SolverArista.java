package Logica;


public class SolverArista {

	private Vertice _vertices;
	private Grafo g;
	private GolosoDominante goloso;

	public SolverArista(Vertice vertices) {
		g = new Grafo(vertices);
	}

	public void conjuntoDominante(){
		goloso = new GolosoDominante(g.getMatriz());
		goloso.conjuntoDominanteHeuristico();
		System.out.println("CAMINO MINIMO" + goloso.conjuntoDominanteHeuristico());
	}

	public void agregarVecinos(int vertice, int vecino) {
		// buscamos el vertice y le agregamos el vecino
		g.agregarVecino(vertice, vecino);
	}



	public void agregarAristaEntre(int vertice1, int vertice2) {
		g.agregarVecino(vertice1, vertice2);
		;
	}

	public void imprimirGrafo() {
		g.imprimirGrafoCompleto();
	}

	public Vertice getVertices() {
		return _vertices;
	}



}
