public class StackAndQueueMain {

	public static void main(String[] args) {



	/*Node<Integer> n1 = new Node<Integer>(new Integer(1));
	Node<Integer> n2 = new Node<Integer>(new Integer(8));
	Node<Integer> n3 = new Node<Integer>(new Integer(11));
	Node<Integer> n4 = new Node<Integer>(new Integer(3));
	Node<Integer> n5 = new Node<Integer>(new Integer(7));
	Node<Integer> n6 = new Node<Integer>(new Integer(2));
	Node<Integer> n7 = new Node<Integer>(new Integer(12));
	Node<Integer> n8 = new Node<Integer>(new Integer(6));
	Node<Integer> n9 = new Node<Integer>(new Integer(4));*/

	Stack<Integer> stack = new Stack<Integer>();

	stack.push(new Integer(1));
	stack.push(new Integer(4));
	stack.push(new Integer(2));
	stack.push(new Integer(9));

	System.out.println(stack.pop());

	stack.print();

	Queue<Integer> queue = new Queue<Integer>();
	queue.enqueue(new Integer(4));
	queue.enqueue(new Integer(6));
	queue.enqueue(new Integer(1));

	System.out.println(queue.dequeue());
	queue.print();

	//n1.setNext(n2);
	//n2.setNext(n3);
	//n3.setNext(n4);
	//n4.setNext(n5);
	//n5.setNext(n6);
	//n6.setNext(n7);
	//n7.setNext(n8);
	//n8.setNext(n9);


	}

	public void print(Node<Integer> head) {
		Node<Integer> node = head;

		while (node != null) {
			System.out.print(node.getValue() + " ");
			node = node.getNext();
		}
		System.out.println();
	}

}

