package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		return this.array[0];
	}

	@Override
	public boolean isEmpty() {
		if(this.tail == -1) return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(this.tail == array.length-1) return true;
		return false;
	}

	private void shiftLeft() {
		for(int i = 0; i < this.tail; i++) {
			this.array[i] = this.array[i+1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(this.isFull()) {
			throw new QueueOverflowException();
		}
		this.tail +=1;
		this.array[tail] = element;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(this.isEmpty()) {
			throw new QueueUnderflowException();
		}
		T result = this.array[0];
		this.shiftLeft();
		this.tail -= 1;
		
		return result;
	}

}
