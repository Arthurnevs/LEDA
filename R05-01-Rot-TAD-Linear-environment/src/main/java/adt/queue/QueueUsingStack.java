package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(this.isFull()) {
			throw new QueueOverflowException();
		}
		try {
			this.stack1.push(element);
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(this.isEmpty()) {
			throw new QueueUnderflowException();
		}
		this.transfere(this.stack1, this.stack2);
		
		try {
			T element = this.stack2.pop();
			this.transfere(stack2, stack1);
			return element;
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public T head() {
		this.transfere(stack1, stack2);
		T element = this.stack2.top();
		this.transfere(stack2, stack1);
		
		return element;
	}

	@Override
	public boolean isEmpty() {
		if(this.stack1.isEmpty()) return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(this.stack1.isFull()) return true;
		return false;
	}
	// Transfere os elementos da Stack1 para a Stack2.
	// A Stack1 fica vazia.
	private void transfere(Stack<T> stack1, Stack<T> stack2) {
		while(!stack1.isEmpty()) {
			try {
				stack2.push(stack1.pop());
			} catch (StackOverflowException | StackUnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
