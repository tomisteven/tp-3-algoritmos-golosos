package Logica;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
class GrafoPrincipalTest {
	@Test
	public void crearGrafoTest() {
		ConjuntoDeVertice vertices = new ConjuntoDeVertice();
		vertices.agregarVertice(2);
		vertices.agregarVertice(9);
		vertices.agregarVertice(5);
		GrafoPrincipal g = new GrafoPrincipal(vertices);
		assertTrue(false);
	}

}
