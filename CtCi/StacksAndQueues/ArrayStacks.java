public class ArrayStacks {
	
	private static final int eachStackSize = 100;
	private static final int totalStacks = 3;

	private int[] stackPointer = {-1, -1, -1};

	private int[] stackArray;

	public ArrayStacks() {
		stackArray = new int[eachStackSize * totalStacks];
	}

	public void push(int stackNumber, int value) throws Exception {
		if (stackPointer[stackNumber] + 1 >= eachStackSize) {
			throw new Exception("Stack " + stackNumber + " is full.");
		}

		stackPointer[stackNumber]++;
		stackArray[topOfStack(stackNumber)] = value;

	}

	public int pop(int stackNumber) throws Exception {
		if (stackPointer[stackNumber] == -1) {
			throw new Exception("Stack " + stackNumber + " is empty.");
		}

		int value = stackArray[topOfStack(stackNumber)];
		stackArray[topOfStack(stackNumber)] = 0;
		stackPointer[stackNumber]--;
		return value;
	}

	public int peek(int stackNumber) throws Exception {
		if (stackPointer[stackNumber] == -1) {
			throw new Exception("Stack " + stackNumber + " is empty.");
		}
		return stackArray[topOfStack(stackNumber)];
	}

	public boolean isEmmpty(int stackNumber) {
		return stackPointer[stackNumber] == -1;
	}

	private int topOfStack(int stackNumber) {
		return stackNumber * eachStackSize + stackPointer[stackNumber];
	}

	public void print() {

		for (int i = 0; i <= 99; i++) {
			if (stackArray[i] != 0) {
				System.out.print(stackArray[i] + " ");
			}
		}
		System.out.println();

		for (int i = 100; i <= 199; i++) {
			if (stackArray[i] != 0) {
				System.out.print(stackArray[i] + " ");
			}
		}
		System.out.println();

		for (int i = 200; i <= 299; i++) {
			if (stackArray[i] != 0) {
				System.out.print(stackArray[i] + " ");
			}
		}
		System.out.println();
	}
}

