package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top(){
		return this.array[top];
	}

	@Override
	public boolean isEmpty() {
		if(this.top == -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(this.array.length - 1 == this.top) {
			return true;
		}
		return false;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(this.isFull()) {
			throw new StackOverflowException();
		}
		this.top +=1;
		array[top] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(this.isEmpty()) {
			throw new StackUnderflowException();
		}
		this.top -= 1;
		return array[this.top+1];
	}

}
