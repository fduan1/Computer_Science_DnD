
public class BinaryNode<E extends Comparable<E>> {
	private E value;
	private BinaryNode<E> left;
	private BinaryNode<E> right;
	private BinaryNode<E> parent;
	private String binary;
	private Integer frequency;

	public BinaryNode(E value, int freq) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
		this.binary = null;
		frequency = freq;
	}

	public E getValue() {
		return value;
	}

	public BinaryNode<E> getLeft() {
		return left;
	}

	public BinaryNode<E> getRight() {
		return right;
	}

	public BinaryNode<E> getParent() {
		return parent;
	}

	public String getBinary() {
		return binary;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public void setLeft(BinaryNode<E> left) {
		this.left = left;
	}

	public void setRight(BinaryNode<E> right) {
		this.right = right;
	}

	public void setParent(BinaryNode<E> parent) {
		this.parent = parent;
	}

	public void setBinary(String binary) {
		this.binary = binary;
	}

	/**
	 * @return the frequency
	 */
	public Integer getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(int frequency) {
		this.frequency = (Integer) frequency;
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public boolean hasParent() {
		return parent != null;
	}

	public boolean isLeaf() {
		return !hasLeft() && !hasRight();
	}

	public boolean isLeft() {
		if (this.parent == null) {
			return false;
		}
		if (this.getParent().getLeft() == null) {
			return false;
		}
		if (this.getParent().getLeft().equals(this)) {
			return true;
		}
		return true;
	}

	public boolean isRight() {
		if (this.parent == null) {
			return false;
		}
		if (this.getParent().getRight() == null) {
			return false;
		}
		if (this.getParent().getRight().equals(this)) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "[" + value + ", " + frequency + "]";
	}

}
