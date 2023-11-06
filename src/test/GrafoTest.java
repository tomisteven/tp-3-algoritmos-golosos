package test;
import Logica.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Logica.ConjuntoDeVertice;
import Logica.GrafoPrincipal;

class GrafoTest {

	@Test
	void test() {
		ConjuntoDeVertice vertices = new ConjuntoDeVertice();
		vertices.agregarVertice(2);
		vertices.agregarVertice(9);
		vertices.agregarVertice(5);
		GrafoPrincipal g = new GrafoPrincipal(vertices);
		assertTrue(g.existeVertice(2));	}

}
