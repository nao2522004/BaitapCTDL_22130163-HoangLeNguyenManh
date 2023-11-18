package task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PublicationsCatalog {
	private List<Publications> publication;

	public PublicationsCatalog(List<Publications> publication) {
		super();
		this.publication = publication;
	}

	// Tính tổng tiền của tất các ấn phẩm trong nhà sách
	public int totalPrices() {
		int result = 0;
		for (Publications publications : publication) {
			result += publications.getTotalPrice();
		}
		return result;
	}

	// Tìm quyển sách tham khảo có chương sách nhiều trang nhất
	public ReferenceBooks findTheMostPages() {
		ReferenceBooks reference = null;
		for (Publications publications : publication) {
			if (publications.getType().equals("ReferenceBooks")) {
				if (reference == null) {
					reference = (ReferenceBooks) publications;
				} else if (reference.getChapterPageNum() < publications.getChapterPageNum()) {
					reference = (ReferenceBooks) publications;
				}
			}
		}

		return reference;
	}

	// Tìm xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước hay
	// không?
	public boolean containsMagazine(String name) {
		for (Publications publications : publication) {
			if (publications.getType().equals("Magazine")) {
				Magazine magazine = (Magazine) publications;
				if (magazine.getName().equals(name)) {
					return true;
				}
			}
		}
		return false;
	}

	// Lấy ra danh sách các tạp chí được xuất bản vào 1 năm cho trước
	public List<Magazine> findMagazines(int currentYear) {
		List<Magazine> listMagazine = new ArrayList<>();
		for (Publications publications : publication) {
			int year = publications.getYear();
			if (publications.getType().equals("Magazine")) {
				if (year == currentYear) {
					listMagazine.add((Magazine) publications);
				}

			}

		}
		return listMagazine;

	}

	// Sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản (sử dụng
	// interface Comparable hoặc Comparator)
	public void sortListPublication() {
		Collections.sort(publication, new Comparator<Publications>() {
			@Override
			public int compare(Publications o1, Publications o2) {
				int result = o1.getTitle().compareTo(o2.getTitle());
				if (result == 0) {
					result = o2.getYear() - o1.getYear();
				}
				return result;
			}
		});
	}

	public void printSortedPublicationList() {
		for (Publications publications : publication) {
			System.out.println("[" + publications.getTitle() + "]" + "[" + publications.getNumOfPage() + "]" + "["
					+ publications.getYear() + "]" + "[" + publications.getAuthor() + "]" + "["
					+ publications.getPrice() + "]");
		}
	}

	// Thống kê số lượng ấn phẩm theo năm xuất bản. Ví dụ 2020: 5, 2021: 10, … năm
	// 2020 có 5 ấn phẩm, năm 2021 có 10 ấn phẩm.
	public Map<Integer, Integer> quantityStatistics() {
		Map<Integer, Integer> newMap = new HashMap<>();
		for (Publications publications : publication) {
			int year = publications.getYear();
			newMap.put(year, newMap.getOrDefault(year, 0) + 1);
		}
		return newMap;
	}

	public static void main(String[] args) {

		Magazine m1 = new Magazine("the thao", 10, 2010, "Hoang Van A", 30000, "tap chi the thao");
		Magazine m2 = new Magazine("dien tu", 20, 2020, "Hoang Van B", 10000, "tap chi dien tu");
		Magazine m3 = new Magazine("du lich", 15, 2010, "Hoang Van C", 20000, "tap chi du lich");
		Magazine m4 = new Magazine("thoi tiet", 9, 2010, "Hoang Van D", 50000, "tap chi thoi tiet");
		Magazine m5 = new Magazine("nong vu", 5, 2010, "Hoang Van E", 60000, "tap chi nong vu");
		Magazine m6 = new Magazine("dien tu", 20, 2015, "Hoang Van B", 10000, "tap chi dien tu");

		Chapter c1 = new Chapter(" tieu de ", 10);
		Chapter c2 = new Chapter(" tieu de 1", 10);
		Chapter c3 = new Chapter(" tieu de 2", 10);

		List<Chapter> l1 = new ArrayList<>();
		l1.add(c1);

		List<Chapter> l1a = new ArrayList<>();
		l1a.add(c1);
		l1a.add(c3);

		List<Chapter> l1b = new ArrayList<>();
		l1b.add(c1);
		l1b.add(c3);
		l1b.add(c2);

		ReferenceBooks r1 = new ReferenceBooks("tham khao1", 30, 2021, "Le Thi A", 50000, "y hoc", l1a);
		ReferenceBooks r2 = new ReferenceBooks("tham khao1", 30, 2010, "Le Thi B", 60000, "the thao", l1);
		ReferenceBooks r3 = new ReferenceBooks("tham khao3", 30, 2015, "Le Thi C", 30000, "giao duc", l1);
		ReferenceBooks r4 = new ReferenceBooks("tham khao4", 30, 2005, "Le Thi D", 30000, "y te", l1);
		ReferenceBooks r5 = new ReferenceBooks("tham khao5", 30, 2010, "Le Thi E", 30000, "quan su", l1b);
		ReferenceBooks r6 = new ReferenceBooks("tham khao6", 30, 2021, "Le Thi A", 50000, "y hoc1", l1a);

		List<Publications> l2 = new ArrayList<>();
		l2.add(m1);
		l2.add(m2);
		l2.add(m3);
		l2.add(m4);
		l2.add(m5);
		l2.add(r1);
		l2.add(r2);
		l2.add(r3);
		l2.add(r4);
		l2.add(r5);

		List<Publications> l3 = new ArrayList<>();
		l3.add(r1);
		l3.add(m2);
		l3.add(r5);
		l3.add(m3);
		l3.add(m6);
		
		List<Publications> l4 = new ArrayList<>();
		l4.add(r1);
		l4.add(r2);
		l4.add(r3);
		l4.add(r4);
		l4.add(r5);
		l4.add(r6);
		l4.add(r1);
		l4.add(r1);
		

		PublicationsCatalog pc1 = new PublicationsCatalog(l3);
		PublicationsCatalog pc2 = new PublicationsCatalog(l2);
		PublicationsCatalog pc3 = new PublicationsCatalog(l4);

		// m la viet tat cua Magazine , r la viet tat cua referencebook

		// test type
		System.out.println("Loai cua magazine1 la: " + m1.getType()); // m1 la Magazine
		System.out.println("Loai cua referenceBook1 la: " + r1.getType()); // r1 la ReferenceBooks

		// test checkPubllicationsIsMagazine / nam san xuat m1 : 2010 , m2 : 2020
		System.out.println("\nKiem tra an pham magazine1 tap chi co san xuat truoc 2021 10 nam hay ko ?: "
				+ m1.checkPublicationsIsMagazine(2021));
		System.out.println("Kiem tra an pham magazine2 tap chi co san xuat truoc 2021 10 nam hay ko ?: "
				+ m2.checkPublicationsIsMagazine(2021));

		// test checkTwoPublicationsIsMagazine
		// ReferenceBooks r1 = new ReferenceBooks("tham khao", 30, 2021, "Le Thi A",
		// 50000, "y hoc", l1a);
		// ReferenceBooks r2 = new ReferenceBooks("tham khao1", 30, 2010, "Le Thi B",
		// 60000, "the thao", l1);
		// ReferenceBooks r6 = new ReferenceBooks("tham khao6", 30, 2021, "Le Thi A",
		// 50000, "y hoc1", l1a);
		System.out
				.println("\ntap chi r1 va r2 co cung loai va tac gia khong: " + r2.checkTwoPublicationsIsMagazine(r1));
		System.out.println("tap chi r1 va r6 co cung loai va tac gia khong: " + r6.checkTwoPublicationsIsMagazine(r1));

		// test totalPrice
		// tong tien cua l3 la : 120000
		System.out.println("\nTong tien la: " + pc1.totalPrices());

		// test findTheMostPages , trong pc3 sach tham khao co chuong nhieu trang nhat co tieu de la tham khao5 voi 30 trang
		System.out.println("\nsach tham khao co chuong nhieu trang nhat la: " + pc3.findTheMostPages().getTitle());

		// test containsMagazine 
		System.out.println("\n Tap chi co ten cho truoc hay khong: " + pc2.containsMagazine("tap chi dien tu"));
		System.out.println("Tap chi co ten cho truoc hay khong: " + pc2.containsMagazine("tap chi dien tu1"));

		// test findMagazines
		List<Magazine> newList = pc2.findMagazines(2010);
		System.out.println("\n Các tạp chi được sản xuất vào năm 2010: ");
		for (Magazine list : newList) {
			System.out.println("[" + list.getTitle() + "]" + "[" + list.getNumOfPage() + "]" + "[" + list.getYear()
					+ "]" + "[" + list.getAuthor() + "]" + "[" + list.getPrice() + "]" + "[" + list.getName() + "]");
		}

		// test sortListPublication
		System.out.println("\n Danh sách sau khi sắp xếp:");
		pc2.sortListPublication();
		pc2.printSortedPublicationList();

		//
		Map<Integer, Integer> newMap = pc2.quantityStatistics();
		System.out.println("\n Thong ke so luong an pham theo nam: ");
		for (Entry<Integer, Integer> entry : newMap.entrySet()) {
			System.out.print(entry.getKey() + "-" + entry.getValue() + "  ");
		}

	}
}
