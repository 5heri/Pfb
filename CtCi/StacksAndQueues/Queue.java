public class Queue<T> {
	
	private Node<T> first;
	private Node<T> last;

	public void enqueue(T item) {
		if (first == null) {
			last = new Node<T>(item);
			first = last;
		} else {
			last.setNext(new Node<T>(item));
			last = last.getNext();
		}
	}

	public T dequeue() {
		if (first != null) {
			T tmp = first.getValue();
			first = first.getNext();
			return tmp;
		} 
		return null;
	}

	public void print() {
		Node<T> node = first;

		while (node != null) {
			System.out.print(node.getValue() + " ");
			node = node.getNext();
		}
		System.out.println();
	}

}

