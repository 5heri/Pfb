public class SetOfStacksMain {

	public static void main(String[] args) {

		SetOfStacks stacks = new SetOfStacks(3);

		stacks.push(1);
		stacks.push(9);
		stacks.push(8);
		stacks.push(11);
		stacks.push(7);
		stacks.push(2);

		stacks.printStacks();

		System.out.print(stacks.pop() + " ");
		System.out.print(stacks.pop() + " ");
		System.out.print(stacks.pop() + " ");
		System.out.print(stacks.pop() + " ");
		System.out.print(stacks.pop() + " ");
		System.out.print(stacks.pop() + "\n");

		stacks.printStacks();

	}
}
