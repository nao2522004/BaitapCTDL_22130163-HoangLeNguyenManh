
public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		super();
		this.array = array;
	}

	// task 1.1
	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public int recursiveLinearSearch(int target) {
		return linearSearch(target, 0);
	}

	private int linearSearch(int target, int index) {
		if (index >= array.length) {
			return -1;
		}
		if (array[index] == target) {
			return index;
		}
		return linearSearch(target, index + 1);

	}

	// task 1.2
	public int iterativeBinarySearch(int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;

	}

	public int recursiveBinarySearch(int target) {
		return binarySearch(target, 0, array.length - 1);
	}

	private int binarySearch(int target, int low, int high) {
		if (low <= high) {
			int mid = low + (high - low) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				return binarySearch(target, low, (mid - 1));
			} else {
				return binarySearch(target, (mid + 1), high);
			}
		}
		return -1;

	}

	// task 1,3

	public int iterativeBinarySearch1(int target) {
		int low = 0;
		int high = array.length - 1;

		for (int i = high; i >= low; i--) {
			int mid = low + (high - low) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				low = mid + 1; // Điều chỉnh low để thu hẹp phạm vi tìm kiếm
			} else {
				high = mid - 1; // Điều chỉnh high để thu hẹp phạm vi tìm kiếm
			}
		}

		return -1; // Trả về -1 nếu không tìm thấy target
	}

	public int recursiveBinarySearch1(int target) {
		return binarySearch1(target, array.length - 1, 0);
	}

	private int binarySearch1(int target, int high, int low) {
		if (low <= high) {
			int mid = low + (high - low) / 2;

			if (array[mid] == target) {
				return mid;
			}
			if (array[mid] > target) {
				return binarySearch1(target, high, (mid + 1));
			} else {
				return binarySearch1(target, (mid - 1), low);
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int[] ascendingArray = { 1, 2, 3, 4, 5, 6, 7 };
		int[] descendingArray = { 7, 6, 5, 4, 3, 2, 1 };

		System.out.println(" Test task 1.1");
		// test interativeLinearSearch
		MyArray arr1 = new MyArray(array);
		int index1 = arr1.iterativeLinearSearch(45);
		System.out.println("Output interativeLinearSearch: " + index1);
		// test recursiveLinearSearch
		MyArray arr2 = new MyArray(array);
		int index2 = arr2.recursiveLinearSearch(15);
		System.out.println("Output recursiveLinearSearch: " + index2);
		System.out.println("");
		
		System.out.println(" Test task 1.2");
		// test iterativeBinarySearch
		MyArray arr3 = new MyArray(ascendingArray);
		int index3 = arr3.iterativeBinarySearch(10);
		System.out.println("Output iterativeBinarySearch: " + index3);
		// test recursiveBinarySearch
		MyArray arr4 = new MyArray(ascendingArray);
		int index4 = arr4.recursiveBinarySearch(5);
		System.out.println("Output recursiveBinarySearch: " + index4);
		System.out.println("");

		System.out.println(" Test task 1.3");
		MyArray arr5 = new MyArray(descendingArray);
		int index5 = arr5.iterativeBinarySearch1(5);
		System.out.println("Output iterativeBinarySearch1: " + index5);
		MyArray arr6 = new MyArray(descendingArray);
		int index6 = arr6.recursiveBinarySearch1(10);
		System.out.println("Output recursiveBinarySearch1: " + index6);

	}
}
