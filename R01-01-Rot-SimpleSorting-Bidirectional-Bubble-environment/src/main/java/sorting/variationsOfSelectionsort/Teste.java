package sorting.variationsOfSelectionsort;

import java.util.Arrays;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RecursiveSelectionSort<Integer> r = new RecursiveSelectionSort<Integer>();
		
		Integer[] array = {30, 28, 7, 29, 11, 26, 4, 22, 23,31 };
		
		r.sort(array);
		
		System.out.println(Arrays.toString(array));
	}

}
