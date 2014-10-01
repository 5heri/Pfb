public class LinkedList<T> implements List<T> {

	private Node<T> head;
	private int size;

	@Override
	public int size() {
		return size;
	}	

	@Override
	public void add(int index, T value) {
		Node<T> newNode = new Node<T>(value);
		if (index == 0) {
			newNode.setNext(head);
			head = newNode;
		} else {
			Node<T> prev = getNodeAt(index - 1);
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);
		}
		size++;
	}

	@Override
	public Node<T> delete(int index) {
		if (index == 0) {
			head = head.getNext();
		} else {
			Node<T> prev = getNodeAt(index - 1);
			prev.setNext(prev.getNext().getNext());
		}
		size--;
		return head;
	}

	@Override
	public T get(int index) {
		return getNodeAt(index).getValue();
	}

	private Node<T> getNodeAt(int index) {
		Node<T> curr = head;

		for (int i = 0; i < index; i++) {
			curr = curr.getNext();
		}
		return curr;
	}

	public void display() {
		Node<T> curr = head;
		while (curr != null) {
			System.out.print(curr.getValue() + " ");
			curr = curr.getNext();
		}
		System.out.println();
	}
}

