
public class HeapPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {

	private E[] heap;
	private int objectCount;

	public HeapPQ() {
		this.heap = (E[]) new Comparable[3];
		this.objectCount = 0;
	}

	// Returns the number of elements in the priority queue
	public int size() {
		return objectCount;
	}

	// DO NOT CHANGE MY JANKY TOSTRING!!!!!
	public String toString() {
		StringBuffer stringbuf = new StringBuffer("[");
		for (int i = 0; i < objectCount; i++) {
			stringbuf.append(heap[i]);
			if (i < objectCount - 1)
				stringbuf.append(", ");
		}
		stringbuf.append("]\nor alternatively,\n");

		for (int rowLength = 1, j = 0; j < objectCount; rowLength *= 2) {
			for (int i = 0; i < rowLength && j < objectCount; i++, j++) {
				stringbuf.append(heap[j] + " ");
			}
			stringbuf.append("\n");
			if (j < objectCount) {
				for (int i = 0; i < Math.min(objectCount - j, rowLength * 2); i++) {
					if (i % 2 == 0)
						stringbuf.append("/");
					else
						stringbuf.append("\\ ");
				}
				stringbuf.append("\n");
			}
		}
		return stringbuf.toString();
	}

	// Doubles the size of the heap array
	private void increaseCapacity() {
		E[] doubledHeap = (E[]) new Comparable[size() * 2];
		for (int i = 0; i < size(); i++) {
			doubledHeap[i] = heap[i];
		}
		heap = doubledHeap;
	}

	// Returns the index of the "parent" of index i
	private int parent(int i) {
		if (i == 0) {
			return 0;
		}
		if (i % 2 == 0) {
			return i / 2 - 1;
		}
		return (i - 1) / 2;
	}

	// Returns the index of the *smaller child* of index i
	private int smallerChild(int i) {
		int child1 = i * 2 + 1;
		int child2 = (i + 1) * 2;

		if (heap[child2].compareTo(heap[child1]) < 0) {
			if (child2 >= objectCount) {
				return objectCount - 1;
			}
			return child2;
		}
		if (child1 >= objectCount) {
			return objectCount - 1;
		}
		return child1;
	}

	// Swaps the contents of indices i and j
	private void swap(int i, int j) {
		E obj1 = heap[i];
		heap[i] = heap[j];
		heap[j] = obj1;
	}

	// Bubbles the element at index i upwards until the heap properties hold again.
	private void bubbleUp(int i) {
		for (int j = i; heap[j].compareTo(heap[parent(j)]) < 0; j = parent(j)) {
			swap(j, parent(j));
		}
	}

	// Bubbles the element at index i downwards until the heap properties hold again.
	private void bubbleDown(int i) {
		for (int j = i; heap[j].compareTo(heap[smallerChild(j)]) > 0; j = smallerChild(j)) {
			swap(j, smallerChild(j));
		}
	}

	@Override
	public void add(E obj) {
		// TODO Auto-generated method stub
		if (heap.length == objectCount) {
			increaseCapacity();
		}
		heap[objectCount] = obj;
		bubbleUp(objectCount);
		objectCount++;
	}

	@Override
	public E removeMin() {
		// TODO Auto-generated method stub
		E removed = heap[0];
		swap(0, objectCount - 1);
		heap[objectCount - 1] = null;
		bubbleDown(0);
		objectCount--;

		return removed;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return heap[0];
	}

	@Override
	public boolean isEmpty() {
		if (objectCount == 0) {
			return true;
		}
		return false;
	}

}
