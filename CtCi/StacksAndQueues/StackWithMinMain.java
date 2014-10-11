public class StackWithMinMain {

	public static void main(String[] args) {
		StackWithMin sMin = new StackWithMin();

		sMin.push(3);
		sMin.push(5);
		sMin.push(2);
		sMin.push(1);

		sMin.printMinStack();
		System.out.print("Current Stack : ");
		sMin.printStack();
		System.out.println("Current min: " + sMin.getMin());

		sMin.pop();

		sMin.printMinStack();
		System.out.print("Current Stack : ");
		sMin.printStack();
		System.out.println("Current min: " + sMin.getMin());


		sMin.push(3);
		sMin.push(5);
		sMin.push(2);

		sMin.printMinStack();
		System.out.print("Current Stack : ");
		sMin.printStack();
		System.out.println("Current min: " + sMin.getMin());

		sMin.pop();

		sMin.printMinStack();
		System.out.print("Current Stack : ");
		sMin.printStack();
		System.out.println("Current min: " + sMin.getMin());

		sMin.pop();
		sMin.pop();

		sMin.printMinStack();
		System.out.print("Current Stack : ");
		sMin.printStack();
		System.out.println("Current min: " + sMin.getMin());

		sMin.pop();

		sMin.printMinStack();
		System.out.print("Current Stack : ");
		sMin.printStack();
		System.out.println("Current min: " + sMin.getMin());
	}
	
}

