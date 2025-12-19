public class SortedArrayList<E extends Comparable<E>> extends MyArrayList<E> {

	@Override
	public boolean contains(E obj) {
		if (binarySearch(obj, 0, objectCount-1) != -1) {
			return true;
		}
		return false;
	}

	public int binarySearch(E obj, int low, int high) {
		if (high >= low) {
			int mid = (high + low) / 2;
			if (this.get(mid).equals(obj)) {
				return mid;
			}
			if (obj.compareTo(this.get(mid)) < 0) {
				return binarySearch(obj, low, mid - 1);
			}
			if (obj.compareTo(this.get(mid)) > 0) {
				return binarySearch(obj, mid + 1, high);
			}
		}
		return -1;
	}

	// May not contain more than one of the same object
	@Override
	public boolean add(E obj) {
		if (objectCount == 0) {
			this.add(0, obj);
			return true;
		}
		if (this.contains(obj)) {
			return false;
		}
		if (obj.compareTo(this.get(0)) < 0) {
			this.add(0, obj);
			return true;
		}
		if (obj.compareTo(this.get(objectCount-1)) > 0) {
			this.add(objectCount, obj);
			return true;
		}
		for (int i = 1; i < objectCount; i++) {
			if (obj.compareTo(this.get(i-1)) > 0 && obj.compareTo(this.get(i)) < 0) {
				this.add(i, obj);
				return true;
			}
		}
		return false;
	}


	@Override
	public boolean remove(E obj) {
		return super.remove(obj);
	}

	public E min() {
		return internalArray[0];
	}

	public E max() {
		return internalArray[objectCount - 1];
	}

}
