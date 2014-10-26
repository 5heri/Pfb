public class StackTestMain {
	
	public static void main(String[] args) throws Exception {
		Stack s = new Stack();

		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);

		System.out.println(s.pop().getValue() + " " + s.pop().getValue() 
			+ " " + s.pop().getValue() + " " + s.pop().getValue());		

		// System.out.println(s.pop());   // should throw exception

	}
}
