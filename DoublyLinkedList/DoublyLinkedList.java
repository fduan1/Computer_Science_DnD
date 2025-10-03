
public class DoublyLinkedList {
	// Implements a circular doubly-linked list.

	private final ListNode2<Nucleotide> SENTINEL = new ListNode2<Nucleotide>(null);
	private int nodeCount;

	// Constructor: creates an empty list
	public DoublyLinkedList() {
		nodeCount = 0;
		this.SENTINEL.setPrevious(SENTINEL);
		this.SENTINEL.setNext(SENTINEL);
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public DoublyLinkedList(Nucleotide[] values) {
		this.SENTINEL.setPrevious(SENTINEL);
		this.SENTINEL.setNext(SENTINEL);
		for (int i = 0; i < values.length; i++) {
			this.add((Nucleotide) values[i]);
		}
		nodeCount = values.length;
	}

	public ListNode2<Nucleotide> getSentinel() {
		return SENTINEL;
	}

	public ListNode2<Nucleotide> getHead() {
		return SENTINEL.getNext();
	}

	public ListNode2<Nucleotide> getTail() {
		return SENTINEL.getPrevious();
	}


	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		if (nodeCount == 0) {
			return true;
		}
		return false;
	}

	// Returns the number of elements in this list.
	public int size() {
		return this.nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(Nucleotide obj) {
		if (this.indexOf(obj) == -1) {
			return false;
		}
		return true;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(Nucleotide obj) {
		int index = 0;
		for (ListNode2<Nucleotide> node = SENTINEL.getNext(); node != SENTINEL; node =
				node.getNext()) {
			if (node.getValue().equals(obj)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	public boolean add(Nucleotide obj) {
		ListNode2<Nucleotide> newNode =
				new ListNode2<Nucleotide>(obj, SENTINEL.getPrevious(), SENTINEL);
		SENTINEL.getPrevious().setNext(newNode);
		SENTINEL.setPrevious(newNode);
		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(Nucleotide obj) {
		int objIndex = indexOf(obj);
		if (objIndex == -1) {
			return false;
		}
		this.remove(objIndex);
		return true;
	}

	public void checkIfInBounds(int i) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}
	}

	// Returns the i-th element.
	public Nucleotide get(int i) {
		checkIfInBounds(i);
		int index = 0;
		for (ListNode2<Nucleotide> node = SENTINEL.getNext(); node != SENTINEL; node =
				node.getNext()) {
			if (index == i) {
				return node.getValue();
			}
			index++;
		}
		return null;
	}

	// Replaces the i-th element with obj and returns the old value.
	public Nucleotide set(int i, Nucleotide obj) {
		checkIfInBounds(i);
		Nucleotide oldValue = null;
		int index = 0;
		for (ListNode2<Nucleotide> node = SENTINEL.getNext(); node != SENTINEL; node =
				node.getNext()) {
			if (index == i) {
				oldValue = node.getValue();
				node.setValue(obj);
			}
			index++;
		}
		return oldValue;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Nucleotide obj) {
		checkIfInBounds(i);
		int index = 0;
		ListNode2<Nucleotide> newNode = new ListNode2<Nucleotide>(obj);
		for (ListNode2<Nucleotide> node = SENTINEL.getNext(); node != SENTINEL; node =
				node.getNext()) {
			if (index == i) {
				node.getPrevious().setNext(newNode);
				newNode.setNext(node);
				newNode.setPrevious(node.getPrevious());
				node.setPrevious(newNode);
				nodeCount++;
			}
			index++;
		}
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public Nucleotide remove(int i) {
		if (i < 0 || i >= nodeCount) {
			throw new IndexOutOfBoundsException();
		}
		int index = 0;
		for (ListNode2<Nucleotide> node = SENTINEL.getNext(); node != SENTINEL; node =
				node.getNext()) {
			if (index == i) {
				node.getNext().setPrevious(node.getPrevious());
				node.getPrevious().setNext(node.getNext());
				nodeCount--;
				return node.getValue();
			}
			index++;
		}
		return null;
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		StringBuilder objs = new StringBuilder("[");
		for (ListNode2<Nucleotide> node = SENTINEL.getNext(); node != SENTINEL; node =
				node.getNext()) {
			objs.append(node.getValue());
			objs.append(", ");
		}
		objs.delete(objs.length() - 2, objs.length()).append("]");
		return objs.toString();
	}


	// Like question 7 on the SinglyLinkedList test:
	// Add a "segment" (another list) onto the end of this list
	public void addSegmentToEnd(DoublyLinkedList seg) {
		this.SENTINEL.getPrevious().setNext(seg.SENTINEL.getNext());
		this.SENTINEL.setPrevious(seg.SENTINEL.getPrevious());
		seg.SENTINEL.getPrevious().setNext(SENTINEL);
		seg.SENTINEL.getNext().setPrevious(SENTINEL.getPrevious());
		nodeCount += seg.nodeCount;
	}

	public int nodeIndex(ListNode2<Nucleotide> node) {
		int indexNode = 0;
		for (ListNode2<Nucleotide> thisNode = SENTINEL.getNext(); thisNode != SENTINEL; thisNode =
				thisNode.getNext()) {
			if (node.equals(thisNode)) {
				return indexNode;
			}
			indexNode++;
		}
		return -1;
	}


	// Like question 8 on the SinglyLinkedList test:
	// You are to remove the next 16 nodes from the list, after the node nodeBefore.
	// (on the test these nodes were assumed to contain CCCCCCCCGGGGGGGG, but here
	// you do not need to assume or check for that)
	public void removeCCCCCCCCGGGGGGGG(ListNode2<Nucleotide> nodeBefore) {
		int startIndex = nodeIndex(nodeBefore);
		if (nodeCount - startIndex < 16) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = 0; i < 16; i++) {
			this.remove(startIndex + 1);
		}
	}

	// Like question 9 on the SinglyLinkedList test:
	// You are to find and delete the first instance of seg in the list.
	// If seg is not in the list, return false, otherwise return true.
	public boolean deleteSegment(DoublyLinkedList seg) {
		int segLength = seg.nodeCount;
		if (segLength > nodeCount) {
			return false;
		}
		int matching = 0;
		int index = 0;
		ListNode2<Nucleotide> segNode = seg.getHead();
		for (ListNode2<Nucleotide> node = this.getHead(); node != SENTINEL; node = node.getNext()) {
			if (node.equals(segNode)) {
				matching++;
				segNode = segNode.getNext();
			} else {
				matching = 0;
				segNode = seg.getHead();
			}
			if (matching == segLength) {
				break;
			}
			index++;
		}
		for (int i = 0; i < segLength; i++) {
			this.remove(index + 1);
		}
		return true;

	}

	// // Like question 10 on the SinglyLinkedList test:
	// // Delete the last three nodes in the list
	// // If there are not enough nodes, return false
	// public boolean deleteLastThree() {

	// }

	// // Like question 11 on the SinglyLinkedList test:
	// // Replaces every node containing "A" with three nodes containing "T" "A" "C"
	// public void replaceEveryAWithTAC() {

	// }

}
