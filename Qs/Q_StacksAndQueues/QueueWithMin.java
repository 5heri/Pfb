/*
 *	Queue with getMin() with O(1) is not possible with only a queue
 *  - the input data needs to be sorted
 *  - it is possible to do it with a queue only but with O(n) 
 */



public class QueueWithMin {

	private Node first;
	private Node last;
	private int min;

	private Queue minQueue;

	public QueueWithMin() {
		minQueue = new Queue();
		min = Integer.MAX;
	}	

	public void enqueue(int value) {
		Node n = new Node(value);
		if (first == null) {
			first = n;
			last = first;
		} else {
			last.setNext(n);
			last = last.getNext();
		}
		if (value <= min) {
			minQueue.enqueue(value); 
			min = value;
		}
	}

	public int dequeue() throws new Exception {
		if (first != null) {
			int v = first.getValue();
			first = first.getNext();

			if (v == minStack.getFirst()) {
				if (min == minStack.dequeue()) {
					
				}
			}

			return v;
		} else {
			throw new Exception("Stack is empty!");
		}

	}

	public int getMin() {
		return min;
	}
}
