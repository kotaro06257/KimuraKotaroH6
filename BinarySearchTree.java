package homework6;

public class BinarySearchTree<T> {
	public static class Node {
		private Comparable value;
		private Node left;
		private Node right;

		public Node(Comparable value) {
			this.value = value;

		}

		public String toString() {
			return "Node(" + value + ")";

		}
	}

	private Node rootNode;

	// INSERT
	public void insert(Comparable value) {

		rootNode = insert(value, rootNode);
	}

	private Node insert(Comparable value, Node root) {

		if (root == null) {
			return new Node(value);
		}

		int cmp = root.value.compareTo(value);
		if (cmp < 0) {

			root.right = insert(value, root.right);
		} else {

			root.left = insert(value, root.left);
		}
		return root;
	}

	// SEARCH
	public Comparable search(Comparable value) {
		return search(value, rootNode);
	}

	private Comparable search(Comparable value, Node root) {
		if (root == null) {
			return null;
		}
		int cmp = root.value.compareTo(value);
		if (cmp == 0) {
			return root.value;
		} else if (cmp < 0) {
			return search(value, root.right);
		} else {
			return search(value, root.left);
		}
	}

	// REMOVE
	public void remove(Comparable value) {
		rootNode = remove(value, rootNode);
	}

	private Node remove(Comparable value, Node root) {
		if (root == null) {
			return null;
		}
		int cmp = root.value.compareTo(value);
		if (cmp == 0) {

			if (root.left == null) {
				return root.right;
			}
			if (root.right == null) {
				return root.left;
			}

			Node n = searchLargestNode(root.left);
			n.left = root.left;
			n.right = root.right;
			return n;
		} else if (cmp < 0) {
			root.right = remove(value, root.right);
		} else {
			root.left = remove(value, root.left);
		}
		return root;
	}

	// PRINT
	public String toString() {
		StringBuilder buf = new StringBuilder();

		toString(buf, rootNode);

		return buf.toString();
	}

	private void toString(StringBuilder buf, Node root) {
		if (root == null) {
			return;
		}

		toString(buf, root.left);

		buf.append(root.value);
		buf.append(" ");

		toString(buf, root.right);
	}

	private Node searchLargestNode(Node root) {

		if (root.right == null) {
			return root;
		}

		Node n = searchLargestNode(root.right);

		if (n == root.right) {

			root.right = n.left;
		}
		return n;
	}

}
