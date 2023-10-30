package Logica;
import java.util.Set;

public class Auxiliares
{
	// Determina si un conjunto de vertices forma una clique
	public static boolean esClique(Grafo grafo, Set<Integer> conjunto)
	{
		for(Integer i: conjunto)
		for(Integer j: conjunto)
		{
			if( i != j && grafo.existeArista(i, j) == false )
				return false;
		}

		return true;
	}
}