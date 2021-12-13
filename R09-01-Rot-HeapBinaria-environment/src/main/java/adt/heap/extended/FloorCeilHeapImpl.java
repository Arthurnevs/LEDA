package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		for(int i = 0; i < array.length; i++) {
			this.insert(array[i]);
		}
		int floor = Integer.MIN_VALUE;
		while(this.rootElement() != null) {
			if(this.rootElement() <= numero && this.rootElement() >= floor) {
				floor = this.rootElement();
			}
			this.extractRootElement();
		}
		return floor;
	}
	/**
	 * Metodo para calcular o ceil de um dado numero do array usando a Heap. 
	 * O ceil de um numero eh o inteiro do array igual ou maior e que mais se aproxima do numero.
	 * Esse calculo deve ser feito usando a Heap. 
	 * 
	 * 	 * Restricoes
	 * - Da heap voce pode usar apenas os metodos insert, rootElement e extractRootElement
	 * - Voce nao pode ordenar o array
	 * - Voce nao pode tirar uma copia do array e trabalhar nela
	 * 
	 * @param numero
	 * @return
	 */
	@Override
	public Integer ceil(Integer[] array, double numero) {
		// TODO Auto-generated method stub
		for(int i = 0; i < array.length; i++) {
			this.insert(array[i]);
		}
		int ceil = Integer.MAX_VALUE;
		while(this.rootElement() != null) {
			if(this.rootElement() >= numero && this.rootElement() <= ceil) {
				ceil = this.rootElement();
			}
			this.extractRootElement();
		}
		return ceil;
	}

	}
