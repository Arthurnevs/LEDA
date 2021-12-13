package adt.linkedList;


public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	@Override
	public void insert(T element) {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
		newNode.data = (element);
		
		if(isEmpty()) {
			this.head = newNode;
			this.last = newNode;
		}else {
			this.last.next = newNode;
			newNode.previous = this.last;
			this.last = newNode;
		}
		super.size += 1;
		
	}
	
	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
		newNode.data = element;
		newNode.previous = new DoubleLinkedListNode<>();
		
		if (isEmpty()) {
			newNode.next = new DoubleLinkedListNode<>();
			this.last = newNode;
		} else {
			((DoubleLinkedListNode<T>) this.head).previous = newNode;
			newNode.next = this.head;
		}
		this.head = newNode;
		super.size += 1;
	}

	@Override
	public void removeFirst() {
		if(this.isEmpty()) {
			return;
		}
				
		if(this.head.next.isNIL()) {
			this.head = null;
			this.last = null;
		}else {
			this.head = this.head.next;
			((DoubleLinkedListNode<T>) this.head).previous = null;
		}
		super.size -=1;
		
	}

	@Override
	public void removeLast() {
		if(!isEmpty()) {			
			if(this.head.next.isNIL()) {
				this.head = null;
				this.last = null;
			}else {
				this.last = this.last.getPrevious();
				this.last.next = null;
			}
		}
		super.size -= 1;
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}	
	@Override
	public T[] toArray() {
		int cont = 0;
		
		T[] array = (T[]) new Object[this.size()];
		
		SingleLinkedListNode<T> aux = this.head;
		
		while(aux != null && !aux.isNIL()) {
			array[cont] = aux.data;
			cont ++;
			aux = (DoubleLinkedListNode<T>) aux.getNext();
		}	
		return array;
	}
	
	@Override
	public void remove(T element) {
		DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.getHead();
		for(int i = 0; i < this.size(); i++) {
			if(aux.data.equals(element)) {
				if(i == 0) {
					this.removeFirst();
				}else if(i == this.size()-1){
					this.removeLast();
				}else {
					aux.previous.next = aux.next;
					aux = aux.previous;
					super.size -= 1;
				}
				return;
			}
			aux = (DoubleLinkedListNode<T>) aux.next;
		}
		return;
		
	}
	@Override
	public T search(T element) {
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.head;
		DoubleLinkedListNode<T> auxLast = (DoubleLinkedListNode<T>) this.last;
		
		while(auxHead != auxLast && auxHead.next != auxLast && auxHead.data != element && auxLast.data != element) {
			auxHead = (DoubleLinkedListNode<T>) auxHead.next;
			auxLast = auxLast.previous;
		}
		if(auxHead.data == element) return auxHead.data;
		if(auxLast.data == element) return auxLast.data;
		return null;
	}

}
