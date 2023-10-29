
public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {

	}

	// Returns the number of elements in the list.
	public int size() {
		return size;
	}

	// Returns true if the list is empty, and false otherwise.
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	// Returns (but does not remove) the first element in the list.
	public E first() {
		if (isEmpty()) {
			return null;
		} else {
			return head.getData();
		}

	}

	// Returns (but does not remove) the last element in the list.
	public E last() {
		if (isEmpty()) {
			return null;
		} else {
			return tail.getData();
		}
	}

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e);

		if (!isEmpty()) {
			newNode.setNext(head);
			head = newNode;
		} else {
			head = newNode;
			tail = newNode;
		}
		size++;
	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e);

		if (!isEmpty()) {
			tail.setNext(newNode);
			tail = newNode;
		} else {
			tail = newNode;
			head = newNode;
		}
		size++;
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {

		if (!isEmpty()) {
			E firstNode = head.getData();
			head = head.getNext();
			return firstNode;
		} else {
			return head.getData();
		}
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		Node<E> lastNode = head;
		Node<E> prevNode = null;

		if (isEmpty()) {
			return null;
		}
		while (lastNode.getNext() != null) {
			prevNode = lastNode;
			lastNode = lastNode.getNext();
		}
		if (prevNode == null) {
			return null;
		} else {
			prevNode.setNext(lastNode.getNext());
		}
		return lastNode.getData();
	}

	// Thêm phương thức printlinkedList vào lớp SinglyLinkedList
	public void printlinkedList() {
		Node<E> current = head;

		while (current != null) {
			System.out.print(current.getData() + " "); // In giá trị của nút hiện tại
			current = current.getNext(); // Di chuyển đến nút tiếp theo
		}
		System.out.println(); // In xuống dòng để kết thúc danh sách
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> integerLinkedList = new SinglyLinkedList<>();
		integerLinkedList.addFirst(5);
		integerLinkedList.addFirst(4);
		integerLinkedList.addFirst(3);
		integerLinkedList.addFirst(2);
		integerLinkedList.addFirst(1);

		System.out.print("LinkedList: ");
		integerLinkedList.printlinkedList();

		// test size
		System.out.print("Size của LinkedList: " + integerLinkedList.size + "\n");

		// test isEmpty
		System.out.println("List có trống không: " + integerLinkedList.isEmpty());

		// test first
		System.out.println("first element of list: " + integerLinkedList.first());

		// test last
		System.out.println("last element of list: " + integerLinkedList.last());

		// test addfirst
		integerLinkedList.addFirst(0);
		System.out.print("list sau khi thêm 0 vào đầu: ");
		integerLinkedList.printlinkedList();

		// test addLast
		integerLinkedList.addLast(6);
		System.out.print("list sau khi thêm 6 vào cuối: ");
		integerLinkedList.printlinkedList();

		// test remove first
		System.out.println("first element after being removed: " + integerLinkedList.removeFirst());
		System.out.print("list sau khi đã xóa phần tử đầu : ");
		integerLinkedList.printlinkedList();

		// test remove Last
		System.out.println("last element after being removed: " + integerLinkedList.removeLast());
		System.out.print("list sau khi đã xóa phần tử cuối : ");
		integerLinkedList.printlinkedList();

	}
}