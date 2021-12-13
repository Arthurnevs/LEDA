package sorting.simpleSorting;

import util.*;
import sorting.AbstractSorting;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int cont = 0;
		for(int i = leftIndex; i < rightIndex; i++) {
			for(int j = leftIndex; j < rightIndex - cont;j++) {
				if(array[j].compareTo(array[j+1])>0) {
					Util.swap(array, j+1, j);
					}
				}
			cont ++;
			}
		
		}

	}
