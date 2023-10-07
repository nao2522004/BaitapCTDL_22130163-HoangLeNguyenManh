import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}

	public double cost() {
		double totalCost = 0.0;
		for (OrderItem item : items) {
			totalCost += item.getSubtotal();
		}
		return totalCost;
	}

	// using binary search approach
	public boolean contains(Product p) {
		// Sắp xếp mảng items dựa trên ID sản phẩm
		Arrays.sort(items, Comparator.comparing(item -> item.getP().getId()));

		int left = 0;
		int right = items.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			int comparison = items[mid].getP().getId().compareTo(p.getId());

			if (comparison == 0) {
				return true; // Product found
			} else if (comparison < 0) {
				left = mid + 1; // Search the right half
			} else {
				right = mid - 1; // Search the left half
			}
		}

		return false; // Product not found
	}

	// get all products based on the given type using linear search
	public Product[] filter(String type) {
		List<Product> filteredProducts = new ArrayList<>();

		for (OrderItem item : items) {
			if (item.getP().getType().equals(type)) { // equalsIgnoreCase ss mà không phân biệt hoa thường
				filteredProducts.add(item.getP());
			}
		}

		return filteredProducts.toArray(new Product[0]);
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
		Product productToCheck = new Product("02", "Sản phẩm 2", 15.0, "Loại 2");
		boolean containsProduct = order.contains(productToCheck);
		System.out.println("Đơn hàng có chứa sản phẩm 2 không? " + containsProduct);

		// Lọc các sản phẩm theo loại
		String typeToFilter = "Loại 1";
		Product[] filteredProducts = order.filter(typeToFilter);
		System.out.println("Sản phẩm loại 1 trong đơn hàng:");
		for (Product product : filteredProducts) {
			System.out.println(product.getId()+";"+product.getName()+";"+product.getPrice()+";"+product.getType());
		}
	}
}
