// Implements a singly-linked list.

import java.util.List;
import java.lang.StringBuilder;


public class SinglyLinkedList<E> {
	private ListNode<E> head;
	private ListNode<E> tail;
	private int nodeCount;

	// Constructor: creates an empty list
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public SinglyLinkedList(Object[] values) {
		head = new ListNode(values[0]);
		tail = head;
		for (int i = 0; i < values.length; i++) {
			this.add((E) values[i]);
		}
		nodeCount = values.length;
	}

	public ListNode<E> getHead() {
		return head;
	}

	public ListNode<E> getTail() {
		return tail;
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
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
		for (ListNode<E> node = head; node != null; node = node.getNext()) {
			if (node.getValue() == obj) {
				return true;
			}
		}
		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		int index = 0;
		for (ListNode<E> node = head; node != null; node = node.getNext()) {
			if (node.getValue() == obj) {
				return index;
			}
			index++;
		}
		return -1;
	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		ListNode newNode = new ListNode<E>(obj);
		if (nodeCount == 0) {
			head = newNode;
			tail = head;
			nodeCount++;
			return true;
		}
		tail.setNext(newNode);
		this.tail = tail.getNext();
		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		int index = indexOf(obj);
		if (index == -1) {
			return false;
		}
		ListNode<E> node = head;
		for (int i = 0; i <= index; i++) {
			if (i == index) {
				node.setNext((node.getNext()).getNext());
				nodeCount--;
				return true;
			}
			node = node.getNext();
		}
		return false;

	}

	// Returns the i-th element.
	public E get(int i) {
		int index = 0;
		for (ListNode<E> node = head; node != null; node = node.getNext()) {
			if (index == i) {
				return node.getValue();
			}
			index++;
		}
		return null;
	}

	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, Object obj) {
		int index = 0;
		if (i < 0 || i >= nodeCount) {
			return null;
		}
		for (ListNode<E> node = head; node != null; node = node.getNext()) {
			if (index == i) {
				E oldValue = node.getValue();
				node.setValue((E) obj); // ask abt this bc object isnt E??
				return oldValue;
			}
			index++;
		}
		return null;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj) {
		int index = 0;
		if (i == 0) {
			ListNode<E> newItem = new ListNode(obj, head);
			head = newItem;
		}
		for (ListNode<E> node = head; node != null; node = node.getNext()) {
			if (index == i - 1) {
				ListNode<E> nextItem = node.getNext();
				node.setNext(new ListNode(obj, nextItem));
			}
			index++;
		}
		nodeCount++;
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		int index = 0;
		if (i < 0 || i >= nodeCount) {
			return null;
		}
		for (ListNode<E> node = head; node != null; node = node.getNext()) {
			if (index == i - 1) {
				E value = node.getNext().getValue();
				node.setNext(node.getNext().getNext());
				nodeCount--;
				return value;
			}
			index++;
		}
		return null;
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		StringBuilder objs = new StringBuilder("[");
		for (ListNode<E> node = head; node != null; node = node.getNext()) {
			objs.append(node.getValue() + ", ");
		}
		objs.delete(objs.length() - 2, objs.length()).append("]");
		return objs.toString();
	}


}
