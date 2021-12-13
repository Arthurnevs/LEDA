package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitos elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int[] lim = partition(array, leftIndex, rightIndex);
			int lt = lim[0];
			int gt = lim[1];
			
			sort(array, leftIndex, lt-1);
			sort(array, gt+1, rightIndex);
		}
	
	
	}
	public int[] partition(T[] array, int left, int right) {
		int[] lim = new int[2];
		int lt = left;
		int i = left;
		
		int rt = right;
		
		T pivot = array[left];
		
		while(i <= rt) {
			if(array[i].compareTo(pivot)<0) {
				Util.swap(array, lt, i);
				lt +=1;
				i+=1;
			}
			else if(array[i].compareTo(pivot)>0) {
				Util.swap(array, i, rt);
				rt -=1;
			}
			else {
				i +=1;
			}
	
		}
		
		lim[0] = lt;
		lim[1] = rt;
		
		return lim;
	}

}
