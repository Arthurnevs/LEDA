package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] b, int leftIndex, int rightIndex) {
		if(b.length > 0) {
			
			int maior = getMaiorValor(b, leftIndex, rightIndex);
			int menor = getMenorValor(b,leftIndex,rightIndex);
			
			if(maior != menor) {
				Integer[] a = b.clone();
				
				
				int[] c = new int[maior - menor +1];
				
				for(int i = leftIndex; i <= rightIndex; i++) {
					c[b[i] - menor] += 1;
				}
				
				for(int i = 1; i < c.length; i++) {
					c[i] += c[i-1];
				}
						
				for(int i = rightIndex; i >= leftIndex; i--) {
					b[c[a[i]-menor]-1] = a[i];
					c[a[i]-menor] -= 1;
				}
			
			}

			}
			
		
		}
	

	public int getMaiorValor(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];
		for(int i = leftIndex + 1; i <= rightIndex; i++) {
			if(array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
		
	}
	
	public int getMenorValor(Integer[] array, int leftIndex, int rightIndex) {
		int menor = array[leftIndex];
		
		for(int i = leftIndex; i < rightIndex; i++) {
			if(array[i] < menor) {
				menor = array[i];
			}
		}
		return menor;
	}
	

}
