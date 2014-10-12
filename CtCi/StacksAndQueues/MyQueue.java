public class MyQueue<T> {

	private Stack<T> firstStack;
	private Stack<T> secondStack;

	public MyQueue() {
		firstStack = new Stack<T>();
		secondStack = new Stack<T>();
	}

	public void enqueue(T value) {
		firstStack.push(value);
	}

	public T dequeue() {
		if (secondStack.isEmpty()) {
			while (!firstStack.isEmpty()) {
				secondStack.push(firstStack.pop());
			}
		}
		return secondStack.pop();
	}
}
