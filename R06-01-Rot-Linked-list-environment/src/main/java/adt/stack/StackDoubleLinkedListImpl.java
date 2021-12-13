package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;
		private int last = -1;
	
	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}
	
	@Override
	public void push(T element) throws StackOverflowException {
		if(this.isFull()) {
			throw new StackOverflowException();
		}
		last+=1;
		top.insertFirst(element);
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(this.isEmpty()) {
			throw new StackUnderflowException();
		}
		T array = top.toArray()[0];
		top.removeFirst();
		return array;
	}

	@Override
	public T top() {
		return top.toArray()[0];
	}

	@Override
	public boolean isEmpty() {
		return top.isEmpty();
	}

	@Override
	public boolean isFull() {
		if(this.size == top.size()) {
			return true;
		}
		return false;
	}

}
