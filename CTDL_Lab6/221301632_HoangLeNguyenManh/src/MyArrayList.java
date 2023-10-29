import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of elements is full
	public void growSize() {
		if (size == elements.length) {
			elements = Arrays.copyOf(elements, elements.length * 2);
		}
	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("index is out of bound");
		}
		return elements[i];

	}

	// Replaces the element at index i with e, and returns the replaced element. ∗/
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("index is out of bound");
		}
		E replaceElement = elements[i];
		elements[i] = e;
		return replaceElement;
	}

	// It is used to append the specified element at the end of a list.
	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size] = e;
		size++;
		return true;
	}

	// Inserts element e to be at index i, shifting all subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("index is out of bound");
		}
		if (size == elements.length) {
			growSize();
		}
		for (int j = size; j > i; j--) {
			elements[j] = elements[j - 1];
		}
		elements[i] = e;
		size++;
	}

	// Removes and returns the element at index i, shifting subsequent elements
	// earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("index is out of bound");
		}
		E removeElement = elements[i];
		for (int j = i; j < size - 1; j++) {
			elements[j] = elements[j + 1];

		}
		elements[size - 1] = null;
		size--;

		return removeElement;
	}

	// It is used to clear all elements in the list.
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

//  It is used to return the index in this list of the
//	last occurrence of the specified element, or -1 if the
//	list does not contain this element.
	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
			if (o == null && elements[i] == null) {
				return i; // Phần tử null tồn tại trong danh sách
			} else if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	// It is used to return an array containing all of the elements in this list in
	// the correct order.
	public E[] toArray() {
		E[] newArray = (E[]) new Object[size];
		for (int i = 0; i < size; i++) {
			newArray[i] = elements[i];
		}
		return newArray;
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> clonedList = new MyArrayList<>(this.size);
		clonedList.size = this.size;
		clonedList.elements = Arrays.copyOf(this.elements, this.size);
		return clonedList;
	}

	// It returns true if the list contains the specified lement
	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (o == null && elements[i] == null) {
				return true;
			} else if (o.equals(elements[i])) {
				return true;
			}
		}
		return false;
	}

//	It is used to return the index in this list of the
//	first occurrence of the specified element, or -1 if the
//	List does not contain this element.
	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elements[i])) {
				return i;
			}
		}

		return -1;
	}

	// It is used to remove the first occurrence of the specified element.

	public boolean removed(E e) {
		for (int i = 0; i < size; i++) {
			if ((e == null && elements[i] == null) || (e != null && e.equals(elements[i]))) {
				// Tìm thấy phần tử, xóa nó
				for (int j = i; j < size - 1; j++) {
					elements[j] = elements[j + 1];
				}
				elements[size - 1] = null;
				size--;
				return true;
			}
		}
		return false;
	}

	// It is used to sort the elements of the list on the basis of specified
	// comparator.
	public void sort(Comparator<E> c) {
		Arrays.sort(elements, 0, size, c);
	}

	public void printList() {
		for (int i = 0; i < size; i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		// Tạo một MyArrayList từ mảng arr
		MyArrayList<Integer> integerList = new MyArrayList<>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		integerList.add(4);
		integerList.add(5);

		System.out.print("List: ");
		integerList.printList();

		// Kiểm tra các phương thức của MyArrayList

		System.out.println("----Test size----");
		System.out.println("Kích thước của integerList: " + integerList.size());
		System.out.println("----Test isEmpty----");
		System.out.println("integerList có trống không? " + integerList.isEmpty());
		System.out.println();

		// Kiểm tra get() để truy cập các phần tử
		System.out.println("----Test get----");
		System.out.println("Phần tử tại vị trí 2: " + integerList.get(2));
		System.out.println();

		// Kiểm tra set() để cập nhật một phần tử
		System.out.println("----Test set----");
		Integer setList = integerList.set(1, 12);
		System.out.print("Phần tử tại vị trí 1 sau khi set: ");
		integerList.printList();
		System.out.println();

		// Kiểm tra add(E e) để chèn một phần tử
		System.out.println("----Test add----");
		if (integerList.add(6)) {
			System.out.println(" element 6 đã được chèn vào cuối của danh sách ");
		} else {
			System.out.println("false");
		}
		System.out.print(" List khi đã được chèn 6 vào cuối: ");
		integerList.printList();
		System.out.println();

		// Kiểm tra add(int, E) để chèn một phần tử
		System.out.println("----Test add----");
		integerList.add(2, 25);
		System.out.print("Phần tử tại vị trí 2 sau khi thêm: ");
		integerList.printList();
		System.out.println();

		// Kiểm tra remove(int) để xóa một phần tử
		System.out.println("----Test remove----");
		integerList.remove(3);
		System.out.print("Phần tử tại vị trí 3 sau khi xóa: ");
		integerList.printList();
		System.out.println();

		// Kiểm tra clear() để làm sạch danh sách
		System.out.println("----Test clear----");
		integerList.clear();
		System.out.println("integerList sau khi làm sạch: ");
		integerList.printList();
		System.out.println();

		// thêm các element mới vào integerList
		integerList.add(10);
		integerList.add(20);
		integerList.add(20);
		integerList.add(10);
		integerList.add(15);
		integerList.add(30);

		// Kiểm tra lastIndexOf()
		System.out.println("----Test lastIndexOf----");
		int lastIndex = integerList.lastIndexOf(10);
		System.out.println("Vị trí cuối cùng của 10: " + lastIndex);
		integerList.printList();
		System.out.println();

		// Kiểm tra toArray()
		System.out.println("----Test toArray----");
		System.out.println("Các phần tử trong integerArray:" + Arrays.deepToString(integerList.toArray()));
		System.out.println();

		// Kiểm tra clone()
		System.out.println("----Test clone----");
		MyArrayList<Integer> clonedList = integerList.clone();
		System.out.print("Các element trong clonedList: ");
		clonedList.printList();
		System.out.println();

		// Kiểm tra contains()
		System.out.println("----Test contains----");
		System.out.println("integerList có chứa số 5 không? " + integerList.contains(5));
		System.out.println("integerList có chứa số 10 không? " + integerList.contains(10));
		System.out.println();

		// test indexOf
		System.out.println("----Test indexOf----");
		System.out.println("vị trí số 10 đầu tiên trong list là: " + integerList.indexOf(10));
		System.out.print("List: ");
		integerList.printList();
		System.out.println();

		// test remove(E e)
		System.out.println("----Test remove(boolean)----");
		System.out.print("list số 10 đầu tiên của list bị xóa là : " + integerList.removed(20) + "\n List: ");
		integerList.printList();
		System.out.println();

		// Kiểm tra phương thức sort(Comparator<E> c)
		// Tạo một bộ so sánh để sắp xếp theo thứ tự ngược (giảm dần)
		System.out.println("----Test sort----");
		Comparator<Integer> reverseOrder = (a, b) -> b.compareTo(a);

		integerList.sort(reverseOrder);

		System.out.print("Sau khi sắp xếp theo thứ tự lớn -> bé: ");
		integerList.printList();

	}

}
