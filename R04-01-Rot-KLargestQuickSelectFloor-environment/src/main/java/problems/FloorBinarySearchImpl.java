package problems;

public class FloorBinarySearchImpl implements Floor {
	
	
	@Override
	public Integer floor(Integer[] array, Integer x) {
		return floorBinarySearch(array, x, 0, array.length);
	
	}
	int floor = Integer.MIN_VALUE;
	public Integer floorBinarySearch(Integer[] array, int x, int ini, int fim) {
		if(ini < fim) {
			int meio = (ini + fim)/2;
			
			if(array[meio] == x) {
				 floor = array[meio];
			}
			else if(array[meio]<x && array[meio] > floor) {
				floor = array[meio];
			}
			
			if(array[meio] > x) {
				floorBinarySearch(array, x, ini, meio);
			}
			else {
				floorBinarySearch(array, x, meio+1, fim);
			}
		}
		if(floor == Integer.MIN_VALUE) {
			return null;
		}
		return floor;
		
	}
	
	

}
