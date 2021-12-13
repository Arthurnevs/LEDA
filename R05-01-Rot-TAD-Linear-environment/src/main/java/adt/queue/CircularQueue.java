package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(this.isFull()) throw new QueueOverflowException();
		if(this.isEmpty()) {
			this.head += 1;
			this.tail += 1;
			this.array[head] = element;
		}
		else {
			this.tail = (this.tail + 1) % this.array.length;
			this.array[this.tail] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(this.isEmpty()) throw new QueueUnderflowException();
		
		T element = this.array[this.head];
		
		if(this.tail == this.head) {
			this.head = -1;
			this.tail = -1;
		}else {
			this.head = ((this.head+1)%this.array.length);
		}
		return element;
	}

	@Override
	public T head() {
		return this.array[this.head];
	}

	@Override
	public boolean isEmpty() {
		if(this.tail == -1 && this.head == -1) return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(((this.tail+1) % this.array.length) == this.head) return true;
		return false;
	}

}
