public class Task1_Sort {

	public static void print(int count, int[] array) {
		System.out.printf("%d: ", count);
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d ", array[i]);
		}
		System.out.println();
	}

	// task 1.2
	// sort by descending order
	public static void bubbleSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			boolean isSorted = true;
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] < array[j + 1]) {
					isSorted = false;
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			print(i, array);
			if (isSorted) {
				break;
			}
		}

	}

	// task 1.2
	// sort by descending order
	public static void selectionSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			int maxIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j] > array[maxIndex]) {
					maxIndex = j;
				}

			}
			if (maxIndex != i) {
				int t = array[i];
				array[i] = array[maxIndex];
				array[maxIndex] = t;
			}
			print(i, array);
		}

	}

	// task 1.3
	public static void insertionSort(int[] array) {
		int n = array.length;
		for (int i = 1; i < n; i++) {
			int ai = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] < ai) {
                  array[j+1] = array[j];
                  j--;
			}
			array[j+1] = ai;
			print(i,array);
		}
		
	}

	public static void main(String[] args) {
		System.out.println(" bubbleSort ");
		int[] arr = { 3, 2, 5, 4, 8, 6, 9 };
		bubbleSort(arr);
		System.out.println(" selectionSort ");
		int[] arr1 = { 3, 5,7,8,9,4,2,1 };
		selectionSort(arr1);
		System.out.println(" insertionSort ");
		int[] arr2 = { 9, 4, 5, 6, 4, 1, 2 };
		insertionSort(arr2);

	}

}
