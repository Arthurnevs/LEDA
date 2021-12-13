package adt.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import util.Util;

/**
 * O comportamento de qualquer heap é definido pelo heapify. Neste caso o
 * heapify dessa heap deve comparar os elementos e colocar o menor sempre no
 * topo. Ou seja, admitindo um comparador normal (responde corretamente 2 < 3),
 * essa heap deixa os elementos menores no topo. Essa comparação não é feita
 * diretamente com os elementos armazenados, mas sim usando um comparator. 
 * Dessa forma, dependendo do comparator, a heap pode funcionar como uma max-heap 
 * ou min-heap.
 */
public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

	protected T[] heap;
	protected int index = -1;
	/**
	 * O comparador é utilizado para fazer as comparações da heap. O ideal é
	 * mudar apenas o comparator e mandar reordenar a heap usando esse
	 * comparator. Assim os metodos da heap não precisam saber se vai funcionar
	 * como max-heap ou min-heap.
	 */
	protected Comparator<T> comparator;

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;

	/**
	 * Construtor da classe. Note que de inicio a heap funciona como uma
	 * min-heap. OU seja, voce deve considerar que a heap usa o comparator
	 * interno e se o comparator responde compare(x,y) < 0 entao o x eh menor
	 * e sobe na heap.
	 */
	@SuppressWarnings("unchecked")
	public HeapImpl(Comparator<T> comparator) {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.comparator = comparator;
	}

	// /////////////////// METODOS IMPLEMENTADOS
	private int parent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Deve retornar o indice que representa o filho a esquerda do elemento
	 * indexado pela posicao i no vetor
	 */
	private int left(int i) {
		return (i * 2 + 1);
	}

	/**
	 * Deve retornar o indice que representa o filho a direita do elemento
	 * indexado pela posicao i no vetor
	 */
	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	@Override
	public boolean isEmpty() {
		return (index == -1);
	}

	@Override
	public T[] toArray() {
		ArrayList<T> resp = new ArrayList<T>();
		for (int i = 0; i <= this.index; i++) {
			resp.add(this.heap[i]);
		}
		return (T[])resp.toArray(new Comparable[0]);
	}

	// ///////////// METODOS A IMPLEMENTAR
	/**
	 * Valida o invariante de uma heap a partir de determinada posicao, que pode
	 * ser a raiz da heap ou de uma sub-heap. O heapify deve usar o comparator
	 * para subir os elementos na heap.
	 */
	private void heapify(int position) {
		int left = this.left(position);
		int right = this.right(position);
		int max = position;
		
		if(left <= index && comparator.compare(heap[left], heap[max]) > 0) {
			max = left;
		}
		
		if(right <= index && comparator.compare(heap[right], heap[max])> 0 ) {
			max = right;
		}
		
		if(max != position) {
			Util.swap(this.heap, max, position);
			heapify(max);
		}


	}

	@Override
	public void insert(T element) {
		// ESSE CODIGO E PARA A HEAP CRESCER SE FOR PRECISO. NAO MODIFIQUE
		if (index == heap.length - 1) {
			heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
		}
		// /////////////////////////////////////////////////////////////////
		// TODO Implemente a insercao na heap aqui.
		index ++;
		if(index == 0) {
			heap[index] = element;
		}else {
			heap[index] = element;
			int j = index;
			while(j > 0 && comparator.compare(heap[this.parent(j)], heap[j]) < 0) {
				Util.swap(heap, j, parent(j));
				j = parent(j);
			}
		}
	}

	@Override
	public void buildHeap(T[] array) {
		
		this.heap = Arrays.copyOf(array, array.length);
		
		this.index = array.length - 1;
		
		for(int i = this.index; i >= 0; i--) {
			heapify(i);
		}
		
	}

	@Override
	public T extractRootElement() {
		T element = null;
		if(!this.isEmpty()) {
			element = this.heap[0];
			this.heap[0] = null;
			Util.swap(this.heap, 0, this.index);
			index --;
			
			this.heapify(0);
		}
		return element;
		
	}

	@Override
	public T rootElement() {
		if(this.isEmpty()) {
			return null;
		}else {
			return this.heap[0];
		}
	}

	@Override
	public T[] heapsort(T[] array) {
		if (array == null || array.length <= 0) {
			return array;
		}
		
		int i = index;
		T[] heapAux = this.getHeap();
		
		Comparator<T> comparatorAux = getComparator();
		
		comparator = new Comparator<T>() {
		@Override
		public int compare(T o1, T o2) {
			return o1.compareTo(o2);
			}		
		};
		
		this.buildHeap(array);
		
		T[] result = (T[]) new Comparable[array.length];
		
		for(int j = array.length - 1; j >= 0; j--) {
			result[j] = extractRootElement();
		}
		
		heap = heapAux;
		index = i;
		comparator = comparatorAux;
		
		return result;
	}

	@Override
	public int size() {
		return index + 1;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public T[] getHeap() {
		return heap;
	}
	public void print() {
		System.out.println(Arrays.toString(heap));
	}

}
