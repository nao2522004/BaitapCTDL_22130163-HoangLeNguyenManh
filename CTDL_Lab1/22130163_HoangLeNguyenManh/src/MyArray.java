
import java.util.Arrays;
import java.util.List;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		super();
		this.array = array;
	}

	// Method mirror that outputs the contents of an array in a
	// reverse order like a mirror
	// Example: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
	public int[] mirror() {
		int[] arr = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			arr[i] = array[i];
			arr[array.length * 2 - 1 - i] = arr[i];

		}
		return arr;
	}

	// removes all duplicate elements from an array and returns a
	// new array
	// Input: 1 3 5 1 3 7 9 8
	// Output: 1 3 5 7 9 8
	public int[] removeDuplicates() {

		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					// Phát hiện trùng lặp với phần tử trước đó
					count++;
					break; // Dừng vòng lặp nếu đã tìm thấy trùng lặp
				}
			}
		}

		int[] arrWithoutDuplicates = new int[array.length - count];
		int index = 0;

		for (int i = 0; i < array.length; i++) {
			boolean isDuplicate = false;
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				arrWithoutDuplicates[index++] = array[i];
			}
		}

		return arrWithoutDuplicates;

	}

	public int[] getMissingValues() {
		int minValue = array[0];
		int maxValue = array[array.length - 1];
		int missingCount = 0;

		// missing count
		for (int i = minValue; i <= maxValue; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i != array[j]) {
					missingCount++;
					break;
				}
			}
		}

		// create array containing missing value
		int[] missingValues = new int[missingCount - array.length];
		int index = 0;

		for (int i = minValue; i <= maxValue; i++) {
			boolean isMissing = true;
			for (int j = 0; j < array.length; j++) {
				if (i == array[j]) {
					isMissing = false;
					break;
				}
			}
			if (isMissing) {
				missingValues[index++] = i;
			}
		}

		return missingValues;
	}

	// Input: 10 11 12 -1 14 10 17 19 20
	// Output(k=3): 10 11 12 12 14 16 17 19 20
	public int[] fillMissingValues(int k) {
		int[] outPut = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			outPut[i] = array[i];
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] == -1) {
				if (i == 0) {
					outPut[i] = array[i + 1];
					break;
				} else if (i == array.length - 1) {
					outPut[i] = array[i - 1];
					break;
				} else {
					int sum = 0;
					int count = 0;
					for (int j = i - k; j <= i + k; j++) {
						if (j >= 0 && j < array.length && array[j] != -1) {
							sum += array[j];
							count++;
						}
					}
					outPut[i] = sum / count;
				}
			}
		}
		return outPut;
	}

	public static void main(String[] args) {
		// test mirror
		int[] array = { 1, 2, 3 };
		MyArray arr1 = new MyArray(array);
		System.out.println("" + Arrays.toString(arr1.mirror()));
		// test getMissingValues
		int[] array1 = { 10, 11, 12, 13, 14, 16, 17, 19 };
		MyArray arr2 = new MyArray(array1);
		System.out.println("" + Arrays.toString(arr2.getMissingValues()));
		// test removeDuplicates
		int[] array2 = { 1, 3, 5, 1, 3, 7, 9, 8 };
		MyArray arr3 = new MyArray(array2);
		System.out.println("" + Arrays.toString(arr3.removeDuplicates()));
		// test fillMissing
		int[] array3 = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };
		MyArray arr4 = new MyArray(array3);
		System.out.println("" + Arrays.toString(arr4.fillMissingValues(3)));
	}
}
