// Implements a BST with BinaryNode nodes


public class MyBST<E extends Comparable<E>> {

	private BinaryNode<E> root; // holds the root of this BST

	// Constructor: creates an empty BST.
	public MyBST() {
		root = null;
	}

	public BinaryNode<E> getRoot() {
		return root;
	}

	public int getHeight() {
		return root.getHeight();
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(E value) {
		return false;
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(E value) {
		// help should i do this recursively
		if (this.contains(value)) {
			return false;
		}
		if (root == null) {
			root = new BinaryNode<E>(value);
			return true;
		}
		BinaryNode<E> newNode = new BinaryNode<E>(value);
		BinaryNode<E> node = root;
		while (node.hasRight() || node.hasLeft()) {
			if (node.getValue().compareTo(value) > 0) {
				if (!node.hasRight()) {
					break;
				}
				node = node.getRight();
			} else {
				if (!node.hasLeft()) {
					break;
				}
				node = node.getLeft();
			}
		}
		if (node.getValue().compareTo(value) > 0) {
			node.setRight(newNode);
			newNode.setParent(node);
			return true;
		} else {
			node.setLeft(newNode);
			newNode.setParent(node);
			return true;
		}
	}

	// Removes value from this BST. Returns true if value has been
	// found and removed; otherwise returns false.
	// If removing a node with two children: replace it with the
	// largest node in the right subtree
	public boolean remove(E value) {
		return false;
	}

	// Returns the minimum in the tree
	public E min() {
		return null;
	}

	// Returns the maximum in the tree.
	public E max() {
		return null;
	}

	// Returns a bracket-surrounded, comma separated list of the contents of the nodes, in order
	// e.g. [Apple, Cranberry, Durian, Mango]
	public String toString() {
		return "";
	}

	public String stringHelper(String str) {
		E min = min();
		BinaryNode<E> currentNode = root;
		String nodes = str;
		if (currentNode.getValue().equals(min)) {

		}

	}


}
