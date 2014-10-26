public class StackWithMin {
	
	private Node top;
	private Stack minstack;

	public StackWithMin() {
		minstack = new Stack();
	}

	public int top() throws Exception {
		if (top != null) {
			return top.getValue();
		} else {
			throw new Exception("Stack is empty!");
		}
	}

	public void push(int value) throws Exception {
		Node n = new Node(value);
		if (top == null) {
			top = n;
			minstack.push(value);
		} else {
			n.setNext(top);
			top = n;
			
			if (value <= getMin()) {
				minstack.push(value);
			}
		}
	}

	public Node pop() throws Exception {
		if (top != null) {
			Node r = top;
			top = top.getNext();
			
			if (r.getValue() == getMin()) {
				minstack.pop();
			}
			return r;
		} else {
			throw new Exception("Stack is empty!");
		}
	}

	public int getMin() throws Exception {
		if (!minstack.isEmpty()) {
			return minstack.peek();
		} else {
			throw new Exception("Stack is empty!");
		}
	}
}
