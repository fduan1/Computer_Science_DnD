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
		BinaryNode<E> currentNode = root;
		while (currentNode != null) {
			if (currentNode.getValue().compareTo(value) == 0) {
				return true;
			} else if (currentNode.getValue().compareTo(value) < 0) {
				currentNode = currentNode.getRight();
			} else {
				currentNode = currentNode.getLeft();
			}
		}
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
			if (node.getValue().compareTo(value) < 0) {
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
		if (node.getValue().compareTo(value) < 0) {
			newNode.setParent(node);
			node.setRight(newNode);
			return true;
		} else {
			newNode.setParent(node);
			node.setLeft(newNode);
			return true;
		}
	}

	// Removes value from this BST. Returns true if value has been
	// found and removed; otherwise returns false.
	// If removing a node with two children: replace it with the
	// largest node in the right subtree
	public boolean remove(E value) {
		if (!contains(value)) {
			return false;
		}
		BinaryNode<E> removed = locateNode(value, root);
		if (removed.isLeaf()) {
			if (removed.isLeft()) {
				removed.getParent().setLeft(null);
				return true;
			}
			if (removed.isRight()) {
				removed.getParent().setRight(null);
				return true;
			}
			return false;
		}
		BinaryNode<E> replacementNode = findReplacement(removed);
		// this isn't working (when removing root)
		if (removed.equals(root)) {
			replacementNode.setParent(null);
			if (root.hasLeft()) {
				if (root.hasRight()) {
					root.getRight().setParent(replacementNode);
					replacementNode.setRight(root.getRight());
				}
				if (!root.getLeft().equals(replacementNode)) {
					root.getLeft().setParent(replacementNode);
					replacementNode.setLeft(root.getLeft());
				}
			} else {

			}
			root = replacementNode;
			return true;
		}
		replacementNode.setParent(removed.getParent());
		if (removed.isLeft()) {
			removed.getParent().setLeft(replacementNode);
		} else {
			removed.getParent().setRight(replacementNode);
		}
		if (removed.hasLeft()) {
			if (removed.hasRight()) {
				replacementNode.setRight(removed.getRight());
				removed.getRight().setParent(replacementNode);
				if (!removed.getLeft().hasLeft()) {
					return true;
				}
			}
			replacementNode.setLeft(removed.getLeft());
			removed.getLeft().setParent(replacementNode);
			return true;
		} else {
			replacementNode.setRight(removed.getRight());
			removed.getRight().setParent(replacementNode);
			return true;
		}
	}

	public BinaryNode<E> findReplacement(BinaryNode<E> removedNode) {
		if (!removedNode.hasLeft()) {
			return removedNode.getRight();
		}
		BinaryNode<E> currentNode = removedNode.getLeft();
		if (!currentNode.hasRight()) {
			return currentNode;
		}
		return currentNode.getRight();
	}

	public BinaryNode<E> locateNode(E value, BinaryNode<E> starterNode) {
		BinaryNode<E> currentNode = starterNode;
		if (currentNode.getValue().compareTo(value) == 0) {
			return currentNode;
		} else if (currentNode.getValue().compareTo(value) < 0) {
			return locateNode(value, starterNode.getRight());
		} else {
			return locateNode(value, starterNode.getLeft());
		}
	}

	// Returns the minimum in the tree
	public E min() {
		return minHelper(root);
	}

	public E minHelper(BinaryNode<E> currentNode) {
		if (!currentNode.hasLeft()) {
			return currentNode.getValue();
		}
		return minHelper(currentNode.getLeft());
	}

	// Returns the maximum in the tree.
	public E max() {
		return maxHelper(root);
	}

	public E maxHelper(BinaryNode<E> currentNode) {
		if (!currentNode.hasRight()) {
			return currentNode.getValue();
		}
		return minHelper(currentNode.getRight());
	}

	// Returns a bracket-surrounded, comma separated list of the contents of the
	// nodes, in order
	// e.g. [Apple, Cranberry, Durian, Mango]
	public String toString() {
		String contents = stringHelper(root, "");
		return "[" + contents.substring(0, contents.length()-2) + "]";
	}

	public String stringHelper(BinaryNode<E> currentNode, String str) {
		if (currentNode == null) {
			return "";
		}
		if (!currentNode.hasLeft()) {
			str += currentNode.getValue() + ", ";
			if (currentNode.hasRight()) {
				str = stringHelper(currentNode.getRight(), str);
			}
			return str;
		}
		str = stringHelper(currentNode.getLeft(), str);
		str += currentNode.getValue() + ", ";
		if (currentNode.hasRight()) {
			str = stringHelper(currentNode.getRight(), str);
		}
		return str;
	}

}
