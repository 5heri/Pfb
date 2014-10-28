public class QueueTestMain {
	
	public static void main(String[] args) throws Exception {
		Queue q = new Queue();

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);

		System.out.println(q.dequeue() + " " + q.dequeue() 
			+ " " + q.dequeue() + " " + q.dequeue());

		// q.dequeue();  // throw Exception



		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);

		System.out.println(q.getMiddle().getValue());  // should be 3

		q.dequeue();

		System.out.println(q.getMiddle().getValue());   // should be 4

		q.dequeue();

		System.out.println(q.getMiddle().getValue());   // should be 4

		q.enqueue(6);
		q.enqueue(7);

		System.out.println(q.getMiddle().getValue());  // should be 5

		q.enqueue(8);
		q.enqueue(9);

		System.out.println(q.getMiddle().getValue());  // should be 6

	}
}
