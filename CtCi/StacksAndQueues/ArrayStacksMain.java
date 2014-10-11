public class ArrayStacksMain {
	
	public static void main(String[] args) throws Exception {

		ArrayStacks as = new ArrayStacks();

		as.push(0, 4);
		as.push(0, 1);
		as.push(1, 5);
		as.push(0, 19);
		as.push(1, 1);
		as.push(2, 1);
		as.push(2, 4);

		as.print();

		System.out.println(as.pop(0));

		as.print();
	}

}

