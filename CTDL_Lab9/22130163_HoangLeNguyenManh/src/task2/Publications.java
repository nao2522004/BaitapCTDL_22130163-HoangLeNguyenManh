package task2;

import java.util.ArrayList;
import java.util.List;

public abstract class Publications {
	protected String title;
	protected int numOfPage;
	protected int year;
	protected String author;
	protected int price;

	public Publications(String title, int numOfPage, int year, String author, int price) {
		super();
		this.title = title;
		this.numOfPage = numOfPage;
		this.year = year;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public int getNumOfPage() {
		return numOfPage;
	}

	public int getYear() {
		return year;
	}

	public String getAuthor() {
		return author;
	}

	public int getPrice() {
		return price;
	}

	// Phương thức xác định loại của ấn phẩm (Tạp chí hay Sách tham khảo)
	public String getType() {
		return "";
	}

	// Phương thức kiểm tra ấn phẩm là tạp chí và có thời gian xuất bản cách đây
	// (2021) 10 năm hay không
	public boolean checkPublicationsIsMagazine(int currentYear) {
		if (this.getType().equals("Magazine")) {
			if (currentYear - this.getYear() < 10) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	// Phương thức kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không
	public boolean checkTwoPublicationsIsMagazine(Publications other) {
		if (!this.getType().equals(other.getType())) {
			return false;
		} else if (!this.author.equals(other.getAuthor())) {
			return false;
		}
		return true;
	}

	// Tính tổng tiền của tất các ấn phẩm trong nhà sách
	public int getTotalPrice() {
		int total = 0;
		total += this.getPrice();
		return total;
	}
	
	public int getChapterPageNum(){ 
		return 0;
	}
	
	public List<Chapter> getChapter(){
		return null;
		
	}


	public static void main(String[] args) {
		Magazine m1 = new Magazine("the thao", 10, 2010, "Hoang Van A", 30000, "tap chi the thao");
		Magazine m2 = new Magazine("the thao", 10, 2012, "Hoang Van B", 30000, "tap chi the thao");

		Chapter c3 = new Chapter(" tieu de 2", 10);
		Chapter c4 = new Chapter("tieu de4", 20);
		List<Chapter> l1 = new ArrayList<>();
		l1.add(c3);
		l1.add(c4);
		ReferenceBooks r1 = new ReferenceBooks("tham khao", 30, 2021, "Le Thi A", 30000, "y hoc", l1);
		ReferenceBooks r2 = new ReferenceBooks("tham khao", 30, 2021, "Le Thi A", 30000, "y hoc", l1);

		List<Publications> l11 = new ArrayList<>();
		l11.add(m1);
		l11.add(m2);
		l11.add(r2);
		l11.add(r1);

		
		System.out.println("Type: " + m1.getType());
		System.out.println("Type: " + r1.getType());

		System.out.println(
				"Kiem tra xem tap chi co san xuat truoc 2021 10 nam hay ko ?: " + m1.checkPublicationsIsMagazine(2021));

		System.out.println("2 tap chi co cung loai va tac gia khong: " + r2.checkTwoPublicationsIsMagazine(r1));

		System.out.println(" tong tien cac an pham la: ");
		
		System.out.println(" so trang cua chuong trong sach giao khoa: "+ r1.getChapterPageNum());

	}
}
