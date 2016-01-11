public class ArrayList {
	private Object[] array;
	private int size;

	ArrayList() {
		array = new Object[5];
	}

	private void validateIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index = " + index
					+ ", should be between 0 (inclusive) and " + size);
		}
	}

	public void add(Object value) {
		add(size, value);
	}

	public void add(int index, Object value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index = " + index
					+ ", should be between 0 and " + size + " (inclusive)");
		}

		if (array.length == size) {
			Object[] arrayExt = new Object[size * 2];
			System.arraycopy(array, 0, arrayExt, 0, index);
			System.arraycopy(array, index, arrayExt, index + 1, size - index);
			array = arrayExt;
		} else if (index < size) {
			System.arraycopy(array, index, array, index + 1, size - index);
		}
		array[index] = value;
		size++;
	}

	public void clear() {
		size = 0;
	}

	public boolean contains(Object value) {
		return indexOf(value) > -1;
	}

	public Object get(int index) {
		validateIndex(index);
		return array[index];
	}

	public int indexOf(Object value) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int lastIndexOf(Object value) {
		for (int i = size - 1; i >= 0; i--) {
			if (array[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

	public void remove(int index) {
		validateIndex(index);
		System.arraycopy(array, index + 1, array, index, size - index - 1);
		size--;
	}

	public boolean remove(Object value) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(value)) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	public void removeRange(int fromIndex, int toIndex) {
		if (fromIndex >= toIndex) {
			return;
		}
		validateIndex(fromIndex);
		validateIndex(toIndex);

		Object[] arrayExt = new Object[array.length];
		System.arraycopy(array, 0, arrayExt, 0, fromIndex);
		System.arraycopy(array, toIndex, arrayExt, fromIndex, size - toIndex);

		array = arrayExt;
		size-= toIndex - fromIndex;
	}

	public void set(int index, Object value) {
		validateIndex(index);
		array[index] = value;
	}

	public int size() {
		return size;
	}

	public Object[] toArray() {
		return array.clone();
	}

	public void trimToSize() {
		Object[] arrayExt;
		arrayExt = new Object[size];
		System.arraycopy(array, 0, arrayExt, 0, size);
		array = arrayExt;
	}

	@Override
	public String toString() {
		String arrayValues = "[";

		for (int i = 0; i < size; i++) {
			arrayValues += i == 0 ? array[i] : "," + array[i];
		}
		return arrayValues + "]";
	}
}