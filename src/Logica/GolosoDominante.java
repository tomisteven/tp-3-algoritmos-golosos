package Logica;

import java.util.HashSet;
import java.util.Set;

public class GolosoDominante {
	public Set<Integer> conjuntoDominanteHeuristico() {
		Set<Integer> conjuntoDominante = new HashSet<>();
		// donde esta el 1, va tamanio del grafo
		boolean[] cubiertos = new boolean[1];

		while (!todosCubiertos(cubiertos)) {
			int mejorVertice = encontrarMejorVertice(cubiertos);
			conjuntoDominante.add(mejorVertice);
			cubiertos[mejorVertice] = true;

			for (int i = 0; i < 1; i++) {
				// if (matrizAdyacencia[mejorVertice][i]) {
				// cubiertos[i] = true;
				// }
			}
		}

		// return conjuntoDominante;
		return null;
	}

	private boolean todosCubiertos(boolean[] cubiertos) {
		for (boolean cubierto : cubiertos) {
			if (!cubierto) {
				return false;
			}
		}
		return true;
	}

	private int encontrarMejorVertice(boolean[] cubiertos) {
		int mejorVertice = -1;
		int maxVecinosNoCubiertos = -1;

		for (int i = 0; i < 1; i++) {
			if (!cubiertos[i]) {
				int vecinosNoCubiertos = contarVecinosNoCubiertos(i, cubiertos);
				if (vecinosNoCubiertos > maxVecinosNoCubiertos) {
					maxVecinosNoCubiertos = vecinosNoCubiertos;
					mejorVertice = i;
				}
			}
		}

		return mejorVertice;
	}

	private int contarVecinosNoCubiertos(int vertice, boolean[] cubiertos) {
		int count = 0;
		for (int i = 0; i < 1; i++) {
			// if (matrizAdyacencia[vertice][i] && !cubiertos[i]) {
			// count++;
			// }
		}
		return count;
	}

}
