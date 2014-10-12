import java.util.ArrayList;

public class SetOfStacks {
	
	private ArrayList<StackWithCap<Integer>> stacks;
	private int capacity;

	public SetOfStacks(int capacity) {
		stacks = new ArrayList<StackWithCap<Integer>>();
		this.capacity = capacity;
	}

	public void push(int value) {
		StackWithCap<Integer> lastStack = getLastStack();

		if (lastStack != null && !lastStack.isFull()) {
			lastStack.push(value);
		} else {
			StackWithCap<Integer> newStack = 
								new StackWithCap<Integer>(capacity);
			newStack.push(value);
			stacks.add(newStack);
		}
	}

	public Integer pop() {
		StackWithCap lastStack = getLastStack();
		Integer value = (Integer) lastStack.pop();

		if (lastStack.isEmpty()) {
			stacks.remove(stacks.size() - 1);
		}
		return value;
	}

	private StackWithCap<Integer> getLastStack() {
		if (stacks.size() == 0) {
			return null;
		} else {
			return stacks.get(stacks.size() - 1);
		}
	}

	public void printStacks() {
		for (int i = 0; i < stacks.size(); i++) {
			System.out.println("Stack at " + i + ": ");
			stacks.get(i).print();
		}
	}

}

