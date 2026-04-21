// Represents a node of a doubly-linked list.


public class ListNode<E> {
	private E value;
	private Integer frequency;
	private ListNode<E> previous;
	private ListNode<E> next;


	public ListNode(E v, Integer f) {
		value = v;
		frequency = f;
		previous = null;
		next = null;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public ListNode(E v, ListNode<E> prev, ListNode<E> nx) {
		value = v;
		previous = prev;
		next = nx;
	}

	public E getValue() {
		return value;
	}

	public ListNode<E> getPrevious() {
		return previous;
	}

	public ListNode<E> getNext() {
		return next;
	}

	public void setValue(E v) {
		value = v;
	}

	public void setPrevious(ListNode<E> previous) {
		this.previous = previous;
	}

	public void setNext(ListNode<E> nx) {
		next = nx;
	}

	public String toString() {
		return "[" + value + ", " + frequency + "]";
	}


}


