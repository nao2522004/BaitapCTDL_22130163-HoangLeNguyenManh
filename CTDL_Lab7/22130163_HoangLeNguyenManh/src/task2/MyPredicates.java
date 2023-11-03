package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		List<T> newList = new ArrayList<>();
		for (T col : coll) {
			if (!p.test(col)) {
				newList.add(col);
			}
		}
		coll.clear(); // Xóa toàn bộ phần tử trong coll
		coll.addAll(newList); // Thêm lại các phần tử đã được lọc
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		List<T> newList = new ArrayList<>();
		for (T col : coll) {
			if (p.test(col)) {
				newList.add(col);
			}
		}
		coll.clear();
		coll.addAll(newList);
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> newSet = new HashSet<>();
		for (T col : coll) {
			if (p.test(col)) {
				newSet.add(col);
			}
		}
		coll.clear();
		coll.addAll(newSet);
		return newSet;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		int index = 0;
		for (T obj : coll) {
			if (p.test(obj)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public static void main(String[] args) {
		// test remove
		List<Integer> newList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		Predicate<Integer> pre = new Even();
		MyPredicates.remove(newList, pre);
		System.out.println(" test remove: " + newList);

		// test retain
		List<Integer> newList1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		Predicate<Integer> pre1 = new Even();
		MyPredicates.retain(newList1, pre1);
		System.out.println(" test contain: " + newList1);

		// test collect
		Set<Integer> newSet = new HashSet<>(Arrays.asList(1, 2, 3, 2, 4, 6, 4, 5, 6));
		Predicate<Integer> pre2 = new Even();
		MyPredicates.collect(newSet, pre2);
		System.out.println(" test collect: " + newSet);

		// test find
		List<Integer> newList3 = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6));
		Predicate<Integer> pre3 = new Even();
		System.out.println(" test find: " + MyPredicates.find(newList3, pre3));
	}
}
