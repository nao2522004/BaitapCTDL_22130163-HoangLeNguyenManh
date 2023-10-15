import java.util.Arrays;
import java.util.Random;

public class Task2_2_Sort {

	private static void qickSort(int[] a) {
		if (a.length <= 1) {
			return;
		}

		qickSort_MedianOfThree(a, 0, a.length - 1);

	}

	private static void qickSort_MedianOfThree(int[] a, int l, int r) {
		if (l >= r) {
			return;
		} else {
			// b1 : chọn chốt
			int pivot = a[l + (r - l) / 2];
			// b2 : phân bố lại mảng
			int k = getPivot_MedianOfThree(a, l, r, pivot);

			// b3 : chia đôi mảng và lặp lại.
			qickSort_MedianOfThree(a, l, k - 1);
			qickSort_MedianOfThree(a, k, r);
		}
	}

	// return pivotvalue (k)
	public static int getPivot_MedianOfThree(int[] a, int l, int r, int pivot) {
		int il = l;
		int ir = r;
		while (il <= ir) {
			while (a[il] < pivot)
				il++;

			while (a[ir] > pivot)
				ir--;

			if (il <= ir) {
				int temp = a[il];
				a[il] = a[ir];
				a[ir] = temp;
				il++;
				ir--;
			}
		}
		return il;
	}

	private static void qickSort1(int[] a) {
		if (a.length <= 1) {
			return;
		}

		qickSort_First(a, 0, a.length - 1);

	}

	private static void qickSort_First(int[] a, int l, int r) {
		if (l >= r) {
			return;
		} else {
			// b1 : chọn chốt
			int pivot = a[l];
			// b2 : phân bố lại mảng
			int k = getPivot_First(a, l, r, pivot);

			// b3 : chia đôi mảng và lặp lại.
			qickSort_First(a, l, k - 1);
			qickSort_First(a, k, r);
		}
	}

	// return pivotvalue (k)
	public static int getPivot_First(int[] a, int l, int r, int pivot) {
		int il = l;
		int ir = r;
		while (il <= ir) {
			while (a[il] < pivot)
				il++;

			while (a[ir] > pivot)
				ir--;

			if (il <= ir) {
				int temp = a[il];
				a[il] = a[ir];
				a[ir] = temp;
				il++;
				ir--;
			}
		}
		return il;
	}

	private static void qickSort3(int[] a) {
    if (a.length <= 1) {
        return;
    }

    qickSort_Random(a, 0, a.length - 1);
}

private static void qickSort_Random(int[] a, int l, int r) {
    if (l < r) {
        // b1: Chọn chốt
        int pivotIndex = getPivot_Random(l, r);
        int pivot = a[pivotIndex];

        // Hoán đổi chốt với phần tử cuối cùng
        int temp = a[pivotIndex];
        a[pivotIndex] = a[r];
        a[r] = temp;

        // b2: Phân bố lại mảng
        int k = partition(a, l, r, pivot);

        // b3: Chia đôi mảng và lặp lại
        qickSort_Random(a, l, k - 1);
        qickSort_Random(a, k + 1, r);
    }
}

// Return pivot value (k)
public static int getPivot_Random(int l, int r) {
    Random rand = new Random();
    return rand.nextInt(r - l + 1) + l;
}

private static int partition(int[] a, int l, int r, int pivot) {
    int i = l - 1;
    for (int j = l; j < r; j++) {
        if (a[j] <= pivot) {
            i++;
            // Swap a[i] and a[j]
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
    // Swap a[i + 1] and a[r] (put the pivot in its correct position)
    int temp = a[i + 1];
    a[i + 1] = a[r];
    a[r] = temp;
    return i + 1;
}

	
	
	

	private static void qickSort2(int[] a) {
		if (a.length <= 1) {
			return;
		}

		qickSort_Last(a, 0, a.length - 1);

	}

	private static void qickSort_Last(int[] a, int l, int r) {
		if (l < r) {
			return;
		} else {
			// b1 : chọn chốt
			int pivot = a[r];
			// b2 : phân bố lại mảng
			int k = getPivot_Last(a, l, r, pivot);

			// b3 : chia đôi mảng và lặp lại.
			qickSort_Last(a, l, k - 1);
			qickSort_Last(a, k, r);
		}
	}

	// return pivotvalue (k)
	public static int getPivot_Last(int[] a, int l, int r, int pivot) {
		int il = l;
		int ir = r;
		while (il <= ir) {
			while (a[il] < pivot)
				il++;

			while (a[ir] > pivot)
				ir--;

			if (il <= ir) {
				int temp = a[il];
				a[il] = a[ir];
				a[ir] = temp;
				il++;
				ir--;
			}
		}
		return il;
	}

	public static void main(String[] args) {
		int[] a = { 6, 7, 8, 1, 5, 2, 3, 4 };

		qickSort(a);
		System.out.println("Mảng đã sắp xếp của getPivott_MedianOfThree: " + Arrays.toString(a));

		qickSort1(a);
		System.out.println("Mảng đã sắp xếp của getPivott_First: " + Arrays.toString(a));

		qickSort2(a);
		System.out.println("Mảng đã sắp xếp của getPivott_Last: " + Arrays.toString(a));
		
		qickSort3(a);
		System.out.println("Mảng đã sắp xếp của getPivott_Random: " + Arrays.toString(a));
	}
}
