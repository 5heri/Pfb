public class MainEncodeDecode {
	

	public static void main(String[] args) {
		Node n1 = new Node(10);
		Node n2 = new Node(8);
		Node n3 = new Node(6);
		Node n4 = new Node(5);
		Node n5 = new Node(9);
		Node n6 = new Node(10);

		n1.setLeft(n2);
		n1.setRight(n3);
		n2.setLeft(n4);
		n3.setLeft(n5);
		n5.setLeft(n6);
		n6.setRight(new Node(11));
		n4.setRight(new Node(12));



		TreeCoding tc = new TreeCoding();
		System.out.println(tc.encode(n1));
		Node root = tc.decode(tc.encode(n1));

		System.out.println(tc.encode(root));

	}
}
