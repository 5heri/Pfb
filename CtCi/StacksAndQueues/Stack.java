public class Stack<T> {
	
	private Node<T> top;

	public T pop() {
		if (top != null) {
			T tmp = top.getValue();
			top = top.getNext();
			return tmp;
		}
		return null;	
	}

	public void push(T item) {
		Node<T> n = new Node<T>(item);
		n.setNext(top);
		top = n;
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

}

