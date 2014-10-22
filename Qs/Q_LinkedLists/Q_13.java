public class Q_13 {
	
	public static void main(String[] args) {

		NodeDouble n5 = new NodeDouble(5);
		NodeDouble n8 = new NodeDouble(8);
		NodeDouble n3 = new NodeDouble(3);
		NodeDouble n6 = new NodeDouble(6);

		n5.setNext(n8);
		n8.setNext(n3);
		n3.setNext(n6);
		n6.setPrev(n3);
		n3.setPrev(n8);
		n8.setPrev(n5);

		printDDL(reverseDDL(n5));
	}	


	private static NodeDouble reverseDDL(NodeDouble head) {
		NodeDouble curr = head;

		NodeDouble oldPrev = null;
		while (curr.getNext() != null) {
			oldPrev = curr.getPrev();
			curr.setPrev(curr.getNext());
			curr.setNext(oldPrev);
			curr = curr.getPrev();
		}
		oldPrev = curr.getPrev();
		curr.setPrev(curr.getNext());
 		curr.setNext(oldPrev);
		return curr;
	}

	private static void printDDL(NodeDouble head) {
		NodeDouble curr = head;

		while (curr != null) {
			System.out.print(curr.getValue() + " ");
			curr = curr.getNext();
		}
		System.out.println();
	}

}
