package adt.linkedList;


public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		if(data == null) return true;
		return false;
	}

	@Override
	public int size() {
		if(this.isEmpty()){
			return 0;
		}else {
			return 1 + this.next.size();
		}
	}

	@Override
	public T search(T element) {
		if(this.isEmpty()) {
			return null;
		}
		else {
			if(this.data == element) {
				return element;
			}else {
				return this.next.search(element);
			}
		}
	}

	@Override
	public void insert(T element) {
		if(isEmpty()) {
			this.data = element;
			this.next = new RecursiveSingleLinkedListImpl<>();
		}
		else {
			this.next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if(this.isEmpty()) {
			
		}else {
			if(this.data == element) {
				this.data = this.next.data;
				this.next = this.next.next;
			}else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		java.util.LinkedList<T> result = new java.util.LinkedList<T>();
		toArray(result,this);
		return(T[]) result.toArray();
		
	}

	protected void toArray(java.util.LinkedList<T> list, RecursiveSingleLinkedListImpl<T> node) {
		if(!node.isEmpty()) {
			list.add(node.data);
			toArray(list,node.next);
		}
	}
	

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
