/*
 * See ArrayList documentation here:
 * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 */

/*
 * Your indexed functions should throw IndexOutOfBoundsException if index is invalid!
 */

public class MyArrayList<E> {

	/* Internal Object counter */
	protected int objectCount = 0;

	/* Internal Object array */
	protected E[] internalArray;

	/* Constructor: Create it with whatever capacity you want? */
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.internalArray = (E[]) new Object[12];
	}

	/* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity) {
		this.internalArray = (E[]) new Object[initialCapacity];
	}

	/* Return the number of active slots in the array list */
	public int size() {
		/* ---- YOUR CODE HERE ---- */
		return objectCount;
	}

	/* Are there zero objects in the array list? */
	public boolean isEmpty() {
		/* ---- YOUR CODE HERE ---- */
		if (objectCount != 0) {
			return false;
		}
		return true;
	}

	/* Get the index-th object in the list. */
	public E get(int index) {
		/* ---- YOUR CODE HERE ---- */
		if (index >= objectCount || index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (internalArray[index] == null) {
			throw new NullPointerException();
		} else {
			return internalArray[index];
		}
	}

	/* Replace the object at index with obj. returns object that was replaced. */
	public E set(int index, E obj) {
		/* ---- YOUR CODE HERE ---- */
		if (index > objectCount || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (internalArray[index] == null) {
			objectCount++;
		}
		E temp = internalArray[index];
		internalArray[index] = obj;
		return temp;
	}

	/*
	 * Returns true if this list contains an element equal to obj; otherwise returns false.
	 */
	public boolean contains(E obj) {
		/* ---- YOUR CODE HERE ---- */
		for (int i = 0; i < objectCount; i++) {
			if (internalArray[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}

	/* Insert an object at index */
	@SuppressWarnings("unchecked")
	public void add(int index, E obj) {
		/* ---- YOUR CODE HERE ---- */
		if (index > objectCount || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (objectCount == internalArray.length) {
			E[] expandedArray = (E[]) new Object[internalArray.length * internalArray.length];
			for (int i = 0; i < index; i++) {
				expandedArray[i] = internalArray[i];
			}
			this.internalArray = expandedArray;
		}
		for (int i = objectCount - 1; i > index ; i--) {
			this.set(i, internalArray[i - 1]);
		}
		internalArray[index] = null;
		this.set(index, obj); // objCount++ included in set()

	}

	/* Add an object to the end of the list; returns true */
	// @SuppressWarnings("unchecked")
	public boolean add(E obj) {
		/* ---- YOUR CODE HERE ---- */
		add(objectCount, obj);
		return true;
		// if (objectCount == internalArray.length) {
		// 	E[] expandedArray = (E[]) new Object[internalArray.length * 2];
		// 	for (int i = 0; i < objectCount; i++) {
		// 		expandedArray[i] = internalArray[i];
		// 	}
		// 	expandedArray[internalArray.length] = obj;
		// 	this.internalArray = expandedArray;
		// } else {
		// 	internalArray[objectCount] = obj;
		// }
		// objectCount++;
		// return true;
	}

	/* Remove the object at index and shift. Returns removed object. */
	public E remove(int index) {
		/* ---- YOUR CODE HERE ---- */
		E temp = this.internalArray[index];
		for (int i = index + 1; i < this.objectCount; i++) {
			this.set(index, internalArray[i]);
			index++;
		}
		objectCount--;
		internalArray[objectCount] = null;
		return temp;
	}

	/*
	 * Removes the first occurrence of the specified element from this list, if it is present. If
	 * the list does not contain the element, it is unchanged. More formally, removes the element
	 * with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))) (if such an
	 * element exists). Returns true if this list contained the specified element (or equivalently,
	 * if this list changed as a result of the call).
	 */
	public boolean remove(E obj) {
		/* ---- YOUR CODE HERE ---- */
		if (!this.contains(obj)) {
			return false;
		}
		for (int i = 0; i < this.objectCount; i++) {
			if (internalArray[i].equals(obj)) {
				remove(i);
				return true;
			}
		}
		return true;
	}


	/*
	 * For testing; your string should output as "[X, X, X, X, ...]" where X, X, X, X, ... are the
	 * elements in the ArrayList. If the array is empty, it should return "[]". If there is one
	 * element, "[X]", etc. Elements are separated by a comma and a space.
	 */
	public String toString() {
		/* ---- YOUR CODE HERE ---- */
		String objs = "[";
		for (int i = 0; i < internalArray.length; i++) {
			if (internalArray[i] != null) {
				objs += "" + internalArray[i] + ", ";
			}
		}
		return objs.substring(0, objs.length() - 2) + "]";
	}

}
