package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] b, int leftIndex, int rightIndex) {
		if(b.length > 0) {
			
			int maior = getMeiorValor(b, leftIndex, rightIndex);
			
			Integer[] a = b.clone();
			
			
			int[] c = new int[maior+1];
			
			for(int i = leftIndex; i <= rightIndex; i++) {
				c[b[i]] += 1;
			}
			
			for(int i = 1; i < c.length; i++) {
				c[i] += c[i-1];
			}
					
			for(int i = rightIndex; i >= leftIndex; i--) {
				b[c[a[i]]-1] = a[i];
				c[a[i]] -= 1;
			}
		
		}
			
	}
	public int getMeiorValor(Integer[] array, int leftIndex, int rightIndex) {
		int maior = 0;
		for(int i = leftIndex; i <= rightIndex; i++) {
			if(array[i] >= maior) {
				maior = array[i];
			}
		}
		return maior;	
	}	
}