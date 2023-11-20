package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Logica.GolosoDominante;
import Logica.Grafo;
import Logica.Vertice;

public class GrafoTest {
	private Vertice v;
	private Grafo g;
	private int[] vecinosPosiblesAlVertice1;
	private int[] vecinosPosiblesAlVertice2;
	private int[] vecinosPosiblesAlVertice3;
	private int[] vecinosPosiblesAlVertice4;
	private int[] vecinosPosiblesAlVertice5;
	private int[] verticeDelGrafo;

	@Before
	public void inicializar() {
		vecinosPosiblesAlVertice1 = new int[] { 2 };
		vecinosPosiblesAlVertice2 = new int[] { 1, 3, 4 };
		vecinosPosiblesAlVertice3 = new int[] { 2 };
		vecinosPosiblesAlVertice4 = new int[] { 2, 5 };
		vecinosPosiblesAlVertice5 = new int[] { 4 };
		verticeDelGrafo = new int[] { 1, 2, 3, 4, 5 };

		v = crearVertices();
		g = crearGrafo(v);
	}

	@Test
	public void cantidadDeVerticeTest() {
		assertTrue(g.tamanio() == v.tamanio());
	}

	@Test
	public void conjuntoDeVecinosTest() {
		relacionarVecinos();
		assertTrue(seRelacionan(g.conjuntoVertice(), vecinosPosiblesAlVertice1));
		assertTrue(seRelacionan(g.conjuntoVertice(), vecinosPosiblesAlVertice2));
		assertTrue(seRelacionan(g.conjuntoVertice(), vecinosPosiblesAlVertice3));
		assertTrue(seRelacionan(g.conjuntoVertice(), vecinosPosiblesAlVertice4));
		assertTrue(seRelacionan(g.conjuntoVertice(), vecinosPosiblesAlVertice5));

	}

	private boolean seRelacionan(Collection<ArrayList<Integer>> conjuntoVertice, int[] vecinosPosiblesAlVertice) {
		boolean ret = false;
		for (ArrayList<Integer> vecinos : conjuntoVertice) {
			for (int elem : vecinosPosiblesAlVertice) {
				ret = ret || vecinos.contains(elem);
			}
		}

		return ret;
	}

	@Test
	public void existeVerticeEnGrafoTest() {
		assertTrue(g.existeVertice(1));
	}

	@Test
	public void ordenDeRecorridoTest() {
		relacionarVecinos();
		// assertTrue(g.solucion().size()== verticeDelGrafo.length);

		// assertTrue(seRelacionan(g.solucion(), verticeDelGrafo));
	}

	@Test
	public void verticesNoRelacionadosTest() {

		assertTrue(g.cantidadVecinos(2) == 0);
	}

	@Test
	public void relacinarVerticeTest() {
		relacionarVecinos();
		assertTrue(g.cantidadVecinos(2) == 3);
	}

	@Test
	public void existeVecinosDelVertice1() {
		relacionarVecinos();
		assertTrue(seRelacionan(g.vecinos(1), vecinosPosiblesAlVertice1));
	}

	@Test
	public void existeVecinosDelVertice2() {
		relacionarVecinos();
		assertTrue(seRelacionan(g.vecinos(2), vecinosPosiblesAlVertice2));
	}

	@Test
	public void existeVecinosDelVertice3() {
		relacionarVecinos();
		assertTrue(seRelacionan(g.vecinos(3), vecinosPosiblesAlVertice3));
	}

	@Test
	public void existeVecinosDelVertice4() {
		relacionarVecinos();
		assertTrue(seRelacionan(g.vecinos(4), vecinosPosiblesAlVertice4));
	}

	@Test
	public void existeVecinosDelVertice5() {
		relacionarVecinos();
		assertTrue(seRelacionan(g.vecinos(5), vecinosPosiblesAlVertice5));
	}

	@Test
	public void existeLoopsTest() {
		relacionarVecinos();
		assertFalse(seRelacionan(g.vecinos(1), 1));
		assertFalse(seRelacionan(g.vecinos(2), 2));
		assertFalse(seRelacionan(g.vecinos(3), 3));
		assertFalse(seRelacionan(g.vecinos(4), 4));
		assertFalse(seRelacionan(g.vecinos(5), 5));

	}

	@Test
	public void verticesDelGrafoTest() {
		relacionarVecinos();
		assertTrue(seRelacionan(g.vertices(), verticeDelGrafo));

	}

	@Test(expected = RuntimeException.class)
	public void verificarLoopsVerticeTest() {
		relacionarVecinos();
		g.agregarVecino(1, 1);
	}

	@Test(expected = RuntimeException.class)
	public void verificarVecinoExistenteDelVerticeTest() {
		relacionarVecinos();
		g.agregarVecino(1, 2);
	}
	/*
	 * private boolean seRelacionan(Set<Integer> solucion, int[] vertices) {
	 * boolean ret = true;
	 * for (int vecino : vertices) {
	 * ret &= solucion.contains(vecino);
	 * }
	 * return ret;
	 * }
	 */

	private boolean seRelacionan(ArrayList<Integer> vecinos, int vertice) {
		return vecinos.contains(vertice);
	}

	private boolean seRelacionan(ArrayList<Integer> vecinos, int[] vecinosPosiblesAlVertice1) {
		boolean ret = true;
		for (int vecino : vecinosPosiblesAlVertice1) {
			ret &= vecinos.contains(vecino);
		}
		return ret;
	}

	private Grafo crearGrafo(Vertice v) {
		Grafo ret = new Grafo(v);
		return ret;
	}

	private Vertice crearVertices() {
		Vertice v = new Vertice();
		v.agregarVertice(1);
		v.agregarVertice(2);
		v.agregarVertice(3);
		v.agregarVertice(4);
		v.agregarVertice(5);
		return v;
	}

	private void relacionarVecinos() {
		g.agregarVecino(1, 2);
		g.agregarVecino(2, 3);
		g.agregarVecino(2, 4);
		g.agregarVecino(4, 5);
	}

	@Test
	public void pruebaGrafoPequeno() {
		HashMap<Integer, ArrayList<Integer>> grafoPequeno = new HashMap<>();
		grafoPequeno.put(1, new ArrayList<>(Arrays.asList(2, 3)));
		grafoPequeno.put(2, new ArrayList<>(Arrays.asList(1, 3)));
		GolosoDominante golosoPequeno = new GolosoDominante(grafoPequeno);

		Set<Integer> conjuntoDominante = golosoPequeno.conjuntoDominanteHeuristico();

		assertNotNull(conjuntoDominante);
		assertTrue(conjuntoDominante.contains(-1));
		System.out.println("Prueba con Grafo Pequeño - Conjunto Dominante: " + conjuntoDominante);
	}

	@Test
	public void pruebaGrafoDesconectado() {
		HashMap<Integer, ArrayList<Integer>> grafoDesconectado = new HashMap<>();
		grafoDesconectado.put(1, new ArrayList<>(Arrays.asList(2, 3)));
		grafoDesconectado.put(2, new ArrayList<>(Arrays.asList(1, 3)));
		grafoDesconectado.put(4, new ArrayList<>(Arrays.asList(5, 6)));
		GolosoDominante golosoDesconectado = new GolosoDominante(grafoDesconectado);

		Set<Integer> conjuntoDominante = golosoDesconectado.conjuntoDominanteHeuristico();

		assertNotNull(conjuntoDominante);
		assertTrue(conjuntoDominante.size() == 1);
		System.out.println("Prueba con Grafo Desconectado - Conjunto Dominante: " + conjuntoDominante);
	}


	@Test
	public void pruebaGrafoGrande() {

		HashMap<Integer, ArrayList<Integer>> grafoGrande = new HashMap<>();
		grafoGrande.put(1, new ArrayList<>(Arrays.asList(2, 3, 4)));
		grafoGrande.put(2, new ArrayList<>(Arrays.asList(1, 3, 4, 5)));
		grafoGrande.put(3, new ArrayList<>(Arrays.asList(1, 2, 4, 5, 6)));
		grafoGrande.put(4, new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7)));
		grafoGrande.put(5, new ArrayList<>(Arrays.asList(2, 3, 4, 6, 7, 8)));
		grafoGrande.put(6, new ArrayList<>(Arrays.asList(3, 4, 5, 7, 8, 9)));
		grafoGrande.put(7, new ArrayList<>(Arrays.asList(4, 5, 6, 8, 9, 10)));
		grafoGrande.put(8, new ArrayList<>(Arrays.asList(5, 6, 7, 9, 10, 11)));
		grafoGrande.put(9, new ArrayList<>(Arrays.asList(6, 7, 8, 10, 11, 12)));
		grafoGrande.put(10, new ArrayList<>(Arrays.asList(7, 8, 9, 11, 12, 13)));
		grafoGrande.put(11, new ArrayList<>(Arrays.asList(8, 9, 10, 12, 13, 14)));
		grafoGrande.put(12, new ArrayList<>(Arrays.asList(9, 10, 11, 13, 14, 15)));
		grafoGrande.put(13, new ArrayList<>(Arrays.asList(10, 11, 12, 14, 15)));
		grafoGrande.put(14, new ArrayList<>(Arrays.asList(11, 12, 13, 15)));
		grafoGrande.put(15, new ArrayList<>(Arrays.asList(12, 13, 14)));

		GolosoDominante golosoGrande = new GolosoDominante(grafoGrande);
		Set<Integer> conjuntoDominante = golosoGrande.conjuntoDominanteHeuristico();
		assertNotNull(conjuntoDominante);
		assertTrue(conjuntoDominante.size() > 0);
		
		//sabemos que el conjunto dominante es [4,11,15] 
		assertTrue(conjuntoDominante.contains(4));
		assertTrue(conjuntoDominante.contains(11));
		assertTrue(conjuntoDominante.contains(15));
		assertFalse(conjuntoDominante.contains(10));
		

	}

}
