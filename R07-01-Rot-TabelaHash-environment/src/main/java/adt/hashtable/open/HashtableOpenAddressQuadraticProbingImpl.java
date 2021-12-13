package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}
	
	@Override
	public void insert(T element) {
		if(!isFull()) {
			int i = 0;
			while(i < this.table.length) {
				int indice = ((HashFunctionQuadraticProbing<T>)this.hashFunction).hash(element, i);
				
				if(this.table[indice] == null || this.table[indice].equals(this.deletedElement)) {
					this.table[indice] = element;
					this.elements ++;
					break;
				}
				i++;
				this.COLLISIONS++;
			}
		}else {
			throw new HashtableOverflowException();
		}
	}
	@Override
	public void remove(T element) {
		int i = 0;
		while(i < this.table.length) {
			int indice = ((HashFunctionQuadraticProbing<T>)this.hashFunction).hash(element, i);
			if(this.table[indice] == null || this.table[indice].equals(this.deletedElement)) {
				break;
			}
			else if(this.table[indice].equals(element)) {
				this.table[indice] = this.deletedElement;
				this.elements --;
			}
			i++;
		}
	}

	@Override
	public T search(T element) {
		int i = 0;
		T retorno = null;
		while(i < this.table.length) {
			int indice = ((HashFunctionQuadraticProbing<T>)this.hashFunction).hash(element, i);
			
			if(this.table[indice] == null || this.table[indice].equals(this.deletedElement)) {
				break;
			}
			else if(this.table[indice].equals(element)) {
				retorno = element;
				break;
			}
			
			i++;
		}
		return retorno;
	}

	@Override
	public int indexOf(T element) {
		boolean achou = false;
		int i = 0;
		int indice = -1;
		while(i < this.table.length) {
			indice = ((HashFunctionQuadraticProbing<T>)this.hashFunction).hash(element, i);
			if(this.table[indice] == null || this.table[indice].equals(this.deletedElement)) {
				break;
			}
			else if(this.table[indice].equals(element)) {
				achou = true;
				break;
			}
			i++;
		}
		if(achou)return indice;
		return -1;
	}
}