package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import logica.Vertice;

public class VerticeTest {
	 @Test
	 public void agregarVerticeTest() {
		 Vertice v = new Vertice();
		 v.agregarVertice(0);
		 assertTrue(v.pertenece(0));
	 }
	 

}
