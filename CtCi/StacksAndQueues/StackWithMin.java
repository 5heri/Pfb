public class StackWithMin extends Stack<Integer> {

	private Stack<Integer> minStack;

	public StackWithMin() {
		minStack = new Stack<Integer>();
	}

	public void push(int value) {
		super.push(value);

		if (value <= getMin()) {
			minStack.push(value);
		}
	}

	public Integer pop() {
		int value = super.pop();

		if (value == getMin()) {
			minStack.pop();
		} 
		return value;
	}

	public int getMin() {
		if (minStack.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return minStack.peek();
		}
	}

	public void printStack() {
		super.print();
	}

	public void printMinStack() {
		minStack.print();
	}
}

