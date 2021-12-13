package sorting.linearSorting;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtendedCountingSort e = new ExtendedCountingSort();
		
		Integer[] array = {0,-2,0,-1};
				
		e.sort(array, 0, array.length-1);
		
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));

	}

}
