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
			if (removed.equals(root)) {
				root = null;
				return true;
			}
			return false;
		}
		BinaryNode<E> replacementNode = findReplacement(removed);

		// this isn't working (when removing root)
		if (removed.equals(root)) {
			if (replacementNode.getValue().compareTo(removed.getValue()) > 0) {
				if (replacementNode.equals(removed.getRight())) {
					if (removed.hasLeft()) {
						removed.getLeft().setParent(replacementNode);
						replacementNode.setLeft(removed.getLeft());
					}
				} else if (replacementNode.isLeaf()) {
					if (replacementNode.isLeft()) {
						replacementNode.getParent().setLeft(null);
					} else {
						replacementNode.getParent().setRight(null);
					}
					replacementNode.setLeft(removed.getLeft());
					replacementNode.setRight(removed.getRight());
				} else if (replacementNode.isLeft() && replacementNode.hasRight()) {
					replacementNode.getParent().setLeft(replacementNode.getRight());
					replacementNode.getRight().setParent(replacementNode.getParent());
					replacementNode.setLeft(removed.getLeft());
					replacementNode.setRight(removed.getRight());
				}
				replacementNode.setParent(null);
				root = replacementNode;
				return true;
			} else {
				if (replacementNode.equals(removed.getLeft())) {
					if (removed.hasRight()) {
						removed.getRight().setParent(replacementNode);
						replacementNode.setRight(removed.getLeft());
					}
				} else if (replacementNode.isLeaf()) {
					if (replacementNode.isLeft()) {
						replacementNode.getParent().setLeft(null);
					} else {
						replacementNode.getParent().setRight(null);
					}
					replacementNode.setLeft(removed.getLeft());
					replacementNode.setRight(removed.getRight());
				} else if (replacementNode.isRight() && replacementNode.hasLeft()) {
					replacementNode.getParent().setRight(replacementNode.getLeft());
					replacementNode.getLeft().setParent(replacementNode.getRight());

					replacementNode.setLeft(removed.getLeft());
					replacementNode.setRight(removed.getRight());
				}
				replacementNode.setParent(null);
				root = replacementNode;
				return true;
			}
		}

		if (replacementNode.getValue().compareTo(removed.getValue()) > 0) {
			if (replacementNode.equals(removed.getRight())) {
				if (removed.hasLeft()) {
					removed.getLeft().setParent(replacementNode);
					replacementNode.setLeft(removed.getLeft());
				}
				if (removed.isLeft()) {
					removed.getParent().setLeft(replacementNode);
				} else {
					removed.getParent().setRight(replacementNode);
				}
				replacementNode.setParent(removed.getParent());
				return true;
			}
			if (replacementNode.isLeaf()) {
				if (replacementNode.isLeft()) {
					replacementNode.getParent().setLeft(null);
				} else {
					replacementNode.getParent().setRight(null);
				}
				if (removed.hasLeft()) {
					replacementNode.setLeft(removed.getLeft());
				}
				if (removed.hasRight()) {
					replacementNode.setRight(removed.getRight());
				}
				if (removed.isLeft()) {
					removed.getParent().setLeft(replacementNode);
				} else {
					removed.getParent().setRight(replacementNode);
				}
				replacementNode.setParent(removed.getParent());
				return true;
			}
			if (replacementNode.isLeft() && replacementNode.hasRight()) {
				replacementNode.getParent().setLeft(replacementNode.getRight());
				replacementNode.setLeft(removed.getLeft());
				replacementNode.setRight(removed.getRight());
				if (removed.isLeft()) {
					removed.getParent().setLeft(replacementNode);
				} else if (removed.isRight()) {
					removed.getParent().setRight(replacementNode);
				}
				replacementNode.setParent(removed.getParent());
				return true;
			}
		} else {
			if (replacementNode.equals(removed.getLeft())) {
				if (removed.hasRight()) {
					removed.getRight().setParent(replacementNode);
					replacementNode.setRight(removed.getRight());
				}
				if (removed.isRight()) {
					removed.getParent().setRight(replacementNode);
				} else {
					removed.getParent().setLeft(replacementNode);
				}
				replacementNode.setParent(removed.getParent());
				return true;
			}
			if (replacementNode.isLeaf()) {
				if (replacementNode.isLeft()) {
					replacementNode.getParent().setLeft(null);
				} else {
					replacementNode.getParent().setRight(null);
				}
				if (removed.hasLeft()) {
					replacementNode.setLeft(removed.getLeft());
				}
				if (removed.hasRight()) {
					replacementNode.setRight(removed.getRight());
				}
				if (removed.isLeft()) {
					removed.getParent().setLeft(replacementNode);
				} else {
					removed.getParent().setRight(replacementNode);
				}
				replacementNode.setParent(removed.getParent());
				return true;
			}
			if (replacementNode.isRight() && replacementNode.hasLeft()) {
				replacementNode.getParent().setRight(replacementNode.getLeft());
				replacementNode.setRight(removed.getRight());
				replacementNode.setLeft(removed.getLeft());
				if (removed.isRight()) {
					removed.getParent().setRight(replacementNode);
				} else if (removed.isLeft()) {
					removed.getParent().setLeft(replacementNode);
				}
				replacementNode.setParent(removed.getParent());
				return true;
			}
		}
		return true;

	}

	public BinaryNode<E> findReplacement(BinaryNode<E> removedNode) {
		if (!removedNode.hasLeft()) {
			return minHelper(removedNode.getRight());
		}
		return maxHelper(removedNode.getLeft());
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
		return minHelper(root).getValue();
	}

	public BinaryNode<E> minHelper(BinaryNode<E> currentNode) {
		if (!currentNode.hasLeft()) {
			return currentNode;
		}
		return minHelper(currentNode.getLeft());
	}

	// Returns the maximum in the tree.
	public E max() {
		return maxHelper(root).getValue();
	}

	public BinaryNode<E> maxHelper(BinaryNode<E> currentNode) {
		if (!currentNode.hasRight()) {
			return currentNode;
		}
		return maxHelper(currentNode.getRight());
	}

	// Returns a bracket-surrounded, comma separated list of the contents of the
	// nodes, in order
	// e.g. [Apple, Cranberry, Durian, Mango]
	public String toString() {
		String contents = stringHelper(root, "");
		if (contents.length() > 2) {
			contents = contents.substring(0, contents.length() - 2);
		}
		return "[" + contents + "]";
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
