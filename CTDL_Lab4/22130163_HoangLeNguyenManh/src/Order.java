import java.util.ArrayList;
import java.util.List;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}

	public double cost() {
		double totalAll = 0.0;
		for (OrderItem item : items) {
			totalAll += item.totalPrice();
		}
		return totalAll;
	}

	
	// task 1.4
	// using bubbleSort
	public boolean contains(Product p) {
		// sắp xếp theo giá tăng dần
		int n = items.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (items[j].getP().getPrice() > items[j + 1].getP().getPrice()) {
					OrderItem temp = items[j];
					items[j] = items[j + 1];
					items[j + 1] = temp;
				}
			}

		}
		// Thực hiện tìm kiếm nhị phân trên mảng đã sắp xếp
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (items[mid].getP().getPrice() == p.getPrice()) {
				return true;
			} else if (items[mid].getP().getPrice() < p.getPrice()) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return false;
	}

	// using selectionSort
	public boolean contains1(Product p) {
		// sắp xếp theo giá tăng dần
		int n = items.length;
		for (int i = 0; i < n; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (items[j].getP().getPrice() < items[minIndex].getP().getPrice()) {
					minIndex = j;
				}
				if (minIndex != i) {
					OrderItem temp = items[j];
					items[j] = items[minIndex];
					items[minIndex] = items[j];
				}
			}

		}
		// Thực hiện tìm kiếm nhị phân trên mảng đã sắp xếp
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (items[mid].getP().getPrice() == p.getPrice()) {
				return true;
			} else if (items[mid].getP().getPrice() < p.getPrice()) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return false;
	}

	// using insertionSort
	// using selectionSort
	public boolean contains2(Product p) {
		// sắp xếp theo giá tăng dần
		int n = items.length;
		for (int i = 1; i < n; i++) {
			OrderItem ai = items[i];
			int j = i - 1;
			while (j >= 0 && items[j].getP().getPrice() > items[i].getP().getPrice()) {
				items[j + 1] = items[j];
				j--;
			}
			items[j + 1] = ai;

		}
		// Thực hiện tìm kiếm nhị phân trên mảng đã sắp xếp
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (items[mid].getP().getPrice() == p.getPrice()) {
				return true;
			} else if (items[mid].getP().getPrice() < p.getPrice()) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return false;
	}

// get all products based on the given type using linear search

	public Product[] filter(String type) {
		List<Product> filterProduct = new ArrayList<>();
		for (OrderItem item : items) {
			if (item.getP().getType().equals(type)) {
				filterProduct.add(item.getP());
			}
		}
		return filterProduct.toArray(new Product[0]);
	}

	public static void main(String[] args) {

		// Tạo một danh sách các sản phẩm
		Product product1 = new Product("01", "Sản phẩm 1", 10.0, "Loại 1");
		Product product2 = new Product("02", "Sản phẩm 2", 15.0, "Loại 2");
		Product product3 = new Product("03", "Sản phẩm 3", 20.0, "Loại 1");
		Product product4 = new Product("04", "Sản phẩm 4", 12.0, "Loại 2");
		Product product5 = new Product("05", "Sản phẩm 5", 9.0, "Loại 3");

		// Tạo các mục đơn hàng
		OrderItem item1 = new OrderItem(product1, 2);
		OrderItem item2 = new OrderItem(product2, 3);
		OrderItem item3 = new OrderItem(product3, 1);
		OrderItem item4 = new OrderItem(product4, 3);
		OrderItem item5 = new OrderItem(product5, 5);

		// Tạo đơn hàng và thêm các mục vào đơn hàng
		Order order = new Order(new OrderItem[] { item1, item2, item3, item4, item5 });

		// Tính tổng giá đơn hàng
		double totalCost = order.cost();
		System.out.println("Tổng giá của đơn hàng: " + totalCost);

		// Kiểm tra xem đơn hàng có chứa sản phẩm nào đó không
		Product productToCheck = new Product("05", "Sản phẩm 5", 16.0, "Loại 3");
		// test contains using bubbleSort
		System.out.println(" test using bubbleSort");
		boolean containsProduct = order.contains(product1);
		System.out.println("Đơn hàng có chứa sản phẩm 1 không? " + containsProduct);
		// test contains1 using selectionSort
		System.out.println(" test using selectionSort");
		boolean containsProduct1 = order.contains1(product2);
		System.out.println("Đơn hàng có chứa sản phẩm 2 không? " + containsProduct1);
		// test contains1 using insertionSort
		System.out.println(" test using insertionSort");
		boolean containsProduct2 = order.contains2(product3);
		System.out.println("Đơn hàng có chứa sản phẩm 3 không? " + containsProduct2);

		// Lọc các sản phẩm theo loại
		String typeToFilter = "Loại 1";
		Product[] filteredProducts = order.filter(typeToFilter);
		System.out.println("Sản phẩm loại 1 trong đơn hàng:");
		for (Product product : filteredProducts) {
			System.out.println(
					product.getId() + ";" + product.getName() + ";" + product.getPrice() + ";" + product.getType());
		}
	}
}
