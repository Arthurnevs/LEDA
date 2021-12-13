package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;
	
	public RecursiveDoubleLinkedListImpl() {

	}


	@Override
	public void insert(T element) {
		if(isEmpty()) {
			this.data = element;
			this.next = new RecursiveDoubleLinkedListImpl<>();
			if(this.previous == null) {
				this.previous = new RecursiveDoubleLinkedListImpl<>();
			}
		}
		else {
			this.next.insert(element);
		}
	}
	
	@Override
	public void remove(T element) {
		if(isEmpty()) {
			
		}else {
			if(this.data == element) {
				if(this.previous.isEmpty() && next.isEmpty()) {
					this.data = null;
					this.next = null;
					this.previous = null;
				}
				else {
					this.data = this.next.data;
					this.next = this.next.next;
					if(this.next != null) {
						this.previous.next = (RecursiveSingleLinkedListImpl<T>) this;
					}
				}
				
			}else {
				this.next.remove(element);
			}
		}	
	}
	
	@Override
	public void insertFirst(T element) {
		if(isEmpty()) {
			insert(element);
		} else {
			RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<>();
			newNode.data = this.getData();
			newNode.next = this.getNext();
			this.data = element;
			this.previous = new RecursiveDoubleLinkedListImpl<>();
			this.next = newNode;
			
			((RecursiveDoubleLinkedListImpl<T>) this.next).previous = this;
		}
		
	}

	@Override
	public void removeFirst() {
		this.data = this.next.getData();
		this.next = (RecursiveDoubleLinkedListImpl<T>) this.next.next;
	}

	@Override
	public void removeLast() {
		if (this.next.isEmpty()) {
			this.data = null;
			this.next = new RecursiveDoubleLinkedListImpl<T>();
		} else ((RecursiveDoubleLinkedListImpl<T>) this.next).removeLast();
	}

	
	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
