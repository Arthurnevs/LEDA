package adt.linkedList;


public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;
	protected int size;
	
	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHead = this.head;
		while(!auxHead.isNIL() && auxHead.getData() != element) {
			auxHead = auxHead.getNext();
		}
		return auxHead.getData();
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxHead = this.head;
		if(this.head.isNIL()) {
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<>(element,null); 
			newHead.setNext(this.head);
			this.head = newHead;
		}else {
			while(!auxHead.isNIL()) {
				auxHead = auxHead.getNext();
			}
			auxHead.setData(element);
			auxHead.setNext(new SingleLinkedListNode<>());
		}
		this.size+=1;
		
	}

	@Override
	public void remove(T element) {
		if(this.head.getData() == element) {
			this.head = this.head.getNext();
		}else {
			SingleLinkedListNode<T> aux = this.head;
			while(!aux.isNIL() && aux.getData() != element) {
				aux = aux.getNext();
				
			}
			if(!aux.isNIL()) {
				aux.setData(aux.getNext().getData());
				aux.setNext(aux.getNext().getNext());
			}
		}
		this.size -=1;
	}

	@Override
	public T[] toArray() {
		int cont = 0;
		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> aux = this.head;
		while(!aux.isNIL()) {
			array[cont] = aux.getData();
			cont ++;
			aux = aux.getNext();
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	
	}
	
	

}
