public class Queue {
	
	private Node first;
	private Node last;

	private boolean midSetter;
	private Node middle;

	public void enqueue(int value) {
		Node n = new Node(value);
		if (first == null) {
			first = n;
			last = first;
			//midSetter = true;     // for mid
			middle = first; 	  // for mid
		} else {
			last.setNext(n);
			last = last.getNext();
		}

		// For finding mid
		if (midSetter) {
			middle = middle.getNext();
			midSetter = false;
		} else {
			midSetter = true;
		}
	}

	public Node dequeue() throws Exception {
		if (first != null) {
			Node r = first;
			first = first.getNext();

			if (midSetter) {
				middle = middle.getNext();
				midSetter = false;
			} else {
				midSetter = true;
			}
			return r;
		} else {
			throw new Exception("Queue is empty!");
		}
	}

	public Node getMiddle() {
		return middle;
	}
}
