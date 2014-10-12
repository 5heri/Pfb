public class StackWithCap<T> {
	
	private Node<T> top;

	private int capacity;
	private int size;

	public StackWithCap(int capacity) {
		this.capacity = capacity;
	}

	public T pop() {
		if (top != null) {
			T tmp = top.getValue();
			top = top.getNext();
			size--;
			return tmp;
		}
		return null;	
	}

	public void push(T item) {
		if (size < capacity) {
			Node<T> n = new Node<T>(item);
			n.setNext(top);
			top = n;	
			size++;
		}
	}

	public T peek() {
		return top.getValue();   // assuming that stack has element
	}

	public void print() {
		Node<T> node = top;

		while (node != null) {
			System.out.print(node.getValue() + " ");
			node = node.getNext();
		}
		System.out.println();
	}

	public boolean isEmpty() {
		return top == null;
	}

	public boolean isFull() {
		return size == capacity;
	}

}
