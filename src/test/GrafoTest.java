package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

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
				ret= ret || vecinos.contains(elem);
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
		//assertTrue(g.solucion().size()== verticeDelGrafo.length);

//		assertTrue(seRelacionan(g.solucion(), verticeDelGrafo));
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
	private boolean seRelacionan(Set<Integer> solucion, int[] vertices) {
		boolean ret = true;
		for (int vecino : vertices) {
			ret &= solucion.contains(vecino);
		}
		return ret;
	}

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

}
