import java.util.Arrays;

public class Task2_1_Sort {
	
	public static void mergeSort(int[] arr) {
		sortArray(arr, 0, arr.length - 1);
	}
	
	public static int[] merge(int[] a1, int[] a2) {
		int n = a1.length + a2.length;
		int[] result = new int[n];
		int i = 0, i1 = 0, i2 = 0;
		while (i < n) {
			if (i1 < a1.length && i2 < a2.length) { // a1 và a2 khác rỗng
				if (a1[i1] <= a2[i2]) {
					result[i] = a1[i1];
					i++;
					i1++;
				} else {
					result[i] = a2[i2];
					i++;
					i2++;
				}
			} else { // ai or a2 bằng rỗng
				if (i1 < a1.length) { // a1 khác rỗng a2 rỗng
				 	result[i] = a1[i1];
					i++;
					i1++;
				} else { // a2 khác rỗng a1 rỗng
					result[i] = a2[i2];
					i++;
					i2++;
				}
			}
		}
		return result;
	}

	// l = left r = right
	public static int[] sortArray(int a[], int l, int r) {
		if (l == r) {
			int[] singleElement = { a[l] };
			return singleElement;
		}
		// chia ra
		System.out.println("Chia vị trí: " + l + " - " + r);
		int m = (l + r) / 2; // m is mid
		int[] a1 = sortArray(a, l, m); // a1 is leftHalfSrray
		int[] a2 = sortArray(a, m + 1, r); // a2 is rightHalfArray

		// trộn vào a1 và a2 là các mảng đc sắp xếp
		int[] result = merge(a1, a2);
		System.out.println(" kết quả trộn vào : " + Arrays.toString(result));
		return result;
	}

	

	public static void main(String[] args) {
		Task2_1_Sort s = new Task2_1_Sort();
		int[] a = { 1, 5, 3, 2, 8, 7, 6, 4 };
		mergeSort(a);
	}
}



