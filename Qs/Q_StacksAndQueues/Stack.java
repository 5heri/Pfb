public class Stack {
	
	private Node top;


	public void push(int value) {
		Node n = new Node(value);

		if (top == null) {
			top = n;
		} else {
			n.setNext(top);
			top = n;
		}
	}

	public int peek() throws Exception {
		if (top != null) {
			return top.getValue();
		} else {
			throw new Exception("Stack is empty!");
		}
	}  

	public Node pop() throws Exception {
		if (top != null) {
			Node r = top;
			top = top.getNext();
			return r;
		} else {
			throw new Exception("Stack is empty!");
		}
	}

	public boolean isEmpty() {
		return top == null;
	}

}
