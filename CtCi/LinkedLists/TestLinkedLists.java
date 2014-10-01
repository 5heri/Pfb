public class TestLinkedLists {
	
	public static void main(String[] args) {
		
		Integer n1 = new Integer(5);
		Integer n2 = new Integer(2);
		Integer n3 = new Integer(2);
		Integer n4 = new Integer(6);
		Integer n5 = new Integer(9);
		Integer n6 = new Integer(9);

		LinkedList<Integer> list = new LinkedList<Integer>();

		list.add(0, n1);
		list.add(1, n2);
		list.add(2, n3);
		list.add(3, n4);

		list.add(0, n6);

		list.add(1, n5);

		list.display(); // 9 9 5 2 2 6

		list.delete(0);
		list.delete(0);

		list.delete(1);

		list.display(); // 5 2 6

		System.out.println(list.get(2)); // 6
	}
}
// Testing OK.
