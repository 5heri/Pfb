public class MyQueueMain {

	public static void main(String[] args) {

		MyQueue<Integer> mq = new MyQueue<Integer>();

		mq.enqueue(new Integer(5));
		mq.enqueue(new Integer(1));
		mq.enqueue(new Integer(9));

		System.out.println(mq.dequeue() + " " + mq.dequeue() 
				+ " " + mq.dequeue());
	}
}
