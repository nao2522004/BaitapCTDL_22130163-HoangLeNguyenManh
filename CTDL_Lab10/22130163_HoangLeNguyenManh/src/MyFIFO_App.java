import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyFIFO_App {
	// method stutter that accepts a queue of integers as a parameter and replaces
	// every element of the queue with two copies of that element
	// front [1, 2, 3] back becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		int originalSize = input.size();
		for (int i = 0; i < originalSize; i++) {
			E element = input.poll(); // Lấy phần tử từ đầu hàng đợi
			input.offer(element); // Thêm một bản sao
			input.offer(element); // Thêm bản sao thứ hai
		}
	}

	// Method mirror that accepts a queue of strings as a parameter and appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		int originalSizes = input.size();
		Stack<E> newStack = new Stack<>();

		for (E e : input) {
			newStack.add(e);
		}
		
		for (int i = 0; i < originalSizes; i++) {
	           E e = newStack.pop();
	           input.offer(e);
			}
		
		
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		Queue<String> queue1 = new LinkedList<>();
		queue1.offer("a");
		queue1.offer("b");
		queue1.offer("c");

		System.out.println("Before queue: " + queue);

		stutter(queue);
		System.out.println("After stutter: " + queue);
		
		System.out.println("Before queue: " + queue1);

		mirror(queue1);
		System.out.println("After mirror" + queue1);
	}
}
